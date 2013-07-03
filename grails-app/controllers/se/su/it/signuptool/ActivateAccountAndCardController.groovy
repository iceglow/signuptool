package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardController {

  def activateAccountAndCardService
  def configService
  def eventLogService
  def ladokService
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

    String uid = utilityService.fetchUid(session.uid, request.eppn)

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
    if (!session.user) {
      try {
        boolean uidIsPnr = utilityService.uidIsPnr(uid)
        session.user = activateAccountAndCardService.findUser(uid, uidIsPnr)
      } catch (ex) {
        eventLogService.logEvent("Failed when setting user in session for ${uid} with exception ${ex.getMessage()}", (String)flash.referenceId, request)

        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[uid]) as String
        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!session.user) {
      eventLogService.logEvent("First time visit for ${uid}", (String)flash.referenceId, request)
      /** See if we can find the new user in Ladok */
      Map ladokData = [:]

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(uid)
      } catch (ex) {
        log.error "Failed when fetching ladokData for uid: $uid", ex
      }

      if (!ladokData) {
        eventLogService.logEvent("User ${uid} not found in ladok", (String)flash.referenceId, request)
        flash.error = message(code:'activateAccountAndCardController.userNotFoundInLadok') as String
        return redirect(controller:'dashboard', action:'index')
      }

      /** Saving enamn and tnamn for enroll method */
      session.givenName = ladokData.tnamn
      session.sn = ladokData.enamn

      eventLogService.logEvent("User ${uid} starting flow", (String)flash.referenceId, request)

      return redirect(action:'createNewAccount')
    }

    SvcSuPersonVO user = session.user // fetch user from session for the presentation in the view.

    Map cardInfo = activateAccountAndCardService.getCardOrderStatus(user)
    String lpwurl = configService.getValue("signup", "lpwtool")
    String sukaturl = configService.getValue("signup", "sukattool")
    eventLogService.logEvent("User ${uid} already exists in sukat", (String)flash.referenceId, request)

    return render(view:'index', model:[
        user:user,
        password:password,
        cardInfo: cardInfo,
        lpwurl: lpwurl,
        sukaturl: sukaturl
    ])
  }

  /**
   * test method for fetching address from ladok.
   * @return
   */
  def address() {
    Map address = [:]
    if(params.pnr) {
      address = ladokService.getAddressFromLadokByPnr(params.pnr)
    } else {
      address = ladokService.getAddressFromLadokByPnr("4105211124")
    }
    return render(text:address)
  }

  def createNewAccountFlow = {
    /** Prereq:
     * + pnr
     * + personen är antagen innevarande termin. ( i dagsläget kollar vi bara om personen finns i namntabellen )

     * Req:
     * + Person godkänner avtal

     * Metoder:
     * + Kan välja att ändra epost.
     *
     * Övrigt:
     * Skapa konto sent och skicka vidare till index med password.
     */

    prepareForwardAddress {
      action {
        // Fetch forward address from ladok / lpw

        String forwardAddress = ladokService.findForwardAddressSuggestionForPnr(session.pnr)
        [forwardAddress:forwardAddress]
      }
      on("success").to("selectEmail")
      on("error").to("errorHandler")
      on(Exception).to("errorHandler")
    }

    selectEmail {
      on("activate").to("processEmailInput")
    }

    processEmailInput {
      action {
        if (!activateAccountAndCardService.validateForwardAddress(params?.forwardAddress)) {
          flow.error = "Invalid Email"
          eventLogService.logEvent("Invalid email for ${uid}: ${params?.forwardAddress}", (String)flash.referenceId, request)
          return error()
        }
      }
      on("success") {
        flow.error = ''
      }.to("createAccount")
      on("error").to("selectEmail")
      on(Exception).to("errorHandler")
    }

    createAccount {
      action {

        def givenName = session.givenName
        def sn = session.sn

        // def result = sukatService.enrollUser(givenName, sn, session.pnr)
        log.info "<<< ENROLLED USER : $givenName $sn : ${flow.error} >>>"


        def result = [uid: 'donaldDuck', password: 'kajsa anka']

        if (result == null) {
          flow.error = message(code:'activateAccountAndCardController.failedWhenEnrollingUser')
          throw new Exception("Failed when creating account.")
        }

        /** Since we don't recieve a full account from the creation of an account we return the uid */

        flash.info = "Account created!"
        session.uid = result.uid
        flash.password = result.password

        return redirect(action:'index')
      }
      on("success").to("end")
      on("error").to("errorHandler")
      on(Exception).to("errorHandler")
    }

    errorHandler {
      action {
        log.error("Webflow Exception occurred: ${flash.stateException}", flash.stateException)
      }
      on("success").to("end")
    }

    end() {
      return redirect(action:'index')
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

    }

    errorHandler {
      action {
        log.error("Webflow Exception occurred: ${flash.stateException}", flash.stateException)
      }
      on("success").to("end")
    }
    end() {
      return redirect(action:'index')
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
    return activateAccountAndCardService.canOrderCard()
  }
}
