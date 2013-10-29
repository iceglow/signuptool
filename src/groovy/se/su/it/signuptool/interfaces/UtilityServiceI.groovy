package se.su.it.signuptool.interfaces

import se.su.it.signuptool.EventLog

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

public interface UtilityServiceI {
  String getScopeFromEppn(String eppn)
  EventLog getEventLog(long referenceId)
  EventLog getEventLog()
  String chompNinToSsn(String ssn)
}