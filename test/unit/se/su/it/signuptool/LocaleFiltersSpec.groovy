package se.su.it.signuptool

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(AdminController) // To get some controller to run
@Mock(LocaleFilters)
class LocaleFiltersSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "filter sets session.lang from params.lang"() {
    given:
    params.lang = 'en'

    when:
    withFilters(action: 'index'){
      controller.index()
    }

    then:
    session.lang == 'en'
  }

  void "filter sets params.lang from session.lang"() {
    given:
    session.lang = 'en'

    when:
    withFilters(action: 'index'){
      controller.index()
    }

    then:
    params.lang == 'en'
  }

  @Unroll
  void "filter defaults sets #expected locale for #locale"() {
    given:
    session.lang = locale

    when:
    withFilters(action: 'index'){
      controller.index()
    }

    then:
    params.lang == expected

    where:
    locale | expected
    'en'   | 'en'
    'sv'   | 'sv'
    'foo'  | 'sv'
  }
}
