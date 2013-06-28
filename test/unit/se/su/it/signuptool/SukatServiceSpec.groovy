package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd
import se.su.it.svc.WebServiceAdminImpl
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SukatService)
class SukatServiceSpec extends Specification {

  def setup() {
    service.accountWS = Mock(AccountServiceImpl)
    service.enrollmentWS = Mock(EnrollmentServiceImpl)
    service.statusWS = Mock(Status)
    service.webAdminWS = Mock(WebServiceAdminImpl)

    AuditFactory.metaClass.static.auditObject = {
      return new SvcAudit()
    }
  }

  def cleanup() {
    AuditFactory.metaClass = null
  }

  def "findUserBySocialSecurityNumber"() {
    given:

    when:
    def resp = service.findUserBySocialSecurityNumber('8008080000')

    then:
    resp.givenName == 'kaka'

    and:
    1 * service.accountWS.findSuPersonBySocialSecurityNumber(*_) >> { return new SvcSuPersonVO(givenName:'kaka') }
  }


  def "findUserBySocialSecurityNumber: On error returns null"() {
    given:

    when:
    def resp = service.findUserBySocialSecurityNumber('8008080000')

    then:
    resp == null

    and:
    1 * service.accountWS.findSuPersonBySocialSecurityNumber(*_) >> { throw new RuntimeException('foo') }
  }

  def "enrollUser: No givenName returns null"() {
    expect:
    null == service.enrollUser('', 'sn', 'socialSecurityNumber')
  }

  def "enrollUser: No sn returns null"() {
    expect:
    null == service.enrollUser('givenName', '', 'socialSecurityNumber')
  }

  def "enrollUser: No socialSecurityNumber returns null"() {
    expect:
    null == service.enrollUser('givenName', 'sn', '')
  }

  def "enrollUser: When enrolling service fails with an exception."() {
    when:
    def resp = service.enrollUser('givenName', 'sn', 'socialSecurityNumber')

    then:
    resp == null

    and:
    1 * service.enrollmentWS.enrollUser(*_) >> { throw new RuntimeException('foo') }
  }

  def "enrollUser: When enrolling succeeds."() {
    def response = new SvcUidPwd(uid: 'kaka', password: 'foo123')

    when:
    def resp = service.enrollUser('givenName', 'sn', 'socialSecurityNumber')

    then:
    resp.uid == 'kaka'
    resp.password == 'foo123'

    and:
    1 * service.enrollmentWS.enrollUser(*_) >> { return response }
  }

}
