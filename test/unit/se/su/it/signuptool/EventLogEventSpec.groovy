package se.su.it.signuptool

import grails.buildtestdata.mixin.Build
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(EventLogEvent)
@Build([EventLog, EventLogEvent])
@Mock([EventLog, EventLogEvent])
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

  void "Listing events should return a sorted set."() {
    given:
    def el1 = EventLog.build()

    def ev2 = new EventLogEvent(description: 'bar')
    def ev1 = new EventLogEvent(description: 'foo')

    el1.addToEvents(ev1)
    el1.addToEvents(ev2)

    el1.save()

    expect:
    el1.events*.timeCreated == [ev2.timeCreated, ev1.timeCreated]
  }

  void "Test that a EventLogEvent don't validate without a EventLog"() {
    given:
    def ev = new EventLogEvent(description: 'bar')

    when:
    ev.validate()

    then:
    assert ev.errors.hasFieldErrors('eventLog')
  }

  void "Test that a EventLogEvent validates when a EventLog is set"() {
    given:
    def ev = new EventLogEvent(description: 'bar', eventLog: new EventLog())

    when:
    ev.validate()

    then:
    assert !ev.errors.hasFieldErrors('eventLog')
  }

}
