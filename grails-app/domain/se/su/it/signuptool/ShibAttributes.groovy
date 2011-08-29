package se.su.it.signuptool

class ShibAttributes implements java.io.Serializable {

  // Shib-NorEduPerson-NorEduPersonNIN || Shib-SocialSecurityNumber
  String nin

  // Shib-InetOrgPerson-givenName
  String givenName

  //Shib-Person-surname
  String sn

  static transients = ['nin', 'givenName', 'sn']
  static constraints = {
    nin(blank: false, nullable: false)
    givenName(blank: false, nullable: false)
    sn(blank: false, nullable: false)
  }

  // Automatically set nin to 12 characters if given 10
  // this should be updated to handle year 2k :-) ...finally got to write that!
  public void setNin(String theNin) {
    if (theNin && theNin.length() == 10) {
      this.nin = "19${theNin}"
    } else {
      this.nin = theNin
    }
  }

  public String toString() {
    "nin: ${nin}, givenName: ${givenName}, sn: ${sn}"
  }
}
