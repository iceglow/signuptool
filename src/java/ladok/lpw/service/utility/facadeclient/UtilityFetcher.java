package ladok.lpw.service.utility.facadeclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2013-06-20T07:56:18.231+02:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", name = "UtilityFetcher")
@XmlSeeAlso({ObjectFactory.class})
public interface UtilityFetcher {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getInstitutionByKod", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetInstitutionByKod")
    @WebMethod
    @ResponseWrapper(localName = "getInstitutionByKodResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetInstitutionByKodResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityInstitutionVO getInstitutionByKod(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getKursByInst", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursByInst")
    @WebMethod
    @ResponseWrapper(localName = "getKursByInstResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursByInstResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityKursProvVO> getKursByInst(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getProvByKurskod", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetProvByKurskod")
    @WebMethod
    @ResponseWrapper(localName = "getProvByKurskodResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetProvByKurskodResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityProvVO getProvByKurskod(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findInstitutionsByBenamn", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByBenamn")
    @WebMethod
    @ResponseWrapper(localName = "findInstitutionsByBenamnResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByBenamnResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityInstitutionVO> findInstitutionsByBenamn(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getNameByPartPnr", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetNameByPartPnr")
    @WebMethod
    @ResponseWrapper(localName = "getNameByPartPnrResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetNameByPartPnrResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityNamnListVO getNameByPartPnr(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UtilityNamnVO arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAllInstitutions", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindAllInstitutions")
    @WebMethod
    @ResponseWrapper(localName = "findAllInstitutionsResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindAllInstitutionsResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityInstitutionVO> findAllInstitutions(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findInstitutionsByDelkod", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByDelkod")
    @WebMethod
    @ResponseWrapper(localName = "findInstitutionsByDelkodResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByDelkodResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityInstitutionVO> findInstitutionsByDelkod(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getKursTillFByKod", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursTillFByKod")
    @WebMethod
    @ResponseWrapper(localName = "getKursTillFByKodResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursTillFByKodResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityKursTillFListVO getKursTillFByKod(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getCurrAndNextSemester", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetCurrAndNextSemester")
    @WebMethod
    @ResponseWrapper(localName = "getCurrAndNextSemesterResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetCurrAndNextSemesterResponse")
    public ladok.lpw.service.utility.facadeclient.UtilitySemesterVO getCurrAndNextSemester(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findNameByPnr", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindNameByPnr")
    @WebMethod
    @ResponseWrapper(localName = "findNameByPnrResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindNameByPnrResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityNamnVO findNameByPnr(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UtilityNamnVO arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findInstitutionsByBenamne", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByBenamne")
    @WebMethod
    @ResponseWrapper(localName = "findInstitutionsByBenamneResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindInstitutionsByBenamneResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityInstitutionVO> findInstitutionsByBenamne(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "fetchAdrInfo", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FetchAdrInfo")
    @WebMethod
    @ResponseWrapper(localName = "fetchAdrInfoResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FetchAdrInfoResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityPersonsVO fetchAdrInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findHsk", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindHsk")
    @WebMethod
    @ResponseWrapper(localName = "findHskResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindHskResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityHskVO> findHsk(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UtilityHskVO arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAllPlaces", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindAllPlaces")
    @WebMethod
    @ResponseWrapper(localName = "findAllPlacesResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.FindAllPlacesResponse")
    public java.util.List<ladok.lpw.service.utility.facadeclient.UtilityOrtVO> findAllPlaces(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getKursByKod", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursByKod")
    @WebMethod
    @ResponseWrapper(localName = "getKursByKodResponse", targetNamespace = "http://facadeclient.utility.service.lpw.ladok/", className = "ladok.lpw.service.utility.facadeclient.GetKursByKodResponse")
    public ladok.lpw.service.utility.facadeclient.UtilityKursVO getKursByKod(
        @WebParam(name = "arg0", targetNamespace = "")
        ladok.lpw.service.utility.facadeclient.UserVO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );
}
