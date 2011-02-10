package se.su.it.signuptool

import se.su.it.commons.process.ProcessExecuter
import org.apache.commons.logging.LogFactory

import se.su.it.config.*

class LPWTicketService {

  private static def log = LogFactory.getLog(this)

  private static def configService = new ConfigService()

  static String getTicket() {
    return getTicket(null);
  }

  static String getTicket(uid) {
    def script = configService.getValue("LPW", "ticket_wrapper_script")
    def server = configService.getValue("LPW", "s4u2self_auth_server")
    def command = [
      script,
      "-principal", configService.getValue("LPW", "principal"),
      "-keytab", configService.getValue("LPW", "keytab"),
      "-realm", configService.getValue("LPW", "realm"),
      "-server", server,
      "-impuser", uid,
      "-protocol", configService.getValue("LPW", "protocol")]

    log.debug "*** Exec ticket s4u2self script (${script}) with lpwserver=${server} ***"

    def executer = new ProcessExecuter()
    def process = Runtime.getRuntime().exec((String[]) command)

    def result = ""
    try {
      result = executer.doExec(process);
      log.debug "*** Ticket wrapper script returned ticket=${result} for uid=${uid}"
    } catch (Exception e) {
      log.error(e.toString())
    }
    return result;

  }
}
