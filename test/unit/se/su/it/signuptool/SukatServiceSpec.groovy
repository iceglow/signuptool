package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.CardOrderServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.WebServiceAdminImpl
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SukatService)
class SukatServiceSpec extends Specification {

  def setup() {
    cleanup()
    service.accountWS       = Mock(AccountServiceImpl)
    service.statusWS        = Mock(Status)
    service.webAdminWS      = Mock(WebServiceAdminImpl)
    service.cardOrderWS     = Mock(CardOrderServiceImpl)
    service.utilityService  = Mock(UtilityService)
  }

  def cleanup() {}

  def "findUserBySocialSecurityNumber"() {
    given:
    def ssn = '8008080000'
    when:
    def resp = service.findUsersBySocialSecurityNumber(ssn)

    then:
    resp instanceof List
    resp.first().givenName == 'kaka'

    and:
    1 * service.accountWS.findAllSuPersonsBySocialSecurityNumber(*_) >> { return [new SvcSuPersonVO(givenName:'kaka')] }
    1 * service.utilityService.chompNinToSsn(ssn)
  }


  def "findUserBySocialSecurityNumber: On error returns null"() {
    given:
    def ssn = '8008080000'

    when:
    service.findUsersBySocialSecurityNumber(ssn)

    then:
    thrown(Exception)

    and:
    1 * service.accountWS.findAllSuPersonsBySocialSecurityNumber(*_) >> { throw new RuntimeException('foo') }
    1 * service.utilityService.chompNinToSsn(ssn)
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
    def accMock = Mock(AccountServiceImpl) {
      1 * createSuPerson('gisn1234', '1' *10, 'given', 'sn')
    }

    spy.accountWS = accMock
    spy.utilityService = Mock(UtilityService) {
      1 * chompNinToSsn(ssn) >> ssn
    }

    when:
    def res = spy.createSuPersonStub(givenName, sn, ssn)

    then:
    1 * spy.generateStudentUid(givenName, sn) >> uid
    res == uid
  }

  def "setMailRoutingAddress"() {
    given:
    def uid = 'gisn1234'
    def mail = 'mail'

    when:
    service.setMailRoutingAddress(uid, mail)

    then:
    1 * service.accountWS.setMailRoutingAddress('gisn1234', 'mail')
  }

  def "activateUser"() {
    given:
    def uid = 'gisn1234'

    when:
    service.activateUser(uid)

    then:
    1 * service.accountWS.activateSuPerson(uid, SukatService.DEFAULT_DOMAIN, [SukatService.DEFAULT_AFFILATION])
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
