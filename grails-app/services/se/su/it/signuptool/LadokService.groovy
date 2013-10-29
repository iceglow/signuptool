/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package se.su.it.signuptool

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import se.su.it.signuptool.interfaces.LadokServiceI

import javax.sql.DataSource

class LadokService implements LadokServiceI, Serializable {

  static transactional = false

  def ladokDataSource
  def utilityService
  def grailsApplication

  public Map findStudentInLadok(String nin) throws Exception {
    String ssn = utilityService.chompNinToSsn(nin)
    Map response = [:]

    log.debug "findStudentInLadok: Trying to find person with ssn $ssn"
    List<GroovyRowResult> responseList = doListQuery(
        "SELECT enamn, tnamn FROM NAMN WHERE pnr = :ssn limit 1",
        [ssn:ssn])

    if (responseList?.size() > 0) {
      log.debug "findStudentInLadok: Found person with ssn $ssn in Ladok."
      return responseList.first()
    }

    log.debug "findStudentInLadok: Found no person with ssn $ssn in Ladok."
    return response
  }

  public String findForwardAddressSuggestionForPnr(String nin) throws Exception {
    String ssn = utilityService.chompNinToSsn(nin)
    String response = ''
    log.debug "findForwardAddressSuggestionForPnr: Querying address for person with ssn $ssn in Ladok."

    List<GroovyRowResult> responseList = doListQuery(
        "SELECT komadr FROM telekom WHERE pnr = :ssn AND komtyp = 'EMAIL' limit 1",
        [ssn:ssn])

    if (responseList?.size() > 0) {
      def address = responseList?.first()?.komadr

      if (address) {
        log.debug "findForwardAddressSuggestionForPnr: Found address for person with ssn $ssn in Ladok: $address"
        return address
      }
    }

    log.debug "findForwardAddressSuggestionForPnr: Found no address for person with ssn $ssn in Ladok."
    return response
  }

  /**
   * the address retrived here can differ depending on a config value called useTimeLimitedAddress
   * if the value of this property is set to false the temporary address from ladok will be ignored.
   *
   * @param pnr - social security number.
   * @return An address from ladok.
   */
  public Map getAddressFromLadokByPnr(String nin) throws Exception {
    String ssn = utilityService.chompNinToSsn(nin)
    boolean useTemporaryAddress = grailsApplication.config.useTemporaryAddress ?: true

    HashMap address

    List addresses = doListQuery(
        "SELECT * FROM ADRESS WHERE pnr = :ssn",
        [ssn:ssn]
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

  private withConnection(Closure query) throws Exception {
    def response = null
    Sql sql = null
    try {
      /** getDataSource added for mock and testing purposes */
      sql = new Sql(ladokDataSource as DataSource)
      response = query(sql)
    } catch (ex) {
      log.error "Connection to LADOK failed", ex
      throw ex // Propagate the exception after logging the error.
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
