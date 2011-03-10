package se.su.it.signuptool

class Info implements java.io.Serializable {
  Date created = new Date()
  String subject
  String body
  String locationKey = 'first_page'
  String locale
  String siteKey
  boolean active

  static constraints = {
    created()
    siteKey(blank: false, inList: ['new_account', 'reset_account'])
    subject(blank: false)
    locale(blank: false, inList: ['sv_SE', 'en_US'])
    body(nullable: true, blank: true, maxSize: 10000)
    locationKey()
    active()
  }

  static List findActiveInfoByLocaleAndSiteKey(locale, siteKey) {
    return Info.createCriteria().list {
      and {
        eq('active', true)
        eq('locale', locale)
        eq('siteKey', siteKey)
        eq('locationKey', 'first_page')
        order('created', 'DESC')
      }
    }
  }

  static List findInfoByLocaleAndSiteKey(locale, siteKey) {
    return Info.createCriteria().list {
      and {
        eq('locale', locale)
        eq('siteKey', siteKey)
        eq('locationKey', 'first_page')
        order('created', 'DESC')
      }
    }
  }
}
