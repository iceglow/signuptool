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

<%@ page import="se.su.it.signuptool.ActivateAccountAndCardController" contentType="text/html;charset=UTF-8" %>
<g:applyLayout name="main">
  <html>
  <head>
    <title><g:layoutTitle/></title>
    <g:layoutHead/>
  </head>
  <body>
  <div id="MainLeft" class="main-columns-left">
    <tmpl:/shared/feedback flash="${flash}"/>

    <div class="float-left"></div>
    <h2><g:pageProperty name="page.flowHeader"/></h2>

    <g:if test="${g.pageProperty(name: 'page.flowPreamble')}">
      <p>
        <g:pageProperty name="page.flowPreamble"/>
      </p>
    </g:if>

    <g:pageProperty name="page.flowContent"/>

    <g:pageProperty name="page.flowBottom"/>
  </div>

  <div id="MainRight" class="main-columns-right">
  <g:if test="${! g.pageProperty(name: 'page.hideStepImage')}">
    <div class="state_progress_img">
      <% def step = session.step ?: session.acp?.step ?: ActivateAccountAndCardController.STEP_START %>
      <img src="${resource(dir: 'img', file: g.message(code: "activateAccountAndCardController.step${step}.image"))}" border="0"
           class="logotype" title="<g:message code='activateAccountAndCardController.step${step}.counter'/>">
    </div>
  </g:if>
  </div>
  </body>
  </html>
</g:applyLayout>
