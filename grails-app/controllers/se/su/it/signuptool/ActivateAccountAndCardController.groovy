package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO


class ActivateAccountAndCardController {

  def activateAccountAndCardService
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

    /** Setting uid
     * 1. First hand, use the returned uid.
     * 2. Fetch the uid from eppn
     */

    String uid = utilityService.fetchUid(session.uid, request.eppn)

    if (!uid) {
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
        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[uid]) as String
        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!session.user) {
      /** See if we can find the new user in Ladok */
      Map ladokData = [:]

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(uid)
      } catch (ex) {
        log.error "Failed when fetching ladokData for uid: $uid", ex
      }

      if (!ladokData) {
        flash.error = message(code:'activateAccountAndCardController.userNotFoundInLadok') as String
        return redirect(controller:'dashboard', action:'index')
      }

      /** Saving enamn and tnamn for enroll method */
      session.givenName = ladokData.tnamn
      session.sn = ladokData.enamn

      return redirect(action:'createNewAccount')
    }

    SvcSuPersonVO user = session.user // fetch user from session for the presentation in the view.

    Map cardInfo = activateAccountAndCardService.getCardOrderStatus(user)

    return render(view:'index', model:[
        user:user,
        password:password,
        cardInfo: cardInfo
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

    showTermsOfAgreement {
      on("agree").to("prepareForwardAddress")
      on("decline").to("end")
    }

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
      on("next").to("processEmailInput")
    }

    processEmailInput {
      action {
        if (!activateAccountAndCardService.validateForwardAddress(params?.forwardAddress)) {
          flow.error = "Invalid Email"
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
        log.error "<<< ENROLLED USER : $givenName $sn : ${flow.error} >>>"


        def result = [:]

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
     * + Har har folkbokföringsadress
     * + Har inga tidigare aktiva kort eller aktiva beställningar.

     * Req:
     * + Godkänna folkbokföringsadress
     * + Godkänna låneregler.

     * Metoder:
     * + Skicka beställning.
    */
    end()
  }
}
