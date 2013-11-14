/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package se.su.it.signuptool

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Specification

import javax.servlet.http.HttpServletResponse

@TestFor(AdminController)
@Build([EventLog, EventLogEvent])
class  AdminControllerSpec extends Specification {

  def setup() {}

  def cleanup() {
  }

  @Ignore // GRAILS-8426
  def "search: should only allow POST method"() {
    when:
    controller.search("1", "1")

    then:
    response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED
  }

  def "search: should only allow XHR request"() {
    when:
    controller.search("1", "1")

    then:
    response.status == HttpServletResponse.SC_FOUND
    response.redirectedUrl == '/admin/index'
    flash.error == "Invalid user request, not an ajax request."
  }

  def "search: test search for 'referenceId', should render search result template and return collection of event log"() {
    given:
    request.method = "POST"
    request.makeAjaxRequest()

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
    request.method = "POST"
    request.makeAjaxRequest()

    def searchFor = 'norEduPersonNIN'
    def searchText = '191212121212'
    def mockViewData = "viewData"

    def logEvent = EventLogEvent.build().save(flush: true)
    def log = EventLog.build(userId: searchText).save(flush: true)
    log.addToEvents(logEvent)

    views['/admin/_searchResults.gsp'] = mockViewData

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == mockViewData
  }

  def "search: test no event logs are found, should render message 'no result'"() {
    given:
    request.method = "POST"
    request.makeAjaxRequest()

    def searchFor = 'referenceId'
    def searchText = '1'

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == 'admin.search.noResults.for'
  }

  def "search: test when search criteria is undefined, should render message 'no result'"() {
    given:
    request.method = "POST"
    request.makeAjaxRequest()

    def searchFor = 'unknown'
    def searchText = '1'

    when:
    controller.search(searchFor, searchText)

    then:
    assert response.text == 'admin.search.noResults.for'
  }
}
