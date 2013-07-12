package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

class ActivateAccountAndCardController {

  def activateAccountAndCardService
  def configService
  def ladokService
  def sukatService
  def utilityService

  def index() {
    /** Only display the password if returned and remove it right after. */
    String password = ''

    boolean hasCompletedCardOrder = (session.hasCompletedCardOrder)

    if (session.password) {
      password = session.password
      session.password = null
    }

    if (!session.eventLog) {
      session.eventLog = new EventLog().save(flush:true)
    }

    EventLog eventLog = session.eventLog

    String scope = ''
    String pnr = session.pnr
    String uid = session.user?.uid

    if (!pnr) {
      scope = utilityService.getScopeFromEppn(request.eppn)

      switch(scope) {
        case "studera.nu":
          if (request.norEduPersonNIN) {
            pnr = request.norEduPersonNIN
          } else {
            eventLog.logEvent("unverified account for ${request.eppn}")
            return render(view:'unverifiedAccount', model:[referenceId:eventLog?.id])
          }
          break
        default:
          eventLog.logEvent("no handled or valid scope supplied for ${request.eppn}")
          flash.error = message(
              code:'activateAccountAndCardController.noValidScopeFound',
              args:[request?.eppn]) as String
          return redirect(controller:'dashboard', action:'index')
      }
    }

    if (!eventLog.socialSecurityNumber) {
      eventLog.socialSecurityNumber = pnr
      eventLog.save(flush:true)
    }

    /**
     * If the user isn't already in the session we find it either by ssn or uid and put it in the session.
     */
    if (!session.user) {
      try {
        SvcSuPersonVO user = activateAccountAndCardService.findUser(pnr)
        if (user) {
          session.user = user
          session.uid = user?.uid
        }
      } catch (ex) {
        // TODO: ?
        eventLog.logEvent("Failed when setting user in session for ${uid} with exception ${ex.getMessage()}")

        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[pnr]) as String

        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!session.user || !session.user.accountIsActive) {
      eventLog.logEvent("First time visit for ${pnr}")
      /** See if we can find the new user in Ladok */
      Map ladokData = [:]

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(pnr)
      } catch (ex) {
        log.error "Failed when fetching ladokData for uid: $pnr", ex
      }

      if (!ladokData) {
        eventLog.logEvent("User ${pnr} not found in ladok")
        return render(view:'userNotFoundInLadok', model:[referenceId:eventLog?.id])
      }

      /** Saving enamn and tnamn for enroll method */
      session.givenName = ladokData.tnamn
      session.sn = ladokData.enamn
      session.pnr = ((pnr?.length() == 12) ? pnr[2..11] : pnr)

      eventLog.logEvent("User ${pnr} starting flow")

      return redirect(action:'createNewAccount')
    }

    String lpwurl = configService.getValue("signup", "lpwtool")
    String sukaturl = configService.getValue("signup", "sukattool")
    eventLog.logEvent("Person with pnr: ${pnr} and uid: ${session.uid} already exists in sukat")

    return render(view:'index', model:[
        uid:session?.uid,
        password:password,
        lpwurl: lpwurl,
        sukaturl: sukaturl,
        hasCompletedCardOrder:hasCompletedCardOrder
    ])
  }

  def createNewAccountFlow = {

    prepareForwardAddress {
      action {
        String forwardAddress = ''
        /** Even if fetching forward address fails we should not fail here. */
        try {
          forwardAddress = ladokService.findForwardAddressSuggestionForPnr((String)session.pnr)
        } catch (ex) {
          // TODO: Inform about not being able to fetch forwardaddr from ladok?
          flash.info = g.message(code:'activateAccountAndCardController.unableToFetchForwardAddress')
          log.error "Fetching forward address from LADOK failed.", ex
        }
        [forwardAddress:forwardAddress]
      }
      on("success").to("activateAccount")
    }

    activateAccount {
      on("acceptAccountActivation") {
        flow.approveTermsOfUse = params?.approveTermsOfUse
      }.to("processEmailInput")
    }

    processEmailInput {
      action {

        flow.forwardAddress = params.forwardAddress

        EventLog eventLog = session?.eventLog?.merge()

        if (!flow.approveTermsOfUse) {
          // TODO: Separate messages for these two errors.
          flow.error = g.message(code:'activateAccountAndCardController.forwardEmail.explanation')
          return error()
        }

        if (!activateAccountAndCardService.validateForwardAddress((String)params?.forwardAddress)) {
          // TODO: Separate messages for these two errors.
          flow.error = g.message(code:'activateAccountAndCardController.forwardEmail.explanation')

          eventLog.logEvent("Invalid email for ${session.pnr}: ${params?.forwardAddress}")
          return error()
        }
      }
      on("success") {
        flow.error = ''
      }.to("createAccount")
      on("error").to("activateAccount")
    }

    createAccount {
      action {

        SvcUidPwd result = null

        String forwardAddress = flow.forwardAddress
        String givenName = session.givenName
        String sn = session.sn
        String socialSecurityNumber = session.pnr

        try {
          result = sukatService.enrollUser(givenName, sn, socialSecurityNumber, forwardAddress)
        } catch(ex) {
          log.error "Failed when enrolling user", ex
        }

        if (result == null) {
          flow.error = g.message(code:'activateAccountAndCardController.failedWhenEnrollingUser')
          return error()
        }

        /** Since we don't recieve a full account from the creation of an account we return the uid */

        session.uid = result.uid
        session.password = result.password
      }
      on("success").to("end")
      on("error").to("errorHandler")
    }

    errorHandler {
      action {
        // TODO: Do something nicer than just log?
        log.error("Webflow Exception occurred: ${flash.stateException}", flash.stateException)
        session.uid = null
        session.password = null
      }
      on("success").to("end")
    }

    end {
      return redirect(action:'index')
    }
  }

  def orderCardFlow = {

    prepareForwardOrderCard {
      action {
        EventLog eventLog = null

        try {
          eventLog = session?.eventLog?.merge()
        } catch (ex) {
          log.error "Error when fetching logger", ex
          return sessionTimedOut()
        }

        if (!session.user?.uid) {
          eventLog.logEvent("no account found for uid (${session.user?.uid}) or pnr (${session?.pnr})")
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.noAccount.error')
          return error()
        }

        flow.cardInfo = activateAccountAndCardService.getCardOrderStatus(session.user)

        if (!flow.cardInfo?.canOrderCard) {
          // TODO: Make logEvent more talkative.
          eventLog.logEvent("User can't order card")
          return cantOrderCard()
        }

        return success()
      }
      on("success").to("cardOrder")
      on("error").to("errorHandler")
      on("cantOrderCard").to("cantOrderCard")
    }

    cantOrderCard {
      on("continue") {
        session.hasCompletedCardOrder = true
      }.to("end")
    }

    cardOrder {
      on("sendCardOrder"){

        flow.registeredAddressValid = params?.registeredAddressValid
        flow.acceptLibraryRules = params?.acceptLibraryRules
        flow.registeredAddressInvalid = params?.registeredAddressInvalid

      }.to("processCardOrder")
    }

    processCardOrder {
      action {

        EventLog eventLog = session?.eventLog?.merge()

        if (!flow.registeredAddressValid &&
            !flow.registeredAddressInvalid) {

          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.selectValidInvalid.error')
          eventLog.logEvent("user didn't select if address is valid or invalid")
          return error()
        }

        if (flow.registeredAddressValid) {

          if (!flow.acceptLibraryRules) {

            flow.error = g.message(code:'activateAccountAndCardController.cardOrder.approveTermsOfUse.error')
            eventLog.logEvent("user didn't approve terms of use")
            return error()
          }
          try {
            sukatService.orderCard(session.user, flow.cardInfo?.ladokAddress)
          } catch (ex) {
            log.error "Failed to order card", ex
            return error()
          }
        }

        if (flow.registeredAddressInvalid) {
          eventLog.logEvent("user says address is invalid")

        }
        return success()
      }
      on('success'){
        session.hasCompletedCardOrder = true
      }.to('end')
      on('error').to('cardOrder')
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

  def changeLanguage = {
    if (session.locale && session.locale == "sv_SE") {
      session.locale = "en_US"
    } else {
      session.locale = "sv_SE"
    }

    redirect(controller: params.c, action: params.a, params:['lang':session.locale])
  }
}
