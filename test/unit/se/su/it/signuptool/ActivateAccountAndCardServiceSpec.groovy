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

import grails.test.mixin.TestFor
import se.su.it.svc.SuCard
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ActivateAccountAndCardService)
class ActivateAccountAndCardServiceSpec extends Specification {

  def setup() {
    service.sukatService = Mock(SukatService)
    service.ladokService = Mock(LadokService)
    service.utilityService = Mock(UtilityService)
  }

  def cleanup() {
  }

  @Unroll
  void "validateForwardAddress (invalid): \'#email\' "() {
    expect: 'will return false'
    !service.validateForwardAddress(email)
    where:
    email << [null, '', ' ', 'trixy', 'trixy@', '@trixy',
        '!"#@!"#!', '!trixy@trixy.com', 'trixy@trixy!.com', 'trixy@trixy', 'trixy@trixy_.com']
  }
  @Unroll
  void "validateForwardAddress (valid): \'#email\' "() {
    expect: 'will return true'
    service.validateForwardAddress(email)
    where:
    email << ['a@b.se', 'a@b.info', 'a.b@c.nu', 'a_b@cd.ef']
  }

  void "findUser: when given user \'#user\'"() {
    expect:
    null == service.findUser(user)

    where:
    user << [null, '']
  }

  void "findUser: When uid is pnr but no user is found."() {
    when:
    def resp = service.findUser('someUid')

    then:
    resp == null

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO()
  }

  void "findUser: When uid is pnr."() {
    when:
    def resp = service.findUser('someUid')

    then:
    resp instanceof SvcSuPersonVO

    and:
    1 * service.sukatService.findUserBySocialSecurityNumber(*_) >> new SvcSuPersonVO(uid:'withUid')
  }

  void "fetchLadokData: Given uid \'#uid\'"() {
    expect:
    [:] == service.fetchLadokData(uid)

    where:
    uid << [null, '']
  }

  void "fetchLadokData: Happy path"() {
    when:
    def resp = service.fetchLadokData('abc123efg456')

    then:
    resp.enamn == 'kaka'
    resp.tnamn == 'foo'

    and:
    1 * service.ladokService.findStudentInLadok(*_) >> [enamn:'kaka', tnamn:'foo']
  }

  void "getCardOrderStatus: When connection to ladok fails, should log and throw exception"() {
    when:
    service.getCardOrderStatus(new SvcSuPersonVO())

    then:
    thrown(Exception)

    and:
    1 * service.ladokService.getAddressFromLadokByPnr(*_) >> { throw new RuntimeException('foo') }
  }

  void "getCardOrderStatus: When no valid address is returned"() {
    when:
    def resp = service.getCardOrderStatus(new SvcSuPersonVO())

    then:
    resp.hasAddress == false
    resp.ladokAddress == [:]
    resp.suCards?.size() == 1
    resp.cardOrders?.size() == 1
    resp.canOrderCard == false

    and:
    service.ladokService.getAddressFromLadokByPnr(*_) >> [:]

    and:
    service.sukatService.getCardsForUser(*_) >> [new SuCard(suCardUUID:'suCardUUID')]

    and:
    service.sukatService.getCardOrdersForUser(*_) >> [new SvcCardOrderVO(id:1)]
  }
  @Unroll
  void "canOrderCard: hasAddress: #hasAddress suCards: #suCards cardOrders: #cardOrders => #expected"() {
    expect:
    expected == service.canOrderCard([
        hasAddress:hasAddress,
        suCards:suCards,
        cardOrders:cardOrders,
    ])

    where:
    hasAddress | suCards | cardOrders | expected
    false      | false   | false      | false
    true       | true    | false      | false
    true       | false   | true       | false
    true       | false   | false      | true
  }
}
