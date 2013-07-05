package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ResetPasswordController)
class ResetPasswordControllerSpec extends Specification {

  def setup() {
    controller.utilityService = Mock(UtilityService)
  }

  void "index"() {

    when:
    controller.index()

    then:
    view == '/resetPassword/index'
    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "kalle anka"
  }
}