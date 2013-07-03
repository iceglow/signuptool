
import org.grails.plugins.localization.Localization
import org.springframework.core.io.Resource
import se.su.it.grails.plugins.access.AccessRole

class BootStrap {
  def configService

  def grailsApplication
  def accessService

  def init = { servletContext ->
    String sucardsvcurl = ''

    switch (System.getProperty("signuptool", "dev")) {
      case ~/prod(uction)?/:
        sucardsvcurl = "https://sucard-prod-svc.it.su.se/services"
        break
      case "test":
        sucardsvcurl = "https://sucard-test-svc.it.su.se/services"
        break
      case ~/dev(elopment)?/:
      default:
        sucardsvcurl = "https://sucard-test-svc.it.su.se/services"
    }

    //sucardsvc
    configService.registerValueToSection("WS", "CardOrderFacade", "${sucardsvcurl}/CardOrderFacade")
    configService.registerValueToSection("WS", "CardSyncFacade", "${sucardsvcurl}/CardSyncFacade")
    //sucardsvc

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
        def languages = ['sv']
        def locale = "*" // rework this when we get more locales..

        files << [name:"messages.properties", locale:"*"]
        files << [name:"localizations.properties", locale:"*"]
        files << [name:"criteria.properties", locale:"*"]
        for (lang in languages) {
          /** Should do something more automatic here, like check what files we have in the directory and iterate over lang */
          files << [name:"messages_${lang}.properties", locale:"$lang"]
        }

        def counts = [imported: 0, skipped: 0, error: 0]

        for (file in files) {
          Resource res = context.getResource("/WEB-INF/grails-app/i18n/${file?.name}")
          def stream
          if (res?.exists()) {
            stream = res?.getInputStream()
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
          def uri = "urn:mace:swami.se:gmai:su-signuptool:sysadmin:env=dev"
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
  }

  def destroy = {
  }
}
