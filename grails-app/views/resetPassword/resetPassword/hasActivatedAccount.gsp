<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Has active Account</title>
</head>
<body>
<tmpl:/shared/feedback flash="${flash}"/>
<div>
  <g:message code="resetPasswordController.changePassword.verifyquestion"/>
  <g:submitButton name="ok"><g:message code="resetPasswordController.changePassword.yesChange"/></g:submitButton>
  <g:submitButton name="skip"><g:message code="resetPasswordController.changePassword.noSkip"/></g:submitButton>
</div>
</body>
</html>