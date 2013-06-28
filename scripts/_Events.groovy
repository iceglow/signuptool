import org.apache.catalina.connector.Connector
import se.su.it.tomcat.valves.HeaderEncodingValve
import grails.util.Environment;

/** Configure AJP */
eventConfigureTomcat = {tomcat ->
  if (Environment?.current == Environment.DEVELOPMENT) {
    def ajpConnector = new Connector("org.apache.coyote.ajp.AjpProtocol")
    ajpConnector.port = 8009
    ajpConnector.protocol = "AJP/1.3"
    ajpConnector.redirectPort = 8443
    ajpConnector.enableLookups = false
    ajpConnector.setProperty("redirectPort", "8443")
    ajpConnector.setProperty("protocol", "AJP/1.3")
    ajpConnector.setProperty("enableLookups", "false")
    ajpConnector.URIEncoding = "UTF-8"
    ajpConnector.setProperty("tomcatAuthentication", "false")
    tomcat.service.addConnector ajpConnector

    HeaderEncodingValve headerEncodingValve = new HeaderEncodingValve()
    headerEncodingValve.setPattern('^.*$')
    tomcat.engine.pipeline.addValve(headerEncodingValve)
  }
}
