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
  def enrollmentWS
  def statusWS
  def webAdminWS

  private final DEFAULT_DOMAIN = "student.su.se"
  private final DEFAULT_AFFILATION = "other"
  private final CARD_ORDER_STATUSES_TO_SKIP = ["DISCARDED", "WRITTEN_TO_SUKAT"]

  public String orderCard(SvcSuPersonVO user, Map ladokAddress) {
    SvcCardOrderVO cardOrderVO = createCardOrderVO(user, ladokAddress)
    return cardOrderWS.orderCard(cardOrderVO, AuditFactory.auditObject)
  }

  private static SvcCardOrderVO createCardOrderVO(SvcSuPersonVO user, Map ladokAddress) {
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

  public List<SvcCardOrderVO> getCardOrdersForUser(String uid) {
    // call sukatsvc to fetch cardorders for user , something like findAllCardOrdersForUid in the CardOrderService
    List<SvcCardOrderVO> cardOrders = cardOrderWS.findAllCardOrdersForUid(uid, AuditFactory.auditObject)

    if (!cardOrders) {
      return []
    }

    cardOrders.removeAll { (it?.value in CARD_ORDER_STATUSES_TO_SKIP) }

    return cardOrders
  }

  public List<SuCard> getCardsForUser(String uid) {
    List<SuCard> suCards = []
    try {
      suCards = cardInfoWS.getAllCards(uid, true, AuditFactory.auditObject)
    } catch (Throwable exception) {
      log.error "Failed when getting info about users cards: ${exception.getMessage()}", exception
      suCards = []
    }
    return suCards
  }

  public SvcSuPersonVO findUserBySocialSecurityNumber(String pnr) {
    SvcSuPersonVO suPerson = null

    try {
      suPerson = accountWS.findSuPersonBySocialSecurityNumber(pnr, AuditFactory.auditObject)
    } catch (ex) {
      log.error "Failed when finding user by ssn in SUKAT.", ex
      throw ex
    }

    return suPerson
  }

  public SvcUidPwd enrollUser(String givenName, String sn, String socialSecurityNumber, String forwardAddress) {

    if (!givenName?.trim()) {
      log.error "No givenName supplied."
      return null
    }

    if (!sn?.trim()) {
      log.error "No sn supplied."
      return null
    }

    if (!socialSecurityNumber?.trim()) {
      log.error "No socialSecurityNumber supplied."
      return null
    }

    SvcUidPwd response = enrollmentWS.enrollUserWithMailRoutingAddress(
        DEFAULT_DOMAIN,
        givenName,
        sn,
        DEFAULT_AFFILATION,
        socialSecurityNumber,
        forwardAddress,
        AuditFactory.auditObject
    )

    return response
  }

  public String resetPassword(String uid) {
    return accountWS.resetPassword(uid, AuditFactory.auditObject)
  }
}
