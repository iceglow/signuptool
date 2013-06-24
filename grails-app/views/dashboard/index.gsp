<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title><g:message code="application.title"/></title>
</head>
<body>

  <div class="section">
    <br/>
    <br/>
    <br/>
    <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'index']}">
      <g:submitButton class="button" name="submit" value="${g.message(code:'dashboard.index.activateAccountButton')}"/>
    </g:form>
  </div>
</body>
</html>