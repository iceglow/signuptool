package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ActivateAccountAndCardService)
class ActivateAccountAndCardServiceSpec extends Specification {

  def setup() {
    service.sukatService = Mock(SukatService)
    service.ladokService = Mock(LadokService)
    service.utilityService = Mock(UtilityService)
  }

  def cleanup() {
  }

  void "canOrderCard: happy path"() {
    when:
    SvcSuPersonVO user = SvcSuPersonVO.newInstance()
    user.uid = "donaldDuck"
    boolean canOrder = service.canOrderCard(user)

    then:
    canOrder

    and:
    1 * service.sukatService.getCardsForUser(*_) >> []
  }

  void "canOrderCard: user already has card"() {
    when:
    SvcSuPersonVO user = SvcSuPersonVO.newInstance()
    user.uid = "donaldDuck"
    boolean canOrder = service.canOrderCard(user)

    then:
    !canOrder

    and:
    1 * service.sukatService.getCardsForUser(*_) >> ["placeholder for card"]
  }

  @Unroll
  void "validateForwardAddress (invalid): \'#email\' "() {
    expect: 'will return false'
    !service.validateForwardAddress(email)
    where:
    email << [null, '', ' ', 'trixy', 'trixy@', '@trixy',
        '!"#@!"#!', '!trixy@trixy.com', 'trixy@trixy!.com', 'trixy@trixy', 'trixy@trixy_.com']
  }
  @Unroll
  void "validateForwardAddress (valid): \'#email\' "() {
    expect: 'will return true'
    service.validateForwardAddress(email)
    where:
    email << ['a@b.se', 'a@b.info', 'a.b@c.nu', 'a_b@cd.ef']
  }

  void "findUser: when given user \'#user\'"() {
    expect:
    null == service.findUser(user, false)

    where:
    user << [null, '']
  }

  void "findUser: When uid is pnr but no user is found."() {
    when:
    def resp = service.findUser('someUid', true)

    then:
    resp == null

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO()
  }

  void "findUser: When uid is pnr."() {
    when:
    def resp = service.findUser('someUid', true)

    then:
    resp instanceof SvcSuPersonVO

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO(uid:'withUid')
  }

  void "findUser: with regular sukat uid but no user is found."() {
    when:
    def resp = service.findUser('someUid', false)

    then:
    resp == null

    and:
    1 * service.sukatService.findUserByUid(*_) >> new SvcSuPersonVO()
  }

  void "findUser: with regular sukat uid"() {
    when:
    def resp = service.findUser('someUid', false)

    then:
    resp instanceof SvcSuPersonVO

    and:
    1 * service.sukatService.findUserByUid(*_) >> new SvcSuPersonVO(uid:'withUid')
  }

  void "fetchLadokData: Given uid \'#uid\'"() {
    expect:
    [:] == service.fetchLadokData(uid)

    where:
    uid << [null, '']
  }

  @Unroll
  void "chompUid: When given uid: \'#uid\' we expect '\'#expected\'"() {
    expect:
    ActivateAccountAndCardService.chompUid(uid)

    where:
    uid             | expected
    '***********'   | '***********'   // 11 chars, nothing happens.
    '++**********'  | '*********'     // 12 chars, first 2 chars should be cut.
    '++***********' | '++***********' // 13 chars, nothing happens.
  }

  void "userHasRegisteredAddress: When user has no registered address, should return false"() {
    given:
    def user = new SvcSuPersonVO()
    user.uid = "asdasdasd"

    when:
    def res = service.userHasRegisteredAddress("asdasdasd", false)

    then:
    assert !res

    and:
    1 * service.sukatService.findUserByUid(*_) >> user
  }

  void "userHasRegisteredAddress: When user has registered address, should return true"() {
    given:
    def user = new SvcSuPersonVO()
    user.registeredAddress = "Gatan 13"
    user.uid = "asdasdasd"

    when:
    def res = service.userHasRegisteredAddress("asdasdasd", false)

    then:
    assert res

    and:
    1 * service.sukatService.findUserByUid(*_) >> user
  }

  void "fetchLadokData: When uid is chomped but it's not a pnr uid"() {
    when:
    def resp = service.fetchLadokData('abc123efg456')

    then:
    resp == [:]

    and:
    1 * service.utilityService.uidIsPnr(*_) >> false
    0 * service.ladokService.findStudentInLadok(*_)
  }

  void "fetchLadokData: When uid is chomped and is a pnr uid"() {
    when:
    def resp = service.fetchLadokData('abc123efg456')

    then:
    resp.enamn == 'kaka'
    resp.tnamn == 'foo'

    and:
    1 * service.utilityService.uidIsPnr(*_) >> true
    1 * service.ladokService.findStudentInLadok(*_) >> [enamn:'kaka', tnamn:'foo']
  }
}
