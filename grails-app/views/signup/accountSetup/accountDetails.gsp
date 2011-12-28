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

<content tag="leftCol">
<p class="category"><g:message code="accountSetup.step4.counter"/></p>
<p><a title="<g:message code='accountSetup.step4.counter'/>"><img src="${resource(dir: 'img', file: 'card-progress-4of5.gif')}" alt="<g:message code='accountSetup.step4.counter'/>" border="0" class="logotype" title="<g:message code='accountSetup.step4.counter'/>" /></a></p>
</content>

<div class="section">

  <div id="suErrors">

  </div>

  <g:if test="${canOrderCard}">
    <h1><g:message code="accountSetup.pageHeader" /></h1>
  </g:if>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
<h2><g:message code="accountSetup.confirmation.Info"/></h2>
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
    <input type="button" value="<g:message code='accountSetup.button.printAccount.label'/>" onClick="document.printForm.submit()" />
    <div class="clear-float"></div>
	<div class="apps-dotted-divider"></div>
  </div>

  <div class="apps-content-block-inner">
    <div class="apps-float-30 label-grey-dark"><g:message code="generic.email.label"/></div>
    <div class="apps-float-60">${mail}</div>
    <g:if test="${usd?.shouldUseOtherEmail()}">
      <div class="apps-float-30 label-grey-dark"><g:message code="generic.delivered.to"/></div>
      <div class="apps-float-60">${usd.otherEmail}</div>
    </g:if>
	<div class="clear-float"></div>
  </div>

  <div class="apps-content-block-inner">
    <div class="apps-float-30 label-grey-dark"><g:message code="generic.universityCard.label"/></div>
    <g:if test="${canOrderCard}">
     <div class="apps-float-60">${(usd?.shouldDeliverDefaultAddress() || usd?.shouldDeliverOtherAddress()) ? g.message(code: 'generic.universityCard.deliver.address.label'):g.message(code: 'generic.universityCard.deliver.helpDesk.label')}<br />
    <g:if test="${usd?.shouldDeliverOtherAddress()}">
      ${attrs?.givenName + "&nbsp;" + attrs?.sn}<br />
      ${usd?.coadr}<br />
      ${usd?.gatadr}<br />
      ${usd?.postnr + "&nbsp;" + usd?.ort}<br />
    </g:if>
    <g:if test="${usd?.shouldDeliverDefaultAddress()}">
      ${attrs?.givenName + "&nbsp;" + attrs?.sn}<br />
      ${addrVo?.coadr}<br />
      ${addrVo?.gatadr}<br />
      ${addrVo?.postnr + "&nbsp;" + addrVo?.ort}<br />
    </g:if>
    </div>
   </g:if>
   <g:else>
     <div class="apps-float-60"><g:message code='cardOrder.cannotOrderInfo'/></div>
   </g:else>
  <div class="clear-float"></div>
  </div>
  
  <div class="apps-dotted-divider"></div>

</div>
<div class="section mgn-bottom-20">
  <h2><g:message code="accountSetup.lastStep.header"/></h2>

  <g:if test="${courseSuggestionList != null}">

    <g:if test="${courseSuggestionList.size() == 0}">
      <p><g:message code="accountSetup.noCourses.info"/></p>
    </g:if>
    <g:elseif test="${courseSuggestionList.size() == 1}">
      <p><g:message code="accountSetup.lastStep.info.oneCourse"/></p>
    </g:elseif>
    <g:else>
      <p><g:message code="accountSetup.lastStep.info" args="[courseSuggestionList.size()]"/></p>
    </g:else>

  </g:if>
  <g:else>
    <p><g:message code="accountSetup.lpwFailed.info"/></p>
  </g:else>

  <div class="clear-float"></div>
</div>
<g:if test="${courseSuggestionList != null}">
<div class="section">
  <em><g:message code="accountSetup.button.nextStep.hint"/></em><br />
  <input name="checkNoted" id="checkNotedId" type="checkbox" value="" onClick="noterat(this)" onChange="noterat(this)">
  <label for="checkNotedId"><g:message code="accountSetup.password.checkBox.label"/></label>
</div>

<div class="section align-right">
  <input id="msContinue" disabled="disabled" name="" type="button" value="<g:message code='accountSetup.button.nextStep.label'/>" onClick="window.location.href = 'https://minastudier.su.se/registrate'"/>
  <br/>
  <div class="clear-float"></div>
</div>
</g:if>

</body>
</html>

