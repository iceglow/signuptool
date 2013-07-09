<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Has active Account</title>
  </head>
  <body>
    <tmpl:/shared/feedback flash="${flash}"/>
    <div>
      <g:form id="resetPassWord">
        <div>
          <label><g:message code="resetPasswordController.changePassword.verifyquestion"/></label>
        </div>
        <div>
          <g:submitButton class="signupButton" name="ok" value="${g.message(code:'resetPasswordController.changePassword.yesChange')}"/>
          <g:submitButton class="signupButton" name="skip" value="${g.message(code:'resetPasswordController.changePassword.noSkip')}"/>
        </div>
      </g:form>
    </div>
  </body>
</html>