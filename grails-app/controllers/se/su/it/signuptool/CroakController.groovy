package se.su.it.signuptool

class CroakController {

  def index = {
  }

  def accessDenied = {

  }

  def sukatAccountSetupError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'accountActivationError.pageHeader'), errorMessage: message(code: 'accountActivationError.info.text')])
  }
  def sukatResetPasswordError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'accountResetError.pageHeader'), errorMessage: message(code: 'accountResetError.info.text'), tryAgainAction: 'resetaccount'])
  }

  def studeraNuAccountSetupError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'studeraNuActivationError.pageHeader'), errorMessage: message(code: 'studeraNuAccountSetupError.info.text')])
  }
  def studeraNuResetPasswordError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'accountResetError.pageHeader'), errorMessage: message(code: 'accountResetError.info.text'), tryAgainAction: 'resetaccount'])
  }
}
