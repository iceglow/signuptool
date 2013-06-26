package se.su.it.signuptool

import se.su.it.svc.SvcUidPwd

import se.su.it.svc.AccountServiceImpl
import se.su.it.svc.EnrollmentServiceImpl
import se.su.it.svc.Status
import se.su.it.svc.WebServiceAdminImpl

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def grailsApplication

  AccountServiceImpl accountWS
  EnrollmentServiceImpl enrollmentWS
  Status statusWS
  WebServiceAdminImpl webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"

  public String getMailRoutingAddress(String uid) {
    String mailRoutingAddress = null
    try {
      mailRoutingAddress = accountWS.getMailRoutingAddress(uid, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when getting mail routing address", ex
      return null
    }
    return mailRoutingAddress
  }

  public boolean setMailRoutingAddress(String uid, String mailRoutingAddress) {
    try {
      accountWS.setMailRoutingAddress(uid, mailRoutingAddress, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when setting mail routing address", ex
      return false
    }
    return true
  }

  public SuPerson findUserBySocialSecurityNumber(String pnr) {
    SuPerson suPerson = null
    try {
      suPerson = SuPerson.find(base: "") {
        and {
          eq("objectclass", "superson")
          eq("socialSecurityNumber", pnr)
        }
      }
    } catch (ex) {
      log.error "Failed when finding user by ssn in ldap.", ex
    }
    return suPerson
  }

  public SuPerson findUserByUid(String uid) {
    SuPerson suPerson = null
    try {
      suPerson = SuPerson.find(base: "") {
        and {
          eq("objectclass", "superson")
          eq("uid", uid)
        }
      }
    } catch (ex) {
      log.error "Failed when finding user by uid in ldap.", ex
    }
    return suPerson
  }

  public SvcUidPwd enrollUser(String givenName, String sn, String socialSecurityNumber) {

    if (!givenName?.trim()) {
      log.error "No givenName supplied."
      return null
    }

    if (!sn?.trim()) {
      log.error "No sn supplied."
      return null
    }

    if (!socialSecurityNumber?.trim()) {
      log.error "No socialSecurityNumber supplied."
      return null
    }

    SvcUidPwd response = null

    try {
      EnrollmentServiceImpl enrollmentWebService = getEnrollmentWS()

      response = enrollmentWebService.enrollUser(
          DEFAULT_DOMAIN,
          givenName,
          sn,
          DEFAULT_AFFILATION,
          socialSecurityNumber,
          AuditFactory.auditObject
      )
    } catch (ex) {
      log.error "Enrolling student failed.", ex
    }

    return response
  }
}
