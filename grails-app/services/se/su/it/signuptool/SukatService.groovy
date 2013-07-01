package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy
import org.apache.cxf.configuration.security.AuthorizationPolicy
import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.transport.http.HTTPConduit
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.svc.SuCard
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcUidPwd

import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  AccountServiceImpl accountWS
  EnrollmentServiceImpl enrollmentWS
  Status statusWS
  WebServiceAdminImpl webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"

  public AccountServiceImpl getAccountWS() {
    return getFactory(AccountServiceImpl.class, grailsApplication.config.sukatsvc.accountservice)
  }

  public CardInfoServiceImpl getCardInfoWS() {
    return getFactory(CardInfoServiceImpl.class, grailsApplication.config.sukatsvc.cardinfoservice)
  }

  public EnrollmentServiceImpl getEnrollmentWS() {
    return getFactory(EnrollmentServiceImpl.class, grailsApplication.config.sukatsvc.enrollmentservice)
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
  public List<SuCard> getCardsForUser(String uid) {
    List<SuCard> cards = []
    try {
      cards = getCardInfoWS().getAllCards(uid,true,getAuditObject())
    } catch (Throwable exception) {
      cards = []
      exception.printStackTrace(System.out)
      log.error("Couldnt get cards for user ${uid} : ${exception.getMessage()}",exception)
    }
    return cards
  }

  public String getMailRoutingAddress(String uid) {
    try {
      return getAccountWS().getMailRoutingAddress(uid,getAuditObject())
    } catch (Exception ex) {
      ex.printStackTrace()
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
