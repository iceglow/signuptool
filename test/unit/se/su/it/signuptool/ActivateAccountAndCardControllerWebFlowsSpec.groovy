package se.su.it.signuptool

import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import org.apache.commons.logging.Log
import se.su.it.svc.SvcSuPersonVO
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

  def "createNewAccountFlow > processEmailInput: When not having accepted the terms of agreement "() {
    when:
    def resp = createNewAccountFlow.processEmailInput.action()

    then:
    resp == 'error'

    and:
    0 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> true

    and:
    flow.error == 'activateAccountAndCardController.forwardEmail.explanation'
  }

  def "createNewAccountFlow > processEmailInput: On success "() {
    given:
    flow.approveTermsOfUse = true

    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> true

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: given an invalid email"() {
    given:
    flow.approveTermsOfUse = true

    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> false

    and:
    flow.error == "activateAccountAndCardController.forwardEmail.explanation"

    and:
    1 * controller.eventLogService.logEvent(*_)

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: on successful email validation"() {
    given:
    flow.approveTermsOfUse = true
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

  def "orderCardFlow: test when user is missing account, should log event and redirect to error page"() {
    given:
    session.uid = "abcd1234@su.se"
    session.pnr = "1234567890"

    controller.metaClass.message = {LinkedHashMap code -> 'account error'}

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'error'

    assert flow.error == 'account error'

    and:
    2 * controller.activateAccountAndCardService.findUser(*_) >> null


    and:
    0 * controller.activateAccountAndCardService.canOrderCard(*_)

    and:
    0 * controller.ladokService.getAddressFromLadokByPnr(*_)

    and:
    1 * controller.eventLogService.logEvent(*_)
  }

  def "orderCardFlow: test when user has an account but is not allowed to order cards, should log event and redirect to error page"() {
    given:
    session.uid = "abcd1234@su.se"
    session.pnr = "1234567890"

    controller.metaClass.message = {LinkedHashMap code -> 'order card error'}

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'error'

    assert flow.error == 'order card error'

    and:
    3 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO()

    and:
    1 * controller.activateAccountAndCardService.canOrderCard(*_) >> false

    and:
    0 * controller.ladokService.getAddressFromLadokByPnr(*_)

    and:
    1 * controller.eventLogService.logEvent(*_)
  }

  def "orderCardFlow: test when user doesn't have ladok address, should log event and redirect to error page"() {
    given:
    session.uid = "abcd1234@su.se"
    session.pnr = "1234567890"

    controller.metaClass.message = {LinkedHashMap code -> 'address error'}

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'error'

    assert flow.error == 'address error'

    and:
    3 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO()

    and:
    1 * controller.activateAccountAndCardService.canOrderCard(*_) >> true

    and:
    1 * controller.ladokService.getAddressFromLadokByPnr(*_) >> null

    and:
    1 * controller.eventLogService.logEvent(*_)
  }

  def "orderCardFlow: test when user doesn't select if address is valid or in valid, should log event and redirect to cardOrder page with error message"() {
    given:
    flow.registeredAddressValid = false
    flow.registeredAddressInvalid = false

    controller.metaClass.message = {LinkedHashMap code -> 'address select error'}

    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'error'

    assert flow.error == 'address select error'

    assert 'cardOrder' == orderCardFlow.processCardOrder.on.error.to

    and:
    1 * controller.eventLogService.logEvent(*_)
  }

  def "orderCardFlow: test when user doesn't accept library rules, should log event and redirect to cardOrder page with error message"() {
    given:
    flow.registeredAddressValid = true
    flow.registeredAddressInvalid = false
    flow.acceptLibraryRules = false

    controller.metaClass.message = {LinkedHashMap code -> 'not accepting library rules error'}

    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'error'

    assert flow.error == 'not accepting library rules error'

    assert 'cardOrder' == orderCardFlow.processCardOrder.on.error.to

    and:
    1 * controller.eventLogService.logEvent(*_)
  }

  def "orderCardFlow: test when user select address is invalid, should log event and redirect to end"() {
    given:
    flow.registeredAddressValid = false
    flow.registeredAddressInvalid = true
    flow.acceptLibraryRules = false

    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'success'

    assert 'end' == orderCardFlow.processCardOrder.on.success.to

    and:
    1 * controller.eventLogService.logEvent(*_)
  }
}
