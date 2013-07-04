package se.su.it.signuptool

class ResetPasswordController {
  def utilityService

  def index() {
    // Kolla scope (antagning.se / studera.nu)
    // Kolla norEduPersonNIN
    // Kolla att kontot finns.
    // KOlla input
    // Kör enrollUser
    // ... -> visa passwd mm..
    String scope = utilityService.getScopeFromEppn(request.eppn)
    String norEduPersonNIN = request.norEduPersonNIN

    return render(view:'index')
  }
}
