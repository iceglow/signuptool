package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.ActivateAccountAndCardServiceI
import se.su.it.svc.SvcSuPersonVO

@Slf4j
class ActivateAccountAndCardServiceStub implements ActivateAccountAndCardServiceI {

  @Override
  boolean validateForwardAddress(String forwardAddress) {
    return true
  }

  @Override
  Map fetchLadokData(String socialSecurityNumber) {
    Map response = [:]
    switch(socialSecurityNumber) {
      case "creatingNewUserFromBrokenStub":
        response = [tnamn:'a', enamn:'b']
        break
      default:
        break
    }
    return response
  }

  @Override
  Map getCardOrderStatus(SvcSuPersonVO user) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }
}
