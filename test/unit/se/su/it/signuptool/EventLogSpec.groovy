package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EventLog)
@Mock([EventLog, EventLogEvent])
class EventLogSpec extends Specification {

  EventLog eventLog

  def setup() {
    def eventLog = new EventLog()
    mockForConstraintsTests(EventLog, [eventLog])
    this.eventLog = eventLog
  }

  def cleanup() {
  }

  void "Test socialSecurityNumber constraint"() {
    when:
    eventLog.validate()

    then:
    !eventLog.hasErrors()

    when:
    eventLog.socialSecurityNumber == 'foo'
    eventLog.validate()

    then:
    !eventLog.hasErrors()
  }

  void "Test adding and removing events"() {
    when:
    eventLog.logEvent("foo")

    then:
    eventLog.events?.size() == 1
  }
}