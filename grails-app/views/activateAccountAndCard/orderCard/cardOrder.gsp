%{--
  - Copyright (c) 2013, IT Services, Stockholm University
  - All rights reserved.
  -
  - Redistribution and use in source and binary forms, with or without
  - modification, are permitted provided that the following conditions are met:
  -
  - Redistributions of source code must retain the above copyright notice, this
  - list of conditions and the following disclaimer.
  -
  - Redistributions in binary form must reproduce the above copyright notice,
  - this list of conditions and the following disclaimer in the documentation
  - and/or other materials provided with the distribution.
  -
  - Neither the name of Stockholm University nor the names of its contributors
  - may be used to endorse or promote products derived from this software
  - without specific prior written permission.
  -
  - THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  - AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  - IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  - ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
  - LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  - CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  - SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
  - INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
  - CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  - ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  - POSSIBILITY OF SUCH DAMAGE.
  --}%

<%@ page contentType="text/html;charset=UTF-8" %>
<g:applyLayout name="activateFlow"/>
<head>
  <title>Order University Card</title>
</head>
<content tag="flow.prompt">
        <div><g:message code="activateAccountAndCardController.cardOrder.addressDetail"/></div>
        <div>${session?.user?.givenName} ${session?.user?.sn}</div>
        <div>${cardInfo?.ladokAddress?.gatadr}</div>
        <g:if test="${cardInfo?.ladokAddress?.coadr}">
          <div>${cardInfo?.ladokAddress?.coadr}</div>
        </g:if>
        <div>${cardInfo?.ladokAddress?.postnr} ${cardInfo?.ladokAddress?.ort}</div>

        <g:form>
          <g:radio id="registeredAddressValid" name="addressIsValid" value="1" checked="${(addressIsValid == "1")}"/>
            <label for="registeredAddressValid">
              <g:message code="activateAccountAndCardController.cardOrder.registeredAddressValid"/>
            </label>
            <a href="#" title="${g.message(code:"activateAccountAndCardController.cardOrder.registeredAddressValid.tooltip")}">
              <span class="help"></span>
            </a>
          <br/>

          <div class="indent-small">
            <g:checkBox name="acceptLibraryRules" value="${acceptLibraryRules}"/>
              <label for="acceptLibraryRules">
            <g:message code="activateAccountAndCardController.cardOrder.acceptLibraryRules"/>
            </label>
            <br/>
          </div>

          <g:radio id="registeredAddressInvalid" name="addressIsValid" value="0"/>
          <label for="registeredAddressInvalid">
            <g:message code="activateAccountAndCardController.cardOrder.registeredAddressInvalid"/>
          </label>

          <br/>

          <div class="align-right">
            <g:submitButton class="signupButton" name="sendCardOrder" value="${g.message(code:'activateAccountAndCardController.cardOrder.continue')}"/>
          </div>
        </g:form>
</content>

<content tag="flow.step.image">
        <img src="${resource(dir: 'img', file: g.message(code: 'activateAccountAndCardController.step4.image'))}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step4.counter'/>">
</content>
