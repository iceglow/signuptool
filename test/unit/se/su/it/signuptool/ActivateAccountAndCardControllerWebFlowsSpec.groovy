package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import org.apache.commons.logging.Log
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
@Mock([EventLog, EventLogEvent])
class ActivateAccountAndCardControllerWebFlowsSpec extends Specification {

  @Shared
  controller

  def setup() {
    def myController = mockController(ActivateAccountAndCardController)
    myController.utilityService = Mock(UtilityService)
    myController.ladokService = Mock(LadokService)
    myController.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    myController.sukatService = Mock(SukatService)
    controller = myController
  }

  def "createNewAccountFlow > prepareForwardAddress: Check success pathing"() {
    expect:
    'activateAccount' == createNewAccountFlow.prepareForwardAddress.on.success.to
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
    resp == ['forwardAddress':'']
    'prepareForwardAddress' == lastEventName

    and:
    flash.info == "activateAccountAndCardController.unableToFetchForwardAddress"

    and:
    1 * controller.ladokService.findForwardAddressSuggestionForPnr(*_) >> { throw new RuntimeException('foo') }
  }

  def "createNewAccountFlow > activateAccount: Check success pathing"() {
    expect:
    'processEmailInput' == createNewAccountFlow.activateAccount.on.acceptAccountActivation.to
  }

  def "createNewAccountFlow > activateAccount: Assert that terms of use acceptance get persisted in flow."() {
    given:
    params.approveTermsOfUse = 'kakakaka'

    when:
    createNewAccountFlow.activateAccount.on.acceptAccountActivation.action()

    then:
    flow.approveTermsOfUse == 'kakakaka'
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
    resp == "activateAccount"
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
    session?.eventLog = new EventLog().save(flush:true)
    flow.approveTermsOfUse = true

    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> false

    and:
    flow.error == "activateAccountAndCardController.forwardEmail.explanation"

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
    session.password == response.password

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
    createNewAccountFlow.end

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
  }
}
