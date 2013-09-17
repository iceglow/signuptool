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

class ResetPasswordController {
  def activateAccountAndCardService
  def sukatService
  def utilityService

  def index() {

    EventLog eventLog = utilityService.eventLog
    session.referenceId = eventLog?.id

    String scope = utilityService.getScopeFromEppn(request.eppn)

    switch(scope) {
      case "studera.nu":
        if (request.norEduPersonNIN) {
          session.nin = request.norEduPersonNIN
          eventLog.logEvent("verified account for ${request.eppn}, nin set to ${session.nin} from norEduPersonNIN")
        } else {
          eventLog.logEvent("unverified account for ${request.eppn}")
          return render(view:'/shared/unverifiedAccount', model:[referenceId:eventLog?.id])
        }
        break
      default:
        eventLog.logEvent("no handled or valid scope supplied for ${request.eppn}")
        flash.error = message(
            code:'activateAccountAndCardController.noValidScopeFound',
            args:[request?.eppn]) as String
        return redirect(controller:'dashboard', action:'index')
    }

    List<SvcSuPersonVO> users = []

    try {
      users = sukatService.findUsersBySocialSecurityNumber(session.nin)
    } catch (ex) {
      log.error "Failed to fetch user using social security number ${session.nin}", ex
      flash.error = g.message(code:'sukat.errors.errorWhenFetchingUser')
      return redirect(controller:'dashboard', action:'index')
    }

    if (users?.size() > 1) {
      eventLog.logEvent "Found multiple accounts with social security number ${session.nin}. Aborting password reset."
      log.error "Found multiple accounts with social security number ${session.nin}. Aborting password reset."
      flash.error = g.message(code:'sukat.errors.multipleUsersForSSN')
      return redirect(controller:'dashboard', action:'index')
    }

    if (!users || !users.first() || !users.first().accountIsActive) {
      eventLog.logEvent("User with social security number ${session.nin} doesnt have an account!")
      log.error "User with social security number ${session.nin} doesnt have an account!"
      flash.error = g.message(code:'resetPassword.errors.userNotFound')
      return redirect(controller:'dashboard', action:'index')
    }

    session.user = users.first()

    return redirect(action: 'resetPassword')
  }

  def resetPasswordFlow = {
    confirmResetPassword {
      on('ok').to('resetPassword')
    }

    resetPassword() {
      action {

        EventLog eventLog = null
        try {
          eventLog = utilityService.getEventLog(session.referenceId)
        } catch (ex) {
          log.error "Fetching EventLog failed", ex
          return error()
        }

        try {
          String uid = session?.user?.uid
          flash.password = sukatService.resetPassword(uid)
          flash.uid = session.user?.uid
        } catch (ex) {
          flow.error = g.message(code:'resetPassword.errors.passwordResetFailed')
          log.error "Reset Password failed for user with uid ${session?.user?.uid}.", ex
          eventLog.logEvent("Reset Password failed for user with uid ${session?.user?.uid}: ${ex?.message}")
          return error()
        }
      }
      on("success").to('end')
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
      on("success").to("end")
    }

    end() {
      [password:flash.password, uid:flash.uid]
    }
  }
}
