package se.su.it.signuptool.mock

class UseCase {

  final static String I18N_PREFIX = "use_case"

  String name
  String displayName
  String eppn
  String norEduPersonNIN
  String description

  static constraints = {
    name(nullable:false, blank:false)
    displayName(nullable:false, blank:false, validator: { val ->
      return val.startsWith(I18N_PREFIX)
    })
    eppn(nullable:true, blank:true)
    norEduPersonNIN(nullable:true, blank:true)
    description(nullable:true, blank:true)
  }

}
