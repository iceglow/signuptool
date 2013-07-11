package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(EventLogEvent)
class EventLogEventSpec extends Specification {

  EventLogEvent event

  def setup() {
    EventLog eventLog = new EventLog()
    def event = new EventLogEvent(eventLog:eventLog)
    mockForConstraintsTests(EventLogEvent, [event])
    this.event = event
  }

  def cleanup() {
    event = null
  }
  @Unroll
  void "Test description validity when description => \'#description\'"() {
    given:
    event.description = description

    when:
    event.validate()

    then:
    event.hasErrors() == expected

    and:
    event.errors["description"] == error

    where:
    description | expected | error
    null        | true     | 'nullable'
    ''          | true     | 'blank'
  }

  void "Test description size"() {
    given:
    event.description = 'x'*2000

    when:
    event.validate()

    then:
    !event.hasErrors()

    when:
    event.description = 'x'*2001
    event.validate()

    then:
    event.hasErrors()

    and:
    event.errors["description"] == 'maxSize'
  }
}