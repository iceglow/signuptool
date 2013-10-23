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

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import org.apache.commons.logging.Log
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
@Mock([EventLog, EventLogEvent])
class ActivateAccountAndCardControllerWebFlowsSpec extends Specification {

  @Shared
  controller

  def setup() {
    def myController = mockController(ActivateAccountAndCardController)
    myController.utilityService = Mock(UtilityService) {
      getEventLog(*_) >> { return new EventLog().save(flush:true) }
    }
    myController.ladokService = Mock(LadokService)
    myController.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    myController.sukatService = Mock(SukatService)
    controller = myController
  }

  def "createNewAccountFlow > prepareForwardAddress: Check success pathing"() {
    expect:
    'activateAccount' == createNewAccountFlow.prepareForwardAddress.on.success.to
  }

  def "createNewAccountFlow > prepareForwardAddress: On success"() {
    given:
    def mail = 'kalle@example.com'

    when:
    def resp = createNewAccountFlow.prepareForwardAddress.action()

    then:
    resp == ['forwardAddress':mail]
    'prepareForwardAddress' == lastEventName

    and:
    1 * controller.ladokService.findForwardAddressSuggestionForPnr(*_) >> mail
  }

  def "createNewAccountFlow > prepareForwardAddress: When eventlog throws exception, should log and return error"() {
    when:
    def resp = createNewAccountFlow.prepareForwardAddress.action()

    then:
    resp == "error"

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException("Booom!") }
  }

  def "createNewAccountFlow > prepareForwardAddress: throws an exception"() {
    when:
    def resp = createNewAccountFlow.prepareForwardAddress.action()

    then:
    resp == ['forwardAddress':'']
    'prepareForwardAddress' == lastEventName

    and:
    1 * controller.ladokService.findForwardAddressSuggestionForPnr(*_) >> { throw new RuntimeException('foo') }
  }

  def "createNewAccountFlow > activateAccount: Check success pathing"() {
    expect:
    'processEmailInput' == createNewAccountFlow.activateAccount.on.acceptAccountActivation.to
  }

  def "createNewAccountFlow > activateAccount: Assert that terms of use acceptance get persisted in flow."() {
    given:
    params.approveTermsOfUse = 'kakakaka'

    when:
    createNewAccountFlow.activateAccount.on.acceptAccountActivation.action()

    then:
    flow.approveTermsOfUse == 'kakakaka'
  }

  def "createNewAccountFlow > processEmailInput: Check success pathing"() {
    expect:
    'createAccount' == createNewAccountFlow.processEmailInput.on.success.to
  }

  def "createNewAccountFlow > processEmailInput: Check error pathing"() {
    given:
    def error = 'clear me!'
    flow.error = error

    when:
    def resp = createNewAccountFlow.processEmailInput.on.error.to

    then:
    resp == "errorHandler"
    flow.error == error
  }

  def "createNewAccountFlow > processEmailInput: When eventlog throws exception, should log and return error"() {
    when:
    def resp = createNewAccountFlow.processEmailInput.action()

    then:
    resp == "error"

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException("Booom!") }
  }

  def "createNewAccountFlow > processEmailInput: When not having accepted the terms of agreement "() {
    when:
    def resp = createNewAccountFlow.processEmailInput.action()

    then:
    resp == 'retry'

    and:
    0 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> true

    and:
    flow.error == 'activateAccountAndCardController.errors.notHavingApprovedTermsOfUse'
  }

  def "createNewAccountFlow > processEmailInput: On success "() {
    given:
    flow.approveTermsOfUse = true

    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> true

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: given an invalid email"() {
    given:
    session?.eventLog = new EventLog().save(flush:true)
    flow.approveTermsOfUse = true

    when:
    createNewAccountFlow.processEmailInput.action()

    then:
    1 * controller.activateAccountAndCardService.validateForwardAddress(*_) >> false

    and:
    flow.error == "activateAccountAndCardController.errors.notHavingSuppliedValidForwardAddress"

    and:
    lastEventName == 'processEmailInput'
  }

  def "createNewAccountFlow > processEmailInput: on successful email validation"() {
    given:
    flow.approveTermsOfUse = true
    flow.error == 'clear me!'

    when:
    def resp = createNewAccountFlow.processEmailInput.on.success.action()

    then:
    resp == ""
    flow.error == ''
    lastTransitionName == 'success'
  }

  def "createNewAccountFlow > createAccount: Check success pathing"() {
    expect:
    'beforeEnd' == createNewAccountFlow.createAccount.on.success.to
  }

  def "createNewAccountFlow > createAccount: Check error pathing"() {
    expect:
    'errorHandler' == createNewAccountFlow.createAccount.on.error.to
  }

  def "createNewAccountFlow > createAccount: When eventlog throws exception, should log and return error"() {
    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException("Booom!") }
  }

  def "createNewAccountFlow > createAccount: On successful creation"() {
    given:
    def uid = 'uid'
    session.givenName = 'givenName'
    session.sn = 'sn'
    session.nin = 'socialSecurityNumber'
    flow.forwardAddress = 'mailRoutingAddress'
    def response = [uid:uid, password:'password']

    when:
    createNewAccountFlow.createAccount.action()

    then:
    session.uid == response.uid
    session.password == response.password

    and:
    1 * controller.sukatService.createSuPersonStub(session.givenName,session.sn,session.nin) >> uid

    1 * controller.sukatService.setMailRoutingAddress(uid, flow.forwardAddress)

    1 * controller.sukatService.activateUser(uid) >> response
  }

  def "createNewAccountFlow > createAccount: creation fails."() {
    given:
    session.givenName = 'givenName'
    session.sn = 'sn'
    session.nin = 'socialSecurityNumber'

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"
    session.uid == null
    flash.password == null

    and:
    flash.info == null
    flow.error == "activateAccountAndCardController.errors.failedWhenEnrollingUser"

    and:
    1 * controller.sukatService.createSuPersonStub(*_) >> { throw new RuntimeException('foo') }
  }

  def "createNewAccountFlow > createAccount: user with no uid."() {
    given:
    session.user = new SvcSuPersonVO(uid: null)

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"
  }

  def "createNewAccountFlow > createAccount: exception during setMailRoutingAddress."() {
    given:
    session.user = new SvcSuPersonVO(uid: 'apa')

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"

    and:
    1 * controller.sukatService.setMailRoutingAddress(*_) >> { throw new Exception() }
  }

  def "createNewAccountFlow > createAccount: exception during activateUser."() {
    given:
    session.user = new SvcSuPersonVO(uid: 'apa')

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"

    and:
    1 * controller.sukatService.activateUser(*_) >> { throw new Exception() }
  }

  def "createNewAccountFlow > createAccount: no result from activateUser."() {
    given:
    session.user = new SvcSuPersonVO(uid: 'apa')

    when:
    def resp = createNewAccountFlow.createAccount.action()

    then:
    resp == "error"

    and:
    1 * controller.sukatService.activateUser(*_) >> { null }
  }

  def "createNewAccountFlow > errorHandler: Check success pathing"()  {
    expect:
    'errorPage' == createNewAccountFlow.errorHandler.on.success.to
  }

  def "createNewAccountFlow > errorHandler: Test the errorhandler"()  {
    when:
    createNewAccountFlow.errorHandler.action()

    then: 'flow.error contains message'
    flow.error
  }

  def "createNewAccountFlow > beforeEnd: see that we end up on index again."()  {
    when:
    createNewAccountFlow.beforeEnd.action()

    then:
    response.redirectedUrl == '/activateAccountAndCard/index'
  }

  def "orderCardFlow: test flow when user is found, has registered address and no cards or orders"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    session.nin = "1234567890"


    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'success'
    assert 'success' == stateTransition

    and:
    1 * controller.activateAccountAndCardService.getCardOrderStatus(*_) >> [canOrderCard:true]
  }

  def "orderCardFlow: test when user is missing account, should log event and redirect to error page"() {
    given:
    session.nin = "1234567890"


    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    assert event == 'error'

    assert flow.error == 'activateAccountAndCardController.cardOrder.noAccount.error'
  }

  def "orderCardFlow: test when user has an account but is not allowed to order cards, should log event and redirect to error page"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    session.nin = "1234567890"

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'cantOrderCard'

    and:
    1 * controller.activateAccountAndCardService.getCardOrderStatus(*_) >> [canOrderCard:false]
  }

  def "orderCardFlow: exception on getting event log"() {
    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'error'

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new Exception('Blam!') }
  }

  def "orderCardFlow: exception on getting card order status"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'error'

    and:
    1 * controller.activateAccountAndCardService.getCardOrderStatus(*_) >> { throw new Exception('Blam!') }
  }

  def "orderCardFlow: can't order card"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    controller.activateAccountAndCardService.getCardOrderStatus(*_) >> {
      [canOrderCard: false]
    }

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'cantOrderCard'
  }

  def "orderCardFlow: can't order card & has no address"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    def eventLog = Mock(EventLog)
    controller.utilityService = Mock(UtilityService)
    controller.utilityService.getEventLog(*_) >> { eventLog }
    controller.activateAccountAndCardService.getCardOrderStatus(*_) >> {
      [canOrderCard: false, hasAddress: false]
    }

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'cantOrderCard'

    and:
    1 * eventLog.logEvent(_)
  }

  def "orderCardFlow: can't order card & has cards already"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    def eventLog = Mock(EventLog)
    controller.utilityService = Mock(UtilityService)
    controller.utilityService.getEventLog(*_) >> { eventLog }
    controller.activateAccountAndCardService.getCardOrderStatus(*_) >> {
      [canOrderCard: false, hasAddress: true, suCards: true]
    }

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'cantOrderCard'

    and:
    1 * eventLog.logEvent(_)
  }

  def "orderCardFlow: can't order card & has card orders already"() {
    given:
    session.user = new SvcSuPersonVO(uid:"abcd1234@su.se")
    def eventLog = Mock(EventLog)
    controller.utilityService = Mock(UtilityService)
    controller.utilityService.getEventLog(*_) >> { eventLog }
    controller.activateAccountAndCardService.getCardOrderStatus(*_) >> {
      [canOrderCard: false, hasAddress: true, suCards: false, cardOrders: true]
    }

    when:
    def event = orderCardFlow.prepareForwardOrderCard.action()

    then:
    event == 'cantOrderCard'

    and:
    1 * eventLog.logEvent(_)
  }

  def "orderCardFlow: sendCardOrder sets addressIsValid from params"() {
    given:
    flow.addressIsValid = false
    params.addressIsValid = true

    when:
    orderCardFlow.cardOrder.on.sendCardOrder.action()

    then:
    flow.addressIsValid
  }

  def "orderCardFlow: sendCardOrder sets acceptLibraryRules from params"() {
    given:
    flow.acceptLibraryRules = false
    params.acceptLibraryRules = true

    when:
    orderCardFlow.cardOrder.on.sendCardOrder.action()

    then:
    flow.acceptLibraryRules
  }

  def "orderCardFlow: test when user doesn't select if address is valid or in valid, should log event and redirect to cardOrder page with error message"() {
    given:
    flow.registeredAddressValid = false
    flow.registeredAddressInvalid = false


    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'error'

    assert flow.error == 'activateAccountAndCardController.cardOrder.selectValidInvalid.error'

    assert 'cardOrder' == orderCardFlow.processCardOrder.on.error.to

  }

  def "orderCardFlow: test when user doesn't accept library rules, should log event and redirect to cardOrder page with error message"() {
    given:
    flow.addressIsValid = "1"
    flow.acceptLibraryRules = false

    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'error'

    assert flow.error == 'activateAccountAndCardController.cardOrder.approveTermsOfUse.error'

    assert 'cardOrder' == orderCardFlow.processCardOrder.on.error.to
  }

  def "orderCardFlow: test when user select address is invalid, should log event and redirect to end"() {
    given:
    flow.addressIsValid = "0"

    when:
    def event = orderCardFlow.processCardOrder.action()

    then:
    assert event == 'success'

    assert 'beforeEnd' == orderCardFlow.processCardOrder.on.success.to
  }

  def "orderCardFlow: goes to error if no EventLog"() {
    when:
    def resp = orderCardFlow.processCardOrder.action()

    then:
    resp == "error"

    and:
    1 * controller.utilityService.getEventLog(*_) >> { throw new RuntimeException("Booom!") }
  }

  def "orderCardFlow: processCardOrder happy path"() {
    given:
    SvcSuPersonVO user = new SvcSuPersonVO()
    session.user = user
    flow.cardInfo = [ladokAddress: [foo:'foo']]
    flow.addressIsValid = "1"
    flow.acceptLibraryRules = true

    when:
    orderCardFlow.processCardOrder.action()

    then:
    1 * controller.sukatService.orderCard(user, flow.cardInfo.ladokAddress)
  }

  def "orderCardFlow: exception during orderCard"() {
    given:
    flow.cardInfo = [ladokAddress: [foo:'foo']]
    flow.addressIsValid = "1"
    flow.acceptLibraryRules = true
    controller.sukatService.orderCard(*_) >> { throw new Exception('Blamo!') }

    when:
    def ret = orderCardFlow.processCardOrder.action()

    then:
    ret == 'error'
  }

  def "orderCardFlow: processCardOrder success"() {
    given:
    session.hasCompletedCardOrder = false
    session.errorWhileOrderingCard = true

    when:
    orderCardFlow.processCardOrder.on.success.action()

    then:
    session.hasCompletedCardOrder
    !session.errorWhileOrderingCard
  }

  def "Error handler with provided message"() {
    given:
    flash.stateException = new Exception("kaka")
    def message = "this superior message"
    flow.error = message

    when:
    orderCardFlow.errorHandler.action()

    then:
    session.error == message
    flash.stateException == null
    session.errorWhileOrderingCard
  }

  def "Error handler without provided message"() {
    given:
    flash.stateException = new Exception("kaka")

    when:
    orderCardFlow.errorHandler.action()

    then:
    flash.stateException == null
    session.error == "activateAccountAndCardController.errors.genericError"
    session.errorWhileOrderingCard
  }

  def "cantOrderCard"() {
    when:
    orderCardFlow.cantOrderCard.on.continue.action() == 'beforeEnd'

    then:
    session.hasCompletedCardOrder == true
  }
}
