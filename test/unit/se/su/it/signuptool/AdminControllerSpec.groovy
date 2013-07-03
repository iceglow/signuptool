package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(AdminController)
class AdminControllerSpec extends Specification {

  def setup() {
    EventLogService eventLogService = Mock(EventLogService)
    controller.eventLogService = eventLogService
  }

  def cleanup() {
  }

  void "index"() {
    when:
    controller.index()

    then:
    1 * controller.eventLogService.fetchLatestEvents(*_)>> []
    and:
    0 * controller.eventLogService.findEventsByReferenceId(*_)>> []
    and:
    0 * controller.eventLogService.findEventsBySocialSecurityNumber(*_)>> []
    and:
    0 * controller.eventLogService.findEventsByUserId(*_)>> []

  }
}