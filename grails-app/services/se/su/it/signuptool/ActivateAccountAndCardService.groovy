package se.su.it.signuptool

import se.su.it.sucard.client.CardOrderVO
import se.su.it.svc.SuCard

class ActivateAccountAndCardService implements Serializable {

  def suCardService
  def sukatService

  /** Needed if we want to use this service in the flow. */
  static transactional = false

  public boolean isAdmittedOnCurrentSemester(String socialSecurityNumber) {
    return true
  }

  public def findAccountByPnr(String socialSecurityNumber) {
    return [registeredAddress:'Kakgatan 13', uid: 'mano3567']
  }

  /** Checks if user has any active cards or active order for a card */
  public boolean canOrderCard(String uid) {
    List<SuCard> cards = sukatService.getCardsForUser(uid)
    log.error("epa cards: ${(cards?.size()>0)} ")
    CardOrderVO[] cardOrders=suCardService.getCardOrdersForUser(uid)
    log.error("apa cardorders: ${(cardOrders?.size()>0)} ")
    return !(cards?.size()>0 || cardOrders?.size()>0)
  }

  public String getForwardAddress(String socialSecurityNumber) {
    // lpwService get telekom ?
    return "some@email.com"
  }
}
