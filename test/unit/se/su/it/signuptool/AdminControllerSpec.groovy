package se.su.it.signuptool

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(AdminController)
@Build([EventLog, EventLogEvent])
class  AdminControllerSpec extends Specification {

  def setup() {}

  def cleanup() {
  }

  def "search: test search for 'referenceId', should render search result template and return collection of event log"() {
    given:
    def searchFor = 'referenceId'
    def searchText = '1'
    def mockViewData = "viewData"

    def logEvent = EventLogEvent.build().save(flush: true)
    def log = EventLog.build().save(flush: true)
    log.addToEvents(logEvent)

    views['/admin/_searchResults.gsp'] = mockViewData

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == mockViewData
  }

  def "search: test search for 'socialSecurityNumber', should render search result template and return collection of event log"() {
    given:
    def searchFor = 'socialSecurityNumber'
    def searchText = '191212121212'
    def mockViewData = "viewData"

    def logEvent = EventLogEvent.build().save(flush: true)
    def log = EventLog.build(socialSecurityNumber: searchText).save(flush: true)
    log.addToEvents(logEvent)

    views['/admin/_searchResults.gsp'] = mockViewData

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == mockViewData
  }

  def "search: test no event logs are found, should render message 'no result'"() {
    given:
    def searchFor = 'referenceId'
    def searchText = '1'

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == 'admin.search.noResults.for'
  }

  def "search: test when search criteria is undefined, should render message 'no result'"() {
    given:
    def searchFor = 'unknown'
    def searchText = '1'

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == 'admin.search.noResults.for'
  }
}