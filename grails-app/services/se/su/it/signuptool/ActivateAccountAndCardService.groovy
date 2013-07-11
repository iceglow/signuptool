package se.su.it.signuptool

import se.su.it.svc.SuCard
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def sukatService
  def utilityService
  def ladokService

  private final emailPattern = /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/

  public boolean validateForwardAddress(String forwardAddress) {
    forwardAddress = forwardAddress?.trim()

    if (!forwardAddress) {
      return false
    }

    if (!(forwardAddress ==~ emailPattern)) {
      return false
    }

    return true
  }

  public SvcSuPersonVO findUser(String pnr) {
    SvcSuPersonVO user = null

    if (!pnr) {
      return user
    }

    user = sukatService.findUserBySocialSecurityNumber(pnr)

    /** Return object could be empty, uid should mean we did get a hit. */
    (user?.uid) ? user : null
  }

  /**
   * The only time we should be fetching data from Ladok is when a student has no account
   * in SUKAT, the uid should thus be a socialSecurityNumber (10 chars)
   * @param uid
   * @return
   */
  public Map fetchLadokData(String socialSecurityNumber) {
    Map ladokData = [:]

    if (!socialSecurityNumber) {
      return ladokData
    }

    /** Turn 12 length ssn into 10 length */
    ladokData = ladokService.findStudentInLadok(socialSecurityNumber)

    return ladokData
  }

  public Map getCardOrderStatus(SvcSuPersonVO user) {
    Map cardInfo = [:]

    try {
      Map address = ladokService.getAddressFromLadokByPnr(user.socialSecurityNumber)
      cardInfo.hasAddress = (null != address && address.size() > 0)
      cardInfo.ladokAddress = address

      // we may want to show info about the active cards a user already has
      cardInfo.suCards = (sukatService.getCardsForUser(user.uid))

      // we may want to show info about cardorders that the user may have done
      cardInfo.cardOrders = (sukatService.getCardOrdersForUser(user.uid))
      cardInfo.canOrderCard = canOrderCard(cardInfo)
    } catch (ex) {
      log.error "Failed when creating card order information object", ex
    }

    return cardInfo
  }

  private static boolean canOrderCard(Map cardInfo) {
    if (!cardInfo.hasAddress) {
      return false
    }

    if (cardInfo.suCards) {
      return false
    }

    if (cardInfo.cardOrders) {
      return false
    }

    return true
  }
}
