package se.su.it.signuptool

import org.apache.commons.logging.LogFactory
import se.su.it.config.*
import java.security.MessageDigest
import sun.misc.BASE64Encoder
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class LPWTicketService {
  private static def log = LogFactory.getLog(this)

  private static def configService = new ConfigService()

  static String getTicket() {
    return getTicket(null);
  }
  //Below code should be replaced by a SPNEGO call to our ticket service https://lpwticket.it.su.se
  //At this time we were really pressed for time and there was no simple way to implement with httpclient
  //due to lots of old dependencies in this Application that seemed to clash with other classes/jars.
  //We did get the spnego to work but it always broke the negotiation token so we couldnt authenticate :(
  static String getTicket(uid) {
    def slotLen = ConfigurationHolder.config.lpwTOTP.slotLen
    def secret = ConfigurationHolder.config.lpwTOTP.secret
    def timeSlot = (java.lang.Integer) ((new Date()).getTime()/(1000 * slotLen))
    def key = uid + ":" + timeSlot + ":" + secret
    log.debug("HASHING: " + key)
    def md = MessageDigest.getInstance("SHA-256")
    md.reset()
    def keyAsBytes = md.digest(new java.lang.String(key).getBytes())
    def encoder = new BASE64Encoder()
    return encoder.encode(keyAsBytes) + ":${uid}"
  }
}
