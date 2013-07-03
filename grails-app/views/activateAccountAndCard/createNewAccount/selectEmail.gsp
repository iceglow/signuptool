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
        <div class="apps-float-30 mgn-left-20">
          <label for="forwardAddress"><g:message code="activateAccountAndCardController.forwardEmail.emailLabel"/></label>
        </div>
        <div class="apps-float-35">
          <g:textField name="forwardAddress" value="${forwardAddress}"/>
        </div>
        <div class="clear-float"></div>
        <div class="apps-float-5 mgn-left-20">
          <g:checkBox name="acceptSuConditions"/>
        </div>
        <div class="apps-float-40">
          <label for="acceptSuConditions"><g:message code="activateAccountAndCardController.forwardEmail.acceptLabel"/></label>
        </div>
        <div class="clear-float"></div>
        <g:submitButton name="activate" value="Aktivera"/>
      </g:form>
    </div>
  </div>
</body>
</html>