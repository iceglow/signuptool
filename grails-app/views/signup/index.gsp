<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>
<g:if test="${info}">
  <g:render template="information" model="[info:info]"/>
</g:if>

<a href="${link}">Till studera.nu</a>
<h1>${session.locale}</h1>
</body>
</html>
