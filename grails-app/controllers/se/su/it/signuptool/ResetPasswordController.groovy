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

import se.su.it.signuptool.commandobjects.ResetPasswordProcess
import se.su.it.svc.SvcSuPersonVO

class ResetPasswordController {
  def activateAccountAndCardService
  def sukatService
  def utilityService

  def index() {

    ResetPasswordProcess rpp = session.rpp

    if (!rpp) {
      rpp = new ResetPasswordProcess(
              eppn:request.eppn,
              norEduPersonNIN:request.norEduPersonNIN)
      session.rpp = rpp
    }

    EventLog eventLog

    if (rpp.referenceId) {
      try {
        eventLog = utilityService.getEventLog(rpp.referenceId)
      } catch (ex) {
        log.error "Failed to fetch eventLog for referenceId ${rpp.referenceId}", ex
        flash.error = g.message(code:'resetPassword.errors.genericError')
        return redirect(controller:'dashboard', action:'index')
      }
    } else {
      try {
        eventLog = utilityService.eventLog
        rpp.referenceId = eventLog?.id
      } catch (ex) {
        log.error "Failed to create new eventLog", ex
        flash.error = g.message(code:'resetPassword.errors.genericError')
        return redirect(controller:'dashboard', action:'index')
      }
    }

    if (!rpp.verified) {
      String scope = utilityService.getScopeFromEppn(rpp.eppn)
      switch(scope) {
        case "studera.nu":
          if (rpp.norEduPersonNIN) {
            rpp.verified = true
            eventLog.logEvent("verified account for ${rpp.eppn} with norEduPersonNIN ${rpp.norEduPersonNIN}")
          } else {
            eventLog.logEvent("unverified account for ${rpp.eppn}")
            flash.error = message(
                  code:'resetPasswordController.unverifiedAccount',
                  args:[rpp.eppn]) as String
            return redirect(controller:'dashboard', action:'index')
          }
          break
        default:
          eventLog.logEvent("no handled or valid scope supplied for ${rpp.eppn}")
          flash.error = message(
                  code:'resetPassword.noValidScopeFound',
                  args:[rpp.eppn]) as String
          return redirect(controller:'dashboard', action:'index')
      }
    }

    if (!eventLog?.userId) {
      eventLog.userId = rpp.norEduPersonNIN
      eventLog.save(flush:true)
    }

    /**
     * If the user isn't already in the session we find it either by ssn or uid and put it in the session.
     */
    if (!rpp.hasUser()) {
      try {
        List<SvcSuPersonVO> vos = sukatService.findUsersBySocialSecurityNumber(rpp.norEduPersonNIN)

        int voCount = (vos) ? vos?.size() : 0

        if (voCount > 1) {
          String msg = "Found multiple accounts with social security number based on norEduPersonNIN: ${rpp.norEduPersonNIN}. Aborting password reset."
          eventLog.logEvent(msg)
          log.error msg
          flash.error = g.message(code:'sukat.errors.multipleUsersForSSN')
          return redirect(controller:'dashboard', action:'index')
        } else if (voCount == 1) {
          rpp.user = vos?.first()
        }
      } catch (ex) {
        eventLog.logEvent("Failed when setting user in session for ${rpp?.user?.uid} with exception ${ex.message}")

        log.error "Failed when setting user in session", ex
        flash.error = message(
                code:'resetPassword.errorWhenFetchingUser',
                args:[rpp.norEduPersonNIN]) as String

        return redirect(controller:'dashboard', action:'index')
      }
    }

    if (!rpp.hasUser() || rpp.isStubUser()) {
      eventLog.logEvent("User with social security number ${rpp.norEduPersonNIN} doesnt have an account!")
      log.error "User with social security number ${rpp.norEduPersonNIN} doesnt have an account!"
      flash.error = g.message(code:'resetPassword.errors.userNotFound')
      return redirect(controller:'dashboard', action:'index')
    }

    eventLog.logEvent "Starting reset password for ${rpp?.user?.uid}."

    return redirect(action: 'resetPassword')
  }

  def resetPasswordFlow = {
    prepareConfirmResetPassword {
      action {
        flow.uid = (session?.rpp as ResetPasswordProcess)?.user?.uid
      }
      on('success').to('confirmResetPassword')
    }

    confirmResetPassword {
      on('ok').to('resetPassword')
    }

    resetPassword() {
      action {

        ResetPasswordProcess rpp = session.rpp
        EventLog eventLog
        try {
          eventLog = utilityService.getEventLog(rpp?.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        eventLog.logEvent "Attempting to reset password for ${rpp?.user?.uid}."

        try {
          rpp.password = sukatService.resetPassword(rpp?.user?.uid)
        } catch (ex) {
          flow.error = g.message(code:'resetPassword.errors.passwordResetFailed')
          log.error "Reset Password failed for user with uid ${rpp?.user?.uid}.", ex
          eventLog.logEvent("Reset Password failed for user with uid ${rpp?.user?.uid}: ${ex?.message}")
          return error()
        }

        eventLog.logEvent "Password reset successful."
      }
      on("success").to('prepareEnd')
      on("error").to("errorHandler")
    }

    errorHandler {
      action {
        if (flash.stateException) {
          log.error "Webflow Exception occurred: ${flash.stateException}", flash.stateException as Throwable
        }
      }
      on("success").to("errorPage")
    }

    errorPage {
      on("continue") {
        flow.error = null
      }.to("dashboard")
    }

    dashboard {
      action {
        return redirect(controller: 'dashboard', action:'index')
      }
      on("success").to("prepareEnd")
    }

    prepareEnd {
      action {
        flow.password = (session.rpp as ResetPasswordProcess)?.password
        flow.uid = (session.rpp as ResetPasswordProcess)?.user?.uid
      }
      on("success").to 'end'
    }

    end {}
  }
}
