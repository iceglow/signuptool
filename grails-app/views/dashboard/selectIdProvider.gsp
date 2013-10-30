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
  <title><g:message code="dashboardController.selectIdProvider.title" /></title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
    $(function() {
      $("select[name=caseId]").on("change", function() {
        var id = $(this).val();
        $.ajax({
          url:"/dashboard/getUseCaseInfo",
          type:"POST",
          data:{caseId:id},
          success: function(data) {
            console.log(data);
            $("#useCaseDescription").html(data);
          },
          error: function(data) {
            $("#useCaseDescription").html("Failed when fetching use case information.");
          }
        })
      });
    });
  </script>
</head>
<body>
<content tag="flowPreamble">
  <g:message code="activateAccountAndCardController.selectIdProviderText"/>
</content>

<content tag="flowContent">
  <div class="bordered-detail-square mgn-bottom-20">
    <div class="header-id-provider">
      <g:message code="activateAccountAndCardController.idProvider.header.antagning"/>
    </div>
    <g:message code="activateAccountAndCardController.idProvider.promptText.antagning"/>
    <g:form url="/Shibboleth.sso/WAYF/antagning.se/produktion">
      <div class="align-right">
        <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
      </div>
    </g:form>
  </div>

  <div class="bordered-detail-square mgn-bottom-20">
    <div class="header-id-provider">
      <g:message code="activateAccountAndCardController.idProvider.header.eduID"/>
    </div>
    <g:message code="activateAccountAndCardController.idProvider.promptText.eduID"/>
    <g:form url="#">
      <div class="align-right">
        <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
      </div>
    </g:form>
  </div>

  <g:if test="${env == 'mock'}">
    <div id="useCases" class="bordered-detail-square mgn-bottom-20" >
      <div class="header-id-provider">
        <g:message code="activateAccountAndCardController.idProvider.header.mockup"/>
      </div>
      <g:message code="activateAccountAndCardController.idProvider.promptText.mockup"/>
      <g:form name="useCaseForm" action="useCase">
        <g:select name="caseId"
                  from="${useCases}"
                  optionKey="id"
                  optionValue="${{message(code:it.displayName)}}"

        />
        <div id="useCaseDescription">${useCase?.description}</div>
        <div class="align-right">
          <g:submitButton class="signupButton" name="run" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
        </div>
      </g:form>
    </div>
  </g:if>
</content>
</body>
</html>
