package se.su.it.signuptool

import org.springframework.web.servlet.support.RequestContextUtils

class LocaleFilters {

  def filters = {

    /**
     * Make sure the locale is set.
     */
    all(controller:'*', action:'*') {
      before = {
        // If we get a lang in params, store it to the session.
        if (params.lang) {
          session.locale = params.lang
        }

        // If no session locale can be found, get it from the request (browser locale)
        if (!session.locale) {
          session.locale = RequestContextUtils.getLocale(request)?.language
        }

        // Check that session.locale is a supported locale, or default to 'sv'
        session.locale = (session.locale in ['sv', 'en'] ? session.locale : 'sv')

        // Set params.lang from session.locale, since params.lang is used by Grails
        params.lang = session.locale
      }
    }
  }
}
