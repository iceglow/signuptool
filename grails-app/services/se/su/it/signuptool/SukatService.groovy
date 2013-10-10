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

import org.apache.commons.collections.Predicate
import se.su.it.commons.PrincipalUtils
import se.su.it.svc.SuCard
import se.su.it.svc.SvcCardOrderVO
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

class SukatService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def accountWS
  def cardInfoWS
  def cardOrderWS
  def statusWS
  def webAdminWS

  def utilityService

  public static final DEFAULT_DOMAIN = "student.su.se"
  public static final DEFAULT_AFFILATION = "other"
  private final CARD_ORDER_STATUSES_TO_SKIP = ["DISCARDED", "WRITTEN_TO_SUKAT"]

  public String orderCard(SvcSuPersonVO user, Map ladokAddress) throws Exception {
    SvcCardOrderVO cardOrderVO = createCardOrderVO(user, ladokAddress)
    return cardOrderWS.orderCard(cardOrderVO)
  }

  public List<SvcCardOrderVO> getCardOrdersForUser(String uid) throws Exception {
    // call sukatsvc to fetch cardorders for user , something like findAllCardOrdersForUid in the CardOrderService
    List<SvcCardOrderVO> cardOrders = cardOrderWS.findAllCardOrdersForUid(uid)

    if (!cardOrders) {
      return []
    }

    cardOrders.removeAll { (it?.value in CARD_ORDER_STATUSES_TO_SKIP) }

    return cardOrders
  }

  public List<SuCard> getCardsForUser(String uid) throws Exception {
    return cardInfoWS.getAllCards(uid, true)
  }

  public List<SvcSuPersonVO> findUsersBySocialSecurityNumber(String nin) throws Exception {
    String ssn = utilityService.chompNinToSsn(nin)
    return accountWS.findAllSuPersonsBySocialSecurityNumber(ssn)
  }

  /**
   * Generate a new student uid, check against svc for uniqueness
   *
   * @param givenName the giveNname to base the new uid on
   * @param sn the sn to base the new uid on
   * @return a new uid
   */
  public String generateStudentUid(String givenName, String sn) {
    String uid = PrincipalUtils.suniqueUID(givenName, sn, new Predicate() {
      public boolean evaluate(Object object) {
        try {
          /* When the search returns null (ie the ) we return true */
          return null == accountWS.findSuPersonByUid((String) object)
        } catch (ex) {
          log.error "Failed when getting SuPerson from GID", ex
          return false
        }
      }
    })

    log.debug "Returning $uid for user with name $givenName $sn"
    return uid
  }

  /**
   * Create a SuPerson stub in SUKAT
   *
   * @param givenName the given name
   * @param sn the surname
   * @param ssn the social security number
   * @return the uid of the stub
   */
  public String createSuPersonStub(String givenName, String sn, String nin) throws Exception {
    String ssn = utilityService.chompNinToSsn(nin)
    String uid = generateStudentUid(givenName, sn)

    accountWS.createSuPerson(uid, ssn, givenName, sn)

    return uid
  }

  /**
   * Set a new mailRoutingAddress on a user account
   *
   * @param uid the user to update mailRoutingAddress for
   * @param mail the new mailRoutingAddress
   */
  public void setMailRoutingAddress(String uid, String mail) throws Exception {
    accountWS.setMailRoutingAddress(uid, mail)
  }

  /**
   * Activate a user account
   *
   * @param uid
   * @return a SvcUidPwd containing the username and password of the activated account.
   */
  public SvcUidPwd activateUser(String uid) throws Exception {
    return accountWS.activateSuPerson(uid, DEFAULT_DOMAIN, [DEFAULT_AFFILATION])
  }

  /**
   * Reset the password for a user account
   *
   * @param uid
   * @return the new password
   */
  public String resetPassword(String uid) throws Exception {
    return accountWS.resetPassword(uid)
  }

  private static SvcCardOrderVO createCardOrderVO(SvcSuPersonVO user, Map ladokAddress) throws Exception {
    if (user == null) {
      throw new IllegalArgumentException('user is null')
    }

    if (!ladokAddress) {
      throw new IllegalArgumentException("Ladok address supplied is invalid ${ladokAddress?.dump()}")
    }

    SvcCardOrderVO cardOrderVO = new SvcCardOrderVO()
    cardOrderVO.firstname = user.givenName
    cardOrderVO.lastname = user.sn
    cardOrderVO.owner = user.uid
    cardOrderVO.streetaddress1 = ladokAddress?.gatadr
    cardOrderVO.streetaddress2 = ladokAddress?.coadr
    cardOrderVO.zipcode = ladokAddress?.postnr
    cardOrderVO.locality = ladokAddress?.ort
    return cardOrderVO
  }
}
