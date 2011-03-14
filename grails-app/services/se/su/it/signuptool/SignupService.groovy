package se.su.it.signuptool

class SignupService {

  def WsMethodService

  static transactional = false

  Map enableAccount(ShibAttributes attrs) throws Exception {
    def vo = null

    vo = WsMethodService?.findEnrolledUserByNIN(attrs.nin)
    if (!vo && attrs.domain =~ /student.su.se/) {
      vo = WsMethodService?.enrollUser(attrs.domain, attrs.givenName, attrs.sn, attrs.nin)
    }

    if (!vo?.uid && !vo?.password) {
      throw new Exception("Aktiveringen av ditt konto misslyckades.")
    }

    WsMethodService?.enableBasicServices(vo.uid)
    def mail =  WsMethodService?.getMail(vo.uid)

    [vo: vo, mail: mail]
  }
}
