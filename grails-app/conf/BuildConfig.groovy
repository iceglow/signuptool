grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits( "global" ) {
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
      build ('org.codehaus.groovy.modules.http-builder:http-builder:0.5.0'){
        excludes "junit", "xml-apis", "xercesImpl"
      }

      runtime ('xerces:xercesImpl:2.8.1'){
        excludes "xml-apis"
      }
      runtime ('net.sourceforge.nekohtml:nekohtml:1.9.9'){
        excludes "xercesImpl"
      }
        // runtime 'mysql:mysql-connector-java:5.1.5'

    }

}
