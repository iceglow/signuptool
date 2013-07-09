<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>ResetPassword</title>
  </head>
  <body>
    <tmpl:/shared/feedback flash="${flash}"/>
    <g:message code="resetPasswordController.changePassword.newpassword"/>: ${flash?.password}
  </body>
</html>