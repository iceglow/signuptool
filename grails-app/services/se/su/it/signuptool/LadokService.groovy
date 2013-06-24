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

  private runQuery(String query, Map args) {
    return withConnection({ Sql sql ->
      return sql.rows(query, args)
    })
  }

  private withConnection = { Closure query ->
    def response = null
    Sql sql = null
    try {
      sql = new Sql(ladokDataSource as BasicDataSource)
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
}
