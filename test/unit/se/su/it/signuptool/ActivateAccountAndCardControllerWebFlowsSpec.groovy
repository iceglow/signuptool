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
    controller.utilityService = Mock(UtilityService)
    controller.ladokService = Mock(LadokService)
    controller.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
  }

  def "orderCardFlow: test flow when user is found, has registered address and no cards or orders"() {
    given:
    session.uid = "abcd1234@su.se"

    when:

    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'success'
    assert 'success' == stateTransition

    and:
    1 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO()

    and:
    1 * controller.activateAccountAndCardService.userHasRegisteredAddress(*_) >> true

    and:
    1 * controller.activateAccountAndCardService.canOrderCard(*_) >> true
  }


}
