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

import grails.test.mixin.*
import org.apache.commons.logging.Log
import se.su.it.config.ConfigService
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification

@TestFor(ActivateAccountAndCardController)
@Mock([EventLog, EventLogEvent])
class ActivateAccountAndCardControllerSpec extends Specification {

  private final String DEFAULT_SCOPE = "studera.nu"

  def setup() {
    controller.utilityService = Mock(UtilityService) {
      getEventLog(*_) >> { return new EventLog().save(flush:true) }
    }
    controller.ladokService = Mock(LadokService)
    controller.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    controller.configService = Mock(ConfigService)
    controller.sukatService = Mock(SukatService)
    controller.log = Mock(Log)
  }

  def "index: Testing the password passing."() {
    given:
    session.password = 's3cret!'

    when:
    controller.index()

    then:
    session.password == null

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
  }

  def "index: handle studera.nu unverified account (missing norEduPersonNIN)"() {
    when:
    controller.index()

    then:
    view == '/shared/unverifiedAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"
  }

  def "index: Test unhandled scope when users nin is not in the session."() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'
    and:
    flash.error == "activateAccountAndCardController.noValidScopeFound"

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.sen"
  }

  def "index: Test when session has reference id, should log to event log"() {
    given:
    session.referenceId = "1234567"

    when:
    controller.index()

    then:
    1 * controller.utilityService.getEventLog(*_) >> { return new EventLog().save(flush:true) }
  }

  def "index: Test when session has reference id and eventlog throws exception, should log error, create user error message and redirect to dashboard"() {
    given:
    session.referenceId = "1234567"

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.errors.genericError'

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException("Booom!") }
  }

  def "index: if we have an active user, we should use it"() {
    given:
    def user = new SvcSuPersonVO(uid: 'foo', accountIsActive: true)
    session.user = user
    session.nin = 'socialSecurityNumber'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/index'

    and:
    model.uid == user.uid
  }

  def "index: Testing when nin is already in the session."() {
    given:
    session.nin = 'socialSecurityNumber'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/userNotFoundInLadok'

    and:
    0 * controller.utilityService.getScopeFromEppn(*_)
  }

  def "index: When nin is set in the session but finding the user throws an exception."() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.errorWhenFetchingUser'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> { throw new RuntimeException('foo') }
  }

  def "index: Trying to create a new user (uid not found in sukat), but user is not found in ladok.."() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/userNotFoundInLadok'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> null
  }

  def "index: Trying to create a new user (uid not found in sukat), and fetching ladok data throws an exception"() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> { throw new RuntimeException('foo')}
  }

  def "index: Trying to create a new user (uid not found in sukat)"() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/activateAccountAndCard/createNewAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> [enamn:'foo', tnamn:'kaka']
  }

  def "index: When a user is found in sukat"() {
    given:
    session.password = 's3cret!'
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/index'

    and:
    model.uid == 'foo'
    model.password == 's3cret!'
    model.lpwurl == "lpwtoolUrl"
    model.sukaturl == "sukattoolUrl"

    and:
    session.password == null

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> [new SvcSuPersonVO(uid:'foo', accountIsActive: true)]
    0 * controller.activateAccountAndCardService.fetchLadokData(*_)
    2 * controller.configService.getValue(_,_) >> { String arg1, String arg2 ->
      assert arg1 == "signup"
      if (arg2 == "lpwtool") { return "lpwtoolUrl" }
      if (arg2 == "sukattool") { return "sukattoolUrl" }
      return null
    }
  }

  def "index: When a stub is found in SUKAT"() {
    given:
    request.norEduPersonNIN = '191102023333'
    flash.password = 's3cret!'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/activateAccountAndCard/createNewAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> [new SvcSuPersonVO(uid:'foo', accountIsActive: false)]
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> [enamn:'enamn', tnamn:'tnamn']
  }

  def "index: When multiple users are found in sukat"() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'sukat.errors.multipleUsersForSSN'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.sukatService.findUsersBySocialSecurityNumber(*_) >> [new SvcSuPersonVO(), new SvcSuPersonVO()]
  }

  def "changeLanguage: test when the locale is sv_SE, should toggle to en_US"() {
    given:
    session.locale = "sv_SE"

    when:
    controller.changeLanguage()

    then:
    assert session.locale == 'en_US'

    assert response.redirectedUrl == '/activateAccountAndCard/index?lang=en_US'
  }

  def "changeLanguage: test when the locale is en_US, should toggle to sv_SE"() {
    given:
    session.locale = "en_US"

    when:
    controller.changeLanguage()

    then:
    assert session.locale == 'sv_SE'

    assert response.redirectedUrl == '/activateAccountAndCard/index?lang=sv_SE'
  }
}
