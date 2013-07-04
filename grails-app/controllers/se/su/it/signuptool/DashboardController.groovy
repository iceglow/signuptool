package se.su.it.signuptool

class DashboardController {

  def index() {
    if (session.controller) {

      /** Always remove stored controllers from the session */
      def savedController = session.controller
      session.controller = null

      /** But only redirect some controller pointers */
      if (savedController in ['activateAccountAndCard', 'resetPassword']) {
        return redirect(controller: savedController)
      }
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
