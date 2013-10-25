package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.SukatServiceI
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

@Slf4j
class SukatServiceStub implements SukatServiceI {

  @Override
  List findUsersBySocialSecurityNumber(String nin) {
    List response = []
    log.info "findUsersBySocialSecurityNumber: handling request for $nin"

    switch(nin) {
      case "1":
        response = [new SvcSuPersonVO(), new SvcSuPersonVO()]
        break
      case "2":
        throw new Exception("Generic SUKAT exception.")
        break
      case "4":
        response = [new SvcSuPersonVO(accountIsActive:true, uid:"fake1")]
        break
      default:
        break
    }

    log.info "findUsersBySocialSecurityNumber: returning response: $response"
    return response
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
