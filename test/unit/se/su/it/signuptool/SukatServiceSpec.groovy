package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcUidPwd
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SukatService)
class SukatServiceSpec extends Specification {

  def setup() {
  }

  def cleanup() {

    SukatService.metaClass = null
    SuPerson.metaClass = null
    EnrollmentServiceImpl.metaClass = null
  }

  def "findUserBySocialSecurityNumber"() {
    given:

    SuPerson suPerson = Mock(SuPerson) {
      getGivenName(*_) >> 'kaka'
    }

    SuPerson.metaClass.static.find = { Map arg1, Closure arg2 ->
      return suPerson
    }

    when:
    def resp = service.findUserBySocialSecurityNumber('8008080000')

    then:
    resp.givenName == 'kaka'
  }


  def "findUserByUid"() {
    given:

    SuPerson suPerson = Mock(SuPerson) {
      getGivenName(*_) >> 'kaka'
    }

    SuPerson.metaClass.static.find = { Map arg1, Closure arg2 ->
      return suPerson
    }

    when:
    def resp = service.findUserByUid('kaba')

    then:
    resp.givenName == 'kaka'
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
    expect:
    null == service.enrollUser('givenName', 'sn', 'socialSecurityNumber')
  }

  def "enrollUser: When enrolling succeeds."() {
    def response = new SvcUidPwd(uid: 'kaka', password: 'foo123')

    EnrollmentServiceImpl enrollmentWebService = Mock(EnrollmentServiceImpl) {
      enrollUser(*_) >> { return response }
    }

    SukatService.metaClass.getEnrollmentWS = {->
      return enrollmentWebService
    }

    SukatService.metaClass.getAuditObject = {->
      return new SvcAudit()
    }

    when:
    def resp = service.enrollUser('givenName', 'sn', 'socialSecurityNumber')

    then:
    resp.uid == 'kaka'
    resp.password == 'foo123'
  }

}
