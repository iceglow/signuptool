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
<div>
  <g:form action="index" method="post">
    <label for="uid">UserId</label>: <g:textField name="uid" maxlength="10" size="15"/> <g:submitButton name="submit" value="Sök"/>
  </g:form>
</div>
<div>
  <g:form action="index" method="post">
    <label for="ssn">Personnummer</label>: <g:textField name="ssn" maxlength="13" size="15"/> <g:submitButton name="submit" value="Sök"/>
  </g:form>
</div>
<div>
  <g:form action="index" method="post">
    <label for="referenceId">ReferensId</label>: <g:textField name="referenceId" maxlength="15" size="15"/> <g:submitButton name="submit" value="Sök"/>
  </g:form>
</div>
<g:if test="${eventLogs}">
  <div>
    <p>Senaste raderna i eventlog</p>
    <table>
      <g:each in="${eventLogs}" var="eventLog">
        <tr>
          <td><g:formatDate format="yyyy-MM-dd HH:mm" date="${eventLog.dateCreated}"/></td>
          <td>${eventLog.description}</td>
          <td>${eventLog.referenceId}</td>
          <td>${eventLog.userId}</td>
        </tr>
      </g:each>
    </table>
  </div>
</g:if>
</body>
</html>