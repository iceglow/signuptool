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
  <h2><g:message code="accountSetup.header.accountInfo"/></h2>
  <div class="content-block apps-colorbox1 mgn-bottom-10">
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

  <div class="apps-content-block-inner">
    <div class="apps-float-30 label-grey-dark"><g:message code="generic.email.label"/></div>
    <div class="apps-float-60">${mail}</div>
	<div class="clear-float"></div>
  </div>
  
  <div class="apps-content-block-inner">
    <g:form url="[action:'print']" name="printForm" target="_blank"></g:form>
    <input type="button" value="<g:message code='accountSetup.button.printAccount.label'/>" onclick="document.printForm.submit()" />
    <div class="clear-float"></div>
  </div>
  <div class="apps-dotted-divider"></div>

</div>
<div class="section mgn-bottom-20">
  <h2><g:message code="accountSetup.lastStep.header"/></h2>

  <g:if test="${courseSuggestionList}">
    <p><g:message code="accountSetup.lastStep.info"/></p>

    <table width="100%" border="0" cellspacing="0" cellpadding="0" summary="Summary">
      <caption><g:message code="accountSetup.table.caption"/></caption>
      <thead>
        <tr>
          <th><g:message code="generic.courseName.label"/></th>
          <th><g:message code="generic.credits.label"/></th>
          <th><g:message code="generic.courseCode.label"/></th>
          %{--<th>Termin</th>--}%
          %{--<th>Kurstakt</th>--}%
          %{--<th>Kurstid</th>--}%
        </tr>
      </thead>

      <tbody>
        <g:each in="${courseSuggestionList}" status="i" var="courseVO">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td><su:localizedString sv="${courseVO.kursbenamn}" en="${courseVO.kursbenamne}" /></td>
            <td>${courseVO.poang }</td>
            <td>${courseVO.kurskod}</td>
            %{--<td>${courseVO.termin}</td>--}%
            %{--<td>${courseVO.kurstakt }%</td>--}%
            %{--<td><su:showProperTime time="${courseVO.kurstid}" /></td>--}%
          </tr>
        </g:each>
      </tbody>
    </table>

  </g:if>
  <g:else>
    <p><g:message code="accountSetup.noCourses.info"/></p>
  </g:else>

  <div class="clear-float"></div>
</div>
<g:if test="${courseSuggestionList}">
<div class="section apps-dialogue-red-simple">
  <g:message code="accountSetup.button.nextStep.hint"/>
</div>
<div class="section align-right">
  <input name="checkNoted" id="checkNotedId" type="checkbox" value="" onchange="noterat(this)">
  <label for="checkNotedId"><g:message code="accountSetup.password.checkBox.label"/>&nbsp;</label>
  <input id="msContinue" disabled="disabled" name="" type="button" value="<g:message code='accountSetup.button.nextStep.label'/>" onclick="window.location.href = 'https://minastudier.su.se/registrate'"/>
  <br/>
  <div class="clear-float"></div>
</div>
</g:if>

</body>
</html>

