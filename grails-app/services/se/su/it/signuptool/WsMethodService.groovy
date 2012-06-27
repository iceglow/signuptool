package se.su.it.signuptool

import se.su.it.sukat.client.*
import se.su.it.sucard.client.CardOrderVO
import se.su.it.sucard.client.CardOrderFacadePortType
import org.springframework.web.context.request.RequestContextHolder

class WsMethodService {
  static scope = "prototype"
  boolean transactional = false

  def wsAccessService

  def enrollUser(String givenName, String sn, String nin)
  {
    try {
      def facade = wsAccessService.getFacade(EnrollmentFacade.class)
      // Using 'other' since other affiliations will be set by some script.
      return facade.enrollUser("student.su.se", givenName, sn, "other", nin, getLogObject())
    }
    catch (Exception e) {
      log.error(e.toString())
      throw e
    }
  }

  def getMailRoutingAddress(String uid)
  {
    try {
      def facade = wsAccessService.getFacade(MailRoutingFacade.class)
      return facade.getMailRoutingAddress(uid)
    }
    catch (Exception e) {
      log.error(e.toString())
      throw e
    }
  }

  def setMailRoutingAddress(String uid, String mailRoutingAddress)
  {
    try {
      def facade = wsAccessService.getFacade(MailRoutingFacade.class)
      facade.setMailRoutingAddress(uid,mailRoutingAddress,getLogObject())
      return true
    }

    catch (Exception e) {
      log.error(e.toString())
      return false
    }
  }


  def getMail(String uid)
  {
    try {
      def facade = wsAccessService.getFacade(UserContactFacade.class)
      return facade.getMail(uid)
    }
    catch (Exception e) {
      log.error(e.toString())
      throw e
    }
  }

  def setMail(String uid, String mail)
  {
    try {
      def facade = wsAccessService.getFacade(MailRoutingFacade.class)
      facade.setMailRoutingAddress(uid,mail,getLogObject())
      return true
    }

    catch (Exception e) {
      log.error(e.toString())
      return false
    }
  }

  CardOrderVO[] getCardOrdersForUser(String uid) {
    try {  
      def facade = wsAccessService.getFacade(CardOrderFacadePortType.class)
      return facade.getCardOrdersForUser(uid).getCardOrderVO()
    }
    catch (Exception e) {
      log.error(e.toString())
      return null
    }

  }

  def orderCard(CardOrderVO covo) {
    try {
      def facade = wsAccessService.getFacade(CardOrderFacadePortType.class)
      facade.orderCard(covo)
      return true
    }

    catch (Exception e) {
      log.error(e.toString())
      return false
    }
  }

  private se.su.it.sukat.client.AuditVO getLogObject() {
    def webRequest = RequestContextHolder.currentRequestAttributes()

    def uid = "signuptool"
    def ip = java.net.InetAddress.getLocalHost().getHostAddress()
    def client = webRequest.getRequest().getRemoteAddr()

    se.su.it.sukat.client.AuditVO lo = new se.su.it.sukat.client.AuditVO(uid: uid, ipAddress: ip, client: client)
    return lo
  }
}
