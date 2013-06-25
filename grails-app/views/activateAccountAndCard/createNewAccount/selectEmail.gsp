<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <meta name="layout" content="main"/>
</head>
<body>
  <div id="section">
    <g:if test="${error}">
      <div class="error">
        ${error}
      </div>
    </g:if>
    <div>
      <g:form>
        <label for="forwardAddress">Forwardadress</label>
        <g:textField name="forwardAddress" value="${forwardAddress}"/>
        <g:submitButton name="next" value="Vidare"/>
      </g:form>
    </div>
  </div>
</body>
</html>