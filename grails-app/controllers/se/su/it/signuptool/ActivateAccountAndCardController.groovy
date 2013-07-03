package se.su.it.signuptool

class ActivateAccountAndCardController {

  def ladokService
  def activateAccountAndCardService
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

    def user = session.user // fetch user from session for the presentation in the view.

    def cardInfo = activateAccountAndCardService.getCardOrderStatus(user)

    return render(view:'index', model:[
        user:user,
        password:password,
        cardInfo: cardInfo
    ])
  }

  def showSelectIdProvider = {
    return render(view: 'selectIdProvider')
  }

  def createNewAccountFlow = {
    /** Prereq:
     * + pnr
     * + personen är antagen innevarande termin.

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
        if (!flow.forwardAddress) {
          flow.forwardAddress = ladokService.findForwardAddressSuggestionForPnr(session.pnr)
        }
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
