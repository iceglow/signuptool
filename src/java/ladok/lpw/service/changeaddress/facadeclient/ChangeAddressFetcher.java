package ladok.lpw.service.changeaddress.facadeclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-06-20T07:56:16.806+02:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "ChangeAddressFetcher")
@XmlSeeAlso({ObjectFactory.class})
public interface ChangeAddressFetcher {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getUserData", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.GetUserData")
    @WebMethod
    @ResponseWrapper(localName = "getUserDataResponse", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.GetUserDataResponse")
    public ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO getUserData(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.changeaddress.facadeclient.UserVO arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "setTelekom", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.SetTelekom")
    @WebMethod
    @ResponseWrapper(localName = "setTelekomResponse", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.SetTelekomResponse")
    public ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO setTelekom(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.changeaddress.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "setLimitedAddress", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.SetLimitedAddress")
    @WebMethod
    @ResponseWrapper(localName = "setLimitedAddressResponse", targetNamespace = "http://facadeclient.changeaddress.service.lpw.ladok/", className = "ladok.lpw.service.changeaddress.facadeclient.SetLimitedAddressResponse")
    public ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO setLimitedAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.changeaddress.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO arg1
    );
}
