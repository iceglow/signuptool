package se.su.it.signuptool

class AdminController {
  def sukatService
  def eventLogService

  def index() {
    List<EventLog> eventLogs = []
    if(params?.ssn) {
      eventLogs = eventLogService.findEventsBySocialSecurityNumber((String)params.ssn)
    } else if(params?.referenceId) {
      eventLogs = eventLogService.findEventsByReferenceId((String)params.referenceId)
    } else if(params?.uid) {
      eventLogs = eventLogService.findEventsByUserId((String)params.uid)
    } else {
      eventLogs = eventLogService.fetchLatestEvents()
    }
    [eventLogs: eventLogs]
  }

  def foo() {
    sukatService.findAllCardOrdersForUid("mool3234")
  }
}
