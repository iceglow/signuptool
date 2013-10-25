package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.EventLog
import se.su.it.signuptool.interfaces.UtilityServiceI

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Slf4j
class UtilityServiceStub implements UtilityServiceI {

  def realUtilityService

  @Override
  String getScopeFromEppn(String eppn) {
    log.info "Proxying request"
    return realUtilityService.getScopeFromEppn(eppn)
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
  void prepareSession(HttpSession session, HttpServletRequest request) {
    if (!session.eppn) {
      throw new IllegalStateException("Illegal state, required attributes not set in session.")
    }
  }
}
