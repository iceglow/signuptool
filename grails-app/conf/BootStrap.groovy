class BootStrap {

  def configService

  def init = { servletContext ->
    // get hostname and inject into system properties
    try {
      def proc = "hostname -f".execute()
      proc.waitFor()
      def hostname = proc.in.text
      System.setProperty("signuptool.hostname", hostname)
      log.info "Setting hostname to ${hostname}"
    } catch (all) {
      System.setProperty("signuptool.hostname", 'unknown')
      log.error "Unable to call 'hostname -f' using 'unknown' instead"
    }

    configService.registerSection("properties")
    configService.registerValueToSection("properties", "javax.security.auth.useSubjectCredsOnly", "false")
    configService.registerValueToSection("properties", "java.security.krb5.kdc", "kerberos.su.se")
    configService.registerValueToSection("properties", "java.security.krb5.realm", "SU.SE")

    configService.registerSection("jaas")
    configService.registerValueToSection("jaas", "client", "TRUE")
    configService.registerValueToSection("jaas", "storeKey", "true")
    configService.registerValueToSection("jaas", "doNotPrompt", "true")
    configService.registerValueToSection("jaas", "useKeyTab", "true")
    configService.registerValueToSection("jaas", "realm", "SU.SE")
    configService.registerValueToSection("jaas", "debug", "false")
    configService.registerValueToSection("jaas", "keyTab", "/etc/krb5.keytab_su-portal-dev")
    configService.registerValueToSection("jaas", "principal", "su-portal-dev@SU.SE")

    java.security.Security.setProperty("login.configuration.provider", "se.su.it.signuptool.Krb5Configuration")

    // Get the properties section and register as system properties
    Properties p = configService.getSectionAsProperties("properties")
    Properties sysprop = System.getProperties()
    for(String key : p.propertyNames()) {
      sysprop.setProperty(key, p.getProperty(key))
    }
    System.setProperties(sysprop)
  }

  def destroy = {
  }
} 
