package se.su.it.signuptool.stubs

import se.su.it.signuptool.interfaces.LadokServiceI

class LadokServiceStub implements LadokServiceI {

  @Override
  Map findStudentInLadok(String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String findForwardAddressSuggestionForPnr(String nin) {
    String email
    switch(nin) {
      case "BROKEN_STUB":
        email = "a.b@su.se"
        break
      case "NEW_USER_FROM_STUB":
        email = "b.c@su.se"
        break
      default:
        email = null
        break
    }
    return email
  }

  @Override
  Map getAddressFromLadokByPnr(String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }
}
