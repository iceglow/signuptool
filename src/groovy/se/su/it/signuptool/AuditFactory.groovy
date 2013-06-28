package se.su.it.signuptool

import groovy.util.logging.Slf4j
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.svc.SvcAudit

@Slf4j
class AuditFactory {

  private final static int SCOPE = 0 // 0 is request scope.
  private final static String USER_ATTRIBUTE = 'REMOTE_USER'
  private final static String ADDRESS_ATTRIBUTE = 'REMOTE_ADDR'

  public static SvcAudit getAuditObject() {
    SvcAudit svcAudit = null
    try {
      def attributes = RequestContextHolder.requestAttributes
      def uid = attributes?.getAttribute(USER_ATTRIBUTE, SCOPE)
      def ip = InetAddress.getLocalHost().getHostAddress()
      def client = attributes.getAttribute(ADDRESS_ATTRIBUTE, SCOPE)
      svcAudit = new SvcAudit(uid: uid, client: client, ipAddress: ip)
    } catch (ex) {
      log.error "Failed to create SVC audit object", ex
    }
    return svcAudit
  }
}
