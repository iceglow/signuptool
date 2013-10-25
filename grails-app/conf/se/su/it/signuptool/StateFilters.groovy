package se.su.it.signuptool

class StateFilters {

  def utilityService

  def filters = {
    all(controller: 'activateAccountAndCard', action: '*') {
      before = {
        log.info "..."
      }
    }
  }
}
