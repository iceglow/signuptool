package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.interfaces.LadokServiceI

@Slf4j
class LadokServiceStub implements LadokServiceI {

  @Override
  Map findStudentInLadok(String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  String findForwardAddressSuggestionForPnr(String nin) {
    log.info "findForwardAddressSuggestionForPnr: Intercepted request for nin: $nin"
    String email

    switch(nin) {
      case "BROKEN_STUB":
        email = "a.b@su.se"
        break
      case "NEW_USER_FROM_STUB":
        email = "b.c@su.se"
        break
      case "NEW_USER_FROM_SCRATCH":
        email = "tnamn.enamn@student.su.se"
        break
      default:
        email = null
        break
    }
    log.info "findForwardAddressSuggestionForPnr: Returning response => $email"
    return email
  }

  @Override
  Map getAddressFromLadokByPnr(String nin) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }
}
