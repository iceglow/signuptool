package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.EventLog
import se.su.it.signuptool.interfaces.UtilityServiceI

import javax.servlet.http.HttpServletRequest

@Slf4j
class UtilityServiceStub implements UtilityServiceI {

  private static String DEFAULT_EPPN = "studera.nu"
  def realUtilityService

  @Override
  String getScopeFromEppn(String eppn) {
    switch(eppn) {
      default:
        log.info "Default case: returning $DEFAULT_EPPN"
        return DEFAULT_EPPN
    }
  }

  @Override
  EventLog getEventLog(long referenceId) {
    // Proxying request.
    log.info "Proxying request"
    return realUtilityService.getEventLog(referenceId)
  }

  @Override
  EventLog getEventLog() {
    // Proxying request.
    log.info "Proxying request"
    return realUtilityService.getEventLog()
  }

  @Override
  String chompNinToSsn(String ssn) {
    // Proxying request.
    log.info "Proxying request"
    return realUtilityService.chompNinToSsn(ssn)
  }

  @Override
  void prepareSession(HttpServletRequest request) {
    if (!session.eppn || !session.norEduPersonNIN) {
      throw new IllegalStateException("Session variables should be set before we end up here.")
    }
  }
}
