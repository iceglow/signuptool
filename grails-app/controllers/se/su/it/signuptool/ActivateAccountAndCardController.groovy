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

    EventLog eventLog = null

    if (session.referenceId) {
      try {
        eventLog = utilityService.getEventLog(session.referenceId)
      } catch (ex) {
        log.error "Failed to fetch eventLog for referenceId ${session.referenceId}", ex
        flash.error = g.message(code:'activateAccountAndCardController.errors.genericError')
        return redirect(controller:'dashboard', action:'index')
      }
    } else {
      eventLog = utilityService.eventLog
      session.referenceId = eventLog?.id
    }

    String scope = ''

    String uid = session.user?.uid

    if (!session.pnr) {
      scope = utilityService.getScopeFromEppn(request.eppn)

      switch(scope) {
        case "studera.nu":
          if (request.norEduPersonNIN) {
            session.pnr = request.norEduPersonNIN
            eventLog.logEvent("verified account for ${request.eppn}, pnr set to ${session.pnr} from norEduPersonNIN")
          } else {
            eventLog.logEvent("unverified account for ${request.eppn}")
            return render(view:'/shared/unverifiedAccount', model:[referenceId:eventLog?.id])
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

    if (!eventLog?.socialSecurityNumber) {
      eventLog.socialSecurityNumber = session.pnr
      eventLog.save(flush:true)
    }

    /**
     * If the user isn't already in the session we find it either by ssn or uid and put it in the session.
     */
    if (!session.user) {
      try {
        SvcSuPersonVO user = activateAccountAndCardService.findUser(session.pnr)
        if (user) {
          session.user = user
          session.uid = user?.uid
        }
      } catch (ex) {
        eventLog.logEvent("Failed when setting user in session for ${uid} with exception ${ex.getMessage()}")

        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[session.pnr]) as String

        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!session.user || !session.user.accountIsActive) {
      eventLog.logEvent("First time visit for ${session.pnr}")
      /** See if we can find the new user in Ladok */
      Map ladokData = [:]

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(session.pnr)
      } catch (ex) {
        eventLog.logEvent("Failed when fetching ladokData for uid: $session.pnr")
        log.error "Failed when fetching ladokData for uid: $session.pnr", ex

        flash.error = message(code: "activateAccountAndCardController.errorWhenContactingLadok")
        return redirect(controller:'dashboard', action:'index')
      }

      if (!ladokData) {
        eventLog.logEvent("User ${session.pnr} not found in ladok")
        return render(view:'userNotFoundInLadok', model:[referenceId:eventLog?.id])
      }

      /** Saving enamn and tnamn for enroll method */
      session.givenName = ladokData.tnamn
      session.sn = ladokData.enamn

      eventLog.logEvent("Account for user with pnr: ${session.pnr} not found in SUKAT, starting create user account flow.")

      return redirect(action:'createNewAccount')
    }

    String lpwurl = configService.getValue("signup", "lpwtool")
    String sukaturl = configService.getValue("signup", "sukattool")
    eventLog.logEvent("Found account with pnr: ${session.pnr} and uid: ${session.uid} in SUKAT, displaying information.")

    return render(view:'index', model:[
        uid:session?.user?.uid,
        password:password,
        lpwurl: lpwurl,
        sukaturl: sukaturl,
        hasCompletedCardOrder:hasCompletedCardOrder
    ])
  }

  def createNewAccountFlow = {

    prepareForwardAddress {
      action {
        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        String forwardAddress = ''
        /** Even if fetching forward address fails we should not fail here. */
        try {
          forwardAddress = ladokService.findForwardAddressSuggestionForPnr((String) session.pnr)
        } catch (ex) {
          eventLog.logEvent("Failed when fetching forward address from Ladok: ${ex?.message}")
          log.error "Fetching forward address from LADOK failed.", ex
        }
        eventLog.logEvent("Fetched forward address from Ladok: $forwardAddress")
        [forwardAddress:forwardAddress]
      }
      on("success").to("activateAccount")
      on("error").to("errorHandler")
    }

    activateAccount {
      on("acceptAccountActivation") {
        flow.forwardAddress = params.forwardAddress
        flow.approveTermsOfUse = params?.approveTermsOfUse
      }.to("processEmailInput")
    }

    processEmailInput {
      action {
        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        if (!flow.approveTermsOfUse) {
          flow.error = g.message(code:'activateAccountAndCardController.errors.notHavingApprovedTermsOfUse')
          eventLog.logEvent("User did not accept the terms of use.")
          return retry()
        }

        if (!activateAccountAndCardService.validateForwardAddress((String)params?.forwardAddress)) {
          flow.error = g.message(code:'activateAccountAndCardController.errors.notHavingSuppliedValidForwardAddress')
          eventLog.logEvent("Invalid email for ${session.pnr}: ${flow.forwardAddress}")
          return retry()
        }
      }
      on("success") {
        flow.error = ''
      }.to("createAccount")
      on("retry").to("activateAccount")
      on("error").to("errorHandler")
    }

    createAccount {
      action {

        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }


        SvcUidPwd result = null

        try {
          result = sukatService.enrollUser(session.givenName, session.sn, session.pnr, flow.forwardAddress)
          if (!result) {
            throw new Exception("Could not enroll user.")
          }
        } catch(ex) {
          log.error "Failed when enrolling user", ex
          eventLog.logEvent("Failed to enroll user: ${ex?.message}")
          flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
          return error()
        }

        /** Since we don't recieve a full account from the creation of an account we return the uid */
        session.uid = result.uid
        session.password = result.password
      }
      on("success").to("beforeEnd")
      on("error").to("errorHandler")
    }

    errorHandler {
      action {
        if (flash.stateException) {
          log.error "Webflow Exception occurred: ${flash.stateException}", flash.stateException
        }
        flow.error = (flow.error)?:g.message(code:"activateAccountAndCardController.errors.genericError")
        clearSession()
      }
      on("success").to("errorPage")
    }

    errorPage {
      on("continue"){
        flow.error = null
      }.to("dashboard")
    }

    dashboard() {
      /** We don't want to send the user back into the same flow that crashed so we send him / her to the dashboard */
      action {
        redirect(controller:'dashboard', action:'index')
      }
      on("success").to("end")
    }

    beforeEnd {
      action {
        redirect(action:'index')
      }
      on("success").to("end")
    }

    end() {
      // Ugly placeholder will never be shown
    }
  }



  private void clearSession() {
    session.uid = null
    session.password = null
  }

  def orderCardFlow = {

    prepareForwardOrderCard {
      action {

        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        if (!session.user?.uid) {
          eventLog.logEvent("User has no valid user in session, this should not happen. Value is currently set to ${session.user}")
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.noAccount.error')
          return error()
        }

        try {
          flow.cardInfo = activateAccountAndCardService.getCardOrderStatus(session.user)
        } catch (ex) {
          log.error "Error when fetching card order status", ex
          eventLog.logEvent("Error when fetching card order status: ${ex?.message}")
          return error()
        }

        if (!flow.cardInfo?.canOrderCard) {
          if (!flow.cardInfo.hasAddress) {
            eventLog.logEvent("User can't order card cause: User is missing address.")
          } else if (flow.cardInfo.suCards) {
            eventLog.logEvent("User can't order card cause: User already has active card(s).")
          } else if (flow.cardInfo.cardOrders) {
            eventLog.logEvent("User can't order card cause: User already has active card order(s).")
          }
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
        /** We consider this a successful completion of the flow since the user can't order a card */
        session.hasCompletedCardOrder = true
      }.to("beforeEnd")
    }

    cardOrder {
      on("sendCardOrder"){
        flow.addressIsValid = params?.addressIsValid
        flow.acceptLibraryRules = params?.acceptLibraryRules
      }.to("processCardOrder")
    }

    processCardOrder {
      action {

        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        if (flow.addressIsValid == null) {
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.selectValidInvalid.error')
          eventLog.logEvent("User didn't select if address is valid or invalid")
          return error()
        }

        if (flow.addressIsValid == "1") {
          if (!flow.acceptLibraryRules) {
            flow.error = g.message(code: 'activateAccountAndCardController.cardOrder.approveTermsOfUse.error')
            eventLog.logEvent("User didn't approve terms of use")
            return error()
          }
          try {
            sukatService.orderCard(session.user, flow.cardInfo?.ladokAddress)
          } catch (ex) {
            log.error "Failed to order card", ex
            eventLog.logEvent("Failed to order card: ${ex.message}")
            return error()
          }
        } else {
          eventLog.logEvent("User says address is invalid")
        }
        return success()
      }
      on('success'){
        session.hasCompletedCardOrder = true
      }.to('beforeEnd')
      on("hasInvalidAddress"){
        session.hasCompletedCardOrder = true
      }.to("hasInvalidAddress")
      on('error').to('cardOrder')
    }

    errorHandler {
      action {
        if (flash.stateException) {
          log.error "Webflow Exception occurred: ${flash.stateException}", flash.stateException
        }
        flow.error = (flow.error)?:g.message(code:"activateAccountAndCardController.errors.genericError")
      }
      on("success").to("errorPage")
    }

    errorPage {
      on("continue"){
        flow.error = null
      }.to("beforeEnd")
    }

    beforeEnd() {
      action {
        return redirect(action:'index')
      }
      on("success").to("end")
    }

    end() {
      // Placeholder
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
