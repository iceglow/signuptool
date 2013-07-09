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
    <div class="apps-float-15"><label for="ssn">Personnummer</label>: </div>
    <div class="apps-float-20"><g:textField name="ssn" maxlength="13" size="15"/></div>
    <div class="apps-float-10"><g:submitButton name="submit" value="Sök"/></div>
    <div class="clear-float"></div>
  </g:form>
</div>
<div>
  <g:form action="index" method="post">
    <div class="apps-float-15"><label for="referenceId">ReferensId</label>:</div>
    <div class="apps-float-20"><g:textField name="referenceId" maxlength="15" size="15"/></div>
    <div class="apps-float-10"><g:submitButton name="submit" value="Sök"/></div>
    <div class="clear-float"></div>
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