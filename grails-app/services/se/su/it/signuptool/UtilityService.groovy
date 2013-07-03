package se.su.it.signuptool

import java.util.regex.Matcher

class UtilityService {

  static transactional = false

  public boolean uidIsPnr(String uid) {
    (uid ==~ /^(([0-9]{6})|[0-9]{8})[0-9,a-ö,A-Ö]{4}$/)
  }

  public String fetchUid(String uid, String eppn) {
      (uid)?:(eppn)? eppnToUid(eppn) : null
  }

  private String eppnToUid(String eppn) {
    String uid = null
    Matcher matcher = (eppn =~ /^([_a-ö,A-Ö,0-9]+)@[_a-ö,A-Ö,0-9\.]+$/)

    uid = (matcher.matches()) ? matcher.group(1) : null
    log.debug "uid: ${uid} found for eppn: $eppn"
    return uid
  }
}
