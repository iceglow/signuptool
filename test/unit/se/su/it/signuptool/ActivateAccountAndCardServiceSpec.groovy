package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
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
    boolean canOrder = service.canOrderCard("donaldDuck")

    then:
    canOrder

    and:
    1 * service.sukatService.getCardsForUser(*_) >> []
  }

  void "canOrderCard: user already has card"() {
    when:
    boolean canOrder = service.canOrderCard("donaldDuck")

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
    null == service.findUser(user)

    where:
    user << [null, '']
  }

  void "findUser: When uid is pnr but no user is found."() {
    when:
    def resp = service.findUser('someUid')

    then:
    resp == null

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO()
  }

  void "findUser: When uid is pnr."() {
    when:
    def resp = service.findUser('someUid')

    then:
    resp instanceof SvcSuPersonVO

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO(uid:'withUid')
  }

  void "fetchLadokData: Given uid \'#uid\'"() {
    expect:
    [:] == service.fetchLadokData(uid)

    where:
    uid << [null, '']
  }

  void "fetchLadokData: Happy path"() {
    when:
    def resp = service.fetchLadokData('abc123efg456')

    then:
    resp.enamn == 'kaka'
    resp.tnamn == 'foo'

    and:
    1 * service.ladokService.findStudentInLadok(*_) >> [enamn:'kaka', tnamn:'foo']
  }
}
