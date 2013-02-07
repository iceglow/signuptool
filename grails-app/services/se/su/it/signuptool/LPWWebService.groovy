package se.su.it.signuptool

import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import ladok.lpw.service.registrate.facadeclient.CourseSuggestionVO
import ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
import ladok.lpw.service.utility.facadeclient.UtilityFetcher
import ladok.lpw.service.utility.facadeclient.UtilitySemesterVO
import org.apache.cxf.endpoint.Client
import org.apache.cxf.frontend.ClientProxy
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.transport.http.HTTPConduit
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy

class LPWWebService {

  def configService
  def clientMap   = [:]

  //TODO: should this be transactional?? cause this is just wrong...
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

  private RegistrateFetcher getRegistrateFacade() {
    // T30
    return (RegistrateFetcher)getClient(RegistrateFetcher.class, "RegistrateFacadeClient")
  }

  // LPW-WS Methods
  UtilitySemesterVO getCurrentAndNextSemester(uid) throws Exception {
    // T22
    try {
      return getUtilityFacade().getCurrAndNextSemester((ladok.lpw.service.utility.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.utility.facadeclient.UserVO"))
    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'method':'getCurrentAndNextSemester'], e)
      throw new Exception('lpw_connection_failure', e)
    }
  }

  ChangeAddressVO getChangeAddressVO(uid) throws Exception {
    // T24
    try {
      return getChangeAddressFacade().getUserData((ladok.lpw.service.changeaddress.facadeclient.UserVO)getTicketForStudent(uid,"ladok.lpw.service.changeaddress.facadeclient.UserVO"))
    } catch (Exception e) {
      UtilityService.logFailure(log, ['uid':uid, 'method':'getChangeAddressVO'], e)
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

  //Utility Methods

  Object getTicketForStudent(uid, userVOClassName) {
    return LPWLadokVOService.getUserVO(uid,"1",userVOClassName)
  }
}
