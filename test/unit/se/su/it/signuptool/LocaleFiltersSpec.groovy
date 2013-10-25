package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.web.servlet.support.RequestContextUtils
import spock.lang.Specification

@TestFor(DashboardController) // To get some controller to run
@Mock(LocaleFilters)
class LocaleFiltersSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "filter sets session.locale from params.lang"() {
    given:
    params.lang = 'foo'

    when:
    withFilters(action: 'dashboard'){
      controller.index()
    }

    then:
    session.locale == 'foo'
  }

  void "filter sets params.lang from session.locale"() {
    given:
    session.locale = 'foo'

    when:
    withFilters(action: 'dashboard'){
      controller.index()
    }

    then:
    params.lang == 'foo'
  }
}
