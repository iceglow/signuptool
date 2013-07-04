package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UtilityService)
class UtilityServiceSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  @Unroll
  void "getUid: Parsing invalid eppns: #eppn"() {
    expect:
    service.getUidFromEppn(eppn) == expected

    where:
    eppn << ['kaka', 'kaka@', 'kaka@kaka@kaka']
    expected << [null, null, null]
  }
  @Unroll
  void "getUid: Parsing valid eppn: #eppn"() {
    expect:
    service.getUidFromEppn(eppn) == expected

    where:
    eppn << ['kaka@su.se', 'kaka@its.uu.se', '_kaka@su.se', 'kaka0_@su.se', 'kötta@su.se', '197007077777@edu.id.se']
    expected << ['kaka', 'kaka', '_kaka', 'kaka0_', 'kötta', '197007077777']
  }
  @Unroll
  void "uidIsPnr: when uid is #uid => #expected"() {
    expect:
    service.uidIsPnr(uid) == expected

    where:
     uid              | expected
     'katten'         | false // no numbers.
     '012345678'      | false // 9 long
     '0123456789012'  | false // 13 long
     '01234X6789'     | false // first 6 contains alphabetic char
     '012345X789'     | true
     '012345TTTT'     | true
     '0123456TTTT'    | false // 11 long
     '01234567TTTT'   | true
     '012345678Ö'     | true
     '01234567891Ö'   | true
  }

  @Unroll
  void "fetchUid where uid: \'#uid\' and eppn \'#eppn\' expecting \'#expected\'"() {
    Map request = [:]
    request.eppn = eppn
    request.norEduPersonNIN = nin

    expect:
    expected == service.fetchUid(scope, request)

    where:
    eppn         | scope        | nin    | expected
    null         | "su.se"      | null   | null
    null         | "su.se"      | null   | null
    ''           | "su.se"      | null   | null
    ''           | "su.se"      | null   | null
    null         | "su.se"      | null   | null
    'eppn'       | "su.se"      | null   | null
    'eppn'       | "su.se"      | null   | null
    'eppn'       | "unknown"    | null   | null
    'eppn@su.se' | "su.se"      | null   | 'eppn'
    'eppn@su.se' | "su.se"      | 'nin'  | 'eppn'
    'eppn@x.se'  | "su.se"      | 'nin'  | 'eppn'
    'eppn@x.se'  | "studera.nu" | 'nin'  | 'nin'
  }
}
