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

import se.su.it.signuptool.commandobjects.AccountAndCardProcess
import se.su.it.svc.SvcSuPersonVO
import se.su.it.svc.SvcUidPwd

class ActivateAccountAndCardController {

  public static final int STEP_START    = 1
  public static final int STEP_IDENTIFY = 2
  public static final int STEP_ACCOUNT  = 3
  public static final int STEP_CARD     = 4
  public static final int STEP_END      = 5

  def activateAccountAndCardService
  def configService
  def ladokService
  def sukatService
  def utilityService

  def index() {

    AccountAndCardProcess acp = session.acp

    if (!acp) {
      acp = new AccountAndCardProcess(
          eppn:request.eppn,
          norEduPersonNIN:request.norEduPersonNIN)
      session.acp = acp
    }

    // Set current step in acp obj.
    acp.step = STEP_ACCOUNT

    if (!acp.validate()) {
      log.error acp.toString()
      flash.error = message(code:'activateAccountAndCard.error.noEppn')
      return redirect(controller:'dashboard', action:'index')
    }

    if (acp.hasError()) {
      /** We don't want the error to hang around so we let it live in the shortest lived scope. */
      request.error = acp.error
    }

    /** Only display the password if returned and remove it right after. */
    String password = ''

    if (acp.hasPassword()) {
      password = acp.password
    }

    EventLog eventLog

    if (acp.referenceId) {
      try {
        eventLog = utilityService.getEventLog(acp.referenceId)
      } catch (ex) {
        log.error "Failed to fetch eventLog for referenceId ${acp.referenceId}", ex
        flash.error = g.message(code:'activateAccountAndCardController.errors.genericError')
        return redirect(controller:'dashboard', action:'index')
      }
    } else {
      try {
        eventLog = utilityService.eventLog
        acp.referenceId = eventLog?.id
      } catch (ex) {
        log.error "Failed to create new eventLog", ex
        flash.error = g.message(code:'activateAccountAndCardController.errors.genericError')
        return redirect(controller:'dashboard', action:'index')
      }
    }

    String uid = acp.user?.uid

    if (!acp.verified) {
      String scope = utilityService.getScopeFromEppn(acp.eppn)
      switch(scope) {
        case "studera.nu":
          if (acp.norEduPersonNIN) {
            acp.verified = true
            eventLog.logEvent("verified account for ${acp.eppn} with norEduPersonNIN ${acp.norEduPersonNIN}")
          } else {
            eventLog.logEvent("unverified account for ${acp.eppn}")
            return render(view:'/shared/unverifiedAccount', model:[referenceId:eventLog?.id])
          }
          break
        default:
          eventLog.logEvent("no handled or valid scope supplied for ${acp.eppn}")
          flash.error = message(
              code:'activateAccountAndCardController.noValidScopeFound',
              args:[acp.eppn]) as String
          return redirect(controller:'dashboard', action:'index')
      }
    }

    if (!eventLog?.userId) {
      eventLog.userId = acp.norEduPersonNIN
      eventLog.save(flush:true)
    }

    /**
     * If the user isn't already in the session we find it either by ssn or uid and put it in the session.
     */
    if (!acp.hasUser()) {
      try {
        List<SvcSuPersonVO> vos = sukatService.findUsersBySocialSecurityNumber(acp.norEduPersonNIN)

        int voCount = (vos) ? vos?.size() : 0

        if (voCount > 1) {
          String msg = "Found multiple accounts with social security number based on norEduPersonNIN: ${acp.norEduPersonNIN}. Aborting activation."
          eventLog.logEvent(msg)
          log.error msg
          flash.error = g.message(code:'sukat.errors.multipleUsersForSSN')
          return redirect(controller:'dashboard', action:'index')
        } else if (voCount == 1) {
          acp.user = vos?.first()
        }
      } catch (ex) {
        eventLog.logEvent("Failed when setting user in session for ${uid} with exception ${ex.message}")

        log.error "Failed when setting user in session", ex
        flash.error = message(
            code:'activateAccountAndCardController.errorWhenFetchingUser',
            args:[acp.norEduPersonNIN]) as String

        return redirect(controller:'dashboard', action:'index')
      }
    }

    /** If we still have no user in the session then this is a first time visit */
    if (!acp.hasUser() || acp.isStubUser()) {

      eventLog.logEvent("First time visit for ${acp.norEduPersonNIN}")
      /** See if we can find the new user in Ladok */
      def ladokData

      try {
        ladokData = activateAccountAndCardService.fetchLadokData(acp.norEduPersonNIN)
      } catch (ex) {
        eventLog.logEvent("Failed when fetching ladokData for uid: $acp.norEduPersonNIN")
        log.error "Failed when fetching ladokData for uid: $acp.norEduPersonNIN", ex
        flash.error = message(code: "activateAccountAndCardController.errorWhenContactingLadok")
        return redirect(controller:'dashboard', action:'index')
      }

      if (!ladokData) {
        eventLog.logEvent("User ${acp.norEduPersonNIN} not found in ladok")
        return render(view:'userNotFoundInLadok', model:[referenceId:eventLog?.id])
      }

      /** Saving enamn and tnamn for enroll method */
      if (!acp.isStubUser()) {
        acp.newUser = true
        acp.user = new SvcSuPersonVO()
      }

      acp.user.givenName = ladokData.tnamn
      acp.user.sn = ladokData.enamn

      eventLog.logEvent("Account for user with nin: ${acp.norEduPersonNIN} not found in SUKAT, starting create user account flow.")
      return redirect(action:'createNewAccount')
    }

    String lpwurl = configService.getValue("signup", "lpwtool")
    String sukaturl = configService.getValue("signup", "sukattool")
    eventLog.logEvent("Found account with nin: ${acp.norEduPersonNIN} and uid: ${acp?.userVO?.uid} in SUKAT, displaying information.")

    if (acp.hasCompletedCardOrder || acp.errorWhileOrderingCard) {
      acp.step = STEP_END
    } else if(! acp.hasCompletedCardOrder) {
      acp.step = STEP_ACCOUNT
    }

    return render(view:'index', model:[
        uid:acp?.userVO?.uid,
        password:password,
        lpwurl: lpwurl,
        sukaturl: sukaturl,
        hasCompletedCardOrder: acp.hasCompletedCardOrder,
        errorWhileOrderingCard: acp.errorWhileOrderingCard
    ])
  }

  def createNewAccountFlow = {

    prepareForwardAddress {
      action {
        EventLog eventLog
        AccountAndCardProcess acp = session.acp
        acp.step = STEP_ACCOUNT
        try {
          eventLog = utilityService.getEventLog(acp.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        String forwardAddress = ''
        /** Even if fetching forward address fails we should not fail here. */
        try {
          forwardAddress = ladokService.findForwardAddressSuggestionForPnr(acp.norEduPersonNIN)
        } catch (ex) {
          eventLog.logEvent("Failed when fetching forward address from Ladok: ${ex?.message}")
          log.error "Fetching forward address from LADOK failed.", ex
        }
        eventLog.logEvent("Fetched forward address from Ladok: $forwardAddress")
        [forwardAddress:forwardAddress]
      }
      on("success").to("activateAccount")
      on("error").to("errorHandler")
    }

    activateAccount {
      on("acceptAccountActivation") {
        flow.forwardAddress = params.forwardAddress
        flow.approveTermsOfUse = params?.approveTermsOfUse
      }.to("processEmailInput")
    }

    processEmailInput {
      action {
        EventLog eventLog
        AccountAndCardProcess acp = session.acp
        acp.step = STEP_ACCOUNT
        try {
          eventLog = utilityService.getEventLog(acp.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        if (!flow.approveTermsOfUse) {
          flow.error = g.message(code:'activateAccountAndCardController.errors.notHavingApprovedTermsOfUse')
          eventLog.logEvent("User did not accept the terms of use.")
          return retry()
        }

        if (!activateAccountAndCardService.validateForwardAddress((String)params?.forwardAddress)) {
          flow.error = g.message(code:'activateAccountAndCardController.errors.notHavingSuppliedValidForwardAddress')
          eventLog.logEvent("Invalid email for ${acp.norEduPersonNIN}: ${flow.forwardAddress}")
          return retry()
        }
      }
      on("success") {
        flow.error = ''
      }.to("createAccount")
      on("retry").to("activateAccount")
      on("error").to("errorHandler")
    }

    createAccount {
      action {

        EventLog eventLog
        AccountAndCardProcess acp = session.acp
        acp.step = STEP_ACCOUNT
        try {
          eventLog = utilityService.getEventLog(acp.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        SvcUidPwd result

        try {

          String forwardAddress = flow.forwardAddress

          SvcSuPersonVO user = acp.user
          String uid = user?.uid

          if (acp.isBrokenStub()) {
            String msg = "There is a user but the user has no uid, likely a broken stub."
            flow.error = msg
            eventLog.logEvent(msg)
            throw new IllegalStateException(msg)
          }

          if (acp.isNewUser()) {
            try {
              uid = sukatService.createSuPersonStub(user.givenName, user.sn, acp.norEduPersonNIN)
            } catch (ex) {
              eventLog.logEvent("Failed to create SUKAT stub for user with social security number: ${acp.norEduPersonNIN}")
              log.error "Failed to create SUKAT stub", ex
              flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
              return error()
            }
            eventLog.logEvent("SuPerson stub created with uid=${uid}")
          }

          try {
            sukatService.setMailRoutingAddress(uid, forwardAddress)
          } catch (ex) {
            eventLog.logEvent("Failed to set MailRoutingAddress for user with uid: $uid, ssn: ${acp.norEduPersonNIN}")
            log.error "Failed to set mailRoutingAddress for user with uid $uid", ex
            flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
            return error()
          }
          eventLog.logEvent("MailRoutingAddress updated for uid=${uid}")

          try {
            result = sukatService.activateUser(uid)
          } catch (ex) {
            eventLog.logEvent("Failed to activate user with uid: $uid")
            log.error "Failed to activate user with uid: $uid", ex
            flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
            return error()
          }
          eventLog.logEvent("User uid=${uid} activated")

          if (!result) {
            log.error "Failed when enrolling user"
            eventLog.logEvent("Failed to enroll user.")
            flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
            return error()
          }
        } catch(ex) {
          log.error "Failed when enrolling user", ex
          eventLog.logEvent("Failed to enroll user: ${ex?.message}")
          flow.error = g.message(code:'activateAccountAndCardController.errors.failedWhenEnrollingUser')
          return error()
        }

        /** Since we don't recieve a full account from the creation of an account we return the uid */

        acp.storeActivationResult(result)
        session.acp = acp
      }
      on("success").to("beforeEnd")
      on("error").to("errorHandler")
    }

    errorHandler {
      action {
        if (flash.stateException) {
          log.error "Webflow Exception occurred: ${flash.stateException}", flash.stateException as Throwable
        }
        flow.error = (flow.error)?:g.message(code:"activateAccountAndCardController.errors.genericError")

        /* On error we clear the AccountAndCardProcess object. */
        session.step = session.acp?.step
        session.acp = null
      }
      on("success").to("errorPage")
    }

    errorPage {
      on("continue"){
        flow.error = null
      }.to("dashboard")
    }

    dashboard() {
      /** We don't want to send the user back into the same flow that crashed so we send him / her to the dashboard */
      action {
        log.info "Account creation process failed, returning to dashboard."
        redirect(controller:'dashboard', action:'index')
      }
      on("success").to("end")
    }

    beforeEnd {
      action {
        log.info "Account creation succeeded, returning to index."
        redirect(action:'index')
      }
      on("success").to("end")
    }

    end() {
      // Ugly placeholder will never be shown
    }
  }

  def orderCardFlow = {

    prepareForwardOrderCard {
      action {
        EventLog eventLog
        AccountAndCardProcess acp = session.acp
        acp.step = STEP_CARD

        try {
          if (acp.referenceId) {
            eventLog = utilityService.getEventLog((long) acp.referenceId)
          } else {
            eventLog = utilityService.getEventLog()
            acp.referenceId = eventLog.id
          }
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        eventLog.logEvent "User started the card order flow."

        if (!acp.user?.uid) {
          eventLog.logEvent("User has no valid user in session, this should not happen. Value is currently set to ${acp.user}")
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.noAccount.error')
          return error()
        }

        // Set the users name from acp.user
        def givenName = acp.user?.givenName ?: ""
        def sn = acp.user?.sn ?: ""
        flow.userName = givenName + " " + sn

        try {
          def cardInfo = activateAccountAndCardService.getCardOrderStatus(acp.user)
          if (!cardInfo) {
            throw new IllegalStateException("Illegal cardInfo state, null or empty.")
          }
          flow.cardInfo = cardInfo
        } catch (ex) {
          log.error "Error when fetching card order status", ex
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.optionalError.errorWhenFetchingCardOrderStatus')
          eventLog.logEvent("Error when fetching card order status: ${ex?.message}")
          return error()
        }

        if (!flow.cardInfo?.canOrderCard) {
          if (!flow.cardInfo.hasAddress) {
            eventLog.logEvent("User can't order card cause: User is missing address.")
          } else if (flow.cardInfo.suCards) {
            eventLog.logEvent("User can't order card cause: User already has active card(s).")
          } else if (flow.cardInfo.cardOrders) {
            eventLog.logEvent("User can't order card cause: User already has active card order(s).")
          }
          return cantOrderCard()
        }

        return success()
      }
      on("success").to("cardOrder")
      on("error").to("errorHandler")
      on("cantOrderCard").to("cantOrderCard")
    }

    cantOrderCard {
      on("continue") {
        /** We consider this a successful completion of the flow since the user can't order a card */
        (session.acp as AccountAndCardProcess).hasCompletedCardOrder = true
      }.to("beforeEnd")
    }

    cardOrder {
      on("sendCardOrder"){
        flow.addressIsValid = params?.addressIsValid
        flow.acceptLibraryRules = params?.acceptLibraryRules
      }.to("processCardOrder")
    }

    cardOrderFailed {
      on("continue") {
        /** We consider this a successful completion of the flow since the user failed while ordering a card */
        (session.acp as AccountAndCardProcess).hasCompletedCardOrder = true
      }.to("beforeEnd")
    }

    processCardOrder {
      action {
        AccountAndCardProcess acp = session.acp
        acp.step = STEP_CARD
        EventLog eventLog
        try {
          eventLog = utilityService.getEventLog(acp.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        if (flow.addressIsValid == null) {
          flow.error = g.message(code:'activateAccountAndCardController.cardOrder.selectValidInvalid.error')
          eventLog.logEvent("User didn't select if address is valid or invalid")
          return error()
        }

        if (flow.addressIsValid == "1") {
          if (!flow.acceptLibraryRules) {
            flow.error = g.message(code: 'activateAccountAndCardController.cardOrder.approveTermsOfUse.error')
            eventLog.logEvent("User didn't approve terms of use")
            return error()
          }
          try {
            Map ladokAddress = flow.cardInfo?.ladokAddress
            sukatService.orderCard(acp.user, ladokAddress)
          } catch (ex) {
            log.error "Failed to order card", ex
            eventLog.logEvent("Failed to order card: ${ex.message}")
            return failed()
          }
        } else {
          eventLog.logEvent("User says address is invalid")
        }

        eventLog.logEvent "Card successfully ordered for ${acp?.user?.uid}."
        return success()
      }
      on('success'){
        flow.error = null
        (session.acp as AccountAndCardProcess).hasCompletedCardOrder = true
        (session.acp as AccountAndCardProcess).errorWhileOrderingCard = false
      }.to('beforeEnd')
      on('failed').to('cardOrderFailed')
      on('error').to('cardOrder')
    }

    errorHandler {
      action {
        if (flash.stateException) {
          log.error "Exception was thrown in the Order Card Flow", flash.stateException as Throwable
          flash.stateException = null
        }
        (session.acp as AccountAndCardProcess).error = (flow.error)?:g.message(code:"activateAccountAndCardController.errors.genericError")
        (session.acp as AccountAndCardProcess).errorWhileOrderingCard = true
      }
      on("success").to("beforeEnd")
    }

    beforeEnd() {
      action {
        session.acp?.step = STEP_END
        return redirect(action:'index')
      }
      on("success").to("end")
    }

    end() {
      // Placeholder
    }
  }
}
