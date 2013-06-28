package se.su.it.signuptool

import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.svc.SvcAudit
import spock.lang.Specification

class AuditFactorySpec extends Specification {
  void "getAuditObject"() {
    given:

    String eppn = 'test@su.se'
    String client = "127.0.0.1"

    RequestAttributes requestAttributes = Mock(RequestAttributes) {
      getAttribute(_,_) >> { String arg1, int arg2 ->
        assert arg2 == 0
        if (arg1 == 'REMOTE_USER') {
          return eppn
        } else if (arg1 == 'REMOTE_ADDR') {
          return client
        }
      }
    }

    RequestContextHolder.metaClass.static.getRequestAttributes = {
      return requestAttributes
    }

    when:
    SvcAudit svcAudit = AuditFactory.getAuditObject()

    then:
    svcAudit.uid == eppn
    svcAudit.client == client
    svcAudit.ipAddress != null
  }
}
