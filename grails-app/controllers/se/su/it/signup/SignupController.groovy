package se.su.it.signup

import groovyx.net.http.URIBuilder

class SignupController {

  def configService

  def signup = {
    def link = formatLink()
    return [link: link]
  }


  def formatLink() {
    def shibb = configService.getValue("studera.nu", "url") ?: "Shibboleth.sso/WAYF"
    def link = request.request.requestURL.toString()

    URIBuilder uri = new URIBuilder(link)
    uri.setScheme("https")
    uri.setPath(shibb)
    uri.setQuery([target: link])

    return uri
  }
}
