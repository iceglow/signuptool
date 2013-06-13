package se.su.it.signuptool

import grails.test.mixin.TestFor
import se.su.it.config.ConfigService
import se.su.it.sucard.client.ArrayOfCardOrderVO
import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO
import se.su.it.ws.commons.WSLocatorFactory
import spock.lang.Specification

@TestFor(SuCardService)
class SuCardServiceSpec extends Specification {

  def setup() {
    service.configService = Mock(ConfigService)
    service.wsLocatorFactory = Mock(WSLocatorFactory)
    service.cardOrderFacade = Mock(CardOrderFacadePortType)
  }

  def "getCardOrdersForUser: test when uid is null, should return null"() {
    given:
    String uid = null

    when:
    def res = service.getCardOrdersForUser(uid)

    then:
    assert !res
  }

  def "getCardOrdersForUser: test when uid is empty string, should return null"() {
    given:
    String uid = ''

    when:
    def res = service.getCardOrdersForUser(uid)

    then:
    assert !res
  }

  def "getCardOrdersForUser: test when facade throws exception, should return null"() {
    given:
    String uid = "evil1234@it.su.se"

    when:
    def res = service.getCardOrdersForUser(uid)

    then:
    assert !res

    and:
    1 * service.cardOrderFacade.getCardOrdersForUser(uid) >> { throw new RuntimeException('...') }
  }

  def "getCardOrdersForUser: test basic flow, should return CardOrderVO[]"() {
    given:
    String uid = "evil1234@it.su.se"

    def arrayOfCardOrderVO = new ArrayOfCardOrderVO()
    CardOrderVO [] cardOrderVOs = [new CardOrderVO()]

    arrayOfCardOrderVO.setCardOrderVO(cardOrderVOs)

    when:
    def res = service.getCardOrdersForUser(uid)

    then:
    assert res

    and:
    1 * service.cardOrderFacade.getCardOrdersForUser(*_) >> {arrayOfCardOrderVO}
  }

  def "orderCard: test when CardOrderVO is null, should return false"() {
    given:
    CardOrderVO cardOrderVO = null

    when:
    def res = service.orderCard(cardOrderVO)

    then:
    assert !res
  }

  def "orderCard: test when call do facade generates exception, should return false"() {
    given:
    CardOrderVO cardOrderVO = new CardOrderVO()

    when:
    def res = service.orderCard(cardOrderVO)

    then:
    assert !res

    and:
    1 * service.cardOrderFacade.orderCard(*_) >> { throw new RuntimeException('...') }
  }

  def "orderCard: test basic flow, should return true"() {
    given:
    CardOrderVO cardOrderVO = new CardOrderVO()

    when:
    def res = service.orderCard(cardOrderVO)

    then:
    assert res

    and:
    1 * service.cardOrderFacade.orderCard(*_)
  }
}
