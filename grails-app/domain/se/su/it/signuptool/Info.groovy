package se.su.it.signuptool

class Info implements java.io.Serializable {
  Date created = new Date()
  String subject
  String body
  String locationKey
  String locale
  String siteKey
  boolean active

  static constraints = {
    created()
    siteKey(blank:false)
    subject(blank:false)
    locale(blank:false, inList:['sv_SE', 'en_US'])
    body(nullable:true, blank:true, maxSize:10000)
    locationKey()
    active()
  }

  static List findInfoByActiveLocationKeyLocaleAndType(key,locale,siteKey) {
    return Info.createCriteria().list {
      and {
        eq('active', true)
        eq('locationKey', key)
        eq('locale', locale)
        eq('siteKey', siteKey)
        order('created', 'desc')
      }
    }
  }
}