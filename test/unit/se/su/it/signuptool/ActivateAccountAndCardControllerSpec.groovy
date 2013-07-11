package se.su.it.signuptool

import grails.test.mixin.*
import se.su.it.config.ConfigService
import se.su.it.svc.SvcSuPersonVO
import spock.lang.IgnoreRest
import spock.lang.Specification

@TestFor(ActivateAccountAndCardController)
@Mock([EventLog, EventLogEvent])
class ActivateAccountAndCardControllerSpec extends Specification {

  private final String DEFAULT_SCOPE = "studera.nu"

  def setup() {
    controller.utilityService = Mock(UtilityService)
    controller.ladokService = Mock(LadokService)
    controller.activateAccountAndCardService = Mock(ActivateAccountAndCardService)
    controller.configService = Mock(ConfigService)
  }

  def "index: Testing the password passing."() {
    given:
    session.password = 's3cret!'

    when:
    controller.index()

    then:
    session.password == null

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
  }

  def "index: handle studera.nu unverified account (missing norEduPersonNIN)"() {
    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/unverifiedAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"
  }

  def "index: Test unhandled scope when users pnr is not in the session."() {
    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'
    and:
    flash.error == "activateAccountAndCardController.noValidScopeFound"

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.sen"
  }

  def "index: Testing when pnr is already in the session."() {
    given:
    session.pnr = 'socialSecurityNumber'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/userNotFoundInLadok'

    and:
    0 * controller.utilityService.getScopeFromEppn(*_)
  }

  def "index: When pnr is set in the session but finding the user throws an exception."() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/dashboard/index'

    and:
    flash.error == 'activateAccountAndCardController.errorWhenFetchingUser'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> { throw new RuntimeException('foo') }
  }

  def "index: Trying to create a new user (uid not found in sukat), but user is not found in ladok.."() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/userNotFoundInLadok'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> null
  }

  def "index: Trying to create a new user (uid not found in sukat), and fetching ladok data throws an exception"() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/userNotFoundInLadok'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> { throw new RuntimeException('foo')}
  }

  def "index: Trying to create a new user (uid not found in sukat)"() {
    given:
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/activateAccountAndCard/createNewAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> null
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> [enamn:'foo', tnamn:'kaka']
  }

  def "index: When a user is found in sukat"() {
    given:
    session.password = 's3cret!'
    request.norEduPersonNIN = '191102023333'

    when:
    controller.index()

    then:
    view == '/activateAccountAndCard/index'

    and:
    model.user.uid == 'foo'
    model.password == 's3cret!'
    model.lpwurl == "lpwtoolUrl"
    model.sukaturl == "sukattoolUrl"

    and:
    session.password == null

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO(uid:'foo', accountIsActive: true)
    0 * controller.activateAccountAndCardService.fetchLadokData(*_)
    2 * controller.configService.getValue(_,_) >> { String arg1, String arg2 ->
      assert arg1 == "signup"
      if (arg2 == "lpwtool") { return "lpwtoolUrl" }
      if (arg2 == "sukattool") { return "sukattoolUrl" }
      return null
    }
  }

  def "index: When a stub is found in SUKAT"() {
    given:
    request.norEduPersonNIN = '191102023333'
    flash.password = 's3cret!'

    when:
    controller.index()

    then:
    response.redirectedUrl == '/activateAccountAndCard/createNewAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> DEFAULT_SCOPE
    1 * controller.activateAccountAndCardService.findUser(*_) >> new SvcSuPersonVO(uid:'foo', accountIsActive: false)
    1 * controller.activateAccountAndCardService.fetchLadokData(*_) >> [enamn:'enamn', tnamn:'tnamn']
  }
}
