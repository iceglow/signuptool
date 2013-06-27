package se.su.it.signuptool

import java.util.regex.Matcher

class UtilityService {

  static transactional = false

  public String getUid(String eppn) {
    String uid = ''
    Matcher matcher = (eppn =~ /^([_a-ö,A-Ö,0-9]+)@[_a-ö,A-Ö,0-9\.]+$/)

    uid = (matcher.matches()) ? matcher.group(1) : ''
    log.debug "uid: ${uid} found for eppn: $eppn"
    return uid
  }
  public boolean uidIsPnr(String uid) {
    (uid ==~ /^(([0-9]{6})|[0-9]{8})[0-9,a-ö,A-Ö]{4}$/)
  }
}
