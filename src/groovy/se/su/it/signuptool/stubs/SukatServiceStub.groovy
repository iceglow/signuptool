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

    log.info "findUsersBySocialSecurityNumber: returning response => $response"
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
    log.info "createSuPersonStub: Intercepted with parameters givenName: $givenName,  sn: $sn, nin: $nin"
    String uid = null

    switch (nin) {
      case "NEW_USER_FROM_SCRATCH":
        uid = "NEW_USER_FROM_SCRATCH"
        break
      default:
        break
    }
    log.info "createSuPersonStub: Returning uid => $uid"
    return uid
  }

  @Override
  String generateStudentUid(String givenName, String sn) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String orderCard(SvcSuPersonVO user, Map ladokAddress) {
    log.info "orderCard: Intercepted request from ${user}"
    String response = null
    switch (user?.uid) {
      case "CARD_ORDER_FAILS":
        throw new IllegalStateException("Set to fail in an epic way!")
        break
      case "CARD_ORDER_SUCCEEDS":
        break;
      default:
        log.info "No case specified for user with uid: $user.uid"
    }
    /* We don't actually care about the response string so it doesn't matter, as long as it is not an exception. */
    log.info "orderCard: Returning => $response"
    return response
  }

  @Override
  String resetPassword(String uid) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  SvcUidPwd activateUser(String uid) {
    log.info "activateUser: Intercepted request for uid: $uid"

    SvcUidPwd result = null

    switch(uid) {
      case "NEW_USER_FROM_STUB":
        result = new SvcUidPwd()
        result.uid = "NEW_USER_FROM_STUB"
        result.password = "p4sSw0rd"
        break
      case "NEW_USER_FROM_SCRATCH":
        result = new SvcUidPwd()
        result.uid = "NEW_USER_FROM_SCRATCH"
        result.password = "p4sSw0rd"
        break
      default:
        break
    }
    log.info "activateUser: returning response => $result"
    return result
  }

  @Override
  void setMailRoutingAddress(String uid, String mail) {
    log.info "setMailRoutingAddress: Intercepted for uid $uid with mail $mail"
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
