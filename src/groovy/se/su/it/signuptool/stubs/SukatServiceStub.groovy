package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.SukatServiceInterface
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

@Slf4j
class SukatServiceStub implements SukatServiceInterface {

  @Override
  List findUsersBySocialSecurityNumber(String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  List getCardOrdersForUser(String uid) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  List getCardsForUser(String uid) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String createSuPersonStub(String givenName, String sn, String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String generateStudentUid(String givenName, String sn) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String orderCard(SvcSuPersonVO user, Map ladokAddress) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String resetPassword(String uid) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  SvcUidPwd activateUser(String uid) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void setMailRoutingAddress(String uid, String mail) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
