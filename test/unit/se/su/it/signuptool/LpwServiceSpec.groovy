package se.su.it.signuptool

import grails.test.mixin.TestFor
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import ladok.lpw.service.registrate.facadeclient.CourseSuggestionVO
import ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
import ladok.lpw.service.utility.facadeclient.UtilityFetcher
import ladok.lpw.service.utility.facadeclient.UtilitySemesterVO
import spock.lang.IgnoreRest
import spock.lang.Specification

@TestFor(LpwService)
class LpwServiceSpec extends Specification {
  def setup() {
    service.lpwTicketService = Mock(LpwTicketService)
    service.utilityFetcherServiceClient = Mock(UtilityFetcher)
    service.changeAddressFetcherServiceClient = Mock(ChangeAddressFetcher)
    service.registrateFetcherServiceClient = Mock(RegistrateFetcher)
  }
  def cleanup() {}

  def "getCurrentAndNextSemester: When method throws an exception."() {
    when:
    service.getCurrentAndNextSemester("uid")

    then:
    def ex = thrown(Exception)

    and:
    ex.message == 'lpw_connection_failure'

    and:
    1 * service.utilityFetcherServiceClient.getCurrAndNextSemester(*_) >> { throw new RuntimeException('...') }
  }

  def "getCurrentAndNextSemester: Happy path."() {
    when:
    def resp = service.getCurrentAndNextSemester("uid")

    then:
    resp instanceof UtilitySemesterVO

    and:
    1 * service.utilityFetcherServiceClient.getCurrAndNextSemester(*_) >> new UtilitySemesterVO()
  }

  def "getChangeAddressVO: When method throws an exception."() {
    when:
    service.getChangeAddressVO("uid")

    then:
    def ex = thrown(Exception)

    and:
    ex.message == 'lpw_connection_failure'

    and:
    1 * service.changeAddressFetcherServiceClient.getUserData(*_) >> { throw new RuntimeException('...') }
  }

  def "getChangeAddressVO: Happy path."() {
    when:
    def resp = service.getChangeAddressVO("uid")

    then:
    resp instanceof ChangeAddressVO

    and:
    1 * service.changeAddressFetcherServiceClient.getUserData(*_) >> new ChangeAddressVO()
  }

  def "getCourseRegSuggestions: When method throws an exception."() {
    when:
    service.getCourseRegSuggestions("uid", "20121")

    then:
    def ex = thrown(Exception)

    and:
    ex.message == 'lpw_connection_failure'

    and:
    1 * service.registrateFetcherServiceClient.getCourseRegSuggestions(*_) >> { throw new RuntimeException('...') }
  }

  def "getCourseRegSuggestions: Happy path."() {
    when:
    def resp = service.getCourseRegSuggestions("uid", "20121")

    then:
    resp instanceof CourseSuggestionVO

    and:
    1 * service.registrateFetcherServiceClient.getCourseRegSuggestions(*_) >> new CourseSuggestionVO()
  }

  def "getUserVO: Test when ticket service doesn't return a ticket"() {
    when:
    def resp = service.getUserVO("registrate", "uid", service.DEFAULT_TYPE)

    then:
    resp == null

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { return null }
  }

  def "getUserVO: Test when ticket service throws and exception"() {
    when:
    def resp = service.getUserVO("registrate", "uid", service.DEFAULT_TYPE)

    then:
    resp == null

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { throw new RuntimeException('foo') }
  }

  def "getUserVO: Test for registrate facade"() {
    when:
    def resp = service.getUserVO("registrate", "uid", service.DEFAULT_TYPE)

    then: 'Despite of what the IDE says we do need the fq-name.'
    resp instanceof ladok.lpw.service.registrate.facadeclient.UserVO

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { return "foo" }
  }

  def "getUserVO: Test for utility facade"() {
    when:
    def resp = service.getUserVO("utility", "uid", service.DEFAULT_TYPE)

    then: 'Despite of what the IDE says we do need the fq-name.'
    resp instanceof ladok.lpw.service.utility.facadeclient.UserVO

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { return "foo" }
  }

  def "getUserVO: Test for changeaddress facade"() {
    when:
    def resp = service.getUserVO("changeaddress", "uid", service.DEFAULT_TYPE)

    then: 'Despite of what the IDE says we do need the fq-name.'
    resp instanceof ladok.lpw.service.changeaddress.facadeclient.UserVO

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { return "foo" }
  }

  def "getUserVO: Test for the none existing foobar facade"() {
    when:
    def resp = service.getUserVO("foobar", "uid", service.DEFAULT_TYPE)

    then:
    resp == null

    and:
    1 * service.lpwTicketService.getTicket(*_) >> { return "foo" }
  }
}
