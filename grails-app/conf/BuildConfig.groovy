grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
    // specify dependency exclusions here; for example, uncomment this to disable ehcache:
    // excludes 'ehcache'
  }
  log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  checksums true // Whether to verify checksums on resolve
  legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

  repositories {
    inherits true // Whether to inherit repository definitions from plugins

    grailsPlugins()
    grailsHome()
    grailsCentral()

    mavenLocal()
    mavenCentral()

    mavenRepo "http://maven.it.su.se/it.su.se/maven2/"
    grailsRepo "http://svn.it.su.se/grails-plugins/"
    // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
    //mavenRepo "http://snapshots.repository.codehaus.org"
    //mavenRepo "http://repository.codehaus.org"
    //mavenRepo "http://download.java.net/maven/2/"
    //mavenRepo "http://repository.jboss.com/maven2/"
  }

  dependencies {
    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
    test "org.spockframework:spock-grails-support:0.7-groovy-2.0"

    /** For Geb functional testing */
    test 'org.gebish:geb-spock:0.9.0'
    test "org.seleniumhq.selenium:selenium-support:2.33.0"
    test "org.seleniumhq.selenium:selenium-chrome-driver:2.33.0"

    compile "se.su.it.cxf:sukat-cxf-svc-client:1.0.5.3"
    compile "org.grails:grails-webflow:$grailsVersion"

    runtime 'mysql:mysql-connector-java:5.1.22'
    runtime 'se.su.it.tomcat:tomcat-header-encoding-valve:2.2'
  }

  plugins {
    test ":code-coverage:1.2.6"
    test ":geb:0.9.0"

    test(":spock:0.7") {
      exclude "spock-grails-support"
    }

    compile(
        ":build-test-data:2.0.4",
        ":cache:1.0.1",
        ":criteria:1.6",
        ":cxf-client:1.5.3"
    )
    compile(':webflow:2.0.0') {
      exclude 'grails-webflow'
    }

    build ":tomcat:$grailsVersion"

    runtime(
        ":database-migration:1.3.5",
        ":hibernate:$grailsVersion",
        ":jquery:1.8.3",
        ":resources:1.1.6",
        ":role-access-manager:0.2.6.1",
        ":su-config:0.6.5",
        ":su-localization-editor:2.0.0"
    )
    runtime(':greenmail:1.3.2') {
      excludes "activation"
    }

    // Uncomment these (or add new ones) to enable additional resources capabilities
    //runtime ":zipped-resources:1.0"
    //runtime ":cached-resources:1.0"
    //runtime ":yui-minify-resources:0.1.5"
  }
}