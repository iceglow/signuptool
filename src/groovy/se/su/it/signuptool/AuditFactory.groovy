package se.su.it.signuptool

import groovy.util.logging.Slf4j
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.svc.SvcAudit

@Slf4j
class AuditFactory {

  public static SvcAudit getAuditObject() {
    SvcAudit svcAudit = null
    try {
      def attributes = RequestContextHolder.requestAttributes
      def uid = attributes?.getAttribute('REMOTE_USER', 0)
      def ip = InetAddress.getLocalHost().getHostAddress()
      def client = attributes.getAttribute('REMOTE_ADDR', 0)
      svcAudit = new SvcAudit(uid: uid, client: client, ipAddress: ip)
    } catch (ex) {
      log.error "Failed to create SVC audit object", ex
    }
    return svcAudit
  }
}
