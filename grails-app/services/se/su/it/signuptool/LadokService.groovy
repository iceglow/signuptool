package se.su.it.signuptool

import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource

class LadokService {

  static transactional = false

  def ladokDataSource

  public findStudentInLadok(String pnr) {
    def response = runQuery("SELECT * FROM NAMN WHERE pnr = :pnr AND avliden != 'J'", [pnr:pnr])
    if (response?.size() > 0) {
      return true
    }
    return false
  }

  private runQuery(String query , Map args) {

    Closure queryClosure = { Sql sql ->
      if (!sql) { return null }
      return sql?.rows(query, args)
    }

    return withConnection(queryClosure)
  }

  private withConnection = { Closure query ->
    def response = null
    Sql sql = null
    try {
      /** getDataSource added for mock and testing purposes */
      sql = newSqlInstanceFromDataSource()
      response = query(sql)
    } catch (ex) {
      log.error "Connection to LADOK failed", ex
    } finally {
      try {
        sql.close()
      } catch (ex) {
        log.error "Failed to close connection", ex
      }
    }
    return response
  }

  private def newSqlInstanceFromDataSource() {
    return new Sql(ladokDataSource as BasicDataSource)
  }
}
