package se.su.it.signuptool.commandobjects

import se.su.it.signuptool.ActivateAccountAndCardController
import se.su.it.svc.SvcSuPersonVO
import spock.lang.Specification

class AccountAndCardProcessSpec extends Specification {

  def setup() {}
  def cleanup() {}

  def "Process extends BaseFlowProcess"() {
    expect:
    AccountAndCardProcess.superclass == FlowProcessBase.class
  }

  def "Initial state should be"() {
    given:

    AccountAndCardProcess acp = new AccountAndCardProcess()

    expect:
    !acp.hasCompletedCardOrder
    !acp.errorWhileOrderingCard
    acp.step == ActivateAccountAndCardController.STEP_START
  }

  def "Setting state"() {
    given:
    AccountAndCardProcess acp = new AccountAndCardProcess()

    when:
    acp.hasCompletedCardOrder = true
    acp.errorWhileOrderingCard = true
    acp.step = ActivateAccountAndCardController.STEP_END

    then:
    acp.hasCompletedCardOrder
    acp.errorWhileOrderingCard
    acp.step == ActivateAccountAndCardController.STEP_END
  }

  def "storeActivationResult with no user"() {
    when:
    AccountAndCardProcess acp = new AccountAndCardProcess()
    acp.storeActivationResult([:])

    then:
    thrown(IllegalStateException)
  }

  def "storeActivationResult"() {
    given:
    def result = [uid:'foo', password:'bar']

    when:
    AccountAndCardProcess acp = new AccountAndCardProcess(user:new SvcSuPersonVO())
    acp.storeActivationResult(result)

    then:
    acp.user.accountIsActive
    acp.user.uid == result.uid
    acp.password == result.password
  }
}
