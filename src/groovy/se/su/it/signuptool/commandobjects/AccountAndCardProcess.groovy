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

  private boolean newUser = false
  private boolean hasCompletedCardOrder = false
  private boolean errorWhileOrderingCard = false
  private int step = ActivateAccountAndCardController.STEP_START

  void setError(String error) {
    this.error = error
  }

  void setPassword(String password) {
    this.@password = password
  }

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

  void setNewUser(boolean newUser) {
    log.info "We are creating a new user."
    this.newUser = newUser
  }

  public boolean isNewUser() {
    newUser
  }

  /**
   * A stub user is a not yet activated account.
   * @return
   */
  public boolean isStubUser() {
    hasUser() && !isNewUser() && !isActiveAccount()
  }

  public boolean isBrokenStub() {
    isStubUser() && !isValidStub()
  }

  private boolean isValidStub() {
    getUser()?.uid
  }

  private boolean isActiveAccount() {
    this.userVO?.accountIsActive
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
