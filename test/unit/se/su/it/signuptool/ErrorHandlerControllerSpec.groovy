package se.su.it.signuptool

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ErrorHandlerController)
class ErrorHandlerControllerSpec extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void "on500"() {
    given:
    def content = 'mock'
    views['/errorHandler/_genericError.gsp'] = content

    when:
    controller.on500()

    then:
    response.text == content
  }

  void "on404"() {
    given:
    def content = 'mock'
    views['/errorHandler/_genericError.gsp'] = content

    when:
    controller.on404()

    then:
    response.text == content
  }

  void "on403"() {
    given:
    def content = 'mock'
    views['/errorHandler/_genericError.gsp'] = content

    when:
    controller.on403()

    then:
    response.text == content
  }

  void "on400"() {
    given:
    def content = 'mock'
    views['/errorHandler/_genericError.gsp'] = content

    when:
    controller.on400()

    then:
    response.text == content
  }
}