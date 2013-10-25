package se.su.it.signuptool

class StateFilters {

  def utilityService

  def filters = {
    all(controller: 'activateAccountAndCard', action: '*') {
      before = {
        if (!session.norEduPersonNIN || !session.eppn) {
          utilityService.prepareSession(session, request)
        }
      }
    }
  }
}
