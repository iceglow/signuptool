package se.su.it.signuptool.pages

import geb.Page

class ActivateAccountPage extends Page {
  static url = "http://localhost:8080"

  static at = { title == "University Account Activation"}

  static content = {
    activateAccountForm {$("form#activateAccountForm")}
    startActivationButton {$("input[name='startAccountActivation']")}
  }

  def startActivateAccountFlow() {
    startActivationButton.click()
  }

}
