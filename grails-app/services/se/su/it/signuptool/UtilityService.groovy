package se.su.it.signuptool

import java.util.regex.Matcher
import java.util.regex.Pattern

class UtilityService {

  static transactional = false

  public String getScopeFromEppn(String eppn) {
    Matcher matcher = (eppn =~ /^[_a-ö,A-Ö,0-9]+@([_a-ö,A-Ö,0-9\.]+)$/)
    String scope = (matcher.matches()) ? matcher.group(1) : null
    log.debug "scope: ${scope} found for eppn: $eppn"
    return scope
  }
}
