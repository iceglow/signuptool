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
      case "MULTIPLE_ENTRIES_IN_SUKAT":
        response = [new SvcSuPersonVO(), new SvcSuPersonVO()]
        break
      case "ERROR_WHEN_ASKING_SUKAT_FOR_USER":
        throw new Exception("Generic SUKAT exception.")
        break
      case "HAS_SUKAT_USER":
        response = [new SvcSuPersonVO(accountIsActive:true, uid:"HAS_SUKAT_USER")]
        break
      case "BROKEN_STUB":
        response = [new SvcSuPersonVO(accountIsActive:false)]
        break
      case "NEW_USER_FROM_STUB":
        response = [new SvcSuPersonVO(accountIsActive:false, uid: 'NEW_USER_FROM_STUB')]
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
    String uid = null

    switch(nin) {
     case "NEW_USER_FROM_STUB":
       uid = "NEW_USER_FROM_STUB"
       break
     default:
       break
    }

    return uid
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
    SvcUidPwd result = null

    switch(uid) {
      case "NEW_USER_FROM_STUB":
        result = new SvcUidPwd()
        result.uid = "NEW_USER_FROM_STUB"
        result.password = "KAKBURK123"
        break
      default:
        break
    }

    return result
  }

  @Override
  void setMailRoutingAddress(String uid, String mail) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
