package se.su.it.signuptool

import javax.servlet.http.Cookie
import se.su.it.ws.commons.WSLocatorFactory
import se.su.it.sukat.client.CardInfoFacade
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO

class SignupController {

  def UtilityService
  def LPWWebService
  def WsMethodService
  def SignupService

  def index = {
  def info = Info.findActiveInfoByLocaleAndSiteKey(params.lang, 'new_account')

    if (info && info.size() > 1) {
      info = info.first()
    }

    def link = "https://${request.getServerName()}/signup/accountSetup"
    [link: link, info: info]
  }

  def resetaccount = {
    def info = Info.findActiveInfoByLocaleAndSiteKey(params.lang, 'reset_account')

    if (info && info.size() > 1) {
      info = info.first()
    }

    def link = "https://${request.getServerName()}/signup/resetconfirm"
    render(view:"index",model:[link: link, info: info])
  }

  def test = {
    Properties p = new Properties()
    p.setProperty("MailRoutingFacade", "https://sukat-svc-test.it.su.se/sukatsvc-ws/services/MailRoutingFacade")
    p.setProperty("CardInfoFacade", "https://sukat-svc.it.su.se/sukatsvc-ws/services/CardInfoFacade")
    def wsloc = WSLocatorFactory.instance(p)
    CardInfoFacade fac = wsloc.getService(CardInfoFacade.class)
    def crads = fac.getAllCards("rnyberg", true)

    ChangeAddressVO addr = LPWWebService.getChangeAddressVO('marcus')
    render "${crads} och ${addr}"
  }

  def accountSetup = {

    // Initialize model with shib data
    def attrs = new ShibAttributes()
    attrs.setIdp(request?.eppn)
    attrs.setNin(request?.norEduPersonNIN)
    attrs.givenName = request?.givenName
    attrs.sn = request?.sn

    // Validate model and handle map of errors if invalid
    if (!attrs.validate()) {
      log.error("accountSetup: validate() failed for user: ${attrs}, errorMessages=${attrs.errorMessages}")
      redirect(controller: "croak", action: "studeraNuAccountSetupError")
      return
    }

    def res
    try {
      res = SignupService.enableAccount(attrs)
    }
    catch (Exception e) {
      log.error("accountSetup: SignupService.enableAccount() failed for user: ${attrs}")
      redirect(controller: "croak", action: "sukatAccountSetupError")
      return
      // do something
    }

    session.currentVo = res.vo;

    def courseSuggestionList = null
    try {
      def semesterVO = LPWWebService?.getCurrentAndNextSemester(res.vo.uid)
      def courseSuggestionVO = LPWWebService?.getCourseRegSuggestions(res.vo.uid, semesterVO.currentSemester)
      
      courseSuggestionList = courseSuggestionVO?.courseRegSuggestions
      courseSuggestionVO = LPWWebService?.getCourseRegSuggestions(res.vo.uid, semesterVO.nextSemester)
      courseSuggestionList.addAll(courseSuggestionVO?.courseRegSuggestions)
    }
    catch (Exception e) {
      e.printStackTrace()
    }

    [vo:res.vo, mail:res.mail, courseSuggestionList: courseSuggestionList]
  }

  def resetconfirm = {
    // Initialize model with shib data
    def attrs = new ShibAttributes()
    attrs.setIdp(request?.eppn)
    attrs.setNin(request?.norEduPersonNIN)
    attrs.givenName = request?.givenName
    attrs.sn = request?.sn

    // Validate model and handle map of errors if invalid
    if (!attrs.validate()) {
      log.error("accountSetup: validate() failed for user: ${attrs}, errorMessages=${attrs.errorMessages}")
      redirect(controller: "croak", action: "studeraNuResetPasswordError")
      return
    }

    def res
    try {
      res = SignupService.enableAccount(attrs)
    }
    catch (Exception e) {
      log.error("resetconfirm: SignupService.enableAccount() failed for user: ${attrs}")
      redirect(controller: "croak", action: "sukatResetPasswordError")
      return
      // do something
    }

    session.currentVo = res.vo;

    [vo:res.vo, mail:res.mail]
  }

  def print = {

    [vo: session.currentVo]
  }

  def changeLanguage = {
    if (session.locale && session.locale == "sv_SE") {
      session.locale = "en_US"
    } else {
      session.locale = "sv_SE"
    }

    redirect(controller: params.c, action: params.a, params:['lang':session.locale])
  }
}
