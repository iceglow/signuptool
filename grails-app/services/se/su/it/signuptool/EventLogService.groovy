package se.su.it.signuptool


import javax.servlet.ServletRequest

class EventLogService {
  private static java.util.Random randomGenerator = new java.util.Random(System.currentTimeMillis())

  public String createReferenceId() {
    long time = System.currentTimeMillis()/86400000L
    String reference = String.format("%07X",time) + String.format("%04X",randomGenerator.nextInt(65536))
    while (isReferenceIdUsed(reference)) {
      reference = String.format("%07X",time) + String.format("%04X",randomGenerator.nextInt(65536))
    }
    return reference
  }

  public List<EventLog> fetchLatestEvents() {
    List<EventLog> eventLogs = EventLog.createCriteria().list {
      order("dateCreated","desc")
      maxResults(100)
    }
    return eventLogs
  }

  public List<EventLog> findEventsByReferenceId(String referenceId) {
    List<EventLog> eventLogs = EventLog.createCriteria().list {
      eq("referenceId",referenceId)
      order("dateCreated","desc")
      maxResults(250)
    }
    return eventLogs
  }

  public List<EventLog> findEventsBySocialSecurityNumber(String socialSecurityNumber) {
    List<EventLog> eventLogs = EventLog.createCriteria().list {
      eq("socialSecurityNumber",socialSecurityNumber)
      order("dateCreated","desc")
      maxResults(250)
    }
    return eventLogs
  }

  public List<EventLog> findEventsByUserId(String userId) {
    List<EventLog> eventLogs = EventLog.createCriteria().list {
      eq("userId",userId)
      order("dateCreated","desc")
      maxResults(250)
    }
    return eventLogs
  }

  public EventLog logEvent(String description, String referenceId, ServletRequest request, String socialSecurityNumber = null, String uid = null) {
    EventLog eventLog = EventLog.newInstance(referenceId: referenceId, socialSecurityNumber: socialSecurityNumber, userId: uid, description: description, localServer: java.net.InetAddress.localHost.hostName, remoteHost: request.remoteHost)
    eventLog.save()
    eventLog.refresh()
    return eventLog
  }

  private boolean isReferenceIdUsed(String referenceId) {
    boolean isUsed = false
    EventLog.executeQuery("select count(*) from EventLog where referenceId= :reference",[reference: referenceId]).each { Long count ->
      isUsed = (count>0)
    }
    return isUsed
  }
}
