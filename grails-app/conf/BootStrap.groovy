
import org.grails.plugins.localization.Localization
import org.springframework.core.io.Resource

class BootStrap {

    def grailsApplication

    def init = { servletContext ->

      def initLocalization = {
        log.info "*** Importing translations from i18n files into the database. ***"
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
                log.error "Failed to import $key from ${file?.name} with locale ${file?.locale}", ex
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
          log.info "Imported: ${counts.imported}, Errors: ${counts.error}, Skipped: ${counts.skipped}"
        }
        log.info "*** Import of translations completed. ***"
      }

      try {
        initLocalization()
      } catch (ex) {
        log.error "Failed to import localizations from i18n files", ex
      }
    }
    def destroy = {
    }
}
