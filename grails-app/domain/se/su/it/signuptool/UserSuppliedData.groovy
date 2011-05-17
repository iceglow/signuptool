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

  boolean shouldDeliverHelpdesk() {
    return cardpickup.equalsIgnoreCase("helpdesk")
  }

  boolean shouldDeliverOtherAddress() {
    return cardpickup.equalsIgnoreCase("otherAddress")
  }

  boolean shouldDeliverDefaultAddress() {
    return cardpickup.equalsIgnoreCase("defaultAddress")
  }

  boolean shouldUseOtherEmail() {
    return email.equalsIgnoreCase("other")
  }

  boolean shouldUseSuEmail() {
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
      return val ==~ /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/
    }
    else {
      return true
    }
  }
}
