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
}
