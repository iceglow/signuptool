package se.su.it.signuptool

import se.su.it.svc.SuCard

class ActivateAccountAndCardService implements Serializable {

  def sukatService

  /** Needed if we want to use this service in the flow. */
  static transactional = false

  public boolean isAdmittedOnCurrentSemester(String socialSecurityNumber) {
    return false
  }

  public def findAccountByPnr(String pnr) {
    return [registeredAddress:'Kakgatan 13', uid: 'kalleAnka']
  }

  /** Checks if user has any active cards or active order for a card */
  public boolean canOrderCard(String uid) {
    List<SuCard> cards = sukatService.getCardsForUser(uid)
    return true
  }

  public String getForwardAddress(String pnr) {
    // lpwService get telekom ?
    return "some@email.com"
  }
}
