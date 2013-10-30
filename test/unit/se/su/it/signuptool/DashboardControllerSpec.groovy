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
import grails.util.Environment
import se.su.it.signuptool.mock.UseCase
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(DashboardController)
@Mock([UseCase])
class DashboardControllerSpec extends Specification {

  def setup() {
  }

  def cleanup() {
    Environment.metaClass = null
  }

  void "index"() {
    when:
    controller.index()

    then:
    view == '/dashboard/index'
  }
  @Unroll
  void "index with saved controller in session, controller: #target, expect: #destination"() {
    given:
    session.controller = target

    when:
    controller.index()

    then:
    response.redirectedUrl == destination

    and:
    session.controller == null

    where:
    target                    | destination
    'activateAccountAndCard'  | '/activateAccountAndCard/index'
    'resetPassword'           | '/resetPassword/index'
    'admin'                   | null
    null                      | null
  }

  void "activateAccountAndCard"() {
    given:
    Environment.metaClass.static.getCurrent = {
      [name:"mock"]
    }

    when:
    UseCase accountCase = new UseCase(type:UseCase.Type.ACCOUNT, name:'foo', displayName: 'use_case.foo', norEduPersonNIN: '1234', description: 'something').save(flush:true)
    UseCase cardCase = new UseCase(type:UseCase.Type.CARD, name:'foo', displayName: 'use_case.foo', norEduPersonNIN: '1234', description: 'something').save(flush:true)

    controller.activateAccountAndCard()

    then:
    view == '/dashboard/selectIdProvider'
    model['env'] == Environment.current.name
    model['accountUseCase'] == accountCase
    model['accountUseCases'] == [accountCase]
    model['cardUseCase'] == cardCase
    model['cardUseCases'] == [cardCase]

    and:
    session.controller == 'activateAccountAndCard'
  }

  void "resetAccountOrPassword"() {
    when:
    controller.resetAccountOrPassword()

    then:
    view == '/dashboard/selectPasswordIdp'

    and:
    session.controller == 'resetPassword'
  }
  @Unroll
  void "useCase: Expect method to not be available in env: #env"() {
    given:
    Environment.metaClass.static.getCurrent = {->
      return env
    }

    when:
    controller.useCase(1)

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'dashboard.faultyEnvironment'

    where:
    env << [Environment.DEVELOPMENT, Environment.PRODUCTION, Environment.TEST, Environment.CUSTOM]
  }

  void "useCase: Trying to load a useCase that does not exists yields"() {
    given:
    Environment.metaClass.static.getCurrent = {->
      [name:'mock']
    }

    when:
    controller.useCase(1)

    then:
    response.redirectedUrl == '/dashboard/index'
  }

  void "useCase: When loading a useCase"() {
    given:

    UseCase useCase = new UseCase(type:UseCase.Type.ACCOUNT, eppn: 'foo@kaka.se', name:'foo', displayName: 'use_case.foo', norEduPersonNIN: '1234', description: 'something').save(flush:true)

    Environment.metaClass.static.getCurrent = {->
      [name:'mock']
    }

    assert session.acp == null

    when:
    controller.useCase(useCase.id)

    then:
    session.acp.eppn == useCase.eppn
    session.acp.norEduPersonNIN == useCase.norEduPersonNIN

    response.redirectedUrl == '/activateAccountAndCard/index'
  }

}
