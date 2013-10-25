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

        // If no session locale can be found, get it from the request (browser locale) or default to sv_SE
        if (!session.locale) {
          session.locale = RequestContextUtils.getLocale(request)?.toString() ?: 'sv_SE'
        }

        // Set params.lang from session.locale, since params.lang is used by Grails
        params.lang = session.locale
      }
    }
  }
}
