package se.su.it.signuptool

class AdminController {
  def eventLogService

  def index() {
    List<EventLog> eventLogs = []
    if (params?.ssn) {
      eventLogs = eventLogService.findEventsBySocialSecurityNumber((String) params.ssn)
    } else if (params?.referenceId) {
      eventLogs = eventLogService.findEventsByReferenceId((String) params.referenceId)
    } else {
      eventLogs = eventLogService.fetchLatestEvents()
    }
    return render(view: 'index', model: [eventLogs: eventLogs])
  }
}
