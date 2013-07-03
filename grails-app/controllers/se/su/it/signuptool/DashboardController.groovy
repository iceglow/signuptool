package se.su.it.signuptool

class DashboardController {

  def index() {
    if (session.controller) {
      def savedController = session.controller
      session.controller = null
      return redirect(controller: savedController)
    }

    return render(view:'index')
  }

  def activateAccountAndCard() {
    session.controller = 'activateAccountAndCard'
    return render(view:'selectIdProvider')
  }

  def resetAccountOrPassword() {
    session.controller = 'resetPassword'
    return render(view:'selectPasswordIdp')
  }
}
