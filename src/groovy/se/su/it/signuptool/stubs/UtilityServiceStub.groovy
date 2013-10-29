package se.su.it.signuptool.stubs

import groovy.util.logging.Slf4j
import se.su.it.signuptool.EventLog
import se.su.it.signuptool.interfaces.UtilityServiceI

@Slf4j
class UtilityServiceStub implements UtilityServiceI {

  def realUtilityService

  @Override
  String getScopeFromEppn(String eppn) {
    log.info "getScopeFromEppn: Proxying request for eppn: $eppn"
    String response = realUtilityService.getScopeFromEppn(eppn)
    log.info "getScopeFromEppn: Returning response => $response"
    return response
  }

  @Override
  EventLog getEventLog(long referenceId) {
    log.info "getEventLog: Proxying request for referenceId: $referenceId"
    return realUtilityService.getEventLog(referenceId)
  }

  @Override
  EventLog getEventLog() {
    log.info "getEventLog: Proxying getEventLog request"
    return realUtilityService.getEventLog()
  }

  @Override
  String chompNinToSsn(String ssn) {
    // Proxying request.
    log.info "chompNinToSsn: Proxying request for ssn: $ssn"
    String result = realUtilityService.chompNinToSsn(ssn)
    log.info "chompNinToSsn: Returning result => $ssn"
    return result
  }
}
