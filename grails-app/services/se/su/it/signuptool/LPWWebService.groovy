package se.su.it.signuptool

import ladok.lpw.service.monitor.facadeclient.MonitorVO
import ladok.lpw.service.anontentamen.facadeclient.TentamenVO
import ladok.lpw.service.register.facadeclient.RegVO
import ladok.lpw.service.degreeapp.facadeclient.ApplicationPremisesVO
import ladok.lpw.service.degreeapp.facadeclient.GetPremisesForApplicationVO
import ladok.lpw.service.followdegreeapp.facadeclient.FollowDegreeAppVO
import ladok.lpw.service.foregister.facadeclient.FoRegisterVO
import ladok.lpw.service.registrationcertificate.facadeclient.RegistrationCertificateVO
import ladok.lpw.service.nationalcertificate.facadeclient.NationalCertificateVO
import ladok.lpw.service.registrate.facadeclient.RegistrateVO
import ladok.lpw.service.certadmin.facadeclient.CertAdminVO
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import ladok.lpw.service.uppfolj.facadeclient.UppfoljVO
import ladok.lpw.service.degreeapp.facadeclient.RequestForUndergraduateDegreeVO
import ladok.lpw.service.securecertificate.facadeclient.SecureCertificateVO
import ladok.lpw.service.registrate.facadeclient.CourseSuggestionVO
import ladok.lpw.service.research.certificate.secure.facadeclient.SecureResearchCertificateVO
import ladok.lpw.service.utility.facadeclient.UtilitySemesterVO
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
import ladok.lpw.service.utility.facadeclient.UtilityFetcher
import ladok.lpw.service.degreeapp.facadeclient.DegreeAppFetcher
import ladok.lpw.service.followdegreeapp.facadeclient.FollowDegreeAppFetcher
import ladok.lpw.service.research.certificate.secure.facadeclient.ResearchCertificateFetcher
import ladok.lpw.service.foregister.facadeclient.FORegisterFetcher
import ladok.lpw.service.securecertificate.facadeclient.SecureCertificateFetcher
import ladok.lpw.service.anontentamen.facadeclient.AnonTentamenFetcher
import ladok.lpw.service.uppfolj.facadeclient.UppfoljFetcher
import ladok.lpw.service.register.facadeclient.RegisterFetcher
import ladok.lpw.service.registrationcertificate.facadeclient.RegistrationCertificateFetcher
import ladok.lpw.service.monitor.facadeclient.MonitorFetcher
import ladok.lpw.service.nationalcertificate.facadeclient.NationalCertificateFetcher
import ladok.lpw.service.certadmin.facadeclient.CertAdminFetcher
import ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
import ladok.lpw.service.resrapp.facadeclient.ResRappFetcher
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.endpoint.Client
import org.apache.cxf.transport.http.HTTPConduit
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy

class LPWWebService {

  def configService
  def UtilityService
  def LPWLadokVOService
  def clientMap   = [:]

  boolean transactional = false

  private Object getClient(Class fetcher, String key)
  {
    def ret
    synchronized (clientMap)
    {
      if(!clientMap.containsKey(key))
      {
        final long startTime = System.nanoTime();
        final long endTime;
        Properties prop = configService.getSectionAsProperties("WS-CXF")
        String url = prop.getProperty(key)
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean()
        factory.setServiceClass(fetcher)
        factory.setAddress(url)
        factory.getInInterceptors().add(new org.apache.cxf.interceptor.LoggingInInterceptor())
        factory.getOutInterceptors().add(new org.apache.cxf.interceptor.LoggingOutInterceptor())
        Object runtimeService = factory.create()
        Client client = ClientProxy.getClient(runtimeService)
        if (client != null)
        {
            HTTPConduit conduit = (HTTPConduit) client.getConduit()
            HTTPClientPolicy policy = new HTTPClientPolicy()
            policy.setConnectionTimeout(configService.getValue("LPW", "lpw_socket_timeout") as Long)
            policy.setReceiveTimeout(configService.getValue("LPW", "lpw_socket_timeout") as Long)

            conduit.setClient(policy)
        }
        clientMap.put(key,runtimeService)
        endTime = System.nanoTime();
        final long duration = endTime - startTime
        log.info "Getting clientproxy time (in sec) of <${key}>: ${duration/1000000000}"
      }
      ret = clientMap.get(key)
    }

    return ret;
  }

  // LPW-Facades

  private RegisterFetcher getRegisterFacade() {
    // T02
     return (RegisterFetcher)getClient(RegisterFetcher.class, "RegisterFacadeClient")
  }

  private UppfoljFetcher getKursFacade() {
    // T05
    return (UppfoljFetcher)getClient(UppfoljFetcher.class, "UppfoljFacadeClient")
  }

  private AnonTentamenFetcher getTentamenFacade() {
    // T10
    return (AnonTentamenFetcher)getClient(AnonTentamenFetcher.class, "TentamenFacadeClient")
  }

  private SecureCertificateFetcher getSecureCertificateFacade() {
    // T12
    return (SecureCertificateFetcher)getClient(SecureCertificateFetcher.class, "SecureCertificateFacadeClient")
  }

  private FORegisterFetcher getFORegisterFacade() {
    // T14
    return (FORegisterFetcher)getClient(FORegisterFetcher.class, "FORegisterFacadeClient")
  }

  private ResearchCertificateFetcher getResearchCertificateFacade() {
    // T16
    return (ResearchCertificateFetcher)getClient(ResearchCertificateFetcher.class, "ResearchCertificateFacadeClient")
  }

  private FollowDegreeAppFetcher getFollowDegreeAppFacade() {
    // T19
    return (FollowDegreeAppFetcher)getClient(FollowDegreeAppFetcher.class, "FollowDegreeAppFacadeClient")
  }

  private DegreeAppFetcher getDegreeAppFacade() {
    // T20
    return (DegreeAppFetcher)getClient(DegreeAppFetcher.class, "DegreeAppFacadeClient")
  }

  private UtilityFetcher getUtilityFacade() {
    // T22
    return (UtilityFetcher)getClient(UtilityFetcher.class, "UtilityFacadeClient")
  }

  private ChangeAddressFetcher getChangeAddressFacade() {
    // T24
    return (ChangeAddressFetcher)getClient(ChangeAddressFetcher.class, "ChangeAddressFacadeClient")
  }

  private ChangeAddressFetcher getSetChangeAddressFacade() {
    // T24
    return (ChangeAddressFetcher)getClient(ChangeAddressFetcher.class, "ChangeAddressFacadeClient")
  }

  private RegistrationCertificateFetcher getRegistrationCertificateFacade() {
    // T25
    return (RegistrationCertificateFetcher)getClient(RegistrationCertificateFetcher.class, "RegistrationCertificateFacadeClient")
  }

  private MonitorFetcher getMonitorFacade() {
    // T26
    return (MonitorFetcher)getClient(MonitorFetcher.class, "MonitorFacadeClient")
  }

  private NationalCertificateFetcher getNationalCertificateFacade() {
    // T27
    return (NationalCertificateFetcher)getClient(NationalCertificateFetcher.class, "NationalCertificateFacadeClient")
  }

  private CertAdminFetcher getCertAdminFacade() {
    // T28
    return (CertAdminFetcher)getClient(CertAdminFetcher.class, "CertAdminFacadeClient")
  }

  private RegistrateFetcher getRegistrateFacade() {
    // T30
    return (RegistrateFetcher)getClient(RegistrateFetcher.class, "RegistrateFacadeClient")
  }

  private ResRappFetcher getResRappFacade() {
    // T06
    return (ResRappFetcher)getClient(ResRappFetcher.class, "ResRappFacadeClient")
  }

  // LPW-WS Methods

  ChangeAddressVO getChangeAddressVO(uid) throws Exception {
    // T24
    try {
      return getChangeAddressFacade().getUserData((ladok.lpw.service.changeaddress.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.changeaddress.facadeclient.UserVO"))
    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'method':'getChangeAddressVO'], e)
      throw new Exception('lpw_connection_failure', e)
    }
  }

  ChangeAddressVO getChangeAddressVOFromSSN(ssn, uid) throws Exception{
    try {

      ladok.lpw.service.changeaddress.facadeclient.UserVO uvo =  (ladok.lpw.service.changeaddress.facadeclient.UserVO)getTicketForEmployee(uid,"ladok.lpw.service.changeaddress.facadeclient.UserVO")
      uvo.getPersonvo().setPnr(ssn)

      return getChangeAddressFacade().getUserData(uvo)
    } catch (Exception e) {
      UtilityService.logFailure(log, ['ssn':ssn, 'uid':uid, 'method':'getChangeAddressVOFromSSN'], e)
      throw new Exception('lpw_connection_failure', e)
    }

  }

  Map setChangeAddressVO(uid, cavo) throws Exception {
    // T24
    try {
      return [taddress: getSetChangeAddressFacade().setLimitedAddress((ladok.lpw.service.changeaddress.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.changeaddress.facadeclient.UserVO"), cavo),
              telekom:  getSetChangeAddressFacade().setTelekom((ladok.lpw.service.changeaddress.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.changeaddress.facadeclient.UserVO"), cavo)]
    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'cavo':cavo, 'method':'setChangeAddressVO'], e)
      throw new Exception('lpw_connection_failure', e)
    }
  }

  CourseSuggestionVO getCourseRegSuggestions(uid, semester) throws Exception {
    // T30
    try {
      // always send false for omreg
      return getRegistrateFacade().getCourseRegSuggestions((ladok.lpw.service.registrate.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.registrate.facadeclient.UserVO"), semester, false)
    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'semester':semester, 'method':'getCourseRegSuggestions'], e)
      throw new Exception('lpw_connection_failure', e)
    }
  }

  RegistrateVO registrate(uid, regVO, ssn) throws Exception {
    // T30
    try {
      return getRegistrateFacade().registrate((ladok.lpw.service.registrate.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.registrate.facadeclient.UserVO"), regVO)

    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'regVO':regVO, 'ssn':ssn, 'method':'registrate'], e)
      throw new Exception('lpw_connection_failure', e)
    }
  }

  //Utility Methods

  Object getTicketForStudent(uid, userVOClassName) {
    return LPWLadokVOService.getUserVO(uid,"1",userVOClassName)
  }

  Object getTicketForEmployee(uid, userVOClassName) {
    return LPWLadokVOService.getUserVO(uid,"2", userVOClassName)
  }

  RegVO getRegVORegister(ssn){
    return LPWLadokVOService.getRegVORegister(ssn)
  }

  RegVO getRegVOResultat(ssn){
    return LPWLadokVOService.getRegVOResultat(ssn)
  }

  RegVO getRegVOAsEmployee(ssn){
    return LPWLadokVOService.getRegVOAsEmployee(ssn)
  }

  FoRegisterVO getFORegisterVO(ssn) {
    return LPWLadokVOService.getFORegisterVO(ssn)
  }

  RegistrateVO getRegistrateVO(ssn) {
    return LPWLadokVOService.getRegistrateVO(ssn)
  }
}
