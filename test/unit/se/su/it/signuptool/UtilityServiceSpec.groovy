package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
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

}
