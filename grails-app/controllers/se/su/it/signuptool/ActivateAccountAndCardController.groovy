package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

class ActivateAccountAndCardController {

  def activateAccountAndCardService
  def configService
  def eventLogService
  def ladokService
  def sukatService
  def utilityService

  def index() {
    log.debug "$controllerName, $actionName, $params"

    /** Only display the password if returned and remove it right after. */
    String password = ''

    if (flash.password) {
      password = flash.password
      flash.password = null
    }

    if(!flash.referenceId) {
      flash.referenceId = eventLogService.createReferenceId()
      log.error("creating new referenceid ${flash.referenceId}")
    }

    /** Setting uid
     * 1. First hand, use the returned uid.
     * 2. Fetch the uid from eppn
     */


    /** Path only taken when no uid is already set in the session */
    String scope = ''

    if (!session.uid) {
      scope = utilityService.getScopeFromEppn(request.eppn)

      switch(scope) {
        case "su.se":
          break
        case "studera.nu":
          if (!request.norEduPersonNIN) {
            return render(view:'unverifiedAccount')
          }
          break
        default:
          log.error("apa: ${scope}")
          flash.error = message(
              code:'activateAccountAndCardController.noValidScopeFound',
              args:[request?.eppn]) as String
          return redirect(controller:'dashboard', action:'index')
      }
    }

    String uid = (session.uid)?:utilityService.fetchUid(scope, request)

    if (!uid) {
      eventLogService.logEvent("No valid user found (${session?.uid} / ${request?.eppn})", (String)flash.referenceId, request)
      flash.error = message(
          code:'activateAccountAndCardController.noValidIdFound',
          args:[session?.uid, request?.eppn]) as String
      return redirect(controller:'dashboard', action:'index')
    }

    /**
     * If the user isn't already in the session we find it either by ssn or uid and put it in the session.
     */
    boolean uidIsPnr = utilityService.uidIsPnr(uid)
    if (!session.user) {
      try {
        def user = activateAccountAndCardService.findUser(uid, uidIsPnr)
        if (user) {
          session.user = user
        }
      } catch (ex) {
        if(uidIsPnr) {
          eventLogService.logEvent("Failed when setting user in session for ${uid} with exception ${ex.getMessage()}", (String)flash.referenceId, request,uid,"")
        } else {
          eventLogService.logEvent("Failed when setting user in session for ${uid} with exception ${ex.getMessage()}", (String)flash.referenceId, request,"",uid)
        }

        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[uid]) as String
        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!session.user || !session.user.accountIsActive) {
      if(uidIsPnr) {
        eventLogService.logEvent("First time visit for ${uid}", (String)flash.referenceId, request,uid,"")
      } else {
        eventLogService.logEvent("First time visit for ${uid}", (String)flash.referenceId, request,"",uid)
      }
      /** See if we can find the new user in Ladok */
      Map ladokData = [:]

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(uid)
      } catch (ex) {
        log.error "Failed when fetching ladokData for uid: $uid", ex
      }

      if (!ladokData) {
        eventLogService.logEvent("User ${uid} not found in ladok", (String)flash.referenceId, request, uid)
        return render(view:'userNotFoundInLadok')
      }
      /** Since the uid is a pnr we set is as pnr in the session to be used by the createAccountFlow later */
      session.pnr = uid

      /** Saving enamn and tnamn for enroll method */
      session.givenName = ladokData.tnamn
      session.sn = ladokData.enamn
      session.pnr = ((uid?.length() == 12) ? uid[2..11] : uid)

      eventLogService.logEvent("User ${uid} starting flow", (String)flash.referenceId, request, uid)

      return redirect(action:'createNewAccount')
    }

    SvcSuPersonVO user = session.user // fetch user from session for the presentation in the view.

    Map cardInfo = activateAccountAndCardService.getCardOrderStatus(user)
    String lpwurl = configService.getValue("signup", "lpwtool")
    String sukaturl = configService.getValue("signup", "sukattool")
    eventLogService.logEvent("User ${uid} already exists in sukat", (String)flash.referenceId, request, "", uid)

    return render(view:'index', model:[
        user:user,
        password:password,
        cardInfo: cardInfo,
        lpwurl: lpwurl,
        sukaturl: sukaturl
    ])
  }

  def createNewAccountFlow = {

    prepareForwardAddress {
      action {
        String forwardAddress = ''
        try {
          forwardAddress = ladokService.findForwardAddressSuggestionForPnr((String)session.pnr)
        } catch (ex) {
          log.error "Fetching forward address from LADOK failed.", ex
          return error()
        }
        [forwardAddress:forwardAddress]
      }
      on("success").to("activateAccount")
      on("error").to("errorHandler")
    }

    activateAccount {
      on("acceptAccountActivation").to("processEmailInput")
    }

    processEmailInput {
      action {
        //TODO: Check the checkbox.
        if (!activateAccountAndCardService.validateForwardAddress((String)params?.forwardAddress)) {
          flow.error = "Invalid Email"
          eventLogService.logEvent("Invalid email for ${session.pnr}: ${params?.forwardAddress}", (String)flash.referenceId, request, (String)session.pnr)
          return error()
        }
      }
      on("success") {
        flow.error = ''
      }.to("createAccount")
      on("error").to("selectEmail")
    }

    createAccount {
      action {

        SvcUidPwd result = null

        String givenName = session.givenName
        String sn = session.sn
        String socialSecurityNumber = session.pnr

        try {
          result = sukatService.enrollUser(givenName, sn, socialSecurityNumber)
        } catch(ex) {
          log.error "Failed when enrolling user", ex
        }

        if (result == null) {
          flow.error = g.message(code:'activateAccountAndCardController.failedWhenEnrollingUser')
          return error()
        }

        /** Since we don't recieve a full account from the creation of an account we return the uid */

        flash.info = "Account created!"
        session.uid = result.uid
        flash.password = result.password

        // return redirect(action:'index')
      }
      on("success").to("end")
      on("error").to("errorHandler")
    }

    errorHandler {
      action {
        // TODO: Do something nicer than just log?
        log.error("Webflow Exception occurred: ${flash.stateException}", flash.stateException)
      }
      on("success").to("end")
      // TODO: else we do?
    }

    end {
      action {
        return redirect(action:'index')
      }
    }
  }

  def orderCardFlow = {
    /** Prereq:
     * + Har konto
     * + Har folkbokföringsadress
     * + Har inga tidigare aktiva kort eller aktiva beställningar.

     * Req:
     * + Godkänna folkbokföringsadress
     * + Godkänna låneregler.

     * Metoder:
     * + Skicka beställning.
    */

    prepareForwardOrderCard {
      action {
        if (!userHasAccount()) {
          flow.error = "user is has no account"
          return error()
        }

        if (!userCanOrderCards()) {
          flow.error = "user has active cards or orders"
        }

        if (!userHasRegisteredAddress()) {
          flow.error = "user registered address is missing"
          return error()
        }

        return success()
      }
      on("success").to("cardOrder")
      on("error").to("errorHandler")
    }

    cardOrder {
      on("sendCardOrder").to("processCardOrder")
    }

    processCardOrder {
      action {
      // todo: beställ kort
      }
      on('success').to('end')
      on('error').to('errorHandler')
    }

    errorHandler {
      action {
        log.error("Webflow Exception occurred: ${flash.stateException}", flash.stateException)
      }
      on("success").to("end")
    }

    end() {
      render(view: 'endAccountAndCard')
    }
  }

  private boolean userHasAccount() {
    def userFoundWithPnr = null
    def userFoundWithUid = null

    if (session?.pnr) {
      userFoundWithPnr = activateAccountAndCardService.findUser(session?.pnr, true)
    }

    if (session?.uid) {
      userFoundWithUid = activateAccountAndCardService.findUser(session?.uid, false)
    }

    return userFoundWithPnr || userFoundWithUid
  }

  private boolean userHasRegisteredAddress() {
    def hasRegisteredAddress = false

    if (session?.pnr) {
      hasRegisteredAddress = activateAccountAndCardService.userHasRegisteredAddress(session?.pnr, true)
    }

    if (session?.uid) {
      hasRegisteredAddress = activateAccountAndCardService.userHasRegisteredAddress(session?.uid, false)
    }

    return hasRegisteredAddress
  }

  private boolean userCanOrderCards() {
    SvcSuPersonVO user = null

    if (session?.pnr) {
      user = activateAccountAndCardService.findUser(session?.pnr, true)
    } else if (session?.uid) {
      user = activateAccountAndCardService.findUser(session?.uid, false)
    }

    boolean canOrder = false
    if(user) {
      canOrder = activateAccountAndCardService.canOrderCard(user?.uid)
    }

    return canOrder
  }
}
