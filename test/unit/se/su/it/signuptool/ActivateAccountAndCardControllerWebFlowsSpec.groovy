package se.su.it.signuptool

import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import org.apache.commons.logging.Log
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)

class ActivateAccountAndCardControllerWebFlowsSpec extends Specification {

  @Shared
  controller

  def setup() {
    def myController = mockController(ActivateAccountAndCardController)
    myController.utilityService = Mock(UtilityService)
    myController.ladokService = Mock(LadokService)
    myController.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    myController.eventLogService = Mock(EventLogService)
    myController.sukatService = Mock(SukatService)
    controller = myController
  }

  def "createNewAccountFlow > prepareForwardAddress: Check success pathing"() {
    expect:
    'activateAccount' == createNewAccountFlow.prepareForwardAddress.on.success.to
  }

  def "createNewAccountFlow > prepareForwardAddress: Check error pathing"() {
    expect:
    'errorHandler' == createNewAccountFlow.prepareForwardAddress.on.error.to
  }

  def "createNewAccountFlow > prepareForwardAddress: On success"() {
    given:
    def mail = 'kalle@example.com'

    when:
    def resp = createNewAccountFlow.prepareForwardAddress.action()

    then:
    resp == ['forwardAddress':mail]
    'prepareForwardAddress' == lastEventName

    and:
    1 * controller.ladokService.findForwardAddressSuggestionForPnr(*_) >> mail
  }

  def "createNewAccountFlow > prepareForwardAddress: throws an exception"() {
    when:
    def resp = createNewAccountFlow.prepareForwardAddress.action()

    then:
    resp == 'error'
    'prepareForwardAddress' == lastEventName

    and:
    1 * controller.ladokService.findForwardAddressSuggestionForPnr(*_) >> { throw new RuntimeException('foo') }
  }

  def "createNewAccountFlow > activateAccount: Check success pathing"() {
    expect:
    'processEmailInput' == createNewAccountFlow.activateAccount.on.acceptAccountActivation.to
  }

  def "createNewAccountFlow > processEmailInput: Check success pathing"() {
    expect:
    'createAccount' == createNewAccountFlow.processEmailInput.on.success.to
  }

  def "createNewAccountFlow > processEmailInput: Check error pathing"() {
    given:
    def error = 'clear me!'
    flow.error = error

    when:
    def resp = createNewAccountFlow.processEmailInput.on.error.to

    then:
    resp == "selectEmail"
    flow.error == error
  }

  def "createNewAccountFlow > processEmailInput: On success "() {
    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> true

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: given an invalid email"() {
    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> false

    and:
    flow.error == "Invalid Email"

    and:
    1 * controller.eventLogService.logEvent(*_)

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: on successful email validation"() {
    given:
    flow.error == 'clear me!'
    when:
    def resp = createNewAccountFlow.processEmailInput.on.success.action()

    then:
    resp == ""
    flow.error == ''
    lastTransitionName == 'success'
  }

  def "createNewAccountFlow > createAccount: Check success pathing"() {
    expect:
    'end' == createNewAccountFlow.createAccount.on.success.to
  }

  def "createNewAccountFlow > createAccount: Check error pathing"() {
    expect:
    'errorHandler' == createNewAccountFlow.createAccount.on.error.to
  }

  def "createNewAccountFlow > createAccount: On successful creation"() {
    given:
    session.givenName = 'givenName'
    session.sn = 'sn'
    session.pnr = 'socialSecurityNumber'
    def response = [uid:'uid', password:'password']

    when:
    createNewAccountFlow.createAccount.action()

    then:
    session.uid == response.uid
    flash.password == response.password

    and:
    flash.info == 'Account created!'

    and:
    1 * controller.sukatService.enrollUser(*_) >> { String arg1, String arg2, String arg3 ->
      assert arg1 == session.givenName
      assert arg2 == session.sn
      assert arg3 == session.pnr
      return response
    }
  }

  def "createNewAccountFlow > createAccount: creation fails."() {
    given:
    session.givenName = 'givenName'
    session.sn = 'sn'
    session.pnr = 'socialSecurityNumber'

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    session.uid == null
    flash.password == null

    and:
    flash.info == null
    flow.error == "activateAccountAndCardController.failedWhenEnrollingUser"

    and:
    1 * controller.sukatService.enrollUser(*_) >> { throw new RuntimeException('foo') }
  }

  def "createNewAccountFlow > errorHandler: Check success pathing"()  {
    expect:
    'end' == createNewAccountFlow.errorHandler.on.success.to
  }

  def "createNewAccountFlow > errorHandler: Test the errorhandler"()  {
    given:
    controller.log = Spy(Log) {
      error(_,_) >> { Object arg1, Throwable arg2 ->
        assert arg1.contains("Webflow Exception occurred")
      }
    }
    when:
    createNewAccountFlow.errorHandler.action()

    then: 'nothing to test here..'
    assert true
  }

  def "createNewAccountFlow > end: see that we end up on index again."()  {
    when:
    createNewAccountFlow.end.action()

    then:
    response.redirectedUrl == '/activateAccountAndCard/index'
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
    2 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO()

    and:
    1 * controller.activateAccountAndCardService.userHasRegisteredAddress(*_) >> true

    and:
    1 * controller.activateAccountAndCardService.canOrderCard(*_) >> true
  }
}
