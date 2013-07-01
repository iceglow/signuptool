package se.su.it.signuptool

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource

class LadokService {

  static transactional = false

  def ladokDataSource
  def grailsApplication

  public boolean doesUserExistInLadok(String socialSecurityNumber) {
    boolean exists = false
    List<GroovyRowResult> responseList = runQuery("SELECT count(*) FROM NAMN WHERE pnr = :pnr", [pnr:socialSecurityNumber])
    responseList?.each { GroovyRowResult result ->
      exists = (result["count(*)"]>0)
    }
    return exists
  }

  public Map findStudentInLadok(String pnr) {
    Map response = [:]
    List<GroovyRowResult> responseList = runQuery("SELECT enamn, tnamn FROM NAMN WHERE pnr = :pnr limit 1", [pnr:pnr])
    if (responseList?.size() > 0) {
      return responseList.first()
    }
    return response
  }

  public String findForwardAddressSuggestionForPnr(String pnr) {
    String response = ''
    List<GroovyRowResult> responseList = runQuery("SELECT komadr FROM telekom WHERE pnr = :pnr AND komtyp = 'EMAIL' limit 1", [pnr:pnr])
    if (responseList?.size() > 0) {
      return (responseList?.first()?.komadr)?:''
    }

    return response
  }

  /**
   * the address retrived here can differ depending on a config value called useTimeLimitedAddress
   * if the value of this property is set to false the temporary address from ladok will be ignored.
   *
   * @param pnr - social security number.
   * @return An address from ladok.
   */
  public Map getAddressFromLadokByPnr(String pnr) {
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

  private List<GroovyRowResult> runQuery(String query, Map args) {

    Closure queryClosure = { Sql sql ->
      if (!sql) { return null }
      return sql?.rows(query, args)
    }

    return withConnection(queryClosure)
  }

  private List<GroovyRowResult> withConnection (Closure query) {
    List<GroovyRowResult> response = null
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

  private Sql newSqlInstanceFromDataSource() {
    return new Sql(ladokDataSource as BasicDataSource)
  }
}
