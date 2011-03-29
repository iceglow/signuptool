<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="status"/>
</head>
  <body>
    <div class="section">
      <h1>Status - ${System.getProperty('signuptool.hostname', 'unknown')} (${GrailsUtil.environment})</h1>
      MySQL Status: ${mysql_status}<br/>
      Grails Version: <g:meta name="app.grails.version"/><br/>
    </div>
  </body>
</html>