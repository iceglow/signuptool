package se.su.it.signuptool

class ActivateAccountAndCardController {

  def activateAccountAndCardService
  def ladokService

  def index() {
    /** Logged in */
    String password = (params.password)?:''

    boolean admitted = activateAccountAndCardService.isAdmittedOnCurrentSemester(session.pnr)

    if (!admitted) {
      flash.error = message(code:'activateAccountAndCardController.notAdmittedCurrentSemester') as String
      return redirect(controller:'dashboard', action:'index')
    }

    def account = null

    if (params.uid) {
      account = activateAccountAndCardService.findAccountByPnr(params.uid)
    }

    // account = activateAccountAndCardService.findAccountByPnr(params.uid)

    boolean canOrderCard = false
    boolean hasAccount = (account)
    def hasAddress = (account?.registeredAddress)

    if (hasAccount) {
      canOrderCard = (hasAddress && activateAccountAndCardService.canOrderCard())
    } else {
      redirect(action:'createNewAccount')
    }

    return render(view:'index', model:[
        account:account,
        password:password,
        hasAddress:hasAddress,
        canOrderCard:canOrderCard
    ])
  }

  /**
   * test method for fetching address from ladok.
   * @return
   */
  def address(){
    def address
    if(params.pnr){
      address = ladokService.getAddressFromLadokByPnr(params.pnr)
    } else{
      address = ladokService.getAddressFromLadokByPnr("4105211124")
    }
    return render(text:address)
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
        String forwardAddress = activateAccountAndCardService.getForwardAddress(session.pnr)
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
        params.email // Validate
        if (params.email == 'invalid') { return error() }
      }
      on("success").to("createAccount")
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
        flash.info "Account created!"
        return redirect(action:'index', model:[uid:uid, password:password])
      }
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
