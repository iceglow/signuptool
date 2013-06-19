<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Dashboard</title>
    <style>
      body {

      }
      #accountInfo {
        min-height: 40%;
        max-height: 40%;
        background: #bbb;
      }
      #cardInfo {
        min-height: 40%;
        max-height: 40%;
        background: #aaa;
      }
    </style>
  </head>
  <body>
  <div id="feedback">
    <g:if test="${flash.info}">
      ${flash.info}
    </g:if>
    <g:if test="${flash.info}">
      ${flash.error}
    </g:if>
  </div>

  <div id="accountInfo">

    </div>
    <div id="cardInfo">

    </div>
  </body>
</html>