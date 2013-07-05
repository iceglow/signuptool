package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO

class ResetPasswordController {
  def sukatService
  def utilityService

  def index() {
    // Kolla scope (antagning.se / studera.nu)
    // Kolla norEduPersonNIN
    // Kolla att kontot finns.
    // KOlla input
    // Kör enrollUser
    // ... -> visa passwd mm..
    String scope = utilityService.getScopeFromEppn(request.eppn)
    if(!(scope && scope == 'studera.nu')) {
      log.error("scope (${scope}) must be defined and set to 'studera.nu' or 'antagning.se'!")
      flash.error = "scope undefined or not equal to 'studera.nu' or 'antagning.se'!"
      return render(view:'index')
    }

    String norEduPersonNIN = request.norEduPersonNIN
    if(!norEduPersonNIN) {
      log.error("norEduPersonNIN not defined")
      flash.error = "norEduPersonNIN not defined!"
      return render(view:'index')
    }

    SvcSuPersonVO user = sukatService.findUserBySocialSecurityNumber(norEduPersonNIN)

    if(!user) {
      log.error("User with nin${norEduPersonNIN} doesnt have any account!")
      flash.error = "norEduPersonNIN not defined!"
      return render(view:'index')
    }

    return render(view:'index')
  }
}
