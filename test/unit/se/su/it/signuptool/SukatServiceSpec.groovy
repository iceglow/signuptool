package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardOrderServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcCardOrderVO
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
    service.cardOrderWS = Mock(CardOrderServiceImpl)

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
    null == service.enrollUser('', 'sn', 'socialSecurityNumber', 'mailRoutingAddress')
  }

  def "enrollUser: No sn returns null"() {
    expect:
    null == service.enrollUser('givenName', '', 'socialSecurityNumber', 'mailRoutingAddress')
  }

  def "enrollUser: No socialSecurityNumber returns null"() {
    expect:
    null == service.enrollUser('givenName', 'sn', '', 'mailRoutingAddress')
  }

  def "enrollUser: When enrolling service fails with an exception."() {
    when:
    def resp = service.enrollUser('givenName', 'sn', 'socialSecurityNumber', 'mailRoutingAddress')

    then:
    resp == null

    and:
    1 * service.enrollmentWS.enrollUserWithMailRoutingAddress(*_) >> { throw new RuntimeException('foo') }
  }

  def "enrollUser: When enrolling succeeds."() {
    def response = new SvcUidPwd(uid: 'kaka', password: 'foo123')

    when:
    def resp = service.enrollUser('givenName', 'sn', 'socialSecurityNumber', 'mailRoutingAddress')

    then:
    resp.uid == 'kaka'
    resp.password == 'foo123'

    and:
    1 * service.enrollmentWS.enrollUserWithMailRoutingAddress(*_) >> { return response }
  }

  def "createCardOrderVO: when supplied user is null"() {
    when:
    service.createCardOrderVO(null, [:])

    then:
    thrown(IllegalArgumentException)
  }

  def "createCardOrderVO: when supplied address map is empty"() {
    given:
    SvcSuPersonVO user = new SvcSuPersonVO(uid:'foo')

    when:
    service.createCardOrderVO(user, [:])

    then:
    thrown(IllegalArgumentException)
  }


  def "createCardOrderVO: when applying attributes to the orderVO"() {
    given:
    SvcSuPersonVO user = new SvcSuPersonVO(
        givenName:'givenName',
        sn:'sn'
    )

    Map ladokAddress = [gatadr: 'gatadr', coadr: 'coadr', postnr: 'postnr', ort: 'ort']

    when:
    def resp = service.createCardOrderVO(user, ladokAddress)

    then:
    resp instanceof SvcCardOrderVO

    and:
    resp.firstname == user.givenName
    resp.lastname == user.sn
    resp.streetaddress1 == ladokAddress.gatadr
    resp.streetaddress2 == ladokAddress.coadr
    resp.zipcode == ladokAddress.postnr
    resp.locality == ladokAddress.ort
  }

  def "orderCard: When an exception is thrown"() {
    when:
    service.orderCard(null, null)

    then:
    thrown(IllegalArgumentException)

    and:
    0 * service.cardOrderWS.orderCard(*_)
  }

  def "orderCard: Happy path"() {
    given:
    def responseText = 'success'

    SvcSuPersonVO user = new SvcSuPersonVO(
        givenName:'givenName',
        sn:'sn'
    )

    Map ladokAddress = [gatadr: 'gatadr', coadr: 'coadr', postnr: 'postnr', ort: 'ort']

    when:
    def response = service.orderCard(user, ladokAddress)

    then:
    responseText == response

    and:
    1 * service.cardOrderWS.orderCard(*_) >> responseText
  }

}
