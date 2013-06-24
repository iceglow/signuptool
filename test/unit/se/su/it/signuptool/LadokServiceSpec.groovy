package se.su.it.signuptool

import grails.test.mixin.TestFor
import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LadokService)
class LadokServiceSpec extends Specification {

  /**
   * These tests are missing some somewhat vital parts.
   * Sql has not been mocked, Sql's no parameter constructor requires
   * objenesis, which causes issues when running tests multiple times
   * from grails interactive mode..
   * @return
   */

  def setup() {
    service.ladokDataSource = Mock(BasicDataSource)
  }

  def cleanup() {
    LadokService.metaClass = null
  }

  void "findStudentInLadok: When no student is found."() {
    given:
    when:
    def resp = service.findStudentInLadok("1234567890")

    then:
    !resp
  }

  void "findStudentInLadok: When a student is found."() {
    given:

    LadokService.metaClass.runQuery = { String arg1, Map arg2 ->
      return ['someData']
    }

    when:
    def resp = service.findStudentInLadok("1234567890")

    then:
    resp
  }

  void "withConnection: When creating a new sql connection fails"() {
    given:
    Closure query = { Sql sql ->
      assert sql instanceof Sql
      return "myQuery"
    }

    when:
    def resp = service.withConnection(query)

    then:
    resp == "myQuery"
  }

  void "withConnection: When creating Sql connection fails"() {
    given:
    LadokService.metaClass.newSqlInstanceFromDataSource = {
      throw new RuntimeException('foo')
    }

    Closure query = { Sql sql ->
      assert sql instanceof Sql
      return "myQuery"
    }

    when:
    def resp = service.withConnection(query)

    then:
    resp == null
  }

  void "withConnection: When querying fails"() {
    given:

    Closure query = { Sql sql ->
      throw new RuntimeException('foo')
    }

    when:
    def resp = service.withConnection(query)

    then:
    resp == null
  }

  void "newSqlInstanceFromDataSource: Should return an Sql instance"() {
    expect:
    service.newSqlInstanceFromDataSource() instanceof Sql
  }


}
