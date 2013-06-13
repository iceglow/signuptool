package se.su.it.signuptool

// skeleton/placeholder based on the methods from the old version - should use cxf for the new sukatsvc
class SukatService {
  public String enrollUser(String givenName, String sn, String nin) {
    return "hejsan svejsan" // should probably return something like a UserVO
  }

  public String getMail(String uid) {
    return "kalle.anka@ankeborg.se"
  }

  public String getMailRoutingAddress(String uid) {
    return "kalle.anka@ankeborg.se"
  }

  public boolean setMail(String uid, String mail) {
    return true
  }

  public boolean setMailRoutingAddress(String uid, String mailRoutingAddress) {
    return true
  }
}
