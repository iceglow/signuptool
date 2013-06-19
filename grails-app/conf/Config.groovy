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

def customConfigurations = ["file:/local/signuptool/conf/SignUpTool.groovy"]

environments {
  development {
     customConfigurations = ["file:/local/signuptool/conf/SignUpTool.groovy", DataSources]
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
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
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
grails.web.disable.multipart=false

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

      info  "grails.app",
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
            "grails.app.conf.se.su.it",

      appenders {
        'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
        appender new DailyRollingFileAppender(
            name: "logFile",
            datePattern: "'.'yyyy-MM-dd",
            fileName: "${System.properties["catalina.home"]}/logs/${appName}-${Environment?.current?.name}.log",
            layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
        )
        appender new SyslogAppender(name: "syslog",
            syslogHost: "127.0.0.1",
            threshold: org.apache.log4j.Level.INFO,
            layout: pattern(conversionPattern: "${appName}: [%t] %-5p %c{2} %x - %m%n")
        )
      }

      root {
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

      info  "grails.app",
            "grails.app.domain",
            "grails.app.controllers",
            "grails.app.services",
            "grails.app.taglib",
            "grails.app.conf",
            "grails.app.filters",

      appenders {
        'null' name: 'stacktrace' // this makes sure we don't get a stacktrace.log
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c{2} %x - %m%n')
      }

      root {
        info 'stdout'
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

cxf {
  client {
    changeAddressFetcherServiceClient {
      wsdl = "https://lpwtest-su.its.uu.se/cxf/ChangeAddressFetcher?wsdl"
      clientInterface = ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
      serviceEndpointAddress = "https://lpwtest-su.its.uu.se/cxf/ChangeAddressFetcher"
      enableDefaultLoggingInterceptors = false
      receiveTimeout = 60000
      connectionTimeout = 30000
      allowChunking = true
    }
    registrateFetcherServiceClient {
      wsdl = "https://lpwtest-su.its.uu.se/cxf/RegistrateFetcher?wsdl"
      clientInterface = ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
      serviceEndpointAddress = "https://lpwtest-su.its.uu.se/cxf/RegistrateFetcher"
      enableDefaultLoggingInterceptors = false
      receiveTimeout = 60000
      connectionTimeout = 30000
      allowChunking = true
    }
    utilityFetcherServiceClient {
      wsdl = "https://lpwtest-su.its.uu.se/cxf/UtilityFetcher?wsdl"
      clientInterface = ladok.lpw.service.utility.facadeclient.UtilityFetcher
      serviceEndpointAddress = "https://lpwtest-su.its.uu.se/cxf/UtilityFetcher"
      enableDefaultLoggingInterceptors = false
      receiveTimeout = 60000
      connectionTimeout = 30000
      allowChunking = true
    }
  }
}

lpwTOTP {
  secret = "mySecretKey"
  slotLen = 3600 * 12
}

access {
  redirect = [controller: 'dashboard']
  unprotected = ['dashboard', 'errorHandler', 'activateAccountAndCard']
  disabledInDynamicAccess = ['dashboard', 'access']
}

