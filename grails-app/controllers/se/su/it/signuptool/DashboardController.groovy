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

import grails.util.Environment
import se.su.it.signuptool.mock.UseCase

class DashboardController {

  def index() {
    if (session.controller) {

      /** Always remove stored controllers from the session */
      def savedController = session.controller
      session.controller = null

      /** But only redirect some controller pointers */
      if (savedController in ['activateAccountAndCard', 'resetPassword']) {
        return redirect(controller: savedController, action:'index')
      }
    }

    return render(view:'index')
  }

  def activateAccountAndCard() {
    session.controller = 'activateAccountAndCard'

    def env = Environment.current.name

    def useCases = UseCase.list()
    def useCase = (useCases) ? useCases?.first() : null

    return render(view:'selectIdProvider', model: [env:env, useCase:useCase, useCases:useCases])
  }

  def useCase(long caseId) {

    if (!Environment.current.name == "mock") {
      String errMsg = "Can't access this method outside mock environment."
      log.error errMsg
      flash.error = errMsg
      return redirect(action:'index')
    }

    UseCase useCase = UseCase.get(caseId)

    if (!useCase) {
      log.error "No use case found for id $caseId"
      flash.error = "Case $caseId is invalid, valid cases are ${UseCase.list()*.id?.join(', ')}"
      return redirect(action:'index')
    }

    session.acp = null
    ActivateAccountAndCardController.AccountAndCardProcess acp = new ActivateAccountAndCardController.AccountAndCardProcess()
    acp.loadUseCase(useCase)
    session.acp = acp

    log.error "Prepared session: ${session.acp}"
    return redirect(controller:'activateAccountAndCard', action:'index')
  }

  def getUseCaseInfo(long caseId) {
    return render(text:UseCase.get(caseId).description)
  }

  def resetAccountOrPassword() {
    session.controller = 'resetPassword'
    return render(view:'selectPasswordIdp')
  }
}
