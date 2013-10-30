package se.su.it.signuptool.mock

class UseCase {

  final static String I18N_PREFIX = "use_case"

  enum Type {
    ACCOUNT,
    CARD
  }

  Type type
  String name
  String displayName
  String eppn
  String norEduPersonNIN
  String description
  MockUserVO user

  static constraints = {
    type(nullable:false)
    name(nullable:false, blank:false)
    displayName(nullable:false, blank:false, validator: { val ->
      return val.startsWith(I18N_PREFIX)
    })
    eppn(nullable:true, blank:true)
    norEduPersonNIN(nullable:true, blank:true)
    description(nullable:true, blank:true)
    user(nullable:true)
  }

}
