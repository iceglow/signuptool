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
            <div class="align-right">
              <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
            </div>
          </g:link>
        </div>

      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: (session.locale =~ /sv_SE/) ? 'identify_activate_account_se.png' : 'identify_activate_account_en.png') }" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step2.counter'/>">
      </div>
    </div>
  </div>
</body>
</html>