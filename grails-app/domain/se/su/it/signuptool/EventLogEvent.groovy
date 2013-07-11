package se.su.it.signuptool

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode @ToString
class EventLogEvent implements Serializable {

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
}
