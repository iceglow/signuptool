package se.su.it.signuptool

import geb.spock.GebSpec
import se.su.it.signuptool.pages.ActivateAccountPage
import se.su.it.signuptool.pages.ShowTermsOfAgreementPage

class ActivateAccountFlowSpec extends GebSpec {

  def setup() {
  }

  def "test default flow when..."() {
    when:
    to ActivateAccountPage

    startActivateAccountFlow()

    then:
    at ShowTermsOfAgreementPage
  }
}
