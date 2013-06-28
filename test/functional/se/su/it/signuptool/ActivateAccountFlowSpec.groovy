package se.su.it.signuptool

import geb.spock.GebReportingSpec
import se.su.it.signuptool.pages.ActivateAccountPage

class ActivateAccountFlowSpec extends GebReportingSpec {

  def setup() {}

  def "test default flow where user is missing credentials, should be redirected to start page"() {
    given:
    to ActivateAccountPage


    when:
    startActivationButton.click()

    then:
    at ActivateAccountPage

  }
}
