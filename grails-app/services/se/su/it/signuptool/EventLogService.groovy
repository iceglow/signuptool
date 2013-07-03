package se.su.it.signuptool


import javax.servlet.ServletRequest

class EventLogService {
  private static java.util.Random randomGenerator = new java.util.Random(System.currentTimeMillis())

  public String createReferenceId() {
    long time = System.currentTimeMillis()/86400000L
    String reference = String.format("%09X",time) + String.format("%04X",randomGenerator.nextInt(65536))
    while (isReferenceIdUsed(reference)) {
      reference = String.format("%08X",time) + String.format("%04X",randomGenerator.nextInt(65536))
    }
    return reference
  }

  public EventLog logEvent(String description, String referenceId, ServletRequest request, String socialSecurityNumber = null, String uid = null) {
    EventLog eventLog = EventLog.newInstance(referenceId: referenceId, socialSecurityNumber: socialSecurityNumber, userId: uid, description: description, localServer: java.net.InetAddress.localHost.hostName, remoteHost: request.remoteHost)
    eventLog.save()
    eventLog.refresh()
    return eventLog
  }

  private boolean isReferenceIdUsed(String referenceId) {
    boolean isUsed = false
    EventLog.executeQuery("select count(*) from EventLog where referenceId= :reference",[reference: referenceId]).each { row ->
      isUsed = (row>0)
    }
    return isUsed
  }
}
