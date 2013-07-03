package se.su.it.signuptool

import java.util.regex.Matcher
import java.util.regex.Pattern

class UtilityService {

  static transactional = false

  public boolean uidIsPnr(String uid) {
    (uid ==~ /^(([0-9]{6})|[0-9]{8})[0-9,a-ö,A-Ö]{4}$/)
  }

  public String fetchUid(String scope, request) {
    String uid = null
    String eppn = (request?.eppn) ?: null

    switch(scope) {
      case "studera.nu":
        uid = (request.norEduPersonNIN)?:null
        break
      break
      case "su.se":
        uid = getUidFromEppn(eppn)
        break
      default:
        log.error "No valid scope defined"
        break
    }

    (uid)?:null
  }

  public String getScopeFromEppn(String eppn) {
    Matcher matcher = (eppn =~ /^[_a-ö,A-Ö,0-9]+@([_a-ö,A-Ö,0-9\.]+)$/)
    String scope = (matcher.matches()) ? matcher.group(1) : null
    log.debug "scope: ${scope} found for eppn: $eppn"
    return scope
  }

  private String getUidFromEppn(String eppn) {
    String uid = null
    Matcher matcher = (eppn =~ /^([_a-ö,A-Ö,0-9]+)@[_a-ö,A-Ö,0-9\.]+$/)

    uid = (matcher.matches()) ? matcher.group(1) : null
    log.debug "uid: ${uid} found for eppn: $eppn"
    return uid
  }
}
