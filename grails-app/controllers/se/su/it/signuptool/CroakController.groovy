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
    render(view: 'errorView', model: [errorTitle: message(code: 'accountResetError.pageHeader'), errorMessage: message(code: 'accountResetError.info.text')])
  }

  def studeraNuAccountSetupError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'accountActivationError.pageHeader'), errorMessage: message(code: 'accountActivationError.info.text')])
  }
  def studeraNuResetPasswordError = {
    render(view: 'errorView', model: [errorTitle: message(code: 'accountResetError.pageHeader'), errorMessage: message(code: 'accountResetError.info.text')])
  }
}
