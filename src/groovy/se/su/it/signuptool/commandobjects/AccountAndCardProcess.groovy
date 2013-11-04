package se.su.it.signuptool.commandobjects

import grails.util.Environment
import grails.validation.Validateable
import groovy.transform.ToString
import groovy.util.logging.Slf4j
import org.springframework.web.context.request.RequestContextHolder
import se.su.it.signuptool.ActivateAccountAndCardController
import se.su.it.signuptool.mock.UseCase
import se.su.it.svc.SvcSuPersonVO

@Validateable
@ToString(includeNames = true, includeFields = true, excludes = ["password"])
@Slf4j
public class AccountAndCardProcess {

  private Long referenceId = null
  private String eppn
  private String norEduPersonNIN
  private String error
  private String password
  private boolean newUser = false
  private boolean verified = false
  private boolean hasCompletedCardOrder = false
  private boolean errorWhileOrderingCard = false
  private SvcSuPersonVO userVO
  private int step = ActivateAccountAndCardController.STEP_START

  static constraints = {
    eppn(nullable:false, blank:false)
  }

  Long getReferenceId() {
    return referenceId
  }

  void setReferenceId(Long referenceId) {
    this.referenceId = referenceId
  }

  String getEppn() {
    return eppn
  }

  void setEppn(String eppn) {
    this.eppn = eppn
  }

  String getNorEduPersonNIN() {
    return norEduPersonNIN
  }

  void setNorEduPersonNIN(String norEduPersonNIN) {
    this.norEduPersonNIN = norEduPersonNIN
  }

  void setError(String error) {
    this.error = error
  }

  void setPassword(String password) {
    this.password = password
  }

  boolean getVerified() {
    return verified
  }

  void setVerified(boolean verified) {
    this.verified = verified
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

  public String getError() {
    log.info "Fetching and clearing error"
    String error = this.error
    this.error = null
    return error
  }

  public String getPassword() {
    log.info "Fetching and clearing password"
    String password = this.password
    this.password = null
    return password
  }

  public boolean hasError() {
    (this.@error)
  }

  public boolean hasPassword() {
    (this.@password)
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

  public boolean hasUser() {
    (this.userVO)
  }

  public def getUser() {
    return this.userVO
  }

  public void setUser(def user) {
    this.userVO = user
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

  public void loadUseCase(UseCase useCase) {
    if (Environment.current.name == "mock") {
      this.eppn = useCase.eppn
      this.norEduPersonNIN = useCase.norEduPersonNIN

      if (useCase.user) {
        def user = new SvcSuPersonVO()
        user.uid = useCase.user.uid
        user.accountIsActive = useCase.user.accountIsActive
        this.userVO = user
      }

      log.info "Done loading use case."
    }
  }
}
