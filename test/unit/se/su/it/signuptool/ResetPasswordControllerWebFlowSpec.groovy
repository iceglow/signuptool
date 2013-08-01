package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
@Mock([EventLog, EventLogEvent])
class ResetPasswordControllerWebFlowSpec extends Specification {
  @Shared
  controller

  def setup() {
    def myController = mockController(ResetPasswordController)
    myController.utilityService = Mock(UtilityService) {
      getEventLog(*_) >> { return new EventLog().save(flush:true) }
    }
    myController.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    myController.sukatService = Mock(SukatService)
    controller = myController
  }

  def "resetPasswordFlow: test start state transition, should progress to resetPassword state"() {
    expect:
    assert 'resetPassword' == resetPasswordFlow.confirmResetPassword.on.ok.to
  }

  def "resetPasswordFlow: test resetPassword state transition when eventLog throws Exception, should progress to errorHandler"() {
    when:
    def resp = resetPasswordFlow.resetPassword.action()

    then:
    assert resp == 'error'

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException('exception') }
  }

  def "resetPasswordFlow: test resetPassword state transition when sukatService throws Exception, should progress to errorHandler and generate user error message"() {
    when:
    def resp = resetPasswordFlow.resetPassword.action()

    then:
    assert resp == 'error'
    assert flow.error == 'resetPassword.errors.passwordResetFailed'

    and:
    1 * controller.sukatService.resetPassword(*_) >> { throw new RuntimeException('exception') }
  }

  def "resetPasswordFlow: test resetPassword state transition when success, should progress to end and display password and uid"() {
    given:
    def password = 'p@ssw0rd'

    def user = new SvcSuPersonVO()
    user.setUid('test1234')

    session.user = user

    when:
    resetPasswordFlow.resetPassword.action()

    then:
    assert flash.password == password
    assert flash.uid == user.uid

    and:
    1 * controller.sukatService.resetPassword(*_) >> { return password }
  }

  def "resetPasswordFlow: test errorHandler state transition when success, should progress to errorPage"() {
    expect:
    assert 'errorPage' == resetPasswordFlow.errorHandler.on.success.to
  }

  def "resetPasswordFlow: test errorPage state transition, should progress to dashboard"() {
    expect:
    assert 'dashboard' == resetPasswordFlow.errorPage.on.continue.to
  }

  def "resetPasswordFlow: test dashboard state transition, should progress to end"() {
    expect:
    assert 'end' == resetPasswordFlow.dashboard.on.success.to
  }
}
