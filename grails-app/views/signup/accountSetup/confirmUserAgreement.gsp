<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>

<body>

<content tag="leftCol">
  <p class="category"><g:message code="accountSetup.step2.counter"/></p>

  <p><strong><g:message code="accountSetup.step2.description"/></strong> <a
    title="<g:message code='accountSetup.step2.counter'/>"><img
      src="${resource(dir: 'img', file: 'card-progress-2of4.gif')}" alt="<g:message code='accountSetup.step2.counter'/>"
      border="0" class="logotype" title="<g:message code='accountSetup.step2.counter'/>"/></a></p>
</content>

<div class="section"><h1><g:message code="accountSetup.confirmUserAgreement.heading.label"/></h1></div>
<g:form action="accountSetup">
  <div class="section mgn-bottom-20">
    <h2><g:message code="accountSetup.confirmUserAgreement.subject1.label"/></h2>

    <div class="content-block apps-colorbox0 mgn-bottom-10">

    </div>
  </div>

  <div class="section mgn-bottom-20">
    <h2><g:message code="accountSetup.confirmUserAgreement.subject2.label"/></h2>

    <div class="content-block apps-colorbox0 mgn-bottom-10">

    </div>
  </div>

  <div class="section align-right">
    <label for="chkagreement">
      <g:message code="accountSetup.confirmUserAgreement.checkboxAgree.label" />
    </label>
    <g:checkBox name="chkagreement" value="triggered" />
    <g:submitButton name="confirmbutton" value="${g.message(code:'accountSetup.confirmUserAgreement.confirmButton.label')}"/>
  </div>
</g:form>

</body>
</html>
