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
import grails.test.mixin.TestFor
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification

@TestFor(ResetPasswordController)
@Mock([EventLog, EventLogEvent])
class ResetPasswordControllerSpec extends Specification {

  def setup() {
    controller.utilityService = Mock(UtilityService) {
      getEventLog(*_) >> { return new EventLog().save(flush:true) }
    }
    controller.sukatService = Mock(SukatService)
  }

  void "index: test when scope is 'studera.nu', basic flow"() {
    given:
    def ssn = "8112129999"
    def user = new SvcSuPersonVO()
    user.setAccountIsActive(true)

    request.norEduPersonNIN = ssn

    when:
    controller.index()

    then:
    assert session.rpp.norEduPersonNIN == ssn

    assert response.redirectedUrl == '/resetPassword/resetPassword'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUsersBySocialSecurityNumber(ssn) >> [user]
  }

  def "index: test when scope is 'studera.nu' and none 'norEduPersonNIN' is set on request, should redirect to unverified account"() {
    when:
    controller.index()

    then:
    assert view == '/shared/unverifiedAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"
  }

  def "index: test when scope is 'bogus', should render flash error and redirect to dashboard"() {
    when:
    controller.index()

    then:
    assert response.redirectedUrl == '/dashboard/index'

    and:
    assert flash.error == 'activateAccountAndCardController.noValidScopeFound'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "bogus"
  }

  def "index: test when user is not found, should render flash error and redirect to dashboard"() {
    given:
    def ssn = "8112129999"

    request.norEduPersonNIN = ssn

    when:
    controller.index()

    then:
    assert session.rpp.norEduPersonNIN == ssn

    assert response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUsersBySocialSecurityNumber(ssn) >> [null]
  }

  def "index: test when user is found but account is inactive, should render flash error and redirect to dashboard"() {
    given:
    def ssn = "8112129999"
    def user = new SvcSuPersonVO()
    user.setAccountIsActive(false)

    request.norEduPersonNIN = ssn

    when:
    controller.index()

    then:
    assert session.rpp.norEduPersonNIN == ssn

    assert response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUsersBySocialSecurityNumber(ssn) >> [user]
  }

  def "index: test when multiple users are found, should render flash error and redirect to dashboard"() {
    given:
    def ssn = "8112129999"
    def user = new SvcSuPersonVO()
    user.setAccountIsActive(false)

    request.norEduPersonNIN = ssn

    when:
    controller.index()

    then:
    assert session.rpp.norEduPersonNIN == ssn

    assert response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUsersBySocialSecurityNumber(ssn) >> [user, user]
  }
}
