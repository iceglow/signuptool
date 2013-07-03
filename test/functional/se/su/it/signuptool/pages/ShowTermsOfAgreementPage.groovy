package se.su.it.signuptool.pages

import geb.Page

class ShowTermsOfAgreementPage extends Page {
  static url = "http://localhost:8080/activateAccountAndCard/createNewAccount?execution=e1s1"

  static at = { title == "1" }

  static content = {
    approveTermsOfAgreementButton { $("input[name='_eventId_agree']") }
    declineTermsOfAgreementButton { $("input[name='_eventId_decline']") }
  }

  def approveTermsOfAgreement() {
    approveTermsOfAgreementButton.click()
  }

  def declineTermsOfAgreement() {
    declineTermsOfAgreementButton.click()
  }
}
