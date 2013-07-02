package se.su.it.signuptool

import se.su.it.svc.SuCard
import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def sukatService
  def utilityService
  def ladokService

  private final emailPattern = /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/

  /** Checks if user has any active cards or active order for a card */
  public boolean canOrderCard(SvcSuPersonVO user) {
    boolean canOrder = true

    List<SuCard> cards = sukatService.getCardsForUser(user.uid)
    if(cards?.size()>0) {
      canOrder = false
    }

    List cardOrders = sukatService.getCardOrdersForUser(user.uid)
    if(cardOrders?.size()>0) {
      canOrder = false
    }

    return canOrder
  }

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

  public SvcSuPersonVO findUser(String uid, boolean uidIsPnr) {
    SvcSuPersonVO user = null

    if (!uid) {
      return user
    }

    if (uidIsPnr) {
      user = sukatService.findUserBySocialSecurityNumber(uid)
    } else {
      user = sukatService.findUserByUid(uid)
    }
    /** Return object could be empty, uid should mean we did get a hit. */
    (user?.uid)? user : null
  }

  public boolean userHasRegisteredAddress(String uid, boolean uidIsPnr) {
    boolean hasRegisteredAddress = false

    def user = findUser(uid, uidIsPnr)

    if (user) {
      hasRegisteredAddress = user.registeredAddress
    }

    return hasRegisteredAddress
  }

  /**
   * The only time we should be fetching data from Ladok is when a student has no account
   * in SUKAT, the uid should thus be a socialSecurityNumber (10 chars)
   * @param uid
   * @return
   */
  public Map fetchLadokData(String uid) {
    Map ladokData = [:]

    if (!uid) {
      return ladokData
    }

    /** Turn 12 length ssn into 10 length */
    String ssn = chompUid(uid)
    if (utilityService.uidIsPnr(ssn)) {
      ladokData = ladokService.findStudentInLadok(ssn)
    }

    return ladokData
  }

  public Map getCardOrderStatus(SvcSuPersonVO user) {
    Map cardInfo = [:]

    try {
      /** TODO: Guessing we want to use LPW to fetch the proper addr. */
      Map address = ladokService.getAddressFromLadokByPnr(user.socialSecurityNumber)
      cardInfo.hasAddress = (null!=address && address.size()>0)

      // we may want to show info about the active cards a user already has
      cardInfo.suCards = sukatService.getCardsForUser(user.uid)

      // we may want to show info about cardorders that the user may have done
      cardInfo.cardOrders = sukatService.getCardOrdersForUser(user.uid)
      /** TODO: Check if we have active orders etc */
      cardInfo.canOrderCard = (cardInfo.hasAddress && canOrderCard(user))
    } catch (ex) {
      log.error "Failed when creating card order information object", ex
    }

    return cardInfo
  }

  private static String chompUid(String uid) {
    (uid?.length() == 12) ? uid[2..0] : uid
  }
}
