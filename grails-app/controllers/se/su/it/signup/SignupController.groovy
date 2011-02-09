package se.su.it.signup

//URLEncoder.encode("https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=http://marcus.it.su.se/signup/setup")]

class SignupController {

  def index = {
    def link = 'https://public.it.secure.su.se/shibboleth/Shibboleth.sso/WAYF/studera.nu/produktion?target=https://sukattool-web1.it.su.se:1043/foo/signup/setup'

    [link: link]
  }

  def setup = {
    def pause = 42
  }
}
