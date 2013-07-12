<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title></title>
  </head>
  <body>
    <tmpl:/shared/feedback flash="${flash}"/>
    <div>
      <div class="bordered-detail-square apps-float-50">
        <g:link action="" class="print-details">
          <span class="mgn-left-30"><g:message code="resetPassword.passwordReset.print"/></span>
        </g:link>
        <div><g:message code="resetPassword.passwordReset.username"/>: ${session?.user?.uid}</div>
      </div>

      <div class="clear-float"></div>

      <g:form id="resetPassWord">
        <div>
          <label><g:message code="resetPasswordController.changePassword.verifyquestion"/></label>
        </div>
        <div>
          <g:submitButton class="signupButton" name="ok" value="${g.message(code:'resetPasswordController.changePassword.yesChange')}"/>
        </div>
      </g:form>
    </div>
  </body>
</html>