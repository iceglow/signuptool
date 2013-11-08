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
import org.apache.log4j.DailyRollingFileAppender
import org.apache.log4j.net.SyslogAppender

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

def customConfigurations = ["file:/local/signuptool/conf/signuptool.groovy"]

environments {
  development {
    customConfigurations = ["file:/local/signuptool/conf/signuptool.groovy", CustomDataSources]
  }
  test {
    customConfigurations = ["file:/local/signuptool/conf/signuptool.groovy", CustomDataSources]
  }
  mock {
    customConfigurations = ["file:/local/signuptool/conf/signuptool.groovy", CustomDataSources]
  }
}
/** Some custom options */
grails.app.context = '/' // set the base directory to / instead of /signuptool/.
grails.views.javascript.library = "jquery"

grails.config.locations = customConfigurations
grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all: '*/*',
    atom: 'application/atom+xml',
    css: 'text/css',
    csv: 'text/csv',
    form: 'application/x-www-form-urlencoded',
    html: ['text/html', 'application/xhtml+xml'],
    js: 'text/javascript',
    json: ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss: 'application/rss+xml',
    text: 'text/plain',
    xml: ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart = false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
  development {
    grails.logging.jul.usebridge = true
  }
  production {
    grails.logging.jul.usebridge = false
    // TODO: grails.serverURL = "http://www.changeme.com"
  }
}

// log4j configuration

def appName = appName //Grails looses track of the appName property inside the log4j block.

log4j = {
  environments {
    production {
      error "org.codehaus.groovy.grails.web",
          "org.codehaus.groovy.grails.web.servlet",
          "org.codehaus.groovy.grails.web.pages",
          "org.codehaus.groovy.grails.web.sitemesh",
          "org.codehaus.groovy.grails.web.mapping",
          "org.codehaus.groovy.grails.web.mapping.filter",
          "org.codehaus.groovy.grails.commons",
          "org.codehaus.groovy.grails.plugins",
          "org.codehaus.groovy.grails.orm.hibernate",
          "net.sf.ehcache",
          "org.springframework",
          "org.hibernate",
          "org.hibernate.cfg.annotations"

      info "grails.app",
          "grails.app.controllers",
          "grails.app.domain",
          "grails.app.services",
          "grails.app.taglib",
          "grails.app.conf",
          "grails.app.filters",
          "grails.app.controllers.se.su.it",
          "grails.app.domain.se.su.it",
          "grails.app.services.se.su.it",
          "grails.app.taglib.se.su.it",
          "grails.app.conf.se.su.it"

          appenders {
            'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
            appender new DailyRollingFileAppender(
                name: "logFile",
                datePattern: "'.'yyyy-MM-dd",
                fileName: "${System.properties["catalina.home"]}/logs/application.log",
                layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
            )
            appender new SyslogAppender(name: "syslog",
                syslogHost: "127.0.0.1",
                threshold: org.apache.log4j.Level.INFO,
                layout: pattern(conversionPattern: "${appName}: [%t] %-5p %c{2} %x - %m%n")
            )
          }

      root {
        info 'logFile'
        error 'syslog', 'logFile'
        additivity: true
      }
    }

    development {
      error "org.codehaus.groovy.grails.web",
          "org.codehaus.groovy.grails.web.servlet",
          "org.codehaus.groovy.grails.web.pages",
          "org.codehaus.groovy.grails.web.sitemesh",
          "org.codehaus.groovy.grails.web.mapping.filter",
          "org.codehaus.groovy.grails.web.mapping",
          "org.codehaus.groovy.grails.commons",
          "org.codehaus.groovy.grails.plugins",
          "org.codehaus.groovy.grails.orm.hibernate",
          "org.springframework",
          "org.hibernate",
          "net.sf.ehcache"

      info "grails.app",
          "grails.app.domain",
          "grails.app.controllers",
          "grails.app.services",
          "grails.app.taglib",
          "grails.app.conf",
          "grails.app.filters"

      appenders {
        'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
      }

      root {
        info 'stdout'
        additivity: true
      }
    }

    mock {
      error "org.codehaus.groovy.grails.web",
          "org.codehaus.groovy.grails.web.servlet",
          "org.codehaus.groovy.grails.web.pages",
          "org.codehaus.groovy.grails.web.sitemesh",
          "org.codehaus.groovy.grails.web.mapping.filter",
          "org.codehaus.groovy.grails.web.mapping",
          "org.codehaus.groovy.grails.commons",
          "org.codehaus.groovy.grails.plugins",
          "org.codehaus.groovy.grails.orm.hibernate",
          "org.springframework",
          "org.hibernate",
          "net.sf.ehcache"

      info "grails.app",
          "grails.app.domain",
          "grails.app.controllers",
          "grails.app.services",
          "grails.app.taglib",
          "grails.app.conf",
          "grails.app.filters"

      appenders {
        'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
        appender new DailyRollingFileAppender(
            name: "logFile",
            datePattern: "'.'yyyy-MM-dd",
            fileName: "${(System.properties["catalina.home"])?:System.properties["user.dir"]}/logs/application-mock.log",
            layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
        )
      }

      root {
        info 'stdout', 'logFile'
        additivity: true
      }
    }

    test {
      appenders {
        'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
      }
      root {
        // Prettier output from tests with loglevel fatal.
        fatal 'stdout'
      }
    }
  }
}

/**
 * Kerberos config
 */

systemproperties {
  user.language = "sv"
  user.region = "SE"
  javax.security.auth.useSubjectCredsOnly = "false"
  java.security.krb5.conf = "/etc/krb5.conf"
  java.security.krb5.kdc = "kerberos.su.se"
  java.security.krb5.realm = "SU.SE"
  sun.security.spnego.debug = "all"
  debug = "true"
}
/**
 * JAAS config
 */

security {
  jaasloginconfigfile = "/local/signuptool/conf/login.config"
  jaasconfigfile = "/local/signuptool/conf/jaas.config"
}

/**
 * SUKAT-SVC config
 */
sukatsvc {
  cardorderservice = "https://sukat-test-svc.it.su.se/1/CardOrderService"
  accountservice = "https://sukat-test-svc.it.su.se/1/AccountService"
  cardinfoservice = "https://sukat-test-svc.it.su.se/1/CardInfoService"
  statusservice = "https://sukat-test-svc.it.su.se/1/Status"
  webserviceadmin = "https://sukat-test-svc.it.su.se/1/WebServiceAdmin"
}

/**
 * RoleAccessManager config
 */
access {
  env = "dev"
  applicationName = appName
  redirect = [controller: 'dashboard']
  unprotected = ['admin','dashboard', 'errorHandler', 'activateAccountAndCard', 'resetPassword']
  disabledInDynamicAccess = ['dashboard', 'access']
}

