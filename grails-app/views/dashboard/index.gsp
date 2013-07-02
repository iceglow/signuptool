<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title><g:message code="application.title"/></title>
</head>
<body>
  <div class="apps-mid-column">
    <div class="section bottom-divider">
      <tmpl:/shared/feedback flash="${flash}"/>
      <br/>
      <p><g:message code="dashboard.index.activateAccountText"/></p>
      <br/>
      <br/>
      <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'index']}">
        <div class="align-center">
          <g:submitButton class="signupButton" name="startAccountActivation" value="${g.message(code:'dashboard.index.startActivateAccountButton')}"/>
        </div>
      </g:form>

      <div class="large-bottom-spacer"></div>
    </div>
    <div class="section">
      <g:link url="http://sunet.se"><g:message code="dashboard.index.forgotPassword"/></g:link>
    </div>
  </div>
</body>
</html>