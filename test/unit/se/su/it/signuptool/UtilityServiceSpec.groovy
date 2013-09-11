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
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UtilityService)
@Mock([EventLog, EventLogEvent])
class UtilityServiceSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  @Unroll
  void "getScopeFromEppn: eppn=\'#eppn\' expecting \'#scope\'"() {
    given:
    Map request = [:]
    request.eppn = eppn

    expect:
    scope == service.getScopeFromEppn(eppn)

    where:
    eppn          | scope
    null          | null
    ''            | null
    'foo'         | null
    'foo@'        | null
    '@foo.se'     | null
    'foo@f#oo'    | null
    'foo@foo'     | 'foo'
    'foo@foo.se'  | 'foo.se'
    'foo#@foo.se' | null
    'foo@foo_.se' | 'foo_.se'
    'foo_@foo_.se'| 'foo_.se'
    'åäöÅÄÖ019@åäöÅÄÖ019' | 'åäöÅÄÖ019'
  }

  void "getEventLog: Get new eventLog"() {
    expect:
    service.eventLog instanceof EventLog
  }

  void "getEventLog: When eventLog does not exist"() {
    when:
    service.getEventLog('1')
    then:
    thrown(Exception)
  }

  void "getEventLog: When eventLog does exist"() {
    given:
    def id = new EventLog().save(flush:true).id
    expect:
    service.getEventLog(id) instanceof EventLog
  }
  @Unroll
  void "chompNinToSsn: When given nin: \'#ssn\' we expect '\'#expected\'"() {
    expect:
    service.chompNinToSsn(nin)

    where:
    nin             | expected
    '***********'   | '***********'   // 11 chars, nothing happens.
    '++**********'  | '*********'     // 12 chars, first 2 chars should be cut.
    '++***********' | '++***********' // 13 chars, nothing happens.
  }
}
