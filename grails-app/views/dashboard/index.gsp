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
  <meta name="layout" content="main"/>
  <title><g:message code="application.title"/></title>
</head>
<body>
  <div class="apps-mid-column">
    <tmpl:/shared/feedback flash="${flash}"/>

    <div class="float-left bottom-divider">
      <div class="prompt">
        <p><g:message code="dashboard.index.activateAccountText"/></p>
        <br/>
        <br/>
        <g:link action="activateAccountAndCard">
          <div class="align-right">
            <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'dashboard.index.startActivateAccountButton')}"/>
          </div>
        </g:link>
      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: (session.locale =~ /sv_SE/) ? 'start_activate_account_se.png' : 'start_activate_account_en.png')}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step1.counter'/>">
      </div>

      <div class="large-bottom-spacer"></div>
    </div>
    <div class="clear-float"></div>
    <div class="section">
      <g:link action="resetAccountOrPassword"><g:message code="dashboard.index.forgotPassword"/></g:link>
    </div>
  </div>
</body>
</html>
