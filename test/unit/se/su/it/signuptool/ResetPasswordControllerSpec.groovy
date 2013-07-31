package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification

@TestFor(ResetPasswordController)
@Mock([EventLog, EventLogEvent])
class ResetPasswordControllerSpec extends Specification {

  def setup() {
    controller.utilityService = Mock(UtilityService) {
      getEventLog(*_) >> { return new EventLog().save(flush:true) }
    }
    controller.sukatService = Mock(SukatService)
  }

  void "index: test when scope is 'studera.nu', basic flow"() {
    given:
    def pnr = "8112129999"
    def user = new SvcSuPersonVO()
    user.setAccountIsActive(true)

    request.norEduPersonNIN = pnr

    when:
    controller.index()

    then:
    assert session.pnr == pnr

    assert response.redirectedUrl == '/resetPassword/resetPassword'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUserBySocialSecurityNumber(pnr) >> {return user}
  }

  def "index: test when scope is 'studera.nu' and none 'norEduPersonNIN' is set on request, should redirect to unverified account"() {
    when:
    controller.index()

    then:
    assert view == '/shared/unverifiedAccount'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"
  }

  def "index: test when scope is 'bogus', should render flash error and redirect to dashboard"() {
    when:
    controller.index()

    then:
    assert response.redirectedUrl == '/dashboard/index'

    and:
    assert flash.error == 'activateAccountAndCardController.noValidScopeFound'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "bogus"
  }

  def "index: test when user is not found, should render flash error and redirect to dashboard"() {
    given:
    def pnr = "8112129999"

    request.norEduPersonNIN = pnr

    when:
    controller.index()

    then:
    assert session.pnr == pnr

    assert response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUserBySocialSecurityNumber(pnr) >> {return null}
  }

  def "index: test when user is found but account is inactive, should render flash error and redirect to dashboard"() {
    given:
    def pnr = "8112129999"
    def user = new SvcSuPersonVO()
    user.setAccountIsActive(false)

    request.norEduPersonNIN = pnr

    when:
    controller.index()

    then:
    assert session.pnr == pnr

    assert response.redirectedUrl == '/dashboard/index'

    and:
    1 * controller.utilityService.getScopeFromEppn(*_) >> "studera.nu"

    and:
    1 * controller.sukatService.findUserBySocialSecurityNumber(pnr) >> {return user}
  }
}