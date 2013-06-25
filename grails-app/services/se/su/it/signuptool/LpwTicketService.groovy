package se.su.it.signuptool

import java.security.MessageDigest
import sun.misc.BASE64Encoder

class LpwTicketService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def grailsApplication

  //Below code should be replaced by a SPNEGO call to our ticket service https://lpwticket.it.su.se
  //At this time we were really pressed for time and there was no simple way to implement with httpclient
  //due to lots of old dependencies in this Application that seemed to clash with other classes/jars.
  //We did get the spnego to work but it always broke the negotiation token so we couldnt authenticate :(
  public String getTicket(uid) {
    String ticket = null

    if (uid && (uid.length() > 0)) {
      def key = createKey(uid)
      log.debug("HASHING: " + key)

      ticket = createTicket(key, uid)
    }

    return ticket
  }

  private String createKey(String uid) {
    def slotLen = grailsApplication.config.lpwTOTP.slotLen
    def secret = grailsApplication.config.lpwTOTP.secret
    def timeSlot = (Integer) ((new Date()).getTime()/(1000 * slotLen))

    return uid + ":" + timeSlot + ":" + secret
  }

  private String createTicket(String key, String uid) {
    def md = MessageDigest.getInstance("SHA-256")
    md.reset()

    def keyAsBytes = md.digest(new String(key).getBytes())
    def encoder = new BASE64Encoder()

    return encoder.encode(keyAsBytes) + ":${uid}"
  }
}
