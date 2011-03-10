package se.su.it.signuptool

import javax.servlet.http.Cookie
import se.su.it.ws.commons.WSLocatorFactory
import se.su.it.sukat.client.CardInfoFacade
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO

class SignupController {

  def UtilityService
  def LPWWebService
  def WsMethodService

  def index = {
  def info = Info.findActiveInfoByLocaleAndSiteKey(params.lang, 'new_account')

    if (info && info.size() > 1) {
      info = info.first()
    }

    //def link = 'https://aktivera-test.su.se/Shibboleth.sso/WAYF/antagning.se/produktion?target=https://aktivera-test.su.se/signup/accountSetup'
    def link = "https://${request.getServerName()}/signup/accountSetup"
    [link: link, info: info]
  }

  def resetaccount = {
    def info = Info.findActiveInfoByLocaleAndSiteKey(params.lang, 'reset_account')

    if (info && info.size() > 1) {
      info = info.first()
    }

    def link = 'https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=https://sukattool-web1.it.su.se:1043/foo/signuptool/setup'
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
      redirect(action: 'index')
      return
    }

    // Reset account only if cookies for password and uid havent been set
    Cookie session_cookie = request.cookies.find{it.name == 'session'}
    Cookie nin_cookie = request.cookies.find{it.name == 'nin'}
    def vo = null
    if (!session_cookie || !nin_cookie || nin_cookie.value != attrs.nin) {

      vo = WsMethodService?.findEnrolledUserByNIN(attrs.nin)
      if (!vo && attrs.domain =~ /student.su.se/) {
        vo = WsMethodService?.enrollUser(attrs.domain, attrs.givenName, attrs.sn, attrs.nin)
      }

      if (!vo?.uid && !vo?.password) {
        flash.error = "Aktiveringen av ditt konto misslyckades."
        // do something
      }

      def isEnabled = WsMethodService?.isBasicServicesEnabled(vo.uid)
      WsMethodService?.enableBasicServices(vo.uid)
      def mail = null
      if (isEnabled) {
        mail = WsMethodService?.getMail(vo.uid)
      }

      //set name for password_cookie to something other than password, and encode base64
      def password_cookie = new Cookie('session', vo.password.encodeAsBase64())
      def uid_cookie = new Cookie('uid', vo.uid)
      def nin2_cookie = new Cookie('nin', attrs.nin)

      response.addCookie(password_cookie)
      response.addCookie(uid_cookie)
      response.addCookie(nin2_cookie)
      //def semester = LPWWebService?.getCurrentAndNextSemester(vo.uid)
      //def coursesugg = LPWWebService?.getCourseRegSuggestions(vo.uid, semester)
      [vo:vo, mail:mail]
    }
    else {
      render("Account already activated")
    }

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
