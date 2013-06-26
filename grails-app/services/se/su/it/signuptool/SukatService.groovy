package se.su.it.signuptool

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy
import org.apache.cxf.configuration.security.AuthorizationPolicy
import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.transport.http.HTTPConduit
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcUidPwd

import java.security.cert.CertificateException
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager
import se.su.it.svc.CardInfoServiceImpl
import se.su.it.svc.CardAdminServiceImpl
import se.su.it.svc.EntitlementServiceImpl
import se.su.it.svc.ServiceServiceImpl
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl
import se.su.it.svc.RoleServiceImpl

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def grailsApplication

  AccountServiceImpl accountWS
  EnrollmentServiceImpl enrollmentWS
  Status statusWS
  WebServiceAdminImpl webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"

  public String getMailRoutingAddress(String uid) {
    try {
      return getAccountWS().getMailRoutingAddress(uid,getAuditObject())
    } catch (Exception ex) {
      ex.printStackTrace()
      return null
    }
  }

  public boolean setMailRoutingAddress(String uid, String mailRoutingAddress) {
    try {
      getAccountWS().setMailRoutingAddress(uid, mailRoutingAddress)
      return true
    } catch (Exception ex) {
      ex.printStackTrace()
      return false
    }
  }

  private SvcAudit getAuditObject() {
    /** TODO: Get the request attributes so we can get the request? Seems wierd to me. */
    def webRequest = RequestContextHolder.currentRequestAttributes()

    def uid = webRequest.getRequest().getRemoteUser()
    def ip = java.net.InetAddress.getLocalHost().getHostAddress()
    def client = webRequest.getRequest().getRemoteAddr()

    return new SvcAudit(uid: uid, client: client, ipAddress: ip)
  }

  public SuPerson findUserBySocialSecurityNumber(String pnr) {
    SuPerson suPerson = null
    try {
      suPerson = SuPerson.find(base: "") {
        and {
          eq("objectclass", "superson")
          eq("socialSecurityNumber", pnr)
        }
      }
    } catch (ex) {
      log.error "Failed when finding user by ssn in ldap.", ex
    }
    return suPerson
  }

  public SuPerson findUserByUid(String uid) {
    SuPerson suPerson = null
    try {
      suPerson = SuPerson.find(base: "") {
        and {
          eq("objectclass", "superson")
          eq("uid", uid)
        }
      }
    } catch (ex) {
      log.error "Failed when finding user by uid in ldap.", ex
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
      EnrollmentServiceImpl enrollmentWebService = getEnrollmentWS()

      response = enrollmentWebService.enrollUser(
          DEFAULT_DOMAIN,
          givenName,
          sn,
          DEFAULT_AFFILATION,
          socialSecurityNumber,
          auditObject
      )
    } catch (ex) {
      log.error "Enrolling student failed.", ex
    }

    return response
  }
}
