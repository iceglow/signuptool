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
    render(view: 'errorView', model: [errorTitle: 'Något gick fel - studera.nu skickade fel saker.', errorMessage: 'På grund av ett tekniskt fel  misslyckades kontoaktiveringen. Försök igen om en stund.'])
  }
  def studeraNuResetPasswordError = {
    render(view: 'errorView', model: [errorTitle: 'Något gick fel - studera.nu skickade fel saker.', errorMessage: 'På grund av ett tekniskt fel  misslyckades lösenordsskapandet. Försök igen om en stund.'])
  }
}
