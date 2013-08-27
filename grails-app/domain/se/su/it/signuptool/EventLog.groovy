package se.su.it.signuptool

class EventLog implements Serializable {

  String socialSecurityNumber

  Date dateCreated
  Date lastUpdated

  SortedSet events

  static hasMany = [events:EventLogEvent]

  static constraints = {
    socialSecurityNumber (nullable: true)
  }

  static mapping = {
    events lazy: false
    events: batchSize(100)
    version false
  }

  public void logEvent(String description) {
    this.addToEvents(new EventLogEvent(description:description)).save(flush:true)
  }
}
