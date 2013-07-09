package se.su.it.signuptool

import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
class ActivateAccountAndCardControllerWebFlowsSpec extends Specification {

  @Shared
  def controller

  def setup() {
    controller = mockController(ActivateAccountAndCardController)
    controller.eventLogService = Mock(EventLogService)
    controller.utilityService = Mock(UtilityService)
    controller.ladokService = Mock(LadokService)
    controller.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
  }

  def "orderCardFlow: test flow when user is found, has registered address and no cards or orders"() {
    given:
    session.uid = "abcd1234@su.se"
    session.pnr = "1234567890"

    when:

    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'success'
    assert 'success' == stateTransition

    and:
    3 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO()

    and:
    2 * controller.ladokService.getAddressFromLadokByPnr(*_) >> [kalle: 'anka']

    and:
    1 * controller.activateAccountAndCardService.canOrderCard(*_) >> true

    and:
    0 * controller.eventLogService.logEvent(*_) >> null
  }
}
