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
