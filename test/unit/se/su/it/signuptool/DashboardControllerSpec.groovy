package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

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
  @Unroll
  void "index with saved controller in session, controller: #target, expect: #destination"() {
    given:
    session.controller = target

    when:
    controller.index()

    then:
    response.redirectedUrl == destination

    and:
    session.controller == null

    where:
    target                    | destination
    'activateAccountAndCard'  | '/activateAccountAndCard/index'
    'resetPassword'           | '/resetPassword/index'
    'admin'                   | null
    null                      | null
  }

  void "activateAccountAndCard"() {
    when:
    controller.activateAccountAndCard()

    then:
    view == '/dashboard/selectIdProvider'

    and:
    session.controller == 'activateAccountAndCard'
  }

  void "resetAccountOrPassword"() {
    when:
    controller.resetAccountOrPassword()

    then:
    view == '/dashboard/selectPasswordIdp'

    and:
    session.controller == 'resetPassword'
  }

}