package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.ActivateAccountAndCardServiceI
import se.su.it.svc.SvcSuPersonVO

@Slf4j
class ActivateAccountAndCardServiceStub implements ActivateAccountAndCardServiceI {

  @Override
  boolean validateForwardAddress(String forwardAddress) {
    log.info "validateForwardAddress: intercepting request for $forwardAddress"
    boolean valid = true
    log.info "validateForwardAddress: returning response => $valid"
    return valid
  }

  @Override
  Map fetchLadokData(String socialSecurityNumber) {
    log.info "fetchLadokData: Intercepted request for $socialSecurityNumber"
    Map response = [:]
    switch(socialSecurityNumber) {
      case "BROKEN_STUB":
        response = [tnamn:'a', enamn:'b']
        break
      case "NEW_USER_FROM_STUB":
        response = [tnamn:'a', enamn:'b']
        break
      case "NEW_USER_FROM_SCRATCH":
        response = [tnamn:'tnamn', enamn:'enamn']
        break
      default:
        break
    }

    log.info "fetchLadokData: Returning response => $response"
    return response
  }

  @Override
  Map getCardOrderStatus(SvcSuPersonVO user) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }
}
