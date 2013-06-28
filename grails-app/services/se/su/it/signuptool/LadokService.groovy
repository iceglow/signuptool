package se.su.it.signuptool

import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource

class LadokService {

  static transactional = false

  def ladokDataSource
  def grailsApplication

  public findStudentInLadok(String pnr) {
    def response = runQuery("SELECT * FROM NAMN WHERE pnr = :pnr AND avliden != 'J'", [pnr:pnr])
    if (response?.size() > 0) {
      return true
    }
    return false
  }

  /**
   * the address retrived here can differ depending on a config value called useTimeLimitedAddress
   * if the value of this property is set to false the temporary address from ladok will be ignored.
   *
   * @param pnr - social security number.
   * @return An address from ladok.
   */
  public getAddressFromLadokByPnr(String pnr) {
    //TODO: tests :|
    boolean useTemporaryAddress = grailsApplication.config.useTemporaryAddress ?: true

    HashMap address

    String query = "SELECT * FROM ADRESS WHERE pnr = :pnr"

    List addresses = runQuery(query, [pnr: pnr])

    HashMap temporaryAddress = addresses?.find { it.adrtyp == "2" } as HashMap
    HashMap registeredAddress = addresses?.find { it.adrtyp == "4" } as HashMap

    address = registeredAddress

    if (temporaryAddress && useTemporaryAddress) {
      Date now        = new Date()
      Date fromDate   = Date.parse("yyyy-MM-dd", temporaryAddress?.fromdat)
      Date toDate     = Date.parse("yyyy-MM-dd", temporaryAddress?.tomdat)
      //TODO: what happens if the dates does not parse?

      if (fromDate < now && now < toDate) {
        address = temporaryAddress
      }
    }

    return address
  }

  private runQuery(String query, Map args) {

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
