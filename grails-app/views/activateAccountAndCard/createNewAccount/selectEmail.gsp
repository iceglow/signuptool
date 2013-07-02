<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <meta name="layout" content="main"/>
</head>
<body>
  <div id="section">
    <g:if test="${error}">
      <div class="error">${error}</div>
    </g:if>
    <div>
      <p><g:message code="activateAccountAndCardController.forwardEmail.explanation"/></p>
      <g:form>
        <div>
          <label for="forwardAddress"><g:message code="activateAccountAndCardController.forwardEmail.emailLabel"/></label>
          <g:textField name="forwardAddress" value="${forwardAddress}"/>
        </div>
        <div>
          <g:checkBox name="acceptSuConditions"/>
          <label for="acceptSuConditions"><g:message code="activateAccountAndCardController.forwardEmail.acceptLabel"/></label>
        </div>
        <g:submitButton name="activate" value="Aktivera"/>
      </g:form>
    </div>
  </div>
</body>
</html>