package se.su.it.signuptool.commandobjects

import grails.validation.Validateable
import groovy.transform.ToString
import groovy.util.logging.Slf4j
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.signuptool.ActivateAccountAndCardController

@Validateable
@ToString(includeNames = true, includeFields = true, excludes = ["password"])
@Slf4j
public class AccountAndCardProcess extends FlowProcessBase {

  private boolean hasCompletedCardOrder = false
  private boolean errorWhileOrderingCard = false
  private int step = ActivateAccountAndCardController.STEP_START

  boolean getHasCompletedCardOrder() {
    return hasCompletedCardOrder
  }

  void setHasCompletedCardOrder(boolean hasCompletedCardOrder) {
    this.hasCompletedCardOrder = hasCompletedCardOrder
  }

  boolean getErrorWhileOrderingCard() {
    return errorWhileOrderingCard
  }

  void setErrorWhileOrderingCard(boolean errorWhileOrderingCard) {
    this.errorWhileOrderingCard = errorWhileOrderingCard
  }

  public int getStep() {
    this.step
  }

  public void setStep(int step) {
    this.step = step
    def session = RequestContextHolder.requestAttributes?.session
    session?.step = null
  }

  /**
   * Stores the result of an account activation on the currently stored user.
   * @param result
   */
  public void storeActivationResult(def result) {
    this.user.accountIsActive = true
    this.user.uid = result.uid
    this.password = result.password
  }
}
