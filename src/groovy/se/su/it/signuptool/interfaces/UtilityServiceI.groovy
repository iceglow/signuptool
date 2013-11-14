package se.su.it.signuptool.interfaces

import se.su.it.signuptool.EventLog

public interface UtilityServiceI {
  String getScopeFromEppn(String eppn)
  EventLog getEventLog(long referenceId)
  EventLog getEventLog()
  String chompNinToSsn(String ssn)
}
