package se.su.it.signuptool

class AuthorizationService {

  boolean transactional = false
  def spocpService


  // Returns true if the user has the specified role (on an optional victim) according to spocp
  boolean hasRole(String uid, String role, String victim="") {
    return spocpService.hasRole(uid, role, victim)
  }

}