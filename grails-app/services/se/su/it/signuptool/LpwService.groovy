package se.su.it.signuptool

import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import ladok.lpw.service.registrate.facadeclient.CourseSuggestionVO
import ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
import ladok.lpw.service.utility.facadeclient.UtilityFetcher
import ladok.lpw.service.utility.facadeclient.UtilitySemesterVO

class LpwService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  UtilityFetcher        utilityFetcherServiceClient
  ChangeAddressFetcher  changeAddressFetcherServiceClient
  RegistrateFetcher     registrateFetcherServiceClient

  def lpwTicketService
  public final String DEFAULT_TYPE = "1"

  UtilitySemesterVO getCurrentAndNextSemester(String uid) throws Exception {
    try {
      def userVO = (ladok.lpw.service.utility.facadeclient.UserVO) getUserVO("utility", uid, DEFAULT_TYPE)
      return utilityFetcherServiceClient.getCurrAndNextSemester(userVO)
    } catch (ex) {
      log.error "Failed when fetching current and next semester for => $uid", ex
      throw new Exception('lpw_connection_failure', ex)
    }
  }

  ChangeAddressVO getChangeAddressVO(String uid) throws Exception {
    try {
      def userVO = (ladok.lpw.service.changeaddress.facadeclient.UserVO) getUserVO("changeaddress", uid, DEFAULT_TYPE)
      return changeAddressFetcherServiceClient.getUserData(userVO)
    } catch (ex) {
      log.error "Failed when fetching change address for => $uid", ex
      throw new Exception('lpw_connection_failure', ex)
    }
  }

  CourseSuggestionVO getCourseRegSuggestions(String uid, String semester) throws Exception {
    try {
      def userVO = (ladok.lpw.service.registrate.facadeclient.UserVO) getUserVO("registrate", uid, DEFAULT_TYPE)
      return registrateFetcherServiceClient.getCourseRegSuggestions(userVO, semester, false)
    } catch (ex) {
      log.error "Failed to fetch course suggestions for => $uid,  semester $semester", ex
      throw new Exception('lpw_connection_failure', ex)
    }
  }

  private getUserVO(String facade, String uid, String type) {

    def userVO = null
    def ticket = null

    try {
      ticket = lpwTicketService.getTicket(uid)
    } catch (ex) {
      log.error "Failed to fetch ticket from the ticket service.", ex
      return null
    }

    if (!ticket) {
      return null
    }

    switch(facade) {
      case "utility":
        def ticketVO = new ladok.lpw.service.utility.facadeclient.TicketVO(ticket: ticket)
        def authInfoVO = new ladok.lpw.service.utility.facadeclient.AuthInfoVO(ticket: ticketVO)
        def personVO = new ladok.lpw.service.utility.facadeclient.PersonVO()

        userVO = new ladok.lpw.service.utility.facadeclient.UserVO(
            uid: uid,
            type: type,
            authinfovo: authInfoVO,
            personvo: personVO)
        break
      case "changeaddress":
        def ticketVO = new ladok.lpw.service.changeaddress.facadeclient.TicketVO(ticket: ticket)
        def authInfoVO = new ladok.lpw.service.changeaddress.facadeclient.AuthInfoVO(ticket: ticketVO)
        def personVO = new ladok.lpw.service.changeaddress.facadeclient.PersonVO()

        userVO = new ladok.lpw.service.changeaddress.facadeclient.UserVO(
            uid: uid,
            type: type,
            authinfovo: authInfoVO,
            personvo: personVO)
        break
      case "registrate":
        def ticketVO = new ladok.lpw.service.registrate.facadeclient.TicketVO(ticket: ticket)
        def authInfoVO = new ladok.lpw.service.registrate.facadeclient.AuthInfoVO(ticket: ticketVO)
        def personVO = new ladok.lpw.service.registrate.facadeclient.PersonVO()

        userVO = new ladok.lpw.service.registrate.facadeclient.UserVO(
            uid: uid,
            type: type,
            authinfovo: authInfoVO,
            personvo: personVO)
        break
      default:
        log.error "facade: $facade is not implemented."
      break
    }
    return userVO
  }
}