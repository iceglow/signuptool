package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DashboardController)
class DashboardControllerSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "index"() {
    when:
    controller.index()

    then:
    view == '/dashboard/index'
  }
}