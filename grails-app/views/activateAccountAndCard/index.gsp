<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <meta name="layout" content="main"/>
</head>
<body>
  <div class="apps-mid-column">
    <g:if test="${(session.hasCompletedCardOrder)}">
      <tmpl:endAccountAndCard model="[lpwurl:lpwurl]"/>
    </g:if>
    <g:else>
      <tmpl:/shared/showAccountInformation model="[password:password, uid:uid]"/>
    </g:else>
  </div>
</body>
</html>