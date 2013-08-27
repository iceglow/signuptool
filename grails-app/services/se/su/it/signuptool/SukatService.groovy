package se.su.it.signuptool

import se.su.it.svc.SuCard
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def accountWS
  def cardInfoServiceImpl
  def cardOrderWS
  def enrollmentWS
  def statusWS
  def webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"
  private final CARD_ORDER_STATUSES_TO_SKIP = ["DISCARDED", "WRITTEN_TO_SUKAT"]

  public String orderCard(SvcSuPersonVO user, Map ladokAddress) {
    SvcCardOrderVO cardOrderVO = createCardOrderVO(user, ladokAddress)
    return cardOrderWS.orderCard(cardOrderVO, AuditFactory.auditObject)
  }

  private static SvcCardOrderVO createCardOrderVO(SvcSuPersonVO user, Map ladokAddress) {
    if (user == null) {
      throw new IllegalArgumentException('user is null')
    }

    if (!ladokAddress) {
      throw new IllegalArgumentException("Ladok address supplied is invalid ${ladokAddress?.dump()}")
    }

    SvcCardOrderVO cardOrderVO = new SvcCardOrderVO()
    cardOrderVO.firstname = user.givenName
    cardOrderVO.lastname = user.sn
    cardOrderVO.owner = user.uid
    cardOrderVO.streetaddress1 = ladokAddress?.gatadr
    cardOrderVO.streetaddress2 = ladokAddress?.coadr
    cardOrderVO.zipcode = ladokAddress?.postnr
    cardOrderVO.locality = ladokAddress?.ort
    return cardOrderVO
  }

  public List<SvcCardOrderVO> getCardOrdersForUser(String uid) {
    List<SvcCardOrderVO> cardOrders = []

    // call sukatsvc to fetch cardorders for user , something like findAllCardOrdersForUid in the CardOrderService
    cardOrders = cardOrderWS.findAllCardOrdersForUid(uid, AuditFactory.auditObject)

    if (!cardOrders) {
      return []
    }

    cardOrders.removeAll { (it?.value in CARD_ORDER_STATUSES_TO_SKIP) }

    return cardOrders
  }

  public List<SuCard> getCardsForUser(String uid) {
    List<SuCard> suCards = []
    try {
      suCards = cardInfoServiceImpl.getAllCards(uid, true, AuditFactory.auditObject)
    } catch (Throwable exception) {
      log.error "Failed when getting info about users cards: ${exception.getMessage()}", exception
      suCards = []
    }
    return suCards
  }

  public SvcSuPersonVO findUserBySocialSecurityNumber(String pnr) {
    SvcSuPersonVO suPerson = null
    try {
      suPerson = accountWS.findSuPersonBySocialSecurityNumber(pnr, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when finding user by ssn in SUKAT.", ex
      throw(ex)
    }
    return suPerson
  }

  public SvcUidPwd enrollUser(String givenName, String sn, String socialSecurityNumber, String forwardAddress) {

    if (!givenName?.trim()) {
      log.error "No givenName supplied."
      return null
    }

    if (!sn?.trim()) {
      log.error "No sn supplied."
      return null
    }

    if (!socialSecurityNumber?.trim()) {
      log.error "No socialSecurityNumber supplied."
      return null
    }

    SvcUidPwd response = null

    response = enrollmentWS.enrollUserWithMailRoutingAddress(
        DEFAULT_DOMAIN,
        givenName,
        sn,
        DEFAULT_AFFILATION,
        socialSecurityNumber,
        forwardAddress,
        AuditFactory.auditObject
    )

    return response
  }

  public String resetPassword(String uid) {
    return accountWS.resetPassword(uid, AuditFactory.auditObject)
  }
}
