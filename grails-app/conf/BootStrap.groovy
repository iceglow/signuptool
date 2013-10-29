
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
import se.su.it.signuptool.mock.UseCase

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

      /** Broken paths */
      useCases << new UseCase(
          name: "MISSING_EPPN",
          displayName: "${UseCase.I18N_PREFIX}.missingEppn",
          eppn: null,
          description: "When user is missing the request.eppn attribute.")

      useCases << new UseCase(
          name: "UNKNOWN_SCOPE",
          displayName: "${UseCase.I18N_PREFIX}.unknown",
          eppn: DEFAULT_INVALID_EPPN,
          description: "When the user has an unknown scope (such as blaha.se), ie not studera.nu")

      useCases << new UseCase(
          name: "UNVERIFIED_ACCOUNT",
          displayName: "${UseCase.I18N_PREFIX}.unverifiedAccount",
          eppn: DEFAULT_VALID_EPPN,
          description: "When the user has a studera.nu account (ie scope studera.nu) but does not have a request.norEduPersonNIN set.")

      useCases << new UseCase(
          name: "MULTIPLE_ENTRIES_IN_SUKAT",
          displayName: "${UseCase.I18N_PREFIX}.multipleEntriesInSukat",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'MULTIPLE_ENTRIES_IN_SUKAT',
          description: "When a search in SUKAT yields serveral hits for the given persons norEduPersonNIN (social security number)")

      useCases << new UseCase(
          name: "ERROR_WHEN_ASKING_SUKAT_FOR_USER",
          displayName: "${UseCase.I18N_PREFIX}.errorWhenAskingSukatForUser",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'ERROR_WHEN_ASKING_SUKAT_FOR_USER',
          description: "When SUKAT throws an error when asking for user information. Such as network error, svc error or similar.")

      useCases << new UseCase(
          name: "NEW_USER_NOT_FOUND_IN_LADOK",
          displayName: "${UseCase.I18N_PREFIX}.newUserNotFoundInLADOK",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'NEW_USER_NOT_FOUND_IN_LADOK',
          description: "When the user has no SUKAT account and can't be found in LADOK, this often occurs when a new user has not yet" +
              "been entered into the LADOK database.")

      useCases << new UseCase(
          name: "BROKEN_STUB",
          displayName: "${UseCase.I18N_PREFIX}.brokenStub",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'BROKEN_STUB',
          description: "When a user has a broken stub entry in SUKAT, in this case a stub user without a uid.")

      /** Functional paths */
      useCases << new UseCase(
          name: "HAS_SUKAT_USER",
          displayName: "${UseCase.I18N_PREFIX}.hasSUKATUser",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'HAS_SUKAT_USER',
          description: "When a user has an active account, happy path without account or card creation.")

      useCases << new UseCase(
          name: "NEW_USER_FROM_STUB",
          displayName: "${UseCase.I18N_PREFIX}.newUserFromStub",
          eppn: DEFAULT_VALID_EPPN,
          norEduPersonNIN: 'NEW_USER_FROM_STUB',
          description: "When a user has a stub entry in SUKAT.")

      for (useCase in useCases) {
        useCase.save(failOnError: true)
      }
    }

  }

  def destroy = {
  }
}
