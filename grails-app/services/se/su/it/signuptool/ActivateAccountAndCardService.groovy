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

import se.su.it.svc.SvcSuPersonVO

class ActivateAccountAndCardService implements Serializable {
  /** Needed if we want to use this service in the flow. */
  static transactional = false

  def sukatService
  def utilityService
  def ladokService

  private final String emailPattern = /[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})/

  public boolean validateForwardAddress(String forwardAddress) {
    forwardAddress = forwardAddress?.trim()

    if (!forwardAddress) {
      return false
    }

    if (!(forwardAddress ==~ emailPattern)) {
      return false
    }

    return true
  }

  public SvcSuPersonVO findUser(String pnr) {
    SvcSuPersonVO user = null

    if (!pnr) {
      return user
    }

    user = sukatService.findUserBySocialSecurityNumber(pnr)

    /** Return object could be empty, uid should mean we did get a hit. */
    (user?.uid) ? user : null
  }

  /**
   * The only time we should be fetching data from Ladok is when a student has no account
   * in SUKAT, the uid should thus be a socialSecurityNumber (10 chars)
   * @param uid
   * @return
   */
  public Map fetchLadokData(String socialSecurityNumber) {
    Map ladokData = [:]

    if (!socialSecurityNumber) {
      return ladokData
    }

    /** Turn 12 length ssn into 10 length */
    ladokData = ladokService.findStudentInLadok(socialSecurityNumber)

    return ladokData
  }

  public Map getCardOrderStatus(SvcSuPersonVO user) {
    Map cardInfo = [:]

    try {
      Map address = ladokService.getAddressFromLadokByPnr(user.socialSecurityNumber)
      cardInfo.hasAddress = address ? true : false
      cardInfo.ladokAddress = address

      // we may want to show info about the active cards a user already has
      cardInfo.suCards = (sukatService.getCardsForUser(user.uid))

      // we may want to show info about cardorders that the user may have done
      cardInfo.cardOrders = (sukatService.getCardOrdersForUser(user.uid))
      cardInfo.canOrderCard = canOrderCard(cardInfo)
    } catch (ex) {
      log.error "Failed when creating card order information object", ex
      throw ex // Propagate exception after logging.
    }

    return cardInfo
  }

  private static boolean canOrderCard(Map cardInfo) {
    if (!cardInfo.hasAddress) {
      return false
    }

    if (cardInfo.suCards) {
      return false
    }

    if (cardInfo.cardOrders) {
      return false
    }

    return true
  }
}
