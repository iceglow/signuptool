package se.su.it.signuptool

class ActivateAccountAndCardController {

  def activateAccountAndCardService

  def index() {
    /** Logged in */

    def password = (request.password)?:''

    def admitted = activateAccountAndCardService.isAdmittedOnCurrentSemester(session.pnr)

    if (!admitted) {
      return "To some good error location."
    }

    def account = activateAccountAndCardService.getAccount(session.pnr)

    def hasAccount = (account)
    def hasAddress = (account.registeredAddress)
    def canOrderCard = false

    if (hasAccount && hasAddress) {
      canOrderCard = activateAccountAndCardService.getCardStatusForAccount()
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

    end()
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

  def editAccount() {
    /** Prereq:
     * + pnr
     * + personen är antagen innevarande termin. (?)

     * Metoder:
     * + Kan välja att ändra epost.
     */
  }
}
