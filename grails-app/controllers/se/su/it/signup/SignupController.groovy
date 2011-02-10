package se.su.it.signup

import javax.servlet.http.Cookie

//URLEncoder.encode("https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=http://marcus.it.su.se/signup/setup")]

class SignupController {

  def index = {
    def link = 'https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=https://sukattool-web1.it.su.se:1043/foo/signup/setup'

    [link: link]
  }

  def idp2domain(String idp) {
    if (idp =~ /studera.nu|antagning.se|umdac.se/) {
      return 'student.su.se'
    } else if (idp =~ /auth-prod-physto-idp/) {
      return 'fysik.su.se'
    }

    return null
  }

  def step_one = {
    def idp = ''//'Shib-Identity-Provider'
    def nin = ''//'Shib-NorEduPerson-NorEduPersonNIN' || "Shib-SocialSecurityNumber"
    def givenName = ''//'Shib-InetOrgPerson-givenName'
    def sn = ''//'Shib-Person-surname'

    if (!idp || !nin || !givenName || !sn) {
      flash.message = 'Något saknas'
      redirect(action: 'index')
      return
    }

    def domain = idp2domain(idp)
    if (!domain) {
      flash.message = 'Otillåten inloggning'
      redirect(action: 'index')
      return
    }

    def affiliation = domain =~ /student.su.se/ ? 'student' : 'employee'
    if (nin.length() == 10) {
      nin = "19${nin}"
    }

    // physto_whitelist ...

    def enrollmentFacade = null
    def accountFacade = null
    def userContactFacade = null

    // reset account only if cookies for password and uid havent been set
    if (!request?.cookies['nin'] || !request?.cookies['session']) { //!defined $q->cookie('session' || $nin ne $q->cookie("nin"))
      def vo = enrollmentFacade?.findEnrolledUserByNIN(nin)
      if (!vo && domain =~ /student.su.se/) {
        vo = enrollmentFacade?.enrollUser(domain, givenName, sn, "other", nin)
      }

      if (!vo?.uid && !vo?.password) {
        flash.error = "Aktiveringen av ditt konto misslyckades."
        // do something
      }

      def isEnabled = accountFacade?.isBasicServicesEnabled(vo.uid)
      accountFacade?.enableBasicServices(vo.uid)
      def mail = null
      if (isEnabled) {
        mail = userContactFacade?.getMail(vo.uid)
      }

      //set name for password_cookie to something other than password, and encode base64
      def password_cookie = new Cookie('session', vo.password.encodeAsBase64())
      def uid_cookie = new Cookie('uid', vo.uid)
      def nin_cookie = new Cookie('nin', nin)

      response.addCookie(password_cookie)
      response.addCookie(uid_cookie)
      response.addCookie(nin_cookie)

      [uid: uid]
    }
  }
}
