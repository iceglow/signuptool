package se.su.it.signuptool

import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def sukatService
  def utilityService
  def ladokService

  private final emailPattern = /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/

  /** Checks if user has any active cards or active order for a card */
  public boolean canOrderCard() {
    return true
  }

  public boolean validateForwardAddress(String forwardAddress) {
    forwardAddress = forwardAddress?.trim()

    if (!forwardAddress) {
      return false
    }

    if (!(forwardAddress ==~ emailPattern)) {
      return false
    }

    return true
  }

  public SvcSuPersonVO findUser(String uid, boolean uidIsPnr) {
    def user = null

    if (uidIsPnr) {
      user = sukatService.findUserBySocialSecurityNumber(uid)
    } else {
      user = sukatService.findUserByUid(uid)
    }
    /** Return object could be empty, uid should mean we did get a hit. */
    (user?.uid)? user : null
  }

  public Map fetchLadokData(String uid) {
    Map ladokData = [:]

    if (!uid) {
      return ladokData
    }

    /** Turn 12 length ssn into 10 length */
    def ssn = (uid?.length() == 12) ? uid[2..0] : uid
    if (utilityService.uidIsPnr(ssn)) {
      ladokData = ladokService.findStudentInLadok(ssn)
    }

    return ladokData
  }
}
