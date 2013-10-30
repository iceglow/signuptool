
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

import grails.util.Environment
import org.grails.plugins.localization.Localization
import org.springframework.core.io.Resource
import se.su.it.grails.plugins.access.AccessRole
import se.su.it.signuptool.mock.MockUserVO
import se.su.it.signuptool.mock.UseCase
import se.su.it.svc.SvcSuPersonVO

class BootStrap {
  def configService

  def grailsApplication
  def accessService

  def init = { servletContext ->
    // some urls to other systems
    configService.registerValueToSection("signup", "lpwtool", "https://minastudier.su.se/registrate/")
    configService.registerValueToSection("signup", "sukattool", "https://kontohantering.su.se/")
    // some urls to other systems

    // Get the config systemproperties and register as system properties
    Properties sysprop = System.getProperties()
    Properties systemproperties = grailsApplication.config.systemproperties.toProperties()
    for (String key : systemproperties.propertyNames()) {
      sysprop.setProperty(key, systemproperties.getProperty(key))
    }
    System.setProperties(sysprop)

    // JAAS Configuration
    System.setProperty("java.security.auth.login.config", "=file:" + grailsApplication.config.security.jaasloginconfigfile)

    def initLocalization = {
        log.info "*** Localizations: Importing translations from i18n files into the database."
        def context = grailsApplication.mainContext
        def files = []
        def locale = "*" // rework this when we get more locales..

        files << [name:"messages.properties", locale:"*"]
        files << [name:"localizations.properties", locale:"*"]
        files << [name:"criteria.properties", locale:"*"]

        def counts = [imported: 0, skipped: 0, error: 0]

        for (file in files) {
          Resource res = context.getResource("/WEB-INF/grails-app/i18n/${file?.name}")
          Reader stream
          if (res?.exists()) {
            stream = new BufferedReader(new InputStreamReader(res?.getInputStream()))
          } else {
            stream = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("${System.properties['base.dir']}/grails-app/i18n/${file?.name}"),
                    "UTF-8"
                )
            )
          }

          def props = new Properties()

          props.load(stream)

          for (key in props?.stringPropertyNames()) {
            def loc = Localization.findByCodeAndLocale(key, locale)
            if (!loc) {
              loc = new Localization()
              loc.code = key
              loc.text = props.get(key)
              loc.locale = file?.locale
              try {
                loc.save(failOnError: true)
                counts.imported = counts.imported + 1
              } catch (ex) {
                log.error "*** Localizations: Failed to import $key from ${file?.name} with locale ${file?.locale}", ex
                counts.error = counts.error + 1
              }
            } else {
              counts.skipped = counts.skipped + 1
            }
          }
        }
        // remove our dummy key..
        Localization.findByCodeAndLocale("foo", "foo")?.delete()
        if (counts.imported > 0 || counts.error > 0) {
          log.info "*** Localizations: Imported: ${counts.imported}, Errors: ${counts.error}, Skipped: ${counts.skipped}"
        } else {
          log.info "*** Localizations: No new localizations to import, nothing imported."
        }
        log.info "*** Localizations: Import of translations completed."

    }

    def initRoleAccessManagement = {
      AccessRole.withTransaction { status ->
        try {
          def displayName = "Sysadmin"
          def uri = ""

          switch(Environment.current.name) {
            case Environment.PRODUCTION.name:
              uri = "urn:mace:swami.se:gmai:su-signuptool:sysadmin:env=prod"
              break
            case Environment.DEVELOPMENT.name:
              uri = "urn:mace:swami.se:gmai:su-signuptool:sysadmin:env=dev"
              break
            case Environment.TEST.name:
              uri = "urn:mace:swami.se:gmai:su-signuptool:sysadmin:env=test"
              break
            case "mock":
              uri = "urn:mace:swami.se:gmai:su-signuptool:sysadmin:env=mock"
              break
            default:
              log.error "Unhandled environment $Environment.current with name ${Environment.current.name}"
          }


          def sysadmin = AccessRole.createOrUpdateInstance(displayName, uri)
          accessService.addAccess(sysadmin, 'admin')
          accessService.addAccess(sysadmin, 'access')
        } catch (ex) {
          log.error "Failed to save role ", ex
          status.setRollbackOnly()
        }
      }
    }

    try {
      initLocalization()
    } catch (ex) {
      log.error "*** Localizations: Failed to import localizations from i18n files", ex
    }

    try {
      initRoleAccessManagement()
    } catch (ex) {
      log.error "*** RoleAccessManagment: Failed to create/add access roles.", ex
    }

    if (Environment.current.name == "mock") {

      final String DEFAULT_VALID_EPPN = "student@studera.nu"
      final String DEFAULT_INVALID_EPPN ="student@skolka.nu"
      /** Bootstrap some use case test data */
      log.info "Adding mock Use Cases"

      List useCases = []

      // TODO: Write more pathing information.

      /** Broken paths */
      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "MISSING_EPPN",
          displayName: "${UseCase.I18N_PREFIX}.missingEppn",
          eppn: null,
          description: "When user is missing the request.eppn attribute.")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "UNKNOWN_SCOPE",
          displayName: "${UseCase.I18N_PREFIX}.unknown",
          eppn: DEFAULT_INVALID_EPPN,
          description: "When the user has an unknown scope (such as blaha.se), ie not studera.nu")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "UNVERIFIED_ACCOUNT",
          displayName: "${UseCase.I18N_PREFIX}.unverifiedAccount",
          eppn: DEFAULT_VALID_EPPN,
          description: "When the user has a studera.nu account (ie scope studera.nu) but does not have a request.norEduPersonNIN set.")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "MULTIPLE_ENTRIES_IN_SUKAT",
          displayName: "${UseCase.I18N_PREFIX}.multipleEntriesInSukat",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'MULTIPLE_ENTRIES_IN_SUKAT',
          description: "When a search in SUKAT yields serveral hits for the given persons norEduPersonNIN (social security number)")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "ERROR_WHEN_ASKING_SUKAT_FOR_USER",
          displayName: "${UseCase.I18N_PREFIX}.errorWhenAskingSukatForUser",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'ERROR_WHEN_ASKING_SUKAT_FOR_USER',
          description: "When SUKAT throws an error when asking for user information. Such as network error, svc error or similar.")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "NEW_USER_NOT_FOUND_IN_LADOK",
          displayName: "${UseCase.I18N_PREFIX}.newUserNotFoundInLADOK",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'NEW_USER_NOT_FOUND_IN_LADOK',
          description: "When the user has no SUKAT account and can't be found in LADOK, this often occurs when a new user has not yet" +
              "been entered into the LADOK database.")

      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "BROKEN_STUB",
          displayName: "${UseCase.I18N_PREFIX}.brokenStub",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'BROKEN_STUB',
          description: "When a user has a broken stub entry in SUKAT, in this case a stub user without a uid.")

      /** Functional paths */
      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "HAS_SUKAT_USER",
          displayName: "${UseCase.I18N_PREFIX}.hasSUKATUser",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'HAS_SUKAT_USER',
          description: "When a user has an active account, happy path without account or card creation.")

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
      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "NEW_USER_FROM_STUB",
          displayName: "${UseCase.I18N_PREFIX}.newUserFromStub",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'NEW_USER_FROM_STUB',
          description: "When a user has a stub entry in SUKAT.")

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
      useCases << new UseCase(
          type: UseCase.Type.ACCOUNT,
          name: "NEW_USER_FROM_SCRATCH",
          displayName: "${UseCase.I18N_PREFIX}.newUserFromScratch",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'NEW_USER_FROM_SCRATCH',
          description: "Account creation from scratch.")

      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "NO_VALID_USER",
          eppn:DEFAULT_VALID_EPPN,
          displayName: "${UseCase.I18N_PREFIX}.noValidUser",
          description: "When the user has no user in the current session (illegal state).",
          user: new MockUserVO(uid:null, accountIsActive: true).save()
      )

      /**
       * 1. activateAccountAndCardService.getCardOrderStatus => null
       */
      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "FETCHING_CARD_ORDER_STATUS_FAILS",
          displayName: "${UseCase.I18N_PREFIX}.fetchingCardOrderStatusFails",
          eppn:DEFAULT_VALID_EPPN,
          norEduPersonNIN: "FETCHING_CARD_ORDER_STATUS_FAILS",
          description: "When the system is unable to fetch the status of the current users cards and card orders.",
          user: new MockUserVO(uid:"FETCHING_CARD_ORDER_STATUS_FAILS", accountIsActive: true).save()
      )

      /**
       * 1. activateAccountAndCardService.getCardOrderStatus => [canOrderCard = false, hasAddress = false]
       */
      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "MISSING_ADDRESS",
          displayName: "${UseCase.I18N_PREFIX}.missingAddress",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: "MISSING_ADDRESS",
          description: "When the user is missing a proper address, which is fetched from LADOK.",
          user: new MockUserVO(uid: "MISSING_ADDRESS", accountIsActive: true).save()
      )

      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "HAS_ACTIVE_CARDS",
          displayName: "${UseCase.I18N_PREFIX}.hasActiveCards",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: "HAS_ACTIVE_CARDS",
          description: "When the user already has an active card",
          user: new MockUserVO(uid: "HAS_ACTIVE_CARDS", accountIsActive: true).save()
      )

      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "HAS_CARD_ORDERS",
          displayName: "${UseCase.I18N_PREFIX}.hasCardOrders",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: "HAS_CARD_ORDERS",
          description: "When the user already has active card orders in the card order database.",
          user: new MockUserVO(uid: "HAS_CARD_ORDERS", accountIsActive: true).save()
      )

      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "CARD_ORDER_FAILS",
          displayName: "${UseCase.I18N_PREFIX}.cardOrderFails",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: "CARD_ORDER_FAILS",
          description: "When the actual ordering of the card fails.",
          user: new MockUserVO(uid: "CARD_ORDER_FAILS", accountIsActive: true).save()
      )

      useCases << new UseCase(
          type: UseCase.Type.CARD,
          name: "CARD_ORDER_SUCCEEDS",
          displayName: "${UseCase.I18N_PREFIX}.cardOrderSucceeds",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: "CARD_ORDER_SUCCEEDS",
          description: "A successful uneventful card order.",
          user: new MockUserVO(uid: "CARD_ORDER_SUCCEEDS", accountIsActive: true).save()
      )

      for (useCase in useCases) {
        useCase.save(failOnError: true)
      }
    }

  }

  def destroy = {
  }
}
