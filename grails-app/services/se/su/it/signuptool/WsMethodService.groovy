package se.su.it.signuptool

import se.su.it.sukat.client.*

class WsMethodService {
  static scope = "prototype"
  boolean transactional = false

  def wsAccessService


  def findEnrolledUserByNIN(String nin) {
    try {
      def facade = wsAccessService.getFacade(EnrollmentFacade.class)
      return facade.findEnrolledUserByNIN(nin);
    }

    catch (Exception e) {
      e.printStackTrace()
      return null
    }
  }

  def enrollUser(String domain, String givenName, String sn, String nin)
  {
    try {
      def facade = wsAccessService.getFacade(EnrollmentFacade.class)
      return facade.enrollUser(domain, givenName, sn, "other", nin)
    }

    catch (Exception e) {
      return null
    }
  }

  def isBasicServicesEnabled(String uid)
  {
     try {
      def facade = wsAccessService.getFacade(AccountFacade.class)
      return facade.isBasicServicesEnabled(uid)
    }

    catch (Exception e) {
      return null
    }
  }

  def enableBasicServices(String uid)
  {
     try {
      def facade = wsAccessService.getFacade(AccountFacade.class)
      return facade.enableBasicServices(uid)
    }

    catch (Exception e) {
      return null
    }
  }

  def getMail(String uid)
  {
    try {
      def facade = wsAccessService.getFacade(UserContactFacade.class)
      return facade.getMail(uid)
    }

    catch (Exception e) {
      return null
    }
  }

  def setMail(String uid, String mail)
  {
    try {
      def facade = wsAccessService.getFacade(UserContactFacade.class)
      facade.setMail(uid,mail)
      return true
    }

    catch (Exception e) {
      e.printStackTrace()
      return false
    }
  }
}
