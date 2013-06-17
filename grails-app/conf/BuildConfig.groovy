grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
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

    grailsRepo "http://svn.it.su.se/grails-plugins/"
    mavenRepo "http://maven.it.su.se/it.su.se/maven2"
    // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
    //mavenRepo "http://snapshots.repository.codehaus.org"
    //mavenRepo "http://repository.codehaus.org"
    //mavenRepo "http://download.java.net/maven/2/"
    //mavenRepo "http://repository.jboss.com/maven2/"
  }

  dependencies {
    log "error"
    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
    test "org.spockframework:spock-grails-support:0.7-groovy-2.0"

    compile 'se.su.it.ws.commons:su-ws-commons:1.5'
    compile 'se.su.it.sucard.svc:sucardsvc-client:1.2'
    runtime 'mysql:mysql-connector-java:5.1.22'
    runtime 'se.su.it.tomcat:tomcat-header-encoding-valve:2.2'
    compile "org.grails:grails-webflow:$grailsVersion"
  }

  plugins {
    test ":code-coverage:1.2.6"
    test(":spock:0.7") {
      exclude "spock-grails-support"
    }

    compile ':webflow:2.0.0', {
      exclude 'grails-webflow'
    }
    compile ':build-test-data:2.0.4'
    compile ':cache:1.0.1'
    compile ":criteria:1.6" // Dependency for su-localization-editor plugin search functionality

    build ":tomcat:$grailsVersion"

    compile ':cache:1.0.1'
    compile ":cxf-client:1.5.3"
    runtime ":hibernate:$grailsVersion"
    runtime ":jquery:1.8.3"
    runtime ":resources:1.1.6"
    runtime(':greenmail:1.3.2') { excludes "activation" }
    runtime ":database-migration:1.3.2"
    runtime ":webflow:2.0.8.1"
    runtime ":su-config:0.6.2"
    runtime ":su-localization-editor:2.0.0"

    // Uncomment these (or add new ones) to enable additional resources capabilities
    //runtime ":zipped-resources:1.0"
    //runtime ":cached-resources:1.0"
    //runtime ":yui-minify-resources:0.1.5"
  }
}
