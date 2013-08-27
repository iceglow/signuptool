<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title><g:message code="resetPassword.errorPage.title"/></title>
    <meta name="layout" content="main"/>
  </head>
  <body>
    <div id="section">
      <g:if test="${error}">
        <div class="error">${error}</div>
      </g:if>
      <div>
        <p><g:message code="resetPassword.errorPage.text"/></p>
        <g:form>
          <g:submitButton name="continue" value="${g.message(code:'resetPassword.errorPage.continue')}"/>
        </g:form>
      </div>
    </div>
  </body>
</html>