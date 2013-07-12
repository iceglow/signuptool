<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title><g:message code="activateAccountAndCard.hasInvalidAddress.title"/></title>
    <meta name="layout" content="main"/>
  </head>
  <body>
    <div class="apps-mid-column">
      <p><g:message code="activateAccountAndCard.hasInvalidAddress.text"/></p>
      <br/>
      <g:form>
        <g:submitButton name="continue" value="${g.message(code:'activateAccountAndCard.hasInvalidAddress.continue')}"/>
      </g:form>
    </div>
  </body>
</html>