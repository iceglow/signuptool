/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import se.su.it.signuptool.commandobjects.ResetPasswordProcess
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
    session.referenceId = 1
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
    controller.utilityService.getEventLog(_) >> { throw new RuntimeException('exception') }
  }

  def "resetPasswordFlow: test resetPassword state transition when sukatService throws Exception, should progress to errorHandler and generate user error message"() {
    given:
    session.rpp = new ResetPasswordProcess(referenceId: 0)

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

    session.rpp = new ResetPasswordProcess(referenceId: 0, user: user)

    when:
    resetPasswordFlow.resetPassword.action()

    then:
    assert session.rpp.password == password
    assert session.rpp.user.uid == user.uid

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

  def "resetPasswordFlow: test dashboard state transition, should progress to prepareEnd"() {
    expect:
    assert 'prepareEnd' == resetPasswordFlow.dashboard.on.success.to
  }

  def "resetPasswordFlow: test prepareEnd state transition, should progress to end"() {
    expect:
    assert 'end' == resetPasswordFlow.prepareEnd.on.success.to
  }

  def "resetPasswordFlow: test prepareEnd action sets uid and password"() {
    given:
    def pass = 'foo'
    def uid = 'bar'
    session.rpp = new ResetPasswordProcess(password: pass, user: new SvcSuPersonVO(uid: uid))

    when:
    resetPasswordFlow.prepareEnd.action()

    then:
    flow.uid == uid
    flow.password == pass
  }
}
