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

  public List<SvcCardOrderVO> getCardOrdersForUser(String uid) {
    List<SvcCardOrderVO> cardOrders = []

    // call sukatsvc to fetch cardorders for user , something like findAllCardOrdersForUid in the CardOrderService
    cardOrders = cardOrderWS.findAllCardOrdersForUid(uid, AuditFactory.auditObject)

    cardOrders.each { SvcCardOrderVO orderVO ->
      orderVO.firstname
      orderVO.lastname
      orderVO.serial
    }
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

  public void findAllCardOrdersForUid(String uid) {
    cardOrderWS.findAllCardOrdersForUid(uid, AuditFactory.auditObject)
  }

  public String getMailRoutingAddress(String uid) {
    String mailRoutingAddress = null
    try {
      mailRoutingAddress = accountWS.getMailRoutingAddress(uid, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when getting mail routing address", ex
      return null
    }
    return mailRoutingAddress
  }

  public boolean setMailRoutingAddress(String uid, String mailRoutingAddress) {
    try {
      accountWS.setMailRoutingAddress(uid, mailRoutingAddress, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when setting mail routing address", ex
      return false
    }
    return true
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

  public SvcSuPersonVO findUserByUid(String uid) {
    SvcSuPersonVO suPerson = null
    try {
      suPerson = accountWS.findSuPersonByUid(uid, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when finding user by ssn in ldap.", ex
    }
    return suPerson
  }

  public SvcUidPwd enrollUser(String givenName, String sn, String socialSecurityNumber) {

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

      response = enrollmentWS.enrollUser(
          DEFAULT_DOMAIN,
          givenName,
          sn,
          DEFAULT_AFFILATION,
          socialSecurityNumber,
          AuditFactory.auditObject
      )
    } catch (ex) {
      log.error "Enrolling student failed.", ex
    }

    return response
  }
}
