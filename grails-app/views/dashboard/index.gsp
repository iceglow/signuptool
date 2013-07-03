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

        <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'showSelectIdProvider']}">
          <div class="align-center">
            <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'dashboard.index.startActivateAccountButton')}"/>
          </div>
        </g:form>
      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: 'start_activate_account.png')}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step1.counter'/>">
      </div>

      <div class="large-bottom-spacer"></div>
    </div>
    <div class="clear-float"></div>
    <div class="section">
      <g:link url="http://sunet.se"><g:message code="dashboard.index.forgotPassword"/></g:link>
    </div>
  </div>
</body>
</html>