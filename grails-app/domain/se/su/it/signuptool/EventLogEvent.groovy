package se.su.it.signuptool

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode @ToString
class EventLogEvent implements Serializable, Comparable {

  String description = ''

  Date dateCreated
  Date lastUpdated

  static belongsTo = EventLog

  static constraints = {
    description(nullable:false, blank:false, maxSize: 2000)
  }

  static mapping = {
    version false
  }

  @Override
  int compareTo(Object o) {
    this.dateCreated.compareTo((o as EventLogEvent).dateCreated)
  }
}
