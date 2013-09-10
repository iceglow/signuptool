package se.su.it.signuptool

import grails.test.mixin.TestFor
import org.junit.Before
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardOrderServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.SvcAudit
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.WebServiceAdminImpl
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SukatService)
class SukatServiceSpec extends Specification {

  @Before
  def setup() {
    service.accountWS     = Mock(AccountServiceImpl)
    service.statusWS      = Mock(Status)
    service.webAdminWS    = Mock(WebServiceAdminImpl)
    service.cardOrderWS   = Mock(CardOrderServiceImpl)

    GroovyMock(AuditFactory, global: true)
    AuditFactory.auditObject >> new SvcAudit()
  }

  def "findUserBySocialSecurityNumber"() {
    when:
    def resp = service.findUsersBySocialSecurityNumber('8008080000')

    then:
    resp instanceof List
    resp.first().givenName == 'kaka'

    and:
    1 * service.accountWS.findAllSuPersonsBySocialSecurityNumber(*_) >> { return [new SvcSuPersonVO(givenName:'kaka')] }
  }


  def "findUserBySocialSecurityNumber: On error returns null"() {
    when:
    service.findUsersBySocialSecurityNumber('8008080000')

    then:
    thrown(Exception)

    and:
    1 * service.accountWS.findAllSuPersonsBySocialSecurityNumber(*_) >> { throw new RuntimeException('foo') }
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

  //TODO: Test new methods

  def "generateStudentUid"() {
    when:
    def res = service.generateStudentUid('foo', 'bar')

    then:
    1 * service.accountWS.findSuPersonByUid(*_) >> null
    res
  }

  def "generateStudentUid: retries on collision"() {
    when:
    def res = service.generateStudentUid('foo', 'bar')

    then:
    2 * service.accountWS.findSuPersonByUid(*_) >>> [new SvcSuPersonVO(), null]
    res
  }

  def "generateStudentUid: retries on exception"() {
    when:
    def res = service.generateStudentUid('foo', 'bar')

    then:
    1 * service.accountWS.findSuPersonByUid(*_) >> {throw new RuntimeException('')}
    1 * service.accountWS.findSuPersonByUid(*_) >> null
    res
  }

  def "createSuPersonStub"() {
    given:
    def givenName = 'given'
    def sn = 'sn'
    def ssn = '1' *10
    def uid = 'gisn1234'
    def spy = Spy(SukatService)
    spy.accountWS = service.accountWS

    when:
    def res = spy.createSuPersonStub(givenName, sn, ssn)

    then:
    1 * spy.generateStudentUid(givenName, sn) >> uid
    1 * spy.accountWS.createSuPerson(uid, givenName, sn, ssn, _)
    res == uid
  }

  def "setMailRoutingAddress"() {
    given:
    def uid = 'gisn1234'
    def mail = 'mail'

    when:
    service.setMailRoutingAddress(uid, mail)

    then:
    1 * service.accountWS.setMailRoutingAddress(uid, mail, _)
  }

  def "activateUser"() {
    given:
    def uid = 'gisn1234'

    when:
    service.activateUser(uid)

    then:
    1 * service.accountWS.activateSuPerson(uid, SukatService.DEFAULT_DOMAIN, [SukatService.DEFAULT_AFFILATION], _)
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
