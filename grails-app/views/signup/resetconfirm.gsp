<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>

<div class="section">

  <div id="suErrors">

  </div>

  <h1><g:message code="accountResetConfirmation.pageHeader"/></h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
  <h2><g:message code="accountResetConfirmation.info.header"/></h2>
  <div class="content-block apps-colorbox1 mgn-bottom-10">
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark"><g:message code="generic.username.label"/></div>
      <div class="apps-float-60">${vo.uid}</div>
    </div>
    <div class="clear-float"></div>
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark"><g:message code="generic.password.label"/></div>
      <div class="apps-float-60">
        ${vo.password}</div>
    </div>
    <div class="clear-float"></div>
  </div>

  <div class="apps-content-block-inner"></div>
  <div class="clear-float"></div>
  <div class="clear-float"></div>
  <div class="apps-content-block-inner">
    <g:form url="[action:'print']" name="printForm" target="_blank"></g:form>
    <input type="button" value="<g:message code='accountSetup.button.printAccount.label'/>" onclick="document.printForm.submit()" />
    <div class="clear-float"></div>
  </div>
  <div class="apps-dotted-divider"></div>

</div>
<div class="section">
  <h2><g:message code="accountResetConfirmation.change.header"/></h2>
  <p><g:message code="accountResetConfirmation.changePassword.text"/></p>
</div>

</body>
</html>
