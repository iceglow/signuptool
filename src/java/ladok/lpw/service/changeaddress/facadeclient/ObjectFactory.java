
package ladok.lpw.service.changeaddress.facadeclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ladok.lpw.service.changeaddress.facadeclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetTelekomResponse_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "setTelekomResponse");
    private final static QName _SetLimitedAddressResponse_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "setLimitedAddressResponse");
    private final static QName _GetUserDataResponse_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "getUserDataResponse");
    private final static QName _SetLimitedAddress_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "setLimitedAddress");
    private final static QName _GetUserData_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "getUserData");
    private final static QName _SetTelekom_QNAME = new QName("http://facadeclient.changeaddress.service.lpw.ladok/", "setTelekom");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ladok.lpw.service.changeaddress.facadeclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketVO }
     * 
     */
    public TicketVO createTicketVO() {
        return new TicketVO();
    }

    /**
     * Create an instance of {@link AuthInfoVO }
     * 
     */
    public AuthInfoVO createAuthInfoVO() {
        return new AuthInfoVO();
    }

    /**
     * Create an instance of {@link SetLimitedAddressResponse }
     * 
     */
    public SetLimitedAddressResponse createSetLimitedAddressResponse() {
        return new SetLimitedAddressResponse();
    }

    /**
     * Create an instance of {@link GetUserData }
     * 
     */
    public GetUserData createGetUserData() {
        return new GetUserData();
    }

    /**
     * Create an instance of {@link SetLimitedAddress }
     * 
     */
    public SetLimitedAddress createSetLimitedAddress() {
        return new SetLimitedAddress();
    }

    /**
     * Create an instance of {@link UserVO }
     * 
     */
    public UserVO createUserVO() {
        return new UserVO();
    }

    /**
     * Create an instance of {@link TelekomVO }
     * 
     */
    public TelekomVO createTelekomVO() {
        return new TelekomVO();
    }

    /**
     * Create an instance of {@link SetTelekomResponse }
     * 
     */
    public SetTelekomResponse createSetTelekomResponse() {
        return new SetTelekomResponse();
    }

    /**
     * Create an instance of {@link ErrorObject }
     * 
     */
    public ErrorObject createErrorObject() {
        return new ErrorObject();
    }

    /**
     * Create an instance of {@link SetTelekom }
     * 
     */
    public SetTelekom createSetTelekom() {
        return new SetTelekom();
    }

    /**
     * Create an instance of {@link GetUserDataResponse }
     * 
     */
    public GetUserDataResponse createGetUserDataResponse() {
        return new GetUserDataResponse();
    }

    /**
     * Create an instance of {@link BksInfoVO }
     * 
     */
    public BksInfoVO createBksInfoVO() {
        return new BksInfoVO();
    }

    /**
     * Create an instance of {@link ChangeAddressVO }
     * 
     */
    public ChangeAddressVO createChangeAddressVO() {
        return new ChangeAddressVO();
    }

    /**
     * Create an instance of {@link AddressVO }
     * 
     */
    public AddressVO createAddressVO() {
        return new AddressVO();
    }

    /**
     * Create an instance of {@link PersonVO }
     * 
     */
    public PersonVO createPersonVO() {
        return new PersonVO();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTelekomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "setTelekomResponse")
    public JAXBElement<SetTelekomResponse> createSetTelekomResponse(SetTelekomResponse value) {
        return new JAXBElement<SetTelekomResponse>(_SetTelekomResponse_QNAME, SetTelekomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLimitedAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "setLimitedAddressResponse")
    public JAXBElement<SetLimitedAddressResponse> createSetLimitedAddressResponse(SetLimitedAddressResponse value) {
        return new JAXBElement<SetLimitedAddressResponse>(_SetLimitedAddressResponse_QNAME, SetLimitedAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "getUserDataResponse")
    public JAXBElement<GetUserDataResponse> createGetUserDataResponse(GetUserDataResponse value) {
        return new JAXBElement<GetUserDataResponse>(_GetUserDataResponse_QNAME, GetUserDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLimitedAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "setLimitedAddress")
    public JAXBElement<SetLimitedAddress> createSetLimitedAddress(SetLimitedAddress value) {
        return new JAXBElement<SetLimitedAddress>(_SetLimitedAddress_QNAME, SetLimitedAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "getUserData")
    public JAXBElement<GetUserData> createGetUserData(GetUserData value) {
        return new JAXBElement<GetUserData>(_GetUserData_QNAME, GetUserData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTelekom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.changeaddress.service.lpw.ladok/", name = "setTelekom")
    public JAXBElement<SetTelekom> createSetTelekom(SetTelekom value) {
        return new JAXBElement<SetTelekom>(_SetTelekom_QNAME, SetTelekom.class, null, value);
    }

}
