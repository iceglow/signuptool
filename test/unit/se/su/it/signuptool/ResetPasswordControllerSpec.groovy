package se.su.it.signuptool

import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
class ResetPasswordControllerSpec extends Specification {
  @Shared
  def controller

  def setup() {
    controller = mockController(ResetPasswordController)
  }

  void "test something"() {
  }
}