<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Dashboard</title>
    <style>
      #accountInfo {
        min-width: 90%;
        min-height: 200px;
        background: #afd7e6;
      }
      #cardInfo {
        min-width: 90%;
        min-height: 200px;
        background: #ffa07a;
      }
      #webreg {
        min-width: 90%;
        min-height: 200px;
        background: #7aff8b;
      }

    </style>
  </head>
  <body>
    <tmpl:/shared/feedback flash="${flash}"/>
    <div id="accountInfo"><tmpl:accountInfo user="${user}" password="${password}"/></div>
    <div id="cardInfo"><tmpl:cardInfo user="${cardInfo}"/></div>
    <div id="webreg"><tmpl:webreg lpwurl="${lpwurl}" sukaturl="${sukaturl}"/></div>
  </body>
</html>