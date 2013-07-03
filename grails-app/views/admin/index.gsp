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
<g:if test="${eventLogs}">
  <div>
    <p>Senaste raderna i eventlog</p>
    <table>
      <g:each in="${eventLogs}" var="eventLog">
        <tr><td>${eventLog.dateCreated}</td></tr>
      </g:each>
    </table>
  </div>
</g:if>
</body>
</html>