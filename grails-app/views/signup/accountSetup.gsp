<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>
<g:javascript>
function noterat(el) {
  var ms = document.getElementById("msContinue");
  if(el.checked)
  {
    ms.disabled = false;
  }
  else
  {
    ms.disabled = true;
  }
}
</g:javascript>
<div class="section">

  <div id="suErrors">

  </div>

  <h1><g:message code="accountSetup.pageHeader" /></h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
  <p><g:message code="accountSetup.header.accountInfo"/></p>
  <div class="content-block apps-colorbox-red mgn-bottom-10">
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark"><g:message code="generic.username.label"/></div>
      <div class="apps-float-60">${vo.uid}</div>
    </div>
    <div class="clear-float"></div>
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark"><g:message code="generic.password.label"/></div>
      <div class="apps-float-60">
        ${vo.password}
      </div>
    </div>
    <div class="clear-float"></div>
  </div>
  
  <p><em><g:message code="accountSetup.noSend.text"/></em></p>

  <div class="apps-content-block-inner">
    <g:form url="[action:'print']" name="printForm" target="_blank"></g:form>
    <input type="button" value="<g:message code='accountSetup.button.printAccount.label'/>" onclick="document.printForm.submit()" />
    <div class="clear-float"></div>
  </div>

  <div class="apps-content-block-inner">
    <div class="apps-float-30 label-grey-dark"><g:message code="generic.email.label"/></div>
    <div class="apps-float-60">${mail}</div>
	<div class="clear-float"></div>
  </div>
  
  <div class="apps-dotted-divider"></div>

</div>
<div class="section mgn-bottom-20">
  <h2><g:message code="accountSetup.lastStep.header"/></h2>

  <g:if test="${courseSuggestionList && courseSuggestionList.size() > 0}">

    <g:if test="${courseSuggestionList.size() == 1}">
      <p><g:message code="accountSetup.lastStep.info.oneCourse"/></p>
    </g:if>
    <g:else>
      <p><g:message code="accountSetup.lastStep.info" args="[courseSuggestionList.size()]"/></p>
    </g:else>

  </g:if>
  <g:else>
    <p><g:message code="accountSetup.noCourses.info"/></p>
  </g:else>

  <div class="clear-float"></div>
</div>
<g:if test="${courseSuggestionList}">
<div class="section">
  <em><g:message code="accountSetup.button.nextStep.hint"/></em><br />
  <input name="checkNoted" id="checkNotedId" type="checkbox" value="" onchange="noterat(this)">
  <label for="checkNotedId"><g:message code="accountSetup.password.checkBox.label"/></label>
</div>

<div class="section align-right">
  <input id="msContinue" disabled="disabled" name="" type="button" value="<g:message code='accountSetup.button.nextStep.label'/>" onclick="window.location.href = 'https://minastudier.su.se/registrate'"/>
  <br/>
  <div class="clear-float"></div>
</div>
</g:if>

</body>
</html>

