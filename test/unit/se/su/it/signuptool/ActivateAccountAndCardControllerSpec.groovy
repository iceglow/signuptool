package se.su.it.signuptool

import grails.test.mixin.*
import grails.test.mixin.webflow.WebFlowUnitTestMixin
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification

@TestMixin(WebFlowUnitTestMixin)
@TestFor(ActivateAccountAndCardController)

class ActivateAccountAndCardControllerSpec extends Specification {

  def setup() {
    controller.utilityService = Mock(UtilityService)
    controller.ladokService = Mock(LadokService)
    controller.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
  }

  def "index: Testing the password passing."() {
    given:
    flash.password = 's3cret!'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.password == null
    flash.error == 'activateAccountAndCardController.noValidIdFound'

    and:
    1 * controller.utilityService.fetchUid(*_)
  }

  def "index: When no proper uid is found."() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.noValidIdFound'

    and:
    1 * controller.utilityService.fetchUid(*_)
  }

  def "index: When uid is set in the session but finding the user throws an exception."() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.errorWhenFetchingUser'

    and:
    1 * controller.utilityService.fetchUid(*_) >> 'foo'
    1 * controller.utilityService.uidIsPnr(*_) >> false
    1 * controller.activateAccountAndCardService.findUser(*_) >> { throw new RuntimeException('foo') }
  }

  def "index: Trying to create a new user (uid not found in sukat), but user is not found in ladok.."() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.userNotFoundInLadok'

    and:
    1 * controller.utilityService.fetchUid(*_) >> 'foo'
    1 * controller.utilityService.uidIsPnr(*_) >> false
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> null
  }

  def "index: Trying to create a new user (uid not found in sukat), and fetching ladok data throws an exception"() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.userNotFoundInLadok'

    and:
    1 * controller.utilityService.fetchUid(*_) >> 'foo'
    1 * controller.utilityService.uidIsPnr(*_) >> false
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> { throw new RuntimeException('foo')}
  }

  def "index: Trying to create a new user (uid not found in sukat)"() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/activateAccountAndCard/createNewAccount'

    and:
    1 * controller.utilityService.fetchUid(*_) >> 'foo'
    1 * controller.utilityService.uidIsPnr(*_) >> false
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> [enamn:'foo', tnamn:'kaka']
  }

  def "index: When a user is found in sukat"() {
    given:
    flash.password = 's3cret!'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/index'

    and:
    model.user.uid == 'foo'
    model.password == 's3cret!'
    model.cardInfo == [:]

    and:
    flash.password == null

    and:
    1 * controller.utilityService.fetchUid(*_) >> 'foo'
    1 * controller.utilityService.uidIsPnr(*_) >> false
    1 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO(uid:'foo')
    0 * controller.activateAccountAndCardService.fetchLadokData(*_)
    1 * controller.activateAccountAndCardService.getCardOrderStatus(*_) >> [:]
  }

  def "createNewAccountFlow"() {
    // TODO: Tests for the flow.
    return true
  }
}
