package se.su.it.signuptool

class ActivateAccountAndCardService {

  // def ladokService
  def sukatService

  public boolean isToBeFoundInLadok(String pnr) {
    // ladokService...
  }

  public SuPerson findAccountByPnr(String pnr) {
    sukatService.findUserBySocialSecurityNumber(pnr)
  }

  /** Checks if user has any active cards or active order for a card */
  public boolean canOrderCard() {
    return true
  }

  public String getForwardAddress(String pnr) {
    // lpwService get telekom ?
    return "some@email.com"
  }
}
