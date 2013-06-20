<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Dashboard</title>
    <style>
      body {
        min-width: 800px;
        min-height: 700px;
      }
      #accountInfo {
        min-width: 100%;
        min-height: 45%;
        background: lightblue;
      }
      #cardInfo {
        min-width: 100%;
        min-height: 45%;
        background: lightsalmon;
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

    <div id="accountInfo"></div>
    <div id="cardInfo"></div>
  </body>
</html>