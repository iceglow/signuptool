package se.su.it.signuptool.stubs

import se.su.it.signuptool.interfaces.ActivateAccountAndCardServiceI
import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardServiceStub implements ActivateAccountAndCardServiceI {

  @Override
  boolean validateForwardAddress(String forwardAddress) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  Map fetchLadokData(String socialSecurityNumber) {
    Map response = [:]
    switch(socialSecurityNumber) {
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
