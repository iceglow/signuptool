class BootStrap {

  def configService //Instantiate the su-grails-config

  def init = { servletContext ->



    // Register default values for system properties
    configService.registerSection("properties")
    configService.registerValueToSection("properties", "javax.security.auth.useSubjectCredsOnly", "false")
    configService.registerValueToSection("properties", "java.security.krb5.kdc", "kerberos.su.se")
    configService.registerValueToSection("properties", "java.security.krb5.realm", "SU.SE")

    // Default language
    configService.registerValueToSection("properties", "user.language", "sv")
    configService.registerValueToSection("properties", "user.region", "SE")


    // Get the properties section and register as system properties
    Properties p = configService.getSectionAsProperties("properties")
    Properties sysprop = System.getProperties()
    for(String key : p.propertyNames()) {
      sysprop.setProperty(key, p.getProperty(key))
    }
    System.setProperties(sysprop)

    // JAAS Configuration
    configService.registerSection("jaas")
    configService.registerValueToSection("jaas", "client", "TRUE")
    configService.registerValueToSection("jaas", "storeKey", "true")
    configService.registerValueToSection("jaas", "doNotPrompt", "true")
    configService.registerValueToSection("jaas", "useKeyTab", "true")
    configService.registerValueToSection("jaas", "realm", "SU.SE")
    configService.registerValueToSection("jaas", "debug", "false")

    java.security.Security.setProperty("login.configuration.provider", "se.su.it.sukattool.Krb5Configuration")

    // JAAS Configuration
    configService.registerValueToSection("jaas", "keyTab", "/etc/krb5.keytab_su-portal-dev")
    configService.registerValueToSection("jaas", "principal", "su-portal-dev@SU.SE")

  }
  def destroy = {
  }
} 