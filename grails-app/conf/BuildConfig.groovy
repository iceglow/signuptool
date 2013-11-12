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

// Change depending on target container compliance (2.5 or 3.0)
grails.servlet.version = "2.5"
grails.project.work.dir = 'target'
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

    compile "se.su.it.cxf:sukat-cxf-svc-client:1.1.0"
    compile "org.grails:grails-webflow:$grailsVersion"
    compile "se.su.it.commons:su-commons:1.9.2"

    runtime 'mysql:mysql-connector-java:5.1.22'
    runtime 'se.su.it.tomcat:tomcat-header-encoding-valve:2.2'
  }

  plugins {
    test(
        ":code-coverage:1.2.6",
        ":geb:0.9.0"
    )

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

    build(
        "se.su.it.grails.plugins:grails-sonar-pom:0.0.3",
        "se.su.it.grails.plugins:grails-release-helper:0.0.3",
        ":tomcat:$grailsVersion"
    )

    runtime(
        "se.su.it.grails.plugins:grails-input-trimmer:0.1.2",
        "se.su.it.grails.plugins:role-access-manager:0.3.3",
        ":database-migration:1.3.5",
        ":hibernate:$grailsVersion",
        ":jquery:1.8.3",
        ":resources:1.1.6",
        ":su-config:0.6.5",
        ":su-localization-editor:2.0.1"
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
