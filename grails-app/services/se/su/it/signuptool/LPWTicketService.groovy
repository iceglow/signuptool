package se.su.it.signuptool

import org.apache.commons.logging.LogFactory

import org.apache.http.client.methods.HttpGet
import org.apache.http.HttpResponse
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.auth.Credentials;
import java.security.Principal
import org.apache.http.auth.AuthScope
import org.apache.http.client.params.AuthPolicy
import org.apache.http.impl.auth.SPNegoSchemeFactory

import se.su.it.config.*

class LPWTicketService {

  private static def log = LogFactory.getLog(this)

  private static def configService = new ConfigService()

  static String getTicket() {
    return getTicket(null);
  }

  static String getTicket(uid) {
    String result = ""
    try {
      DefaultHttpClient httpClient = new DefaultHttpClient()
      httpClient.getAuthSchemes().register(AuthPolicy.SPNEGO, new SPNegoSchemeFactory())
      Credentials use_jaas_creds = new Credentials() {
        public String getPassword() {
          return null
        }
        public Principal getUserPrincipal() {
          return null
        }
      }
      httpClient.getCredentialsProvider().setCredentials(new AuthScope(null, -1, null),use_jaas_creds)

      HttpGet getRequest = new HttpGet("https://" + configService.getValue("ticket", "server") + "/verifier/getticket?uid=" + uid);
      HttpResponse response = httpClient.execute(getRequest);
      BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
      result = br.readLine();
      httpClient.getConnectionManager().shutdown();
    } catch (Exception e) {
      log.error(e.toString())
      throw new Exception("callGetTicket failed with exception: " + e.message, e)
    }
    return result;

  }
}
