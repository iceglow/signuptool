package se.su.it.signuptool

import se.su.it.svc.SuCard
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardInfoServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl
import se.su.it.svc.CardOrderServiceImpl

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  AccountServiceImpl accountWS
  CardInfoServiceImpl cardInfoServiceImpl
  CardOrderServiceImpl cardOrderWS
  EnrollmentServiceImpl enrollmentWS
  Status statusWS
  WebServiceAdminImpl webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"
  private final CARD_ORDER_STATUSES_TO_SKIP = ["DISCARDED", "WRITTEN_TO_SUKAT"]

  public String orderCard(SvcSuPersonVO user, Map ladokAddress) {
    String response = null

    try {
      SvcCardOrderVO cardOrderVO = createCardOrderVO(user, ladokAddress)
      response = cardOrderWS.orderCard(cardOrderVO, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Card order failed", ex
      throw(ex)
    }
    return response
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
      log.error "Failed when finding user by ssn in ldap.", ex
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

    try {
      response = enrollmentWS.enrollUserWithMailRoutingAddress(
          DEFAULT_DOMAIN,
          givenName,
          sn,
          DEFAULT_AFFILATION,
          socialSecurityNumber,
          forwardAddress,
          AuditFactory.auditObject
      )
    } catch (ex) {
      log.error "Enrolling student failed.", ex
    }

    return response
  }
}
