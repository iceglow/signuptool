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
    def link = 'https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=https://sukattool-web1.it.su.se:1043/foo/signuptool/setup'

    [link: link, hostname: System.getProperty('signuptool.hostname')]
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

    def attrs = new ShibAttributes() // Initiate with shib data from studera.nu

    // Validates all of the models attributes and renders map of errors if invalid
    if (!attrs.validate()) {
      flash.message = attrs.getErrorMessages()
      redirect(action: 'index')
      return
    }

    // Should we have a physto whitelist?

    // We now have valid shib data, proceed to WS calling...
    def enrollmentFacade = null
    def accountFacade = null
    def userContactFacade = null

    // Reset account only if cookies for password and uid havent been set
    if (!request?.cookies['session'] || request?.cookies['nin'] != attrs.nin) {

      def vo = WsMethodService?.findEnrolledUserByNIN(attrs.nin)
      if (!vo && attrs.domain =~ /student.su.se/) {
        vo = WsMethodService?.enrollUser(attrs.domain, attrs.givenName, attrs.sn, "other", attrs.nin)
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
      def nin_cookie = new Cookie('nin', attrs.nin)

      response.addCookie(password_cookie)
      response.addCookie(uid_cookie)
      response.addCookie(nin_cookie)
    }

    [status: 'success']
  }
}
