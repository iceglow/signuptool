package se.su.it.signuptool

class ActivateAccountAndCardController {

  def index() { }

  def activateAccountAndCardFlow = {
    startActivation {
      on('success').to('requestUserLogin')
    }

    requestUserLogin {}

    end()
  }

}
