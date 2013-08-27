package se.su.it.signuptool

class EventLogEvent implements Serializable, Comparable {

  Date dateCreated
  Date lastUpdated

  Date timeCreated = new Date() // Added at constructor time.
  String description = ''

  EventLog eventLog

  static belongsTo = EventLog

  static constraints = {
    timeCreated(nullable:false, blank:false)
    description(nullable:false, blank:false, maxSize: 2000)
  }

  static mapping = {
    version false
  }

  @Override
  int compareTo(Object o) {
    this?.timeCreated <=> o?.timeCreated
  }
}