package se.su.it.signuptool

import ladok.lpw.service.changeaddress.facadeclient.ChangeAddressVO
import se.su.it.sucard.client.CardOrderVO
import se.su.it.sucard.client.AddressVO

class SignupService {

  def WsMethodService

  static transactional = false

  Map enableAccount(ShibAttributes attrs) throws Exception {
    def vo = WsMethodService.enrollUser(attrs.givenName, attrs.sn, attrs.nin)
    def mail =  WsMethodService.getMail(vo.uid)
    [vo: vo, mail: mail]
  }

  def setSukatMail(String uid, String mail) {
    return WsMethodService?.setMail(uid, mail)
  }

  def placeCardOrder(String uid, String firstName, String lastName, ChangeAddressVO defaultAddress, UserSuppliedData usd) {
    AddressVO avo = null
    if(usd.shouldDeliverDefaultAddress() && defaultAddress != null && defaultAddress.permanentAddr != null) {
      avo = new AddressVO()
      avo.streetadress1 = defaultAddress.permanentAddr.coadr.length() > 0 ? defaultAddress.permanentAddr.coadr : defaultAddress.permanentAddr.gatadr
      avo.streetaddress2 = defaultAddress.permanentAddr.coadr.length() > 0 ? defaultAddress.permanentAddr.gatadr : ""
      avo.zipcode = defaultAddress.permanentAddr.postnr
      avo.locality = defaultAddress.permanentAddr.ort
    }
    else if(usd.shouldDeliverOtherAddress()) {
      avo = new AddressVO()
      avo.streetadress1 = usd.coadr.length() > 0 ? usd.coadr : usd.gatadr
      avo.streetaddress2 = usd.coadr.length() > 0 ? usd.gatadr : ""
      avo.zipcode = usd.postnr
      avo.locality = usd.ort
    }
    else if(usd.shouldDeliverHelpdesk()) {

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
