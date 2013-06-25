package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ActivateAccountAndCardService)
class ActivateAccountAndCardServiceSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "canOrderCard: Stub"() {
    expect: 'will always return true'
    service.canOrderCard()
  }
  @Unroll
  void "validateForwardAddress (invalid): \'#email\' "() {
    expect: 'will return false'
    !service.validateForwardAddress(email)
    where:
    email << [null, '', ' ', 'trixy', 'trixy@', '@trixy',
        '!"#@!"#!', '!trixy@trixy.com', 'trixy@trixy!.com', 'trixy@trixy', 'trixy@trixy_.com']
  }
  @Unroll
  void "validateForwardAddress (valid): \'#email\' "() {
    expect: 'will return true'
    service.validateForwardAddress(email)
    where:
    email << ['a@b.se', 'a@b.info', 'a.b@c.nu', 'a_b@cd.ef']
  }

}
