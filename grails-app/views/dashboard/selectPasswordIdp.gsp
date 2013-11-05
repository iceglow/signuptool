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
  <title><g:message code="dashboardController.selectPasswordIdp.title" /></title>
</head>
<body>
<content tag="flowHeader">
  <g:message code="activateAccountAndCardController.selectPasswordIdp.header"/>
</content>

<content tag="flowPreamble">
  <g:message code="activateAccountAndCardController.selectPasswordIdp.text"/>
</content>

<content tag="flowContent">
  <div class="apps-colorbox2 mgn-bottom-20">
    <div class="header-id-provider">
      <g:message code="activateAccountAndCardController.idProvider.header.antagning"/>
    </div>
    <g:message code="activateAccountAndCardController.idProvider.promptText.antagning"/>
    <g:form url="/Shibboleth.sso/WAYF/antagning.se/produktion">
      <div class="align-right">
        <g:submitButton class="signupButton"
                        name="resetPassword"
                        alt="${g.message(code:'activateAccountAndCardController.idProvider.select')}"
                        value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"
        />
      </div>
    </g:form>
  </div>

  <div class="apps-colorbox2 mgn-bottom-20">
    <div class="header-id-provider">
      <g:message code="activateAccountAndCardController.idProvider.header.eduID"/>
    </div>
    <g:message code="activateAccountAndCardController.idProvider.promptText.eduID"/>
    <g:form url="#" onclick="return false;">
      <div class="align-right">
        <g:submitButton class="signupButton disabled"
                        name="resetPassword"
                        alt="${g.message(code:'activateAccountAndCardController.idProvider.select')}"
                        value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
      </div>
    </g:form>
  </div>

</content>

<sitemesh:parameter name="hideStepImage" value="true"/>
</body>
</html>
