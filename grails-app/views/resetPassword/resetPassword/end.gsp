<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title><g:message code="resetPassword.passwordReset.title"/></title>
  <meta name="layout" content="main"/>
</head>
<body>
<div class="apps-mid-column">
  <div class="float-left">
    <div class="prompt">
      <p><g:message code="resetPassword.passwordReset.accountActivated"/></p>

      <div class="clear-float"></div>

      <div class="bordered-detail-square apps-float-50">
        <g:link action="" class="print-details">
          <span class="mgn-left-30"><g:message code="resetPassword.passwordReset.print"/></span>
        </g:link>
        <div><g:message code="resetPassword.passwordReset.username"/>: ${uid}</div>
        <g:if test="${password}">
          <div><g:message code="resetPassword.passwordReset.password"/>: ${password}</div>
        </g:if>
      </div>

      <div class="clear-float"></div>
    </div>
  </div>
</div>
</body>
</html>