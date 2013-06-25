package se.su.it.signuptool

import gldapo.schema.annotation.GldapoNamingAttribute
import gldapo.schema.annotation.GldapoSchemaFilter
import gldapo.schema.annotation.GldapoSynonymFor
import org.codehaus.groovy.grails.commons.GrailsApplication
import java.lang.reflect.Field
import org.springframework.test.annotation.SystemProfileValueSource

class SuPerson implements Serializable {

  static final long serialVersionUID = -687991492884005033L;

  @GldapoSchemaFilter("(objectClass=suPerson)")

  /**
   * First attribute must be the uid or funny things will happen.
   */
  @GldapoNamingAttribute
  String uid
  String cn
  String departmentNumber
  String description
  String displayName
  String eduPersonPrimaryAffiliation
  String eduPersonPrimaryOrgUnitDN
  String givenName
  String homeLocalityName
  String homeMobilePhone
  String homePhone
  String homePostalCode
  String labeledURI
  String mailRoutingAddress
  String mobile
  String mydn
  String registeredAddress
  String sn
  String socialSecurityNumber
  String sukatComment
  String sukatLOAFromDate
  String sukatLOAToDate
  String sukatVisibility

  Set<String> roomNumber
  Set<String> telephoneNumber
  Set<String> eduPersonAffiliation
  Set<String> eduPersonEntitlement
  Set<String> eduPersonOrgUnitDN
  Set<String> mail
  Set<String> mailLocalAddress
  Set<String> objectClass
  Set<String> sukatPULAttributes
  Set<String> title
  Set<String> homePostalAddress

  static constraints = {
    cn(nullable: false)
    departmentNumber(nullable:true)
    description(nullable: true)
    displayName(nullable: true)
    eduPersonAffiliation(nullable: true)
    eduPersonEntitlement(nullable: true)
    eduPersonOrgUnitDN(nullable: true)
    eduPersonPrimaryOrgUnitDN(nullable: false)
    givenName(nullable: false)
    homeLocalityName(nullable: true)
    homeMobilePhone(nullable: true)
    homePhone(nullable: true)
    homePostalAddress(nullable: true)
    homePostalCode(nullable: true)
    labeledURI(nullable:true)
    mail(nullable: true)
    mailRoutingAddress(nullable: true)
    mobile(nullable: true)
    registeredAddress(nullable: true)
    roomNumber(nullable: true)
    sn(nullable: true)
    socialSecurityNumber(nullable: false)
    sukatComment(nullable: true)
    sukatLOAFromDate(nullable: true)
    sukatLOAToDate(nullable: true)
    sukatPULAttributes(nullable: true)
    sukatVisibility(nullable: true)
    telephoneNumber(nullable: true)
    title(nullable: true)
    uid(nullable: false)
  }
}
