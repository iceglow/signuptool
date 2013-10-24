package se.su.it.signuptool.interfaces

import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

public interface SukatServiceInterface {
  List findUsersBySocialSecurityNumber(String nin)
  List getCardOrdersForUser(String uid)
  List getCardsForUser(String uid)
  String createSuPersonStub(String givenName, String sn, String nin)
  String generateStudentUid(String givenName, String sn)
  String orderCard(SvcSuPersonVO user, Map ladokAddress)
  String resetPassword(String uid)
  SvcUidPwd activateUser(String uid)
  void setMailRoutingAddress(String uid, String mail)
}