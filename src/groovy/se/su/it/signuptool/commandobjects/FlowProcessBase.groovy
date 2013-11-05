package se.su.it.signuptool.commandobjects

import grails.util.Environment
import grails.validation.Validateable
import groovy.transform.ToString
import groovy.util.logging.Slf4j
import se.su.it.signuptool.mock.UseCase
import se.su.it.svc.SvcSuPersonVO

@Validateable
@ToString(includeNames = true, includeFields = true, excludes = ["password"])
@Slf4j
public class FlowProcessBase {

  protected Long referenceId = null
  protected String eppn
  protected String norEduPersonNIN
  protected String error
  protected String password
  protected boolean newUser = false
  protected boolean verified = false
  protected SvcSuPersonVO userVO

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

  public boolean hasUser() {
    (this.userVO)
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

  public def getUser() {
    return this.userVO
  }

  public void setUser(def user) {
    this.userVO = user
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
