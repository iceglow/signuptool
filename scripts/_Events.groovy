import org.apache.catalina.*
import org.apache.catalina.connector.*

eventConfigureTomcat = {tomcat ->
println "### Starting load of custom application"

def ajpConnector = new Connector("org.apache.jk.server.JkCoyoteHandler")
ajpConnector.port = 8009
ajpConnector.URIEncoding = "UTF-8"
ajpConnector.setProperty("redirectPort", "8443")
ajpConnector.setProperty("protocol", "AJP/1.3")
ajpConnector.setProperty("enableLookups", "false")
ajpConnector.setProperty("tomcatAuthentication", "false")
tomcat.service.addConnector ajpConnector

println "### Ending load of custom application"
}