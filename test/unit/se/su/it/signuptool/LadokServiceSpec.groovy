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
import groovy.sql.Sql
import javax.sql.DataSource

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LadokService)
class LadokServiceSpec extends Specification {

  /**
   * These tests are missing some somewhat vital parts.
   * Sql has not been mocked, Sql's no parameter constructor requires
   * objenesis, which causes issues when running tests multiple times
   * from grails interactive mode..
   * @return
   */

  def setup() {
    service.utilityService  = Mock(UtilityService)
    service.ladokDataSource = Mock(DataSource)
  }

  def cleanup() {
    LadokService.metaClass = null
  }

  void "findStudentInLadok: When no student is found."() {
    given:
    def arg1 = 'tnamn'
    def arg2 = 'enamn'
    def ssn = "1234567890"

    LadokService.metaClass.doListQuery = { String iarg1, Map iarg2 ->
      return null
    }

    when:
    def resp = service.findStudentInLadok(ssn)

    then:
    !resp

    and:
    1 * service.utilityService.chompNinToSsn(ssn)
  }

  void "findStudentInLadok: When a student is found."() {
    given:

    def arg1 = 'tnamn'
    def arg2 = 'enamn'
    def ssn = "1234567890"

    LadokService.metaClass.doListQuery = { String iarg1, Map iarg2 ->
      return [[arg1:arg1, arg2:arg2]]
    }

    when:
    def resp = service.findStudentInLadok(ssn)

    then:
    resp.arg1 == arg1
    resp.arg2 == arg2

    and:
    1 * service.utilityService.chompNinToSsn(ssn)
  }

  void "findForwardAddressSuggestionForPnr: When fetching forward address"() {
    given:
    def arg1 = 'foo@bar.se'
    def ssn = "..."

    LadokService.metaClass.doListQuery = { String iarg1, Map iarg2 ->
      return [[komadr:arg1]]
    }

    when:
    def resp = service.findForwardAddressSuggestionForPnr(ssn)

    then:
    resp == arg1

    and:
    1 * service.utilityService.chompNinToSsn(ssn)
  }

  void "withConnection: When creating a new sql connection fails"() {
    given:
    Closure query = { Sql sql ->
      assert sql instanceof Sql
      return ["myQuery"]
    }

    when:
    List resp = service.withConnection(query)

    then:
    resp?.first() == "myQuery"
  }

  void "withConnection: When querying fails"() {
    given:
    Closure query = { Sql sql ->
      throw new RuntimeException('foo')
    }

    when:
    service.withConnection(query)

    then:
    thrown(RuntimeException)
  }

  void "getAddressFromLadokByPnr: happy path with tempaddress"() {
    given:
    Date now = new Date()

    service.metaClass.doListQuery = { String query, Map map ->
      [[adrtyp:'2',fromdat: now.minus(7).format("yyyy-MM-dd"), tomdat:now.plus(7).format("yyyy-MM-dd"),land: 'SVERIGE',streetaddress1: 'kalle ankas gata', postnr: '123 45', ort: 'toontown'],[adrtyp:'4',land: 'SVERIGE',streetaddress1: 'snickarbacken', postnr: '123 45', ort: 'farsta']]
    }

    when:
    Map address = service.getAddressFromLadokByPnr("1234567890")

    then:
    address

    and:
    address.ort == 'toontown'
  }

  void "getAddressFromLadokByPnr: happy path without tempaddress"() {
    given:

    def ssn = "1234567890"
    Date now = new Date()

    service.metaClass.doListQuery = { String query, Map map ->
      [[adrtyp:'2',fromdat: now.minus(14).format("yyyy-MM-dd"), tomdat:now.minus(7).format("yyyy-MM-dd"),land: 'SVERIGE',streetaddress1: 'kalle ankas gata', postnr: '123 45', ort: 'toontown'],[adrtyp:'4',land: 'SVERIGE',streetaddress1: 'snickarbacken', postnr: '123 45', ort: 'farsta']]
    }

    when:
    Map address = service.getAddressFromLadokByPnr(ssn)

    then:
    address

    and:
    address.ort == 'farsta'

    and:
    1 * service.utilityService.chompNinToSsn(ssn)
  }
}
