package se.su.it.signuptool

import grails.test.mixin.TestFor
import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

import java.text.SimpleDateFormat

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LadokService)
class LadokServiceSpec extends Specification {

  /**
   * These tests are missing some somewhat vital parts.
   * Sql has not been mocked, Sql's no parameter constructor requires
   * objenesis, which causes issues when running tests multiple times
   * from grails interactive mode..
   * @return
   */

  def setup() {
    service.ladokDataSource = Mock(BasicDataSource)
  }

  def cleanup() {
    LadokService.metaClass = null
  }

  void "findStudentInLadok: When no student is found."() {
    given:
    when:
    def resp = service.findStudentInLadok("1234567890")

    then:
    !resp
  }

  void "findStudentInLadok: When a student is found."() {
    given:

    def arg1 = 'tnamn'
    def arg2 = 'enamn'

    LadokService.metaClass.doListQuery = { String iarg1, Map iarg2 ->
      return [[arg1:arg1, arg2:arg2]]
    }

    when:
    def resp = service.findStudentInLadok("1234567890")

    then:
    resp.arg1 == arg1
    resp.arg2 == arg2
  }

  void "findForwardAddressSuggestionForPnr: When fetching forward address"() {
    given:
    def arg1 = 'foo@bar.se'

    LadokService.metaClass.doListQuery = { String iarg1, Map iarg2 ->
      return [[komadr:arg1]]
    }

    when:
    def resp = service.findForwardAddressSuggestionForPnr('...')

    then:
    resp == arg1
  }

  void "withConnection: When creating a new sql connection fails"() {
    given:
    Closure query = { Sql sql ->
      assert sql instanceof Sql
      return ["myQuery"]
    }

    when:
    List resp = service.withConnection(query)

    then:
    resp?.first() == "myQuery"
  }

  void "withConnection: When querying fails"() {
    given:

    Closure query = { Sql sql ->
      throw new RuntimeException('foo')
    }

    when:
    def resp = service.withConnection(query)

    then:
    resp == null
  }

  void "getAddressFromLadokByPnr: happy path with tempaddress"() {
    given:
    Date now = new Date()

    service.metaClass.doListQuery = { String query, Map map ->
      [[adrtyp:'2',fromdat: now.minus(7).format("yyyy-MM-dd"), tomdat:now.plus(7).format("yyyy-MM-dd"),land: 'SVERIGE',streetaddress1: 'kalle ankas gata', postnr: '123 45', ort: 'toontown'],[adrtyp:'4',land: 'SVERIGE',streetaddress1: 'snickarbacken', postnr: '123 45', ort: 'farsta']]
    }

    when:
    Map address = service.getAddressFromLadokByPnr("1234567890")

    then:
    address

    and:
    address.ort == 'toontown'
  }

  void "getAddressFromLadokByPnr: happy path without tempaddress"() {
    given:
    Date now = new Date()

    service.metaClass.doListQuery = { String query, Map map ->
      [[adrtyp:'2',fromdat: now.minus(14).format("yyyy-MM-dd"), tomdat:now.minus(7).format("yyyy-MM-dd"),land: 'SVERIGE',streetaddress1: 'kalle ankas gata', postnr: '123 45', ort: 'toontown'],[adrtyp:'4',land: 'SVERIGE',streetaddress1: 'snickarbacken', postnr: '123 45', ort: 'farsta']]
    }

    when:
    Map address = service.getAddressFromLadokByPnr("1234567890")

    then:
    address

    and:
    address.ort == 'farsta'
  }
  @Unroll
  void "chompPnr: When given pnr: \'#pnr\' we expect '\'#expected\'"() {
    expect:
    LadokService.chompPnr(pnr)

    where:
    pnr             | expected
    '***********'   | '***********'   // 11 chars, nothing happens.
    '++**********'  | '*********'     // 12 chars, first 2 chars should be cut.
    '++***********' | '++***********' // 13 chars, nothing happens.
  }

}
