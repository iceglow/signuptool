package se.su.it.signuptool

class AdminController {
  def index() {}

  def search(String searchFor, String searchText) {

    List eventLogs = []

    switch(searchFor) {
      case "referenceId":
        def eventLog = EventLog.get(searchText)
        if (eventLog) {
          eventLogs << eventLog
        }
        break
      case "socialSecurityNumber":
        eventLogs << EventLog.findAllBySocialSecurityNumber(searchText, [sort:'dateCreated', order:'desc'])
        break
      default:
        break
    }
    if (eventLogs?.size() == 0) {
      return render(text:g.message(code:'admin.search.noResults.for', args:[searchText]))
    }
    return render(template: 'searchResults', collection: eventLogs?.flatten(), var: "eventLog")
  }
}
