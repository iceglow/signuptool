package se.su.it.signuptool

class AdminController {
  def sukatService
  def eventLogService

  def index() {
    List<EventLog> eventLogs = EventLog.createCriteria().list {
      order("dateCreated")
      maxResults(100)
    }
    [eventLogs: eventLogs]
  }

  def foo() {
    sukatService.findAllCardOrdersForUid("mool3234")
  }
}
