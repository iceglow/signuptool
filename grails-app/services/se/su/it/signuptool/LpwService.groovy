package se.su.it.signuptool

import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressFetcher
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import ladok.lpw.service.registrate.facadeclient.CourseSuggestionVO
import ladok.lpw.service.registrate.facadeclient.RegistrateFetcher
import ladok.lpw.service.utility.facadeclient.UtilityFetcher
import ladok.lpw.service.utility.facadeclient.UtilitySemesterVO

class LpwService {
  UtilityFetcher        utilityFetcherServiceClient
  ChangeAddressFetcher  changeAddressFetcherServiceClient
  RegistrateFetcher     registrateFetcherServiceClient

  def lpwTicketService

  UtilitySemesterVO getCurrentAndNextSemester(uid) throws Exception {
    try {
      ladok.lpw.service.utility.facadeclient.UserVO userVO = new ladok.lpw.service.utility.facadeclient.UserVO(
        uid: uid,
        type: "1",
        authinfovo: new ladok.lpw.service.utility.facadeclient.AuthInfoVO(
          ticket: new ladok.lpw.service.utility.facadeclient.TicketVO(ticket: lpwTicketService.getTicket(uid))),
        personvo: new ladok.lpw.service.utility.facadeclient.PersonVO()
      )
      return utilityFetcherServiceClient.getCurrAndNextSemester(userVO)
    } catch (Exception e) {
      throw new Exception('lpw_connection_failure', e)
    }
  }

  ChangeAddressVO getChangeAddressVO(uid) throws Exception {
    try {
      ladok.lpw.service.changeaddress.facadeclient.UserVO userVO = new ladok.lpw.service.changeaddress.facadeclient.UserVO(
        uid: uid,
        type: "1",
        authinfovo: new ladok.lpw.service.changeaddress.facadeclient.AuthInfoVO(
          ticket: new ladok.lpw.service.changeaddress.facadeclient.TicketVO(ticket: lpwTicketService.getTicket(uid))),
        personvo: new ladok.lpw.service.changeaddress.facadeclient.PersonVO()
      )
      return changeAddressFetcherServiceClient.getUserData(userVO)
    } catch (Exception e) {
      throw new Exception('lpw_connection_failure', e)
    }
  }

  CourseSuggestionVO getCourseRegSuggestions(uid, semester) throws Exception {
    try {
      ladok.lpw.service.registrate.facadeclient.UserVO userVO = new ladok.lpw.service.registrate.facadeclient.UserVO(
        uid: uid,
        type: "1",
        authinfovo: new ladok.lpw.service.registrate.facadeclient.AuthInfoVO(
          ticket: new ladok.lpw.service.registrate.facadeclient.TicketVO(ticket: lpwTicketService.getTicket(uid))),
        personvo: new ladok.lpw.service.registrate.facadeclient.PersonVO()
      )
      return registrateFetcherServiceClient.getCourseRegSuggestions(userVO, semester, false)
    } catch (Exception e) {
      throw new Exception('lpw_connection_failure', e)
    }
  }
}