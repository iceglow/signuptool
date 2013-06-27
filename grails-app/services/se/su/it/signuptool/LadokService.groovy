package se.su.it.signuptool

import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource

class LadokService {

  static transactional = false

  def ladokDataSource

  public Map findStudentInLadok(String pnr) {
    def response = [:]
    def responseList = runQuery("SELECT enamn, tnamn FROM NAMN WHERE pnr = :pnr", [pnr:pnr])
    if (responseList?.size() > 0) {
      return responseList.first()
    }
    return response
  }

  public String findForwardAddressSuggestionForPnr(String pnr) {
    def response = ''
    def responseList = runQuery("SELECT komadr FROM telekom WHERE pnr = :pnr AND komtyp = 'EMAIL'", [pnr:pnr])
    if (responseList?.size() > 0) {
      return (responseList?.first()?.komadr)?:''
    }

    return response
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
