package se.su.it.signuptool.mock

class UseCase {
  String name
  String eppn
  String norEduPersonNIN
  String description

  static constraints = {
    name(nullable:false, blank:false)
    eppn(nullable:true, blank:true)
    norEduPersonNIN(nullable:true, blank:true)
    description(nullable:true, blank:true)
  }

}
