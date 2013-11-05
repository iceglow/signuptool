package se.su.it.signuptool

import se.su.it.signuptool.mock.MockUserVO
import se.su.it.signuptool.mock.UseCase

import java.util.concurrent.atomic.AtomicLong

class MockService {

  AtomicLong ids = new AtomicLong()
  private List<UseCase> useCases = Collections.synchronizedList([])
  public List<UseCase> unmodifiableUseCases

  public List<UseCase> findAllByType(UseCase.Type type) {
    useCases.findAll { it.type == type }
  }

  public UseCase findByType(UseCase.Type type) {
    useCases.find { it.type == type }
  }

  public UseCase get(long id) {
    useCases.find { it.id == id }
  }

  /**
   * @return an unmodifiable list of Use cases
   */
  public List<UseCase> getUseCases() {
    if (!unmodifiableUseCases) {
      unmodifiableUseCases = Collections.unmodifiableList(useCases)
    }
    return unmodifiableUseCases
  }

  private UseCase addUseCase(UseCase useCase) {
    useCase.id = ids.getAndIncrement()
    this.useCases << useCase
    useCase
  }

  /**
   * Creates UseCases & validates them
   */
  public void setupUseCases() {

    final String DEFAULT_VALID_EPPN = "student@studera.nu"
    final String DEFAULT_INVALID_EPPN ="student@skolka.nu"
    /** Bootstrap some use case test data */
    log.info "Adding mock Use Cases"

    // TODO: Write more pathing information.

    /** Happy path */
    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "ACTIVATE_HAPPY_PATH",
            displayName: "${UseCase.I18N_PREFIX}.happyPath",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "ACTIVATE_HAPPY_PATH",
            description: "A successful activation."
    ))

    /** Broken paths */
    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "MISSING_EPPN",
            displayName: "${UseCase.I18N_PREFIX}.missingEppn",
            eppn: null,
            description: "When user is missing the request.eppn attribute.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "UNKNOWN_SCOPE",
            displayName: "${UseCase.I18N_PREFIX}.unknown",
            eppn: DEFAULT_INVALID_EPPN,
            description: "When the user has an unknown scope (such as blaha.se), ie not studera.nu")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "UNVERIFIED_ACCOUNT",
            displayName: "${UseCase.I18N_PREFIX}.unverifiedAccount",
            eppn: DEFAULT_VALID_EPPN,
            description: "When the user has a studera.nu account (ie scope studera.nu) but does not have a request.norEduPersonNIN set.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "MULTIPLE_ENTRIES_IN_SUKAT",
            displayName: "${UseCase.I18N_PREFIX}.multipleEntriesInSukat",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'MULTIPLE_ENTRIES_IN_SUKAT',
            description: "When a search in SUKAT yields serveral hits for the given persons norEduPersonNIN (social security number)")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "ERROR_WHEN_ASKING_SUKAT_FOR_USER",
            displayName: "${UseCase.I18N_PREFIX}.errorWhenAskingSukatForUser",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'ERROR_WHEN_ASKING_SUKAT_FOR_USER',
            description: "When SUKAT throws an error when asking for user information. Such as network error, svc error or similar.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "NEW_USER_NOT_FOUND_IN_LADOK",
            displayName: "${UseCase.I18N_PREFIX}.newUserNotFoundInLADOK",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'NEW_USER_NOT_FOUND_IN_LADOK',
            description: "When the user has no SUKAT account and can't be found in LADOK, this often occurs when a new user has not yet" +
                    "been entered into the LADOK database.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "BROKEN_STUB",
            displayName: "${UseCase.I18N_PREFIX}.brokenStub",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'BROKEN_STUB',
            description: "When a user has a broken stub entry in SUKAT, in this case a stub user without a uid.")
    )

    /** Functional paths */
    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "HAS_SUKAT_USER",
            displayName: "${UseCase.I18N_PREFIX}.hasSUKATUser",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'HAS_SUKAT_USER',
            description: "When a user has an active account, happy path without account or card creation.")
    )

    /**
     * === Service Stub Pathing ===
     * UtilityService:
     *  1. getScopeFromEppn => scope from DEFAULT_VALID_EPPN
     * SukatService:
     *  2. findUsersBySocialSecurityNumber => stub user
     *  5. setMailRoutingAddress => void
     *  6. activateUser => SvcUidPwd(uid & passwd)
     * ActivateAccountAndCardService:
     *  4. fetchLadokData => [tnamn:'tnamn', enamn:'enamn']
     * LadokService:
     *  3. findForwardAddressSuggestionForPnr => tnamn.enamn@student.su.se
     */
    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "NEW_USER_FROM_STUB",
            displayName: "${UseCase.I18N_PREFIX}.newUserFromStub",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'NEW_USER_FROM_STUB',
            description: "When a user has a stub entry in SUKAT.")
    )

    /**
     * === Service Stub Pathing ===
     * UtilityService:
     *  1. getScopeFromEppn => scope from DEFAULT_VALID_EPPN
     * SukatService:
     *  2. findUsersBySocialSecurityNumber => [] (since we do it from scratch)
     *  5. createSuPersonStub => uid
     *  6. setMailRoutingAddress => void
     *  7. activateUser => SvcUidPwd(uid & passwd)
     * ActivateAccountAndCardService:
     *  3. fetchLadokData => [tnamn:'tnamn', enamn:'enamn']
     * LadokService:
     *  4. findForwardAddressSuggestionForPnr => tnamn.enamn@student.su.se
     */
    addUseCase(new UseCase(
            type: UseCase.Type.ACCOUNT,
            name: "NEW_USER_FROM_SCRATCH",
            displayName: "${UseCase.I18N_PREFIX}.newUserFromScratch",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'NEW_USER_FROM_SCRATCH',
            description: "Account creation from scratch.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "NO_VALID_USER",
            eppn:DEFAULT_VALID_EPPN,
            displayName: "${UseCase.I18N_PREFIX}.noValidUser",
            description: "When the user has no user in the current session (illegal state).",
            user: new MockUserVO(uid:null, accountIsActive: true)
    ))

    /**
     * 1. activateAccountAndCardService.getCardOrderStatus => null
     */
    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "FETCHING_CARD_ORDER_STATUS_FAILS",
            displayName: "${UseCase.I18N_PREFIX}.fetchingCardOrderStatusFails",
            eppn:DEFAULT_VALID_EPPN,
            norEduPersonNIN: "FETCHING_CARD_ORDER_STATUS_FAILS",
            description: "When the system is unable to fetch the status of the current users cards and card orders.",
            user: new MockUserVO(uid:"FETCHING_CARD_ORDER_STATUS_FAILS", accountIsActive: true)
    ))

    /**
     * 1. activateAccountAndCardService.getCardOrderStatus => [canOrderCard = false, hasAddress = false]
     */
    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "MISSING_ADDRESS",
            displayName: "${UseCase.I18N_PREFIX}.missingAddress",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "MISSING_ADDRESS",
            description: "When the user is missing a proper address, which is fetched from LADOK.",
            user: new MockUserVO(uid: "MISSING_ADDRESS", accountIsActive: true)
    ))

    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "HAS_ACTIVE_CARDS",
            displayName: "${UseCase.I18N_PREFIX}.hasActiveCards",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "HAS_ACTIVE_CARDS",
            description: "When the user already has an active card",
            user: new MockUserVO(uid: "HAS_ACTIVE_CARDS", accountIsActive: true)
    ))

    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "HAS_CARD_ORDERS",
            displayName: "${UseCase.I18N_PREFIX}.hasCardOrders",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "HAS_CARD_ORDERS",
            description: "When the user already has active card orders in the card order database.",
            user: new MockUserVO(uid: "HAS_CARD_ORDERS", accountIsActive: true)
    ))

    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "CARD_ORDER_FAILS",
            displayName: "${UseCase.I18N_PREFIX}.cardOrderFails",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "CARD_ORDER_FAILS",
            description: "When the actual ordering of the card fails.",
            user: new MockUserVO(uid: "CARD_ORDER_FAILS", accountIsActive: true)
    ))

    addUseCase(new UseCase(
            type: UseCase.Type.CARD,
            name: "CARD_ORDER_SUCCEEDS",
            displayName: "${UseCase.I18N_PREFIX}.cardOrderSucceeds",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "CARD_ORDER_SUCCEEDS",
            description: "A successful uneventful card order.",
            user: new MockUserVO(uid: "CARD_ORDER_SUCCEEDS", accountIsActive: true)
    ))

    /** Password flow use cases */
    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_HAPPY_PATH",
            displayName: "${UseCase.I18N_PREFIX}.passwordHappyPath",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "PASSWORD_HAPPY_PATH",
            description: "A successful password reset.",
            user: new MockUserVO(uid: "PASSWORD_HAPPY_PATH", accountIsActive: true)
    ))

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_MISSING_EPPN",
            displayName: "${UseCase.I18N_PREFIX}.missingEppn",
            eppn: null,
            description: "When user is missing the request.eppn attribute.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_MISSING_EPPN",
            displayName: "${UseCase.I18N_PREFIX}.missingEppn",
            eppn: null,
            description: "When user is missing the request.eppn attribute.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_UNKNOWN_SCOPE",
            displayName: "${UseCase.I18N_PREFIX}.unknown",
            eppn: DEFAULT_INVALID_EPPN,
            description: "When the user has an unknown scope (such as blaha.se), ie not studera.nu")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_UNVERIFIED_ACCOUNT",
            displayName: "${UseCase.I18N_PREFIX}.unverifiedAccount",
            eppn: DEFAULT_VALID_EPPN,
            description: "When the user has a studera.nu account (ie scope studera.nu) but does not have a request.norEduPersonNIN set.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_MULTIPLE_ENTRIES_IN_SUKAT",
            displayName: "${UseCase.I18N_PREFIX}.multipleEntriesInSukat",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'MULTIPLE_ENTRIES_IN_SUKAT',
            description: "When a search in SUKAT yields serveral hits for the given persons norEduPersonNIN (social security number)")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_ERROR_WHEN_ASKING_SUKAT_FOR_USER",
            displayName: "${UseCase.I18N_PREFIX}.errorWhenAskingSukatForUser",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'ERROR_WHEN_ASKING_SUKAT_FOR_USER',
            description: "When SUKAT throws an error when asking for user information. Such as network error, svc error or similar.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_STUB_USER",
            displayName: "${UseCase.I18N_PREFIX}.newUserFromStub",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: 'NEW_USER_FROM_STUB',
            description: "When a user has a stub entry in SUKAT.")
    )

    addUseCase(new UseCase(
            type: UseCase.Type.PASSWORD,
            name: "PASSWORD_ERROR_ON_RESET_PWD",
            displayName: "${UseCase.I18N_PREFIX}.passwordResetError",
            eppn: DEFAULT_VALID_EPPN,
            norEduPersonNIN: "PASSWORD_ERROR_ON_RESET_PWD",
            description: "Exception while resetting password",
            user: new MockUserVO(uid: "PASSWORD_ERROR_ON_RESET_PWD", accountIsActive: true)
    ))

    // Validate the UseCases & throw exception on error
    useCases.each { useCase ->
      if(! useCase.validate()) {
        for (error in useCase.errors.allErrors) {
          log.error("UseCase did not validate: " + error.toString())
        }
        throw new IllegalStateException("UseCase did not validate, ${useCase.errors.errorCount} errors.")
      }
    }


  }
}
