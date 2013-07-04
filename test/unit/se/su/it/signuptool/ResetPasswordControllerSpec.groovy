package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ResetPasswordController)
class ResetPasswordControllerSpec extends Specification {

  def setup() {

  }

  void "index"() {

    when:
    controller.index()

    then:
    view == '/resetPassword/index'
  }
}