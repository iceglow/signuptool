package se.su.it.signuptool

import javax.servlet.http.Cookie
import se.su.it.ws.commons.WSLocatorFactory
import se.su.it.sukat.client.CardInfoFacade
import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import se.su.it.sucard.client.CardOrderFacadePortType
import se.su.it.sucard.client.CardOrderVO
import se.su.it.sucard.client.AddressVO

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

  def test2 = {
    Properties p = new Properties()

    p.setProperty("CardOrderFacade", "http://ilinca.it.su.se/sucardsvc-ws/services/CardOrderFacade")
    p.setProperty("CardSyncFacade", "http://ilinca.it.su.se/sucardsvc-ws/services/CardSyncFacade")
    def wsloc = WSLocatorFactory.instance(p)
    CardOrderFacadePortType fac = wsloc.getService(CardOrderFacadePortType.class)

    AddressVO avo = new AddressVO()
    avo.streetadress1 = "gatan 22"
    avo.streetaddress2 = "postbox23"
    avo.zipcode = "14645"
    avo.locality = "Tullinge"
    CardOrderVO covo = new CardOrderVO()
    covo.address = avo
    covo.firstname = "Janne"
    covo.lastname = "Qvarnstr�m"
    covo.owner = "jqvar"


    def crads = fac.orderCard(covo)
    render "JANNE:${crads}:JANNE"
  }

  def accountSetupFlow = {
    receiveShib {
      action {
        def attrs = new ShibAttributes()
        attrs.setIdp(request.eppn)
        attrs.setNin(request.norEduPersonNIN)
        attrs.givenName = request.givenName
        attrs.sn = request.sn

        // Validate model and handle map of errors if invalid
        if (!attrs.validate()) {
          log.error("accountSetup: validate() failed for user: ${attrs}, errorMessages=${attrs.errorMessages}")
          return error()
        }
        [attrs: attrs]
      }
      on("success").to "enableAccount"
      on("error").to "studeraNuAccountSetupError"
    }

    enableAccount {
      action {
        ShibAttributes attrs = flow.attrs
        def res = SignupService.enableAccount(attrs)
        session.currentVo = res.vo // the print action uses this
        [mail: res.mail, vo: res.vo]
      }
      on("success").to "preCardOrder"
      on("error").to "sukatAccountSetupError"
      on(Exception).to "sukatAccountSetupError"
    }

    preCardOrder {
      action {
        try {
          ChangeAddressVO addr = LPWWebService.getChangeAddressVO(flow.vo.uid)
          def usd = new UserSuppliedData()
          if(addr == null || addr.permanentAddr == null) {
            usd.cardpickup = "otherAddress"
          }
          [addrVo: addr.permanentAddr, usd: usd]
        } catch (Exception e) {
          [addrVo: null]
        }
      }
      on("success").to "cardOrder"
    }

    cardOrder { // Process the form data here
      on("cardbutton"){
         def usd = new UserSuppliedData(params)
         usd.validate()
         flow.usd = usd
         if(usd.hasErrors()) {
           return error()
         }

         if(usd.shouldUseOtherEmail()) {
          if(!SignupService.setSukatMail(flow.vo.uid, flow.usd.otherEmail)) {
            flow.usd.email = "su"
            flow.usd.otherEmail = ""
            flash.error = message(code: 'accountSetup.otherEmail.set.error')
            log.error("Could not set other email address<" + flow.usd.otherEmail +"> for uid<" + flow.vo.uid + ">")
          }
         }
         if(!SignupService.placeCardOrder(flow.vo.uid, flow.attrs.givenName, flow.attrs.sn, flow.addrVo, usd)) {
          flash.error = message(code: 'accountSetup.orderCard.error')
          log.error("Could not order card for uid<" + flow.vo.uid + ">")
         }
      }.to "fetchLpwStuff"
    }

    fetchLpwStuff {
      action {
        def courseSuggestionList
        def uid = flow.vo.uid
        try {
          def semesterVO = LPWWebService?.getCurrentAndNextSemester(uid)
          def courseSuggestionVO = LPWWebService?.getCourseRegSuggestions(uid, semesterVO.currentSemester)
          courseSuggestionList = courseSuggestionVO?.courseRegSuggestions
          courseSuggestionVO = LPWWebService?.getCourseRegSuggestions(uid, semesterVO.nextSemester)
          courseSuggestionList.addAll(courseSuggestionVO?.courseRegSuggestions)
        }
        catch (Exception e) { // The view will handle this failure gracefully
          e.printStackTrace()
        }
        [courseSuggestionList: courseSuggestionList]
      }
      on("success").to "accountDetails"
      on("error").to "sukatAccountSetupError"
    }

    accountDetails ()

    studeraNuAccountSetupError {
      redirect(controller: "croak", action: "studeraNuAccountSetupError")
    }

    sukatAccountSetupError {
      redirect(controller: "croak", action: "sukatAccountSetupError")
    }
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
