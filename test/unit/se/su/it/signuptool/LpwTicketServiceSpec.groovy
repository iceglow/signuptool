package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(LpwTicketService)
class LpwTicketServiceSpec extends Specification {

  def setup() {
    grailsApplication.config.lpwTOTP.slotLen = 3600 * 12
    grailsApplication.config.lpwTOTP.secret = "mySecretKey"

    service.grailsApplication = grailsApplication
  }

  def "getTicket: test basic flow"() {
    given:
    def uid = "evil1234@it.su.se"

    when:
    def res = service.getTicket(uid)

    then:
    assert res.contains(uid)
  }

  def "getTicket: test when uid is null, should return null"(){
    given:
    def uid = null

    when:
    def res = service.getTicket(uid)

    then:
    assert !res
  }

  def "getTicket: test when uid is empty string, should return null"(){
    given:
    def uid = ''

    when:
    def res = service.getTicket(uid)

    then:
    assert !res
  }

}
