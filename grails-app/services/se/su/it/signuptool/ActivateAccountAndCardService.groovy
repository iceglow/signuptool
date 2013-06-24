package se.su.it.signuptool

class ActivateAccountAndCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  public boolean isAdmittedOnCurrentSemester(String pnr) {
    return false
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
