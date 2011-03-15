package se.su.it.signuptool

class ShibAttributes {

  // Shib-Identity-Provider
  String idp

  // Shib-NorEduPerson-NorEduPersonNIN || Shib-SocialSecurityNumber
  String nin

  // Shib-InetOrgPerson-givenName
  String givenName

  //Shib-Person-surname
  String sn

  // Either student.su.se || fysik.su.se
  String domain

  // Set affiliation to student or employee
  String affiliation

  static transients = ['idp', 'nin', 'givenName', 'sn', 'domain', 'affiliation']
  static constraints = {
    idp(blank: false, nullable: false)
    nin(blank: false, nullable: false)
    givenName(blank: false, nullable: false)
    sn(blank: false, nullable: false)
    domain(blank: false, nullable: false)
    affiliation(blank: false, nullable: false)
  }

  // Automatically set domain and affiliation from idp
  public void setIdp(String lhs) {
    this.idp = lhs
    this.domain = this.idp2domain(lhs)
    this.affiliation = this.domain =~ /student.su.se/ ? 'student' : 'employee'
  }

  // Automatically set nin to 12 characters if given 10
  // this should be updated to handle year 2k :-) ...finally got to write that!
  public void setNin(String lhs) {
    if (lhs.length() == 10) {
      this.nin = "19${lhs}"
    } else {
      this.nin = lhs
    }
  }

  // Helper method to parse domain from idp
  String idp2domain(String idp) {
    if (idp =~ /studera.nu|antagning.se|umdac.se/) {
      return 'student.su.se'
    } else if (idp =~ /auth-prod-physto-idp/) {
      return 'fysik.su.se'
    }

    return null
  }

  def getErrorMessages() {
    return null // Return Map of Strings with error messages for each invalid attribute
  }

  public String toString() {
    "nin: ${nin}, givenName: ${givenName}, sn: ${sn}"
  }
}
