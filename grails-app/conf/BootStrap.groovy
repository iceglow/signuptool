import se.su.it.signuptool.Info

class BootStrap {

  def configService

  def init = { servletContext ->
    // helper method to strip uid from realm
    String.metaClass.toUid = {-> delegate?.find(~/^(\w+)@.+$/) {string, match -> return match} }

    // get hostname and inject into system properties
    try {
      InetAddress addr = InetAddress.getLocalHost()
      String hostname = addr.getCanonicalHostName()
      System.setProperty("signuptool.hostname", hostname)
      log.info "Setting hostname to ${hostname}"
    } catch (all) {
      System.setProperty("signuptool.hostname", 'unknown')
      log.error "Unable to determine hostname using 'unknown' instead"
    }

    def lpwurl
    def sukatsvcurl
    def aktiverafqdn
    def minastudierfqdn
    switch (System.getProperty("signuptool", "dev")) {
      case ~/prod(uction)?/:
        lpwurl = "https://lpwprod-su.its.uu.se"
        sukatsvcurl = "https://sukat-svc.it.su.se"
        aktiverafqdn = "aktivera.su.se"
        minastudierfqdn = "minastudier.su.se"
        break
      case "test":
        lpwurl = "https://lpwtest-su.its.uu.se"
        sukatsvcurl = "https://sukat-svc-test.it.su.se"
        aktiverafqdn = "aktivera-test.su.se"
        minastudierfqdn = "minastudier-test.su.se"
        break
      case ~/dev(elopment)?/:
      default:
        lpwurl = "https://lpwtest-su.its.uu.se"
        sukatsvcurl = "https://sukat-svc-test.it.su.se"
        aktiverafqdn = "aktivera-test.su.se"
        minastudierfqdn = "minastudier-test.su.se"
    }
    log.info "LPW URL: ${lpwurl}"
    configService.registerSection("WS")
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

    configService.registerSection("WS-CXF")
    configService.registerValueToSection("WS-CXF", "CertAdminFacadeClient", "${lpwurl}/cxf/CertAdminFetcher")
    configService.registerValueToSection("WS-CXF", "ChangeAddressFacadeClient", "${lpwurl}/cxf/ChangeAddressFetcher")
    configService.registerValueToSection("WS-CXF", "DegreeAppFacadeClient", "${lpwurl}/cxf/DegreeAppFetcher")
    configService.registerValueToSection("WS-CXF", "FORegisterFacadeClient", "${lpwurl}/cxf/FORegisterFetcher")
    configService.registerValueToSection("WS-CXF", "FollowDegreeAppFacadeClient", "${lpwurl}/cxf/FollowDegreeAppFetcher")
    configService.registerValueToSection("WS-CXF", "NationalCertificateFacadeClient", "${lpwurl}/cxf/NationalCertificateFetcher")
    configService.registerValueToSection("WS-CXF", "RegisterFacadeClient", "${lpwurl}/cxf/RegisterFetcher")
    configService.registerValueToSection("WS-CXF", "RegistrateFacadeClient", "${lpwurl}/cxf/RegistrateFetcher")
    configService.registerValueToSection("WS-CXF", "RegistrationCertificateFacadeClient", "${lpwurl}/cxf/RegistrationCertificateFetcher")
    configService.registerValueToSection("WS-CXF", "ResearchCertificateFacadeClient", "${lpwurl}/cxf/ResearchCertificateFetcher")
    configService.registerValueToSection("WS-CXF", "SecureCertificateFacadeClient", "${lpwurl}/cxf/SecureCertificateFetcher")
    configService.registerValueToSection("WS-CXF", "TentamenFacadeClient", "${lpwurl}/cxf/AnonTentamenFetcher")
    configService.registerValueToSection("WS-CXF", "UppfoljFacadeClient", "${lpwurl}/cxf/UppfoljFetcher")
    configService.registerValueToSection("WS-CXF", "UtilityFacadeClient", "${lpwurl}/cxf/UtilityFetcher")
    configService.registerValueToSection("WS-CXF", "MonitorFacadeClient", "${lpwurl}/cxf/MonitorFetcher")
    configService.registerValueToSection("WS-CXF", "ResRappFacadeClient", "${lpwurl}/cxf/ResRappFetcher")

    configService.registerSection("LPW")
    configService.registerValueToSection("LPW", "lpw_socket_timeout", "10000")
    configService.registerValueToSection("LPW", "ticket_wrapper_script", "/local/s4u2self/scripts/s4u2self.pl")
    configService.registerValueToSection("LPW", "s4u2self_auth_server", "auth3.su.se")
    configService.registerValueToSection("LPW", "principal", "su-lpwtool-imp@SU.SE")
    configService.registerValueToSection("LPW", "keytab", "/etc/krb5.keytab_su-lpwtool-imp")
    configService.registerValueToSection("LPW", "realm", "SU.SE")
    configService.registerValueToSection("LPW", "protocol", "host")
    // end of lpw settings
    configService.registerSection("spocp")
    configService.registerValueToSection("spocp", "application", "su-signuptool")
    // Get the properties section and register as system properties
    Properties p = configService.getSectionAsProperties("properties")
    Properties sysprop = System.getProperties()
    for (String key: p.propertyNames()) {
      sysprop.setProperty(key, p.getProperty(key))
    }
    System.setProperties(sysprop)

    // Su-FEEDPARSER
    se.su.it.sufeedparser.Feed feed=se.su.it.sufeedparser.Feed.findByIdentifier("FEEDSE")
    if(null==feed) {
        feed=new se.su.it.sufeedparser.Feed(identifier:"FEEDSE",url:"http://dummy.url/feedsv.xml",description:"phoo and millibar")
        feed.save()
    }
    feed=se.su.it.sufeedparser.Feed.findByIdentifier("FEEDEN")
    if(null==feed) {
        feed=new se.su.it.sufeedparser.Feed(identifier:"FEEDEN",url:"http://dummy.url/feeden.xml",description:"phoo and millibar")
        feed.save()
    }

    // Start Set Default Blobs
    def infoSvNa = Info.findInfoByLocaleAndSiteKey('sv_SE', 'new_account')
    if(infoSvNa == null || infoSvNa.size() <= 0) {
      infoSvNa = new se.su.it.signuptool.Info(
        subject:'Default System Swedish New Account View',
        locale: 'sv_SE',
        siteKey: 'new_account',
        active:true,
        body:'''<div class="section">
<h1>Aktivera ditt konto</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
	<img src="/img/card-progress-1of3.gif" alt="Steg 1 av 3" width="100" height="97" border="0" class="image-block-left" title="Steg 1 av 3" />
    <h2>Ny student? Aktivera steg f\u00f6r steg:</h2>
	<p>Som ny student f\u00f6ljer du bara v\u00e5r steg-f\u00f6r-steg-tjolahopp f\u00f6r att aktivera ditt Universitetskonto och f\u00e5 ditt Universitetskort.</p>
	<p><a href="https://''' + aktiverafqdn + '''/signup/accountSetup" class="apps-add-bullet">Steg 1: Logga in med ditt Studera.nu-konto</a></p>
	<div class="clear-float"></div>
</div>

<div class="section mgn-bottom-20">
	<img src="/img/card-progress-3of3.gif" alt="Steg 3 av 3" width="100" height="97" border="0" class="image-block-left" title="Steg 3 av 3" />
	<h2>Redan student? Registrera dig p\u00e5 kurser:</h2>
	<p>Om du redan bla bla beh\u00f6ver du bara registrera dig p\u00e5 de kurser som du \u00c4r antagen till f\u00f6r att allt ska funka finfint.</p>
	<p><a href="https://'''+ minastudierfqdn + '''/registrate/" class="apps-add-bullet">Registrera dig p\u00e5 kurser i Mina studier</a></p>
	<div class="clear-float"></div>
</div>''')
      infoSvNa.save()
    }
    def infoEnNa = Info.findInfoByLocaleAndSiteKey('en_US', 'new_account')
    if(infoEnNa == null || infoEnNa.size() <= 0) {
      infoEnNa = new se.su.it.signuptool.Info(
        subject:'Default System English New Account View',
        locale: 'en_US',
        siteKey: 'new_account',
        active:true,
        body:'''<div class="section">
<h1>This is in English</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
	<img src="/img/card-progress-1of3.gif" alt="Steg 1 av 3" width="100" height="97" border="0" class="image-block-left" title="Steg 1 av 3" />
    <h2>Ny student? Aktivera steg f\u00f6r steg:</h2>
	<p>Som ny student f\u00f6ljer du bara v\u00e5r steg-f\u00f6r-steg-tjolahopp f\u00f6r att aktivera ditt Universitetskonto och f\u00e5 ditt Universitetskort.</p>
	<p><a href="https://''' + aktiverafqdn + '''/signup/accountSetup" class="apps-add-bullet">Steg 1: Logga in med ditt Studera.nu-konto</a></p>
	<div class="clear-float"></div>
</div>

<div class="section mgn-bottom-20">
	<img src="/img/card-progress-3of3.gif" alt="Steg 3 av 3" width="100" height="97" border="0" class="image-block-left" title="Steg 3 av 3" />
	<h2>Redan student? Registrera dig p\u00e5 kurser:</h2>
	<p>Om du redan bla bla beh\u00f6ver du bara registrera dig p\u00e5 de kurser som du \u00c4r antagen till f\u00f6r att allt ska funka finfint.</p>
	<p><a href="https://'''+ minastudierfqdn + '''/registrate/" class="apps-add-bullet">Registrera dig p\u00e5 kurser i Mina studier</a></p>
	<div class="clear-float"></div>
</div>''')
      infoEnNa.save()
    }
    def infoSvRa = Info.findInfoByLocaleAndSiteKey('sv_SE', 'reset_account')
    if(infoSvRa == null || infoSvRa.size() <= 0) {
      infoSvRa = new se.su.it.signuptool.Info(
        subject:'Default System Swedish Reset Account View',
        locale: 'sv_SE',
        siteKey: 'reset_account',
        active:true,
        body:'''<div class="section">
<h1>Har du gl\u00f6mt l\u00f6senordet till ditt Universitetskonto?</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
 <h2>Generera ett nytt l\u00f6senord</h2>
	<p>Ett nytt l\u00f6senord kommer att genereras \u00e5t dig n\u00e4r du klickar p\u00e5 l\u00e4nken och loggar in med ditt Studera.nu-konto (personnummer och l\u00f6senord)</p>
	<p><a href="https://''' + aktiverafqdn + '''/signup/resetconfirm" class="apps-add-bullet">Steg 1: Logga in med ditt Studera.nu-konto</a></p>
	<div class="clear-float"></div>
</div>''')
      infoSvRa.save()
    }
    def infoEnRa = Info.findInfoByLocaleAndSiteKey('en_US', 'reset_account')
    if(infoEnRa == null || infoEnRa.size() <= 0) {
      infoEnRa = new se.su.it.signuptool.Info(
        subject:'Default System English Reset Account View',
        locale: 'en_US',
        siteKey: 'reset_account',
        active:true,
        body:'''<div class="section">
<h1>Have you forgotten your University account password?</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
 <h2>Generate a new password</h2>
	<p>A new password will be generated when you click on this link and log in with your Studera.nu account (personal identity number and password)</p>
	<p><a href="https://''' + aktiverafqdn + '''/signup/resetconfirm" class="apps-add-bullet">Log in with Studera.nu-account</a></p>
	<div class="clear-float"></div>
</div>''')
      infoEnRa.save()
    }
    // End Set Default Blobs
  }
  def destroy = {
  }
} 
