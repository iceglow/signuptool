package se.su.it.signuptool

class CroakController {

  def index = {
  }

  def accessDenied = {

  }

  def sukatAccountSetupError = {
    render(view: 'errorView', model: [errorTitle: 'Något gick fel - ditt konto kunde inte aktiverats.', errorMessage: 'På grund av ett tekniskt fel  misslyckades kontoaktiveringen. Försök igen om en stund.'])
  }
  def sukatResetPasswordError = {
    render(view: 'errorView', model: [errorTitle: 'Något gick fel - ett nytt lösenord kunde inte skapas.', errorMessage: 'På grund av ett tekniskt fel  misslyckades lösenordsskapandet. Försök igen om en stund.'])
  }
}
