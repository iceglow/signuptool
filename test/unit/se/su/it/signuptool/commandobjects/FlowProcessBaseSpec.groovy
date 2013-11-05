package se.su.it.signuptool.commandobjects

import grails.util.Environment
import se.su.it.signuptool.mock.UseCase
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification

class FlowProcessBaseSpec extends Specification {

  FlowProcessBase fpb

  private final static DEFAULT_EPPN = "default@su.se"

  def setup() {
    fpb = new FlowProcessBase(eppn:DEFAULT_EPPN)
  }

  def cleanup() {
    Environment.metaClass = null
  }

  def "referenceId"() {
    when:
    fpb.referenceId = 10

    then:
    fpb.referenceId == 10
  }

  def "eppn"() {
    when:
    fpb.eppn = "new@su.se"

    then:
    fpb.eppn == "new@su.se"
  }

  def "norEduPersonNIN"() {
    when:
    fpb.norEduPersonNIN = 12345

    then:
    fpb.norEduPersonNIN == "12345"
  }

  def "error / hasError / getError"() {
    given:
    assert !fpb.hasError() // make sure we're in a good state.

    when: "adding an error"
    fpb.error = "foo"

    then: "the process holds an error"
    fpb.hasError()

    when: "the error is not removed when we've checked for it."
    fpb.error == "foo"

    then: "but now that we've fetched the error the error is gone."
    !fpb.hasError()

    and: "just to make sure."
    fpb.error == null
  }

  def "password  / hasPassword / getPassword"() {
    given:
    assert !fpb.hasPassword() // make sure we're in a good state.

    when: "adding a password"
    fpb.password = "pasSWORD!"

    then: "the process holds a password"
    fpb.hasPassword()

    when: "the password is not removed when we've checked for it."
    fpb.password == "pasSWORD!"

    then: "but now that we've fetched the password the password is gone."
    !fpb.hasPassword()

    and: "just to make sure."
    fpb.password == null
  }

  def "hasUser"() {
    given: "check state"
    assert !fpb.hasUser()

    when: "add a user"
    fpb.userVO = new SvcSuPersonVO()

    then: "check for the user"
    fpb.hasUser()
  }

  def "newUser"() {
    given: "make sure we don't have a new user as default state."
    assert !fpb.isNewUser()

    when: "Marking the user object as a new user object."
    fpb.newUser = true

    then: "Implicitly uses isNewUser()"
    fpb.newUser
  }

  def "StubUser"() {
    given: "Checking state"
    assert fpb.user == null
    assert !fpb.newUser

    when: 'Make a "valid" stub user'
    fpb.user = new SvcSuPersonVO(accountIsActive:false)

    then:
    fpb.stubUser
  }

  def "brokenStub"() {
    given: "Checking state"
    assert fpb.user == null
    assert !fpb.newUser

    when: "create a stub user"
    fpb.user = new SvcSuPersonVO(accountIsActive:false)

    then: "we get a stub user"
    fpb.stubUser

    and: "it is in a broken state"
    fpb.brokenStub

    when: "we fix the issues"
    fpb.user.uid = "foo"

    then: "the stub is no longer broken"
    !fpb.brokenStub
  }

  def "loadUseCase"() {
    given:
    Environment.metaClass.static.getCurrent = {
      [name:"mock"]
    }

    def useCase = new UseCase(eppn:DEFAULT_EPPN, norEduPersonNIN: "29292", user:[uid:'foo', accountIsActive: true])

    when:
    fpb.loadUseCase(useCase)

    then:
    fpb.eppn == DEFAULT_EPPN
    fpb.norEduPersonNIN == useCase.norEduPersonNIN
    fpb.user.uid == useCase.user.uid
    fpb.user.accountIsActive == useCase.user.accountIsActive
  }
}
