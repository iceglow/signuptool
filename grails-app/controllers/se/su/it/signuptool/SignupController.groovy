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
      flash.message = attrs.getErrorMessages()
      redirect(controller: "signup", action: "error")
      return
    }

    def res
    try {
      res = SignupService.enableAccount(attrs)
    }
    catch (Exception e) {
      flash.error = e.message
      redirect(controller: "signup", action: "error")
      return
      // do something
    }

    session.currentVo = res.vo;

    //def semester = LPWWebService?.getCurrentAndNextSemester(vo.uid)
    //def coursesugg = LPWWebService?.getCourseRegSuggestions(vo.uid, semester)
    [vo:res.vo, mail:res.mail]
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
      flash.message = attrs.getErrorMessages()
      redirect(controller: "signup", action: "error")
      return
    }

    def res
    try {
      res = SignupService.enableAccount(attrs)
    }
    catch (Exception e) {
      flash.error = e.message
      redirect(controller: "signup", action: "error")
      return
      // do something
    }

    session.currentVo = res.vo;

    //def semester = LPWWebService?.getCurrentAndNextSemester(vo.uid)
    //def coursesugg = LPWWebService?.getCourseRegSuggestions(vo.uid, semester)
    [vo:res.vo, mail:res.mail]
  }

  def print = {

    [vo: session.currentVo]
  }

  def error = {
    render("Something did not work out!!!")
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
