package ladok.lpw.service.registrate.facadeclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-06-20T07:56:17.385+02:00
 * Generated source version: 2.6.2
 * 
 */
@WebServiceClient(name = "RegistrateFacadeClientService", 
                  wsdlLocation = "https://lpwtest-su.its.uu.se/cxf/RegistrateFetcher?wsdl",
                  targetNamespace = "http://facadeclient.registrate.service.lpw.ladok/") 
public class RegistrateFacadeClientService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://facadeclient.registrate.service.lpw.ladok/", "RegistrateFacadeClientService");
    public final static QName RegistrateFacadeClientPort = new QName("http://facadeclient.registrate.service.lpw.ladok/", "RegistrateFacadeClientPort");
    static {
        URL url = null;
        try {
            url = new URL("https://lpwtest-su.its.uu.se/cxf/RegistrateFetcher?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RegistrateFacadeClientService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "https://lpwtest-su.its.uu.se/cxf/RegistrateFetcher?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RegistrateFacadeClientService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RegistrateFacadeClientService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RegistrateFacadeClientService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RegistrateFacadeClientService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RegistrateFacadeClientService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RegistrateFacadeClientService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns RegistrateFetcher
     */
    @WebEndpoint(name = "RegistrateFacadeClientPort")
    public RegistrateFetcher getRegistrateFacadeClientPort() {
        return super.getPort(RegistrateFacadeClientPort, RegistrateFetcher.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RegistrateFetcher
     */
    @WebEndpoint(name = "RegistrateFacadeClientPort")
    public RegistrateFetcher getRegistrateFacadeClientPort(WebServiceFeature... features) {
        return super.getPort(RegistrateFacadeClientPort, RegistrateFetcher.class, features);
    }

}
