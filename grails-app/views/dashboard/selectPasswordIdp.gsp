<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <meta name="layout" content="main"/>
</head>
<body>
  <div class="apps-mid-column">
    <div class="float-left">
      <div class="prompt">
        <p><g:message code="activateAccountAndCardController.selectIdProviderText"/></p>
        <div class="bordered-detail-square">
          <div class="header-id-provider">
            <g:message code="activateAccountAndCardController.idProvider.header.antagning"/>
          </div>
          <g:message code="activateAccountAndCardController.idProvider.promptText.antagning"/>
          <g:link url="/Shibboleth.sso/WAYF/antagning.se/produktion">
            <div class="align-center">
              <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
            </div>
          </g:link>
        </div>

      </div>
    </div>
  </div>
</body>
</html>