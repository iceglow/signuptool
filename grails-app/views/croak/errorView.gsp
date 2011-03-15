<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title><g:message code="accountActivationError.pageTitle"/></title>

  </head>
  <body>

  <div class="section">
      <h1>${errorTitle}</h1>
  </div>
<div class="clear-float"></div>
  <div class="section">
    <p>${errorMessage}</p>
    <p><g:link controller="signup" action="${tryAgainAction ?: 'index'}" class="apps-add-bullet-back"><g:message code="accountActivationError.tryAgain.label"/></g:link></p>
  </div>


  </body>
</html>