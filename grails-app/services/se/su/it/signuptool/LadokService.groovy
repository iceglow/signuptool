package se.su.it.signuptool

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.apache.commons.dbcp.BasicDataSource

class LadokService {

  static transactional = false

  def ladokDataSource
  def grailsApplication

  public Map findStudentInLadok(String pnr) {
    pnr = chompPnr(pnr)
    Map response = [:]

    log.debug "findStudentInLadok: Trying to find person with pnr $pnr"
    List<GroovyRowResult> responseList = doListQuery(
        "SELECT enamn, tnamn FROM NAMN WHERE pnr = :pnr limit 1",
        [pnr:pnr])

    if (responseList?.size() > 0) {
      log.debug "findStudentInLadok: Found person with pnr $pnr in Ladok."
      return responseList.first()
    }

    log.debug "findStudentInLadok: Found no person with pnr $pnr in Ladok."
    return response
  }

  public String findForwardAddressSuggestionForPnr(String pnr) {
    pnr = chompPnr(pnr)
    String response = ''
    log.debug "findForwardAddressSuggestionForPnr: Querying address for person with pnr $pnr in Ladok."

    List<GroovyRowResult> responseList = doListQuery(
        "SELECT komadr FROM telekom WHERE pnr = :pnr AND komtyp = 'EMAIL' limit 1",
        [pnr:pnr])

    if (responseList?.size() > 0) {
      def address = responseList?.first()?.komadr

      if (address) {
        log.debug "findForwardAddressSuggestionForPnr: Found address for person with pnr $pnr in Ladok: $address"
        return address
      }
    }

    log.debug "findForwardAddressSuggestionForPnr: Found no address for person with pnr $pnr in Ladok."
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
    pnr = chompPnr(pnr)
    boolean useTemporaryAddress = grailsApplication.config.useTemporaryAddress ?: true

    HashMap address

    List addresses = doListQuery(
        "SELECT * FROM ADRESS WHERE pnr = :pnr",
        [pnr:pnr]
    )

    HashMap temporaryAddress = addresses?.find { it.adrtyp == "2" } as HashMap
    HashMap registeredAddress = addresses?.find { it.adrtyp == "4" } as HashMap

    address = registeredAddress

    if (temporaryAddress && useTemporaryAddress) {
      Date now        = new Date()
      Date fromDate   = Date.parse("yyyy-MM-dd", (String)temporaryAddress?.fromdat)
      Date toDate     = Date.parse("yyyy-MM-dd", (String)temporaryAddress?.tomdat)
      //TODO: what happens if the dates does not parse?

      if (fromDate < now && now < toDate) {
        // according to discussion with janj and friends 2013-07-08, see mail with subject 'Land i ladoks adresstabell' or jira DEVIDM-25
        if(temporaryAddress?.land=='SVERIGE' || temporaryAddress?.land=='') {
          address = temporaryAddress
        }
      }
    }

    return address
  }

  private List doListQuery(String query, Map args) {
    Closure queryClosure = { Sql sql ->
      if (!sql) { return null }
      return sql?.rows(query, args)
    }
    return withConnection(queryClosure)
  }

  private withConnection (Closure query) {
    def response = null
    Sql sql = null
    try {
      /** getDataSource added for mock and testing purposes */
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

  private static String chompPnr(String pnr) {
    (pnr?.length() == 12) ? pnr[2..11] : pnr
  }

}
