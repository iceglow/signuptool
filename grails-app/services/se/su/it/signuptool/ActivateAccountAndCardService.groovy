package se.su.it.signuptool

class ActivateAccountAndCardService {

  public boolean isAdmittedOnCurrentSemester(String pnr) {
    return true
  }

  public def findAccountByPnr(String pnr) {
    return [registeredAddress:'Kakgatan 13']
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
