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
  <title></title>
</head>
<body>
<content tag="flowMainPreamble">
  <g:message code="activateAccountAndCardController.forwardEmail.explanation"/>
</content>

<content tag="flowMainContent">
  <g:form>
    <div class="apps-float-30 mgn-left-20">
      <label for="forwardAddress"><g:message code="activateAccountAndCardController.forwardEmail.emailLabel"/></label>
    </div>
    <div class="apps-float-35">
      <g:textField name="forwardAddress" value="${forwardAddress}"/>
    </div>
    <div class="clear-float"></div>
    <div class="apps-float-5 mgn-left-20">
      <g:checkBox name="acceptSuConditions"/>
    </div>
    <div class="apps-float-40">
      <label for="acceptSuConditions"><g:message code="activateAccountAndCardController.forwardEmail.acceptLabel"/></label>
    </div>
    <div class="clear-float"></div>
    <g:submitButton class="signupButton" name="activate" value="${g.message(code:"activateAccountAndCardController.activateButtonLabel")}"/>
  </g:form>
</content>
</body>
</html>
