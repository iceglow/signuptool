package se.su.it.signuptool

class EventLog {
  Date dateCreated
  Date lastUpdated
  String referenceId
  String socialSecurityNumber
  String userId
  String description
  String localServer
  String remoteHost

  static constraints = {
    description (blank: false)
    dateCreated (nullable: true)
    lastUpdated (nullable: true)
    referenceId (nullable: true)
    socialSecurityNumber (nullable: true)
    userId (nullable: true)
    localServer (nullable: true)
    remoteHost (nullable: true)
  }
}
