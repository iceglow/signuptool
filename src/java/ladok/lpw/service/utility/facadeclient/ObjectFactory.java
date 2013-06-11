
package ladok.lpw.service.utility.facadeclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ladok.lpw.service.utility.facadeclient package. 
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

    private final static QName _FindNameByPnrResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findNameByPnrResponse");
    private final static QName _FindAllInstitutionsResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findAllInstitutionsResponse");
    private final static QName _GetProvByKurskod_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getProvByKurskod");
    private final static QName _FindHskResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findHskResponse");
    private final static QName _FindHsk_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findHsk");
    private final static QName _GetCurrAndNextSemesterResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getCurrAndNextSemesterResponse");
    private final static QName _GetKursByKod_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursByKod");
    private final static QName _GetInstitutionByKod_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getInstitutionByKod");
    private final static QName _GetKursByInstResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursByInstResponse");
    private final static QName _GetKursByInst_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursByInst");
    private final static QName _GetKursTillFByKodResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursTillFByKodResponse");
    private final static QName _GetNameByPartPnrResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getNameByPartPnrResponse");
    private final static QName _FindInstitutionsByBenamn_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByBenamn");
    private final static QName _FindAllPlaces_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findAllPlaces");
    private final static QName _GetNameByPartPnr_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getNameByPartPnr");
    private final static QName _FetchAdrInfo_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "fetchAdrInfo");
    private final static QName _FetchAdrInfoResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "fetchAdrInfoResponse");
    private final static QName _GetProvByKurskodResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getProvByKurskodResponse");
    private final static QName _FindInstitutionsByBenamne_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByBenamne");
    private final static QName _FindAllInstitutions_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findAllInstitutions");
    private final static QName _FindInstitutionsByBenamneResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByBenamneResponse");
    private final static QName _FindInstitutionsByDelkod_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByDelkod");
    private final static QName _GetInstitutionByKodResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getInstitutionByKodResponse");
    private final static QName _FindInstitutionsByDelkodResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByDelkodResponse");
    private final static QName _FindInstitutionsByBenamnResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findInstitutionsByBenamnResponse");
    private final static QName _FindNameByPnr_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findNameByPnr");
    private final static QName _FindAllPlacesResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "findAllPlacesResponse");
    private final static QName _GetKursTillFByKod_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursTillFByKod");
    private final static QName _GetKursByKodResponse_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getKursByKodResponse");
    private final static QName _GetCurrAndNextSemester_QNAME = new QName("http://facadeclient.utility.service.lpw.ladok/", "getCurrAndNextSemester");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ladok.lpw.service.utility.facadeclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrAndNextSemester }
     * 
     */
    public GetCurrAndNextSemester createGetCurrAndNextSemester() {
        return new GetCurrAndNextSemester();
    }

    /**
     * Create an instance of {@link GetNameByPartPnr }
     * 
     */
    public GetNameByPartPnr createGetNameByPartPnr() {
        return new GetNameByPartPnr();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link UtilityKursTillFListVO }
     * 
     */
    public UtilityKursTillFListVO createUtilityKursTillFListVO() {
        return new UtilityKursTillFListVO();
    }

    /**
     * Create an instance of {@link UtilityPersonsVO }
     * 
     */
    public UtilityPersonsVO createUtilityPersonsVO() {
        return new UtilityPersonsVO();
    }

    /**
     * Create an instance of {@link UtilityNamnVO }
     * 
     */
    public UtilityNamnVO createUtilityNamnVO() {
        return new UtilityNamnVO();
    }

    /**
     * Create an instance of {@link PersonVO }
     * 
     */
    public PersonVO createPersonVO() {
        return new PersonVO();
    }

    /**
     * Create an instance of {@link UtilityOrtVO }
     * 
     */
    public UtilityOrtVO createUtilityOrtVO() {
        return new UtilityOrtVO();
    }

    /**
     * Create an instance of {@link UtilityKursVO }
     * 
     */
    public UtilityKursVO createUtilityKursVO() {
        return new UtilityKursVO();
    }

    /**
     * Create an instance of {@link UserVO }
     * 
     */
    public UserVO createUserVO() {
        return new UserVO();
    }

    /**
     * Create an instance of {@link GetKursByInst }
     * 
     */
    public GetKursByInst createGetKursByInst() {
        return new GetKursByInst();
    }

    /**
     * Create an instance of {@link FindAllInstitutions }
     * 
     */
    public FindAllInstitutions createFindAllInstitutions() {
        return new FindAllInstitutions();
    }

    /**
     * Create an instance of {@link UtilitySemesterVO }
     * 
     */
    public UtilitySemesterVO createUtilitySemesterVO() {
        return new UtilitySemesterVO();
    }

    /**
     * Create an instance of {@link FindInstitutionsByDelkodResponse }
     * 
     */
    public FindInstitutionsByDelkodResponse createFindInstitutionsByDelkodResponse() {
        return new FindInstitutionsByDelkodResponse();
    }

    /**
     * Create an instance of {@link GetInstitutionByKodResponse }
     * 
     */
    public GetInstitutionByKodResponse createGetInstitutionByKodResponse() {
        return new GetInstitutionByKodResponse();
    }

    /**
     * Create an instance of {@link FindHskResponse }
     * 
     */
    public FindHskResponse createFindHskResponse() {
        return new FindHskResponse();
    }

    /**
     * Create an instance of {@link ErrorObject }
     * 
     */
    public ErrorObject createErrorObject() {
        return new ErrorObject();
    }

    /**
     * Create an instance of {@link FindNameByPnr }
     * 
     */
    public FindNameByPnr createFindNameByPnr() {
        return new FindNameByPnr();
    }

    /**
     * Create an instance of {@link GetInstitutionByKod }
     * 
     */
    public GetInstitutionByKod createGetInstitutionByKod() {
        return new GetInstitutionByKod();
    }

    /**
     * Create an instance of {@link UtilityHskVO }
     * 
     */
    public UtilityHskVO createUtilityHskVO() {
        return new UtilityHskVO();
    }

    /**
     * Create an instance of {@link FindHsk }
     * 
     */
    public FindHsk createFindHsk() {
        return new FindHsk();
    }

    /**
     * Create an instance of {@link GetKursByKodResponse }
     * 
     */
    public GetKursByKodResponse createGetKursByKodResponse() {
        return new GetKursByKodResponse();
    }

    /**
     * Create an instance of {@link UtilityInstitutionVO }
     * 
     */
    public UtilityInstitutionVO createUtilityInstitutionVO() {
        return new UtilityInstitutionVO();
    }

    /**
     * Create an instance of {@link GetKursTillFByKodResponse }
     * 
     */
    public GetKursTillFByKodResponse createGetKursTillFByKodResponse() {
        return new GetKursTillFByKodResponse();
    }

    /**
     * Create an instance of {@link BksInfoVO }
     * 
     */
    public BksInfoVO createBksInfoVO() {
        return new BksInfoVO();
    }

    /**
     * Create an instance of {@link GetKursTillFByKod }
     * 
     */
    public GetKursTillFByKod createGetKursTillFByKod() {
        return new GetKursTillFByKod();
    }

    /**
     * Create an instance of {@link ProvVO }
     * 
     */
    public ProvVO createProvVO() {
        return new ProvVO();
    }

    /**
     * Create an instance of {@link GetKursByInstResponse }
     * 
     */
    public GetKursByInstResponse createGetKursByInstResponse() {
        return new GetKursByInstResponse();
    }

    /**
     * Create an instance of {@link TicketVO }
     * 
     */
    public TicketVO createTicketVO() {
        return new TicketVO();
    }

    /**
     * Create an instance of {@link GetCurrAndNextSemesterResponse }
     * 
     */
    public GetCurrAndNextSemesterResponse createGetCurrAndNextSemesterResponse() {
        return new GetCurrAndNextSemesterResponse();
    }

    /**
     * Create an instance of {@link UtilityProvVO }
     * 
     */
    public UtilityProvVO createUtilityProvVO() {
        return new UtilityProvVO();
    }

    /**
     * Create an instance of {@link FindInstitutionsByBenamn }
     * 
     */
    public FindInstitutionsByBenamn createFindInstitutionsByBenamn() {
        return new FindInstitutionsByBenamn();
    }

    /**
     * Create an instance of {@link FindAllPlaces }
     * 
     */
    public FindAllPlaces createFindAllPlaces() {
        return new FindAllPlaces();
    }

    /**
     * Create an instance of {@link UtilityNamnListVO }
     * 
     */
    public UtilityNamnListVO createUtilityNamnListVO() {
        return new UtilityNamnListVO();
    }

    /**
     * Create an instance of {@link FindInstitutionsByBenamnResponse }
     * 
     */
    public FindInstitutionsByBenamnResponse createFindInstitutionsByBenamnResponse() {
        return new FindInstitutionsByBenamnResponse();
    }

    /**
     * Create an instance of {@link GetKursByKod }
     * 
     */
    public GetKursByKod createGetKursByKod() {
        return new GetKursByKod();
    }

    /**
     * Create an instance of {@link FindAllPlacesResponse }
     * 
     */
    public FindAllPlacesResponse createFindAllPlacesResponse() {
        return new FindAllPlacesResponse();
    }

    /**
     * Create an instance of {@link GetNameByPartPnrResponse }
     * 
     */
    public GetNameByPartPnrResponse createGetNameByPartPnrResponse() {
        return new GetNameByPartPnrResponse();
    }

    /**
     * Create an instance of {@link FindInstitutionsByBenamneResponse }
     * 
     */
    public FindInstitutionsByBenamneResponse createFindInstitutionsByBenamneResponse() {
        return new FindInstitutionsByBenamneResponse();
    }

    /**
     * Create an instance of {@link UtilityKursProvVO }
     * 
     */
    public UtilityKursProvVO createUtilityKursProvVO() {
        return new UtilityKursProvVO();
    }

    /**
     * Create an instance of {@link AuthInfoVO }
     * 
     */
    public AuthInfoVO createAuthInfoVO() {
        return new AuthInfoVO();
    }

    /**
     * Create an instance of {@link FindNameByPnrResponse }
     * 
     */
    public FindNameByPnrResponse createFindNameByPnrResponse() {
        return new FindNameByPnrResponse();
    }

    /**
     * Create an instance of {@link FindInstitutionsByDelkod }
     * 
     */
    public FindInstitutionsByDelkod createFindInstitutionsByDelkod() {
        return new FindInstitutionsByDelkod();
    }

    /**
     * Create an instance of {@link FetchAdrInfoResponse }
     * 
     */
    public FetchAdrInfoResponse createFetchAdrInfoResponse() {
        return new FetchAdrInfoResponse();
    }

    /**
     * Create an instance of {@link FindAllInstitutionsResponse }
     * 
     */
    public FindAllInstitutionsResponse createFindAllInstitutionsResponse() {
        return new FindAllInstitutionsResponse();
    }

    /**
     * Create an instance of {@link UtilityKursTillFVO }
     * 
     */
    public UtilityKursTillFVO createUtilityKursTillFVO() {
        return new UtilityKursTillFVO();
    }

    /**
     * Create an instance of {@link GetProvByKurskodResponse }
     * 
     */
    public GetProvByKurskodResponse createGetProvByKurskodResponse() {
        return new GetProvByKurskodResponse();
    }

    /**
     * Create an instance of {@link FetchAdrInfo }
     * 
     */
    public FetchAdrInfo createFetchAdrInfo() {
        return new FetchAdrInfo();
    }

    /**
     * Create an instance of {@link GetProvByKurskod }
     * 
     */
    public GetProvByKurskod createGetProvByKurskod() {
        return new GetProvByKurskod();
    }

    /**
     * Create an instance of {@link FindInstitutionsByBenamne }
     * 
     */
    public FindInstitutionsByBenamne createFindInstitutionsByBenamne() {
        return new FindInstitutionsByBenamne();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNameByPnrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findNameByPnrResponse")
    public JAXBElement<FindNameByPnrResponse> createFindNameByPnrResponse(FindNameByPnrResponse value) {
        return new JAXBElement<FindNameByPnrResponse>(_FindNameByPnrResponse_QNAME, FindNameByPnrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllInstitutionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findAllInstitutionsResponse")
    public JAXBElement<FindAllInstitutionsResponse> createFindAllInstitutionsResponse(FindAllInstitutionsResponse value) {
        return new JAXBElement<FindAllInstitutionsResponse>(_FindAllInstitutionsResponse_QNAME, FindAllInstitutionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProvByKurskod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getProvByKurskod")
    public JAXBElement<GetProvByKurskod> createGetProvByKurskod(GetProvByKurskod value) {
        return new JAXBElement<GetProvByKurskod>(_GetProvByKurskod_QNAME, GetProvByKurskod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findHskResponse")
    public JAXBElement<FindHskResponse> createFindHskResponse(FindHskResponse value) {
        return new JAXBElement<FindHskResponse>(_FindHskResponse_QNAME, FindHskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHsk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findHsk")
    public JAXBElement<FindHsk> createFindHsk(FindHsk value) {
        return new JAXBElement<FindHsk>(_FindHsk_QNAME, FindHsk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrAndNextSemesterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getCurrAndNextSemesterResponse")
    public JAXBElement<GetCurrAndNextSemesterResponse> createGetCurrAndNextSemesterResponse(GetCurrAndNextSemesterResponse value) {
        return new JAXBElement<GetCurrAndNextSemesterResponse>(_GetCurrAndNextSemesterResponse_QNAME, GetCurrAndNextSemesterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursByKod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursByKod")
    public JAXBElement<GetKursByKod> createGetKursByKod(GetKursByKod value) {
        return new JAXBElement<GetKursByKod>(_GetKursByKod_QNAME, GetKursByKod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstitutionByKod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getInstitutionByKod")
    public JAXBElement<GetInstitutionByKod> createGetInstitutionByKod(GetInstitutionByKod value) {
        return new JAXBElement<GetInstitutionByKod>(_GetInstitutionByKod_QNAME, GetInstitutionByKod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursByInstResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursByInstResponse")
    public JAXBElement<GetKursByInstResponse> createGetKursByInstResponse(GetKursByInstResponse value) {
        return new JAXBElement<GetKursByInstResponse>(_GetKursByInstResponse_QNAME, GetKursByInstResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursByInst }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursByInst")
    public JAXBElement<GetKursByInst> createGetKursByInst(GetKursByInst value) {
        return new JAXBElement<GetKursByInst>(_GetKursByInst_QNAME, GetKursByInst.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursTillFByKodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursTillFByKodResponse")
    public JAXBElement<GetKursTillFByKodResponse> createGetKursTillFByKodResponse(GetKursTillFByKodResponse value) {
        return new JAXBElement<GetKursTillFByKodResponse>(_GetKursTillFByKodResponse_QNAME, GetKursTillFByKodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameByPartPnrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getNameByPartPnrResponse")
    public JAXBElement<GetNameByPartPnrResponse> createGetNameByPartPnrResponse(GetNameByPartPnrResponse value) {
        return new JAXBElement<GetNameByPartPnrResponse>(_GetNameByPartPnrResponse_QNAME, GetNameByPartPnrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByBenamn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByBenamn")
    public JAXBElement<FindInstitutionsByBenamn> createFindInstitutionsByBenamn(FindInstitutionsByBenamn value) {
        return new JAXBElement<FindInstitutionsByBenamn>(_FindInstitutionsByBenamn_QNAME, FindInstitutionsByBenamn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPlaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findAllPlaces")
    public JAXBElement<FindAllPlaces> createFindAllPlaces(FindAllPlaces value) {
        return new JAXBElement<FindAllPlaces>(_FindAllPlaces_QNAME, FindAllPlaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameByPartPnr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getNameByPartPnr")
    public JAXBElement<GetNameByPartPnr> createGetNameByPartPnr(GetNameByPartPnr value) {
        return new JAXBElement<GetNameByPartPnr>(_GetNameByPartPnr_QNAME, GetNameByPartPnr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAdrInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "fetchAdrInfo")
    public JAXBElement<FetchAdrInfo> createFetchAdrInfo(FetchAdrInfo value) {
        return new JAXBElement<FetchAdrInfo>(_FetchAdrInfo_QNAME, FetchAdrInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchAdrInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "fetchAdrInfoResponse")
    public JAXBElement<FetchAdrInfoResponse> createFetchAdrInfoResponse(FetchAdrInfoResponse value) {
        return new JAXBElement<FetchAdrInfoResponse>(_FetchAdrInfoResponse_QNAME, FetchAdrInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProvByKurskodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getProvByKurskodResponse")
    public JAXBElement<GetProvByKurskodResponse> createGetProvByKurskodResponse(GetProvByKurskodResponse value) {
        return new JAXBElement<GetProvByKurskodResponse>(_GetProvByKurskodResponse_QNAME, GetProvByKurskodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByBenamne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByBenamne")
    public JAXBElement<FindInstitutionsByBenamne> createFindInstitutionsByBenamne(FindInstitutionsByBenamne value) {
        return new JAXBElement<FindInstitutionsByBenamne>(_FindInstitutionsByBenamne_QNAME, FindInstitutionsByBenamne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllInstitutions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findAllInstitutions")
    public JAXBElement<FindAllInstitutions> createFindAllInstitutions(FindAllInstitutions value) {
        return new JAXBElement<FindAllInstitutions>(_FindAllInstitutions_QNAME, FindAllInstitutions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByBenamneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByBenamneResponse")
    public JAXBElement<FindInstitutionsByBenamneResponse> createFindInstitutionsByBenamneResponse(FindInstitutionsByBenamneResponse value) {
        return new JAXBElement<FindInstitutionsByBenamneResponse>(_FindInstitutionsByBenamneResponse_QNAME, FindInstitutionsByBenamneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByDelkod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByDelkod")
    public JAXBElement<FindInstitutionsByDelkod> createFindInstitutionsByDelkod(FindInstitutionsByDelkod value) {
        return new JAXBElement<FindInstitutionsByDelkod>(_FindInstitutionsByDelkod_QNAME, FindInstitutionsByDelkod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInstitutionByKodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getInstitutionByKodResponse")
    public JAXBElement<GetInstitutionByKodResponse> createGetInstitutionByKodResponse(GetInstitutionByKodResponse value) {
        return new JAXBElement<GetInstitutionByKodResponse>(_GetInstitutionByKodResponse_QNAME, GetInstitutionByKodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByDelkodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByDelkodResponse")
    public JAXBElement<FindInstitutionsByDelkodResponse> createFindInstitutionsByDelkodResponse(FindInstitutionsByDelkodResponse value) {
        return new JAXBElement<FindInstitutionsByDelkodResponse>(_FindInstitutionsByDelkodResponse_QNAME, FindInstitutionsByDelkodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindInstitutionsByBenamnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findInstitutionsByBenamnResponse")
    public JAXBElement<FindInstitutionsByBenamnResponse> createFindInstitutionsByBenamnResponse(FindInstitutionsByBenamnResponse value) {
        return new JAXBElement<FindInstitutionsByBenamnResponse>(_FindInstitutionsByBenamnResponse_QNAME, FindInstitutionsByBenamnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNameByPnr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findNameByPnr")
    public JAXBElement<FindNameByPnr> createFindNameByPnr(FindNameByPnr value) {
        return new JAXBElement<FindNameByPnr>(_FindNameByPnr_QNAME, FindNameByPnr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPlacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "findAllPlacesResponse")
    public JAXBElement<FindAllPlacesResponse> createFindAllPlacesResponse(FindAllPlacesResponse value) {
        return new JAXBElement<FindAllPlacesResponse>(_FindAllPlacesResponse_QNAME, FindAllPlacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursTillFByKod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursTillFByKod")
    public JAXBElement<GetKursTillFByKod> createGetKursTillFByKod(GetKursTillFByKod value) {
        return new JAXBElement<GetKursTillFByKod>(_GetKursTillFByKod_QNAME, GetKursTillFByKod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKursByKodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getKursByKodResponse")
    public JAXBElement<GetKursByKodResponse> createGetKursByKodResponse(GetKursByKodResponse value) {
        return new JAXBElement<GetKursByKodResponse>(_GetKursByKodResponse_QNAME, GetKursByKodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrAndNextSemester }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facadeclient.utility.service.lpw.ladok/", name = "getCurrAndNextSemester")
    public JAXBElement<GetCurrAndNextSemester> createGetCurrAndNextSemester(GetCurrAndNextSemester value) {
        return new JAXBElement<GetCurrAndNextSemester>(_GetCurrAndNextSemester_QNAME, GetCurrAndNextSemester.class, null, value);
    }

}
