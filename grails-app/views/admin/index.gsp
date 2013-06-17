<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Admin</title>
</head>
<body>
<g:if test="${flash.error}">
  <div style="color:red">
    ${flash.error}
  </div>
</g:if>
Admin area.
</body>
</html>