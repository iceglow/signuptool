<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Overifierat konto..</title>
  <meta name="layout" content="main"/>
</head>
  <body>
    <div class="apps-mid-column">
      <g:if test="${error}">
        <div class="error">${error}</div>
      </g:if>
    </div>
  </body>
</html>