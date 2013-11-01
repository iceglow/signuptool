package se.su.it.signuptool.mock

import grails.validation.Validateable

@Validateable
class MockUserVO {
  String uid
  boolean accountIsActive

  static constraints = {
    uid(nullable:true, blank:true)
    accountIsActive()
  }
}
