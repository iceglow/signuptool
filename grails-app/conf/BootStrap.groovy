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

    // lpw settings
    def lpwurl
    def sukatsvcurl
    switch (System.getProperty("signuptool", "dev")) {
      case ~/prod(uction)?/:
        lpwurl = "https://lpwprod-su.its.uu.se"
        sukatsvcurl = "https://sukat-svc.it.su.se"
        break
      case "test":
        lpwurl = "https://lpwtest-su.its.uu.se"
        sukatsvcurl = "https://sukat-svc-test.it.su.se"
        break
      case ~/dev(elopment)?/:
      default:
        lpwurl = "http://mittsu-dev-04.dev.it.su.se"
        sukatsvcurl = "https://sukat-svc-test.it.su.se"
    }
    log.info "LPW URL: ${lpwurl}"

    configService.registerValueToSection("WS", "AccountFacade", "${sukatsvcurl}/sukatsvc-ws/services/AccountFacade")
    configService.registerValueToSection("WS", "EnrollmentFacade", "${sukatsvcurl}/sukatsvc-ws/services/EnrollmentFacade")
    configService.registerValueToSection("WS", "UserContactFacade", "${sukatsvcurl}/sukatsvc-ws/services/UserContactFacade")

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
    configService.registerValueToSection("jaas", "keyTab", "/etc/krb5.keytab-su-sukattool")
    configService.registerValueToSection("jaas", "principal", "su-sukattool@SU.SE")

    java.security.Security.setProperty("login.configuration.provider", "se.su.it.signuptool.Krb5Configuration")



    configService.registerSection("WS")
    configService.registerValueToSection("WS", "CertAdminFacadeClient", "${lpwurl}/cxf/CertAdminFetcher")
    configService.registerValueToSection("WS", "ChangeAddressFacadeClient", "${lpwurl}/cxf/ChangeAddressFetcher")
    configService.registerValueToSection("WS", "DegreeAppFacadeClient", "${lpwurl}/cxf/DegreeAppFetcher")
    configService.registerValueToSection("WS", "FORegisterFacadeClient", "${lpwurl}/cxf/FORegisterFetcher")
    configService.registerValueToSection("WS", "FollowDegreeAppFacadeClient", "${lpwurl}/cxf/FollowDegreeAppFetcher")
    configService.registerValueToSection("WS", "NationalCertificateFacadeClient", "${lpwurl}/cxf/NationalCertificateFetcher")
    configService.registerValueToSection("WS", "RegisterFacadeClient", "${lpwurl}/cxf/RegisterFetcher")
    configService.registerValueToSection("WS", "RegistrateFacadeClient", "${lpwurl}/cxf/RegistrateFetcher")
    configService.registerValueToSection("WS", "RegistrationCertificateFacadeClient", "${lpwurl}/cxf/RegistrationCertificateFetcher")
    configService.registerValueToSection("WS", "ResearchCertificateFacadeClient", "${lpwurl}/cxf/ResearchCertificateFetcher")
    configService.registerValueToSection("WS", "SecureCertificateFacadeClient", "${lpwurl}/cxf/SecureCertificateFetcher")
    configService.registerValueToSection("WS", "TentamenFacadeClient", "${lpwurl}/cxf/AnonTentamenFetcher")
    configService.registerValueToSection("WS", "UppfoljFacadeClient", "${lpwurl}/cxf/UppfoljFetcher")
    configService.registerValueToSection("WS", "UtilityFacadeClient", "${lpwurl}/cxf/UtilityFetcher")
    configService.registerValueToSection("WS", "MonitorFacadeClient", "${lpwurl}/cxf/MonitorFetcher")
    configService.registerValueToSection("WS", "ResRappFacadeClient", "${lpwurl}/cxf/ResRappFetcher")

    configService.registerSection("LPW")
    configService.registerValueToSection("LPW", "lpw_socket_timeout", "10000")
    configService.registerValueToSection("LPW", "ticket_wrapper_script", "/local/s4u2self/scripts/s4u2self.pl")
    configService.registerValueToSection("LPW", "s4u2self_auth_server", "auth3.su.se")
    configService.registerValueToSection("LPW", "principal", "su-lpwtool-imp@SU.SE")
    configService.registerValueToSection("LPW", "keytab", "/etc/krb5.keytab_su-lpwtool-imp")
    configService.registerValueToSection("LPW", "realm", "SU.SE")
    configService.registerValueToSection("LPW", "protocol", "host")
    // end of lpw settings

    // Get the properties section and register as system properties
    Properties p = configService.getSectionAsProperties("properties")
    Properties sysprop = System.getProperties()
    for (String key: p.propertyNames()) {
      sysprop.setProperty(key, p.getProperty(key))
    }
    System.setProperties(sysprop)

  }
  def destroy = {
  }
} 
