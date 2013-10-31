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
<html>
<head>
  <meta name="layout" content="activateFlow"/>
  <title><g:message code="activateAccountAndCardController.index.title" /></title>
</head>
<body>
<!-- showAccount: When hasCompletedCardOrder and errorWhileOrderingCard when both are false. -->
<g:set var="showAccountInfo" value="${!(hasCompletedCardOrder) && !(errorWhileOrderingCard)}"/>

<!-- showOrderCard: When hasCompletedCardOrder is false and errorWhileOrderingCard is true -->
<g:set var="showOrderCard" value="${!(hasCompletedCardOrder) || (errorWhileOrderingCard)}"/>

<content tag="flowHeader">
<g:if test="${showAccountInfo}">
  <g:message code="activateAccountAndCardController.hasActivatedAccount.accountActivated.header"/>
</g:if>
<g:else>
  <g:message code="activateAccountAndCard.endAccountAndCard.header"/>
</g:else>

</content>

<content tag="flowPreamble">
<g:if test="${showAccountInfo}">
  <g:message code="activateAccountAndCardController.hasActivatedAccount.accountActivated"/>
</g:if>
<g:else>
  <g:message code="activateAccountAndCard.endAccountAndCard.text"/>
</g:else>
</content>

<content tag="flowContent">
  <!-- Webreg:  When either hasCompletedCardOrder or errorWhileOrderingCard is true (when showAccountInfo == false) -->

  <g:if test="${showAccountInfo}">
    <tmpl:showAccountInformation model="[password:password, uid:uid]"/>
  </g:if>
  <g:else>
    <tmpl:endAccountAndCard model="[lpwurl:lpwurl]"/>
  </g:else>

  <div class="clear-float"></div>

  <div class="top-spacer-10">
  <g:if test="${showOrderCard}">
    <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'orderCard']}">
      <p><g:message code="activateAccountAndCardController.hasActivatedAccount.orderCard"/></p>
      <div class="align-right">
        <g:submitButton class="signupButton" name="orderCard" value="${g.message(code:'activateAccountAndCardController.hasActivatedAccount.card')}"/>
      </div>
    </g:form>
  </g:if>
  </div>
</content>
</body>
</html>
