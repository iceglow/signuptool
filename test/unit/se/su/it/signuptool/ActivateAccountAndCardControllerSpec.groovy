package se.su.it.signuptool

import grails.test.mixin.*
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
class ActivateAccountAndCardControllerSpec extends Specification {

  @Shared
  def controller

  def setup() {
    controller = mockController(ActivateAccountAndCardController)
  }

  def "index"() {

  }
}
