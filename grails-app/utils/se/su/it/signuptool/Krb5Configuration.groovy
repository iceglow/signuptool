package se.su.it.signuptool

import java.util.Properties
import se.su.it.config.ConfigService

import javax.security.auth.login.AppConfigurationEntry
import javax.security.auth.login.Configuration
import java.util.Vector
import org.springframework.beans.factory.InitializingBean
import java.util.Map


public class Krb5Configuration extends Configuration {
  def applicationContext
	
  public Krb5Configuration() {
    super()
    applicationContext = org.codehaus.groovy.grails.web.context.ServletContextHolder.servletContext.getAttribute(org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes.APPLICATION_CONTEXT);
  }
	
  public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
    Vector<AppConfigurationEntry> v = new Vector<AppConfigurationEntry>();
		
    def jaasVals = applicationContext.configService.getValues("jaas")

    Map<String, String > m = new HashMap<String, String>();
		
    for (def it : jaasVals) {
      m.put (it.key.toString(), it.value.toString())
    }
		
    def app = new AppConfigurationEntry("com.sun.security.auth.module.Krb5LoginModule",
      AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, m);
      return app
    }
}
