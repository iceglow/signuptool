
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ladok.lpw.service.registrate.facadeclient package. 
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

    private final static QName _GetFutureSemesterRegSuggestionsResponse_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getFutureSemesterRegSuggestionsResponse");
    private final static QName _GetCourseRegSuggestionsResponse_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getCourseRegSuggestionsResponse");
    private final static QName _GetCourseRegSuggestions_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getCourseRegSuggestions");
    private final static QName _GetSemesterRegSuggestionsResponse_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getSemesterRegSuggestionsResponse");
    private final static QName _GetFutureCourseRegSuggestions_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getFutureCourseRegSuggestions");
    private final static QName _Registrate_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "registrate");
    private final static QName _GetFutureCourseRegSuggestionsResponse_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getFutureCourseRegSuggestionsResponse");
    private final static QName _GetFutureSemesterRegSuggestions_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getFutureSemesterRegSuggestions");
    private final static QName _GetSemesterRegSuggestions_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "getSemesterRegSuggestions");
    private final static QName _RegistrateResponse_QNAME = new QName("http://facadeclient.registrate.service.lpw.ladok/", "registrateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ladok.lpw.service.registrate.facadeclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorObject }
     * 
     */
    public ErrorObject createErrorObject() {
        return new ErrorObject();
    }

    /**
     * Create an instance of {@link Registrate }
     * 
     */
    public Registrate createRegistrate() {
        return new Registrate();
    }

    /**
     * Create an instance of {@link GetSemesterRegSuggestionsResponse }
     * 
     */
    public GetSemesterRegSuggestionsResponse createGetSemesterRegSuggestionsResponse() {
        return new GetSemesterRegSuggestionsResponse();
    }

    /**
     * Create an instance of {@link GetFutureSemesterRegSuggestionsResponse }
     * 
     */
    public GetFutureSemesterRegSuggestionsResponse createGetFutureSemesterRegSuggestionsResponse() {
        return new GetFutureSemesterRegSuggestionsResponse();
    }

    /**
     * Create an instance of {@link TicketVO }
     * 
     */
    public TicketVO createTicketVO() {
        return new TicketVO();
    }

    /**
     * Create an instance of {@link VillkorVO }
     * 
     */
    public VillkorVO createVillkorVO() {
        return new VillkorVO();
    }

    /**
     * Create an instance of {@link RegistrateVO }
     * 
     */
    public RegistrateVO createRegistrateVO() {
        return new RegistrateVO();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link GetCourseRegSuggestionsResponse }
     * 
     */
    public GetCourseRegSuggestionsResponse createGetCourseRegSuggestionsResponse() {
        return new GetCourseRegSuggestionsResponse();
    }

    /**
     * Create an instance of {@link GetSemesterRegSuggestions }
     * 
     */
    public GetSemesterRegSuggestions createGetSemesterRegSuggestions() {
        return new GetSemesterRegSuggestions();
    }

    /**
     * Create an instance of {@link SemesterSuggestionVO }
     * 
     */
    public SemesterSuggestionVO createSemesterSuggestionVO() {
        return new SemesterSuggestionVO();
    }

    /**
     * Create an instance of {@link GetFutureCourseRegSuggestionsResponse }
     * 
     */
    public GetFutureCourseRegSuggestionsResponse createGetFutureCourseRegSuggestionsResponse() {
        return new GetFutureCourseRegSuggestionsResponse();
    }

    /**
     * Create an instance of {@link GetFutureSemesterRegSuggestions }
     * 
     */
    public GetFutureSemesterRegSuggestions createGetFutureSemesterRegSuggestions() {
        return new GetFutureSemesterRegSuggestions();
    }

    /**
     * Create an instance of {@link BksInfoVO }
     * 
     */
    public BksInfoVO createBksInfoVO() {
        return new BksInfoVO();
    }

    /**
     * Create an instance of {@link RegistrateResponse }
     * 
     */
    public RegistrateResponse createRegistrateResponse() {
        return new RegistrateResponse();
    }

    /**
     * Create an instance of {@link CourseSuggestionVO }
     * 
     */
    public CourseSuggestionVO createCourseSuggestionVO() {
        return new CourseSuggestionVO();
    }

    /**
     * Create an instance of {@link AuthInfoVO }
     * 
     */
    public AuthInfoVO createAuthInfoVO() {
        return new AuthInfoVO();
    }

    /**
     * Create an instance of {@link PersonVO }
     * 
     */
    public PersonVO createPersonVO() {
        return new PersonVO();
    }

    /**
     * Create an instance of {@link UserVO }
     * 
     */
    public UserVO createUserVO() {
        return new UserVO();
    }

    /**
     * Create an instance of {@link SemesterRegistrationVO }
     * 
     */
    public SemesterRegistrationVO createSemesterRegistrationVO() {
        return new SemesterRegistrationVO();
    }

    /**
     * Create an instance of {@link GetFutureCourseRegSuggestions }
     * 
     */
    public GetFutureCourseRegSuggestions createGetFutureCourseRegSuggestions() {
        return new GetFutureCourseRegSuggestions();
    }

    /**
     * Create an instance of {@link GetCourseRegSuggestions }
     * 
     */
    public GetCourseRegSuggestions createGetCourseRegSuggestions() {
        return new GetCourseRegSuggestions();
    }

    /**
     * Create an instance of {@link CourseRegistrationVO }
     * 
     */
    public CourseRegistrationVO createCourseRegistrationVO() {
        return new CourseRegistrationVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureSemesterRegSuggestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getFutureSemesterRegSuggestionsResponse")
    public JAXBElement<GetFutureSemesterRegSuggestionsResponse> createGetFutureSemesterRegSuggestionsResponse(GetFutureSemesterRegSuggestionsResponse value) {
        return new JAXBElement<GetFutureSemesterRegSuggestionsResponse>(_GetFutureSemesterRegSuggestionsResponse_QNAME, GetFutureSemesterRegSuggestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourseRegSuggestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getCourseRegSuggestionsResponse")
    public JAXBElement<GetCourseRegSuggestionsResponse> createGetCourseRegSuggestionsResponse(GetCourseRegSuggestionsResponse value) {
        return new JAXBElement<GetCourseRegSuggestionsResponse>(_GetCourseRegSuggestionsResponse_QNAME, GetCourseRegSuggestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourseRegSuggestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getCourseRegSuggestions")
    public JAXBElement<GetCourseRegSuggestions> createGetCourseRegSuggestions(GetCourseRegSuggestions value) {
        return new JAXBElement<GetCourseRegSuggestions>(_GetCourseRegSuggestions_QNAME, GetCourseRegSuggestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSemesterRegSuggestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getSemesterRegSuggestionsResponse")
    public JAXBElement<GetSemesterRegSuggestionsResponse> createGetSemesterRegSuggestionsResponse(GetSemesterRegSuggestionsResponse value) {
        return new JAXBElement<GetSemesterRegSuggestionsResponse>(_GetSemesterRegSuggestionsResponse_QNAME, GetSemesterRegSuggestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureCourseRegSuggestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getFutureCourseRegSuggestions")
    public JAXBElement<GetFutureCourseRegSuggestions> createGetFutureCourseRegSuggestions(GetFutureCourseRegSuggestions value) {
        return new JAXBElement<GetFutureCourseRegSuggestions>(_GetFutureCourseRegSuggestions_QNAME, GetFutureCourseRegSuggestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registrate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "registrate")
    public JAXBElement<Registrate> createRegistrate(Registrate value) {
        return new JAXBElement<Registrate>(_Registrate_QNAME, Registrate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureCourseRegSuggestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getFutureCourseRegSuggestionsResponse")
    public JAXBElement<GetFutureCourseRegSuggestionsResponse> createGetFutureCourseRegSuggestionsResponse(GetFutureCourseRegSuggestionsResponse value) {
        return new JAXBElement<GetFutureCourseRegSuggestionsResponse>(_GetFutureCourseRegSuggestionsResponse_QNAME, GetFutureCourseRegSuggestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureSemesterRegSuggestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getFutureSemesterRegSuggestions")
    public JAXBElement<GetFutureSemesterRegSuggestions> createGetFutureSemesterRegSuggestions(GetFutureSemesterRegSuggestions value) {
        return new JAXBElement<GetFutureSemesterRegSuggestions>(_GetFutureSemesterRegSuggestions_QNAME, GetFutureSemesterRegSuggestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSemesterRegSuggestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "getSemesterRegSuggestions")
    public JAXBElement<GetSemesterRegSuggestions> createGetSemesterRegSuggestions(GetSemesterRegSuggestions value) {
        return new JAXBElement<GetSemesterRegSuggestions>(_GetSemesterRegSuggestions_QNAME, GetSemesterRegSuggestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.registrate.service.lpw.ladok/", name = "registrateResponse")
    public JAXBElement<RegistrateResponse> createRegistrateResponse(RegistrateResponse value) {
        return new JAXBElement<RegistrateResponse>(_RegistrateResponse_QNAME, RegistrateResponse.class, null, value);
    }

}
