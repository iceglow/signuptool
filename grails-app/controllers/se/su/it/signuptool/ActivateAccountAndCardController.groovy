package se.su.it.signuptool

class ActivateAccountAndCardController {

  def sukatService
  def ladokService
  def activateAccountAndCardService

  def index() {
    /** Logged in */
    String password = (params.password)?:''

    /** If the user is not already in the session or a uid is supplied we fetch the user and put it in the session. */
    if (!session.user && session.uid) {
      def user = sukatService.findUserByUid(session.uid)
      if (user) {
        session.user = user
      } else {
        flash.error = message(code:'activateAccountAndCardController.userNotFoundForUid', args:[session.uid]) as String
        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we have no use in the session and no uid either this is a first time visit */
    if (!session.user) {

      /** See if we can find the user in Ladok */
      if (!ladokService.findStudentInLadok(session.pnr)) {
        flash.error = message(code:'activateAccountAndCardController.userNotFoundInLadok') as String
        return redirect(controller:'dashboard', action:'index')
      }

      session.user = (sukatService.findUserBySocialSecurityNumber(session.pnr))?:null
    }

    def user = session.user
    boolean canOrderCard = false
    def hasAddress = (user?.registeredAddress)?: false

    if (user != null && hasAddress) {
      /** TODO: Check if we have active orders etc */
      canOrderCard = activateAccountAndCardService.canOrderCard()
    } else {
      redirect(action:'createNewAccount')
    }

    return render(view:'index', model:[
        user:user,
        password:password,
        hasAddress:hasAddress,
        canOrderCard:canOrderCard
    ])
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
      on("success").to("createAccount")
      on("error").to("selectEmail")
      on(Exception).to("errorHandler")
    }

    createAccount {
      action {
        def result = activateAccountAndCardService.createAccount()
        if (result == null) {
          throw new Exception("Could not create account.")
        }

        String uid = result.uid
        String password = result.password
        session.uid = uid

        flash.info = "Account created!"

        return redirect(action:'index', model:[password:password])
      }
      on("success").to("end")
      on("error").to("errorHandler")
      on(Exception).to("errorHandler")
    }

    errorHandler {
      action{
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
