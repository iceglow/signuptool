package se.su.it.signuptool

import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import se.su.it.sucard.client.CardOrderVO
import se.su.it.sucard.client.AddressVO

class SignupService {

  def WsMethodService

  static transactional = false

  Map enableAccount(ShibAttributes attrs) throws Exception {
    def vo = WsMethodService.enrollUser(attrs.givenName, attrs.sn, attrs.nin)

    // Check for empty mailRoutingAddress
    if (!WsMethodService.getMailRoutingAddress(vo.uid)) {
      WsMethodService.setMailRoutingAddress(vo.uid, vo.uid + "@mbox.su.se")
    }

    def mail =  WsMethodService.getMail(vo.uid)
    [vo: vo, mail: mail]
  }

  def setSukatMail(String uid, String mail) {
    return WsMethodService?.setMail(uid, mail)
  }

  Boolean canOrderCard(String uid) {
    CardOrderVO[] orders = WsMethodService.getCardOrdersForUser(uid)
    return orders == null || orders.find { it.status != "DISCARDED" } == null
  }

  def placeCardOrder(String uid, String firstName, String lastName, ladok.lpw.service.changeaddress.facadeclient.AddressVO defaultAddress, UserSuppliedData usd) {
    AddressVO avo = null
    if(usd.shouldDeliverDefaultAddress() && defaultAddress != null) {
      avo = new AddressVO()
      avo.streetaddress1 = defaultAddress.coadr.length() > 0 ? defaultAddress.coadr : defaultAddress.gatadr
      avo.streetaddress2 = defaultAddress.coadr.length() > 0 ? defaultAddress.gatadr : ""
      avo.zipcode = defaultAddress.postnr
      avo.locality = defaultAddress.ort
    }
    else if(usd.shouldDeliverOtherAddress()) {
      avo = new AddressVO()
      avo.streetaddress1 = usd.coadr.length() > 0 ? usd.coadr : usd.gatadr
      avo.streetaddress2 = usd.coadr.length() > 0 ? usd.gatadr : ""
      avo.zipcode = usd.postnr
      avo.locality = usd.ort
    }
    else if(usd.shouldDeliverHelpdesk()) {
      //Functionality changed last couple of day of project. When this option is used we dont want to place
      //an cardOrder. Ppl need to go to Helpdesk and order it manually.
      //So lets just return true here
      return true;
    }
    else {
      return false
    }
    CardOrderVO covo = new CardOrderVO()
    covo.address = avo
    covo.firstname = firstName
    covo.lastname = lastName
    covo.owner = uid
    return WsMethodService?.orderCard(covo)
  }

  def sendConfirmMailToStudent(String mailaddress) {

    try {

      String toAddress = mailaddress

      String subject = "Bekr\u00e4ftelse universitetskonto och -kort, Stockholms universitet / Confirmation, University Account and University Card, Stockholm University";

      String msgBody = "Du har nu ett aktiverat universitetskonto och har best\u00e4llt hem ditt universitetskort!\n" +
                       "Kortet b\u00f6r komma inom fem arbetsdagar.\n" +
                       "Om du har n\u00e5gra fr\u00e5gor \u00e4r du v\u00e4lkommen att kontakta universitetets Helpdesk f\u00f6r IT-fr\u00e5gor: www.su.se/studentsupport/helpdesk/\n" +
                       "L\u00e4s mer om universitetskontot, universitetskortet och Stockholms universitets IT-tj\u00e4nster: www.su.se/studentsupport/\n" +
                       "V\u00e4lkommen som student vid Stockholms universitet!\n" +
                       "\n" +
                       "------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                       "You now have activated your University Account, and have successfully ordered your University Card! The card should arrive within five working days.\n" +
                       "If you have any questions, please contact the University Helpdesk for IT issues: http://www.su.se/english/study/student-services/university-account \n" +
                       "Learn more about your University Account, University Card and Stockholm University's IT services at: http://www.su.se/english/study/student-services/university-account/what-is-a-university-account \n"+
                       "Welcome as a student at Stockholm University!"

      MailUtil mailUtil = new MailUtil("smtp.su.se", "noreply@su.se")
      mailUtil.sendEmail(msgBody, subject, toAddress)
    }
    catch (Exception e) {
      e.printStackTrace()
    }

  }
}
