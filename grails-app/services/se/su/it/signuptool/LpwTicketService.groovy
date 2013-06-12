package se.su.it.signuptool

import grails.util.Holders
import org.apache.commons.logging.LogFactory
import java.security.MessageDigest
import sun.misc.BASE64Encoder

class LpwTicketService {
  private static def log = LogFactory.getLog(this)

  //Below code should be replaced by a SPNEGO call to our ticket service https://lpwticket.it.su.se
  //At this time we were really pressed for time and there was no simple way to implement with httpclient
  //due to lots of old dependencies in this Application that seemed to clash with other classes/jars.
  //We did get the spnego to work but it always broke the negotiation token so we couldnt authenticate :(
  public String getTicket(uid) {
    def grailsApplication = Holders.getGrailsApplication()
    def slotLen = grailsApplication.config.lpwTOTP.slotLen
    def secret = grailsApplication.config.lpwTOTP.secret
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