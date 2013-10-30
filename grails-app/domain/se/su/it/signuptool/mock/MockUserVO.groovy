package se.su.it.signuptool.mock

class MockUserVO {
  String uid
  boolean accountIsActive

  static constraints = {
    uid(nullable:true, blank:true)
    accountIsActive()
  }
}
