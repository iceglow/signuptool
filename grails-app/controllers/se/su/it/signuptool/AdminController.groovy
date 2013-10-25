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

class AdminController {

  def sukatService

  private static def useCases = [
    [id:"missingEppn",
        eppn:'',
        description:"useCases.missingEppn"],
    [id:"unknown",
        eppn:'unknown@unknown.se',
        description:"useCases.unhandledScope"],
    [id:"unverifiedAccount",
        eppn:"x@studera.nu",
        description:"useCases.unverifiedAccount"],
    [id:"multipleEntriesInSukat",
        eppn:"x@studera.nu",
        norEduPersonNIN:'1',
        description:"useCases.multipleEntriesInSukat"],
    [id:"errorWhenAskingSukatForUser",
        eppn:"x@studera.nu",
        norEduPersonNIN:'2',
        description:"useCases.errorWhenAskingSukatForUser"],
    [id:"noSUKATuserAndNotFoundInLADOK",
        eppn:"x@studera.nu",
        norEduPersonNIN:'3',
        description:"useCases.noSUKATuserAndNotFoundInLADOK"],
    [id:"hasActiveUserInSUKAT",
        eppn:"x@studera.nu",
        norEduPersonNIN:'4',
        description:"useCases.hasActiveUserInSUKAT"],
    [id:"creatingNewUserFromStub",
        eppn:"x@studera.nu",
        norEduPersonNIN:'5',
        description:"useCases.creatingNewUserFromStub"]

  ]

  def index() {
    [useCases:useCases.clone()]
  }

  def search(String searchFor, String searchText) {

    List eventLogs = []

    switch(searchFor) {
      case "referenceId":
        def eventLog = EventLog.get(searchText)
        if (eventLog) {
          eventLogs << eventLog
        }
        break
      case "norEduPersonNIN":
        eventLogs = EventLog.findAllByUserId(searchText, [sort:'dateCreated', order:'desc'])
        break
      default:
        break
    }
    if (eventLogs?.size() == 0) {
      return render(text:g.message(code:'admin.search.noResults.for', args:[searchText]))
    }
    return render(template: 'searchResults', collection: eventLogs, var: "eventLog")
  }

  def useCase(String caseName) {

    if (!caseName || !caseName in useCases*.id) {
      log.error "Case name needed"
      flash.error = "Case name needed: ${useCases*.id?.join(', ')}"
      return redirect(action:'index')
    }

    session.acp = null
    ActivateAccountAndCardController.AccountAndCardProcess acp = new ActivateAccountAndCardController.AccountAndCardProcess()
    acp.loadUseCase(getUseCase(caseName))
    session.acp = acp

    log.error "Prepared session: ${session.acp}"
    return redirect(controller:'activateAccountAndCard', action:'index')
  }

  def getUseCase(String name) {
    log.info "Requesting use case $name"
    return useCases.find { it.id == name }
  }
}
