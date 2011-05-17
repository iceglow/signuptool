package se.su.it.signuptool

class UserSuppliedData implements Serializable{
  String cardpickup = "defaultAddress"
  String email      = "su"
  String coadr
  String gatadr
  String postnr
  String ort
  String otherEmail

  static constraints = {
    cardpickup(blank: false, inList: ['helpdesk', 'otherAddress', 'defaultAddress'])
    email(blank: false, inList: ['su', 'other'])
    coadr()
    gatadr(validator: { val, obj -> return UserSuppliedData.validatorTestOtherAddress("gatadr",val,obj)})
    postnr(validator: { val, obj -> return UserSuppliedData.validatorTestOtherAddress("postnr",val,obj)})
    ort(validator: { val, obj -> return UserSuppliedData.validatorTestOtherAddress("ort",val,obj)})
    otherEmail(validator: { val, obj -> return UserSuppliedData.validatorTestOtherEmail(val,obj)})
  }

  boolean isDeliverHelpdesk() {
    return cardpickup.equalsIgnoreCase("helpdesk")
  }

  boolean isDeliverOtherAddress() {
    return cardpickup.equalsIgnoreCase("otherAddress")
  }

  boolean isDeliverDefaultAddress() {
    return cardpickup.equalsIgnoreCase("defaultAddress")
  }

  boolean isDeliverOtherEmail() {
    return email.equalsIgnoreCase("otherEmail")
  }

  boolean isDeliverSuEmail() {
    return email.equalsIgnoreCase("su")
  }

  static boolean validatorTestOtherAddress(String field,String val,UserSuppliedData obj)
  {
    if (obj.cardpickup.equalsIgnoreCase("otherAddress")) {
      return val.length() > 0
    }
    else {
      return true
    }
  }

  static boolean validatorTestOtherEmail(String val,UserSuppliedData obj)
  {
    if (obj.email.equalsIgnoreCase("other")) {
      return val ==~ /[a-z_][a-z0-9_]+@[a-z0-9_.?]+.[a-z]{1,3}/
    }
    else {
      return true
    }
  }
}
