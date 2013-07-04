package se.su.it.signuptool

class ResetPasswordController {

  def index() {
    // Kolla scope (antagning.se / studera.nu)
    // Kolla norEduPersonNIN
    // Kolla att kontot finns.
    // KOlla input
    // Kör enrollUser
    // ... -> visa passwd mm..
    return render(view:'index')
  }
}
