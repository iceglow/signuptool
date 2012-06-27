grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
    // uncomment to disable ehcache
    // excludes 'ehcache'
  }
  log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  repositories {
    grailsPlugins()
    grailsHome()

    grailsRepo "http://svn.codehaus.org/grails-plugins/"

    // Our own plugins hosted in a svn repository
    grailsRepo "http://svn.it.su.se/grails-plugins/trunk/"

    // uncomment the below to enable remote dependency resolution
    // from public Maven repositories
    //mavenLocal()
    mavenCentral()
    //mavenRepo "http://snapshots.repository.codehaus.org"
    mavenRepo "http://repository.codehaus.org"
    mavenRepo "http://download.java.net/maven/2/"
    //mavenRepo "http://repository.jboss.com/maven2/"
    mavenRepo "http://maven.it.su.se/it.su.se/maven2/"
    mavenRepo "http://repo2.maven.org/maven2/"
    mavenRepo "http://bleu.west.spy.net/~dustin/m2repo/"
  }
  dependencies {
    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
    compile 'se.su.it.ws.commons:su-ws-commons:1.5'
    compile 'se.su.it.sukat.svc:sukatsvc-client:2.3'
    compile 'se.su.it.sucard.svc:sucardsvc-client:1.2'
    compile 'se.su.it.lpw:su-lpw-client:2011-01-20'
    compile 'se.su.it.tickethandler:su-lpw-tickethandler:1.0'
    compile 'javax.mail:mail:1.4'
    compile 'commons-logging:commons-logging:1.1.1'

    runtime 'mysql:mysql-connector-java:5.1.7'

  }
}
