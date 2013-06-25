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
  def factoryMap = [:]

  public AccountServiceImpl getAccountWS() {
    return getFactory(AccountServiceImpl.class, grailsApplication.config.sukatsvc.accountservice)
  }

  public EnrollmentServiceImpl getEnrollmentWS() {
    return getFactory(EnrollmentServiceImpl.class, grailsApplication.config.sukatsvc.enrollmentservice)
  }

  public Status getStatusWS() {
    return getFactory(Status.class, grailsApplication.config.sukatsvc.statusservice)
  }

  public WebServiceAdminImpl getWebAdminWS() {
    return getFactory(WebServiceAdminImpl.class, grailsApplication.config.sukatsvc.webserviceadmin)
  }

  private Object getFactory(Class cz, String url) {
    final long startTime = System.nanoTime()
    final long endTime;
    def theFactory = null

    synchronized (factoryMap) {
      theFactory = factoryMap.get(cz.name)
      if (theFactory == null) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean()
        factory.setServiceClass(cz)
        factory.setAddress(url)
        factory.getInInterceptors().add(new org.apache.cxf.interceptor.LoggingInInterceptor())
        factory.getOutInterceptors().add(new org.apache.cxf.interceptor.LoggingOutInterceptor())
        Client client
        try {

          theFactory = factory.create()
          client = ClientProxy.getClient(theFactory)
          factoryMap.put(cz.name, theFactory)
        } catch (e) {
//      e.printStackTrace()
        }
        if (client != null) {
          HTTPConduit conduit = (HTTPConduit) client.getConduit()
          HTTPClientPolicy policy = new HTTPClientPolicy()
          policy.setConnectionTimeout(10000)
          policy.setReceiveTimeout(10000)

          conduit.setClient(policy)

          def auth = new AuthorizationPolicy()
          auth.setAuthorizationType("Negotiate")
          conduit.setAuthorization(auth)

          //This bypasses certificate checks, god for testing with selfsigned certificates
          //Remove this code when you have a valid certificate on the server
          /*BEGIN
          TLSClientParameters tcp = new TLSClientParameters()
          TrustManager[] tm = new TrustManager[1]
          tm[0] = new TrustAllX509TrustManager()
          tcp.setTrustManagers(tm)
          tcp.setDisableCNCheck(true)
          conduit.setTlsClientParameters(tcp)

          *///END
        }
      }
    }
    endTime = System.nanoTime()
    final long duration = endTime - startTime
    log.debug("Getting clientproxy time (in sec) of ${theFactory.getEndpointReference()}: ${duration / 1000000000}")
    return theFactory
  }

/*
public class TrustAllX509TrustManager implements X509TrustManager {
  public static final TrustAllX509TrustManager INSTANCE = new TrustAllX509TrustManager();
  @Override
  public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
  }
  @Override
  public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
  }
  @Override
  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }
}
*/


  public SvcUidPwd enrollUser(String givenName, String sn, String nin) {
    try {
      return getEnrollmentWS().enrollUser("student.su.se",givenName,sn,"other",nin,getAuditObject())
    } catch (Exception ex) {
      ex.printStackTrace()
      return null
    }
  }

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

}
