<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>

<content tag="leftCol">
  <p class="category"><g:message code="accountSetup.step2.counter"/></p>
  <p><strong><g:message code="accountSetup.step2.description"/></strong> <a title="<g:message code='accountSetup.step2.counter'/>"><img src="${resource(dir: 'img', file: 'card-progress-2of4.gif')}" alt="<g:message code='accountSetup.step2.counter'/>" border="0" class="logotype" title="<g:message code='accountSetup.step2.counter'/>"/></a></p>
</content>

<div class="section"><h1><g:message code="cardOrder.pageHeader"/></h1></div>
<g:form action="accountSetup">
  <div class="section mgn-bottom-20">
    <h2><g:message code="cardOrder.orderQuestion"/></h2>
    <div class="content-block apps-colorbox1 mgn-bottom-10">
      <div class="apps-content-block-inner">
        <div class="apps-float-40"><label><g:radio value="helpdesk" name="cardpickup" checked="${usd?.cardpickup.equalsIgnoreCase('helpdesk') ? 'checked':false}" /><g:message code="cardOrder.helpdesk.label"/></label></div>
        <div class="apps-float-50"><g:message code="cardOrder.helpdesk.desc"/></div>
        <div class="clear-float"></div>
      </div>
      <g:if test="${addrVo != null}">
        <div class="apps-content-block-inner">
          <div class="apps-float-40"><label><g:radio value="defaultAddress" name="cardpickup" checked="${usd?.cardpickup.equalsIgnoreCase('defaultAddress') ? 'checked':false}"/><g:message code="cardOrder.permAddr"/></label></div>
          <div class="apps-float-50">${attrs.givenName} ${attrs.sn}<br/><g:if test="${addrVo.coadr != null && !addrVo.coadr.isEmpty()}">${addrVo.coadr}<br/></g:if>${addrVo.gatadr}<br/>${addrVo.postnr} ${addrVo.ort}</div>
          <div class="clear-float"></div>
        </div>
      </g:if>
      <div class="apps-content-block-inner">
        <div class="apps-float-40"><label><g:radio value="otherAddress" name="cardpickup" checked="${usd?.cardpickup.equalsIgnoreCase('otherAddress') ? 'checked':false}"/><g:message code="cardOrder.otherAddr.label"/></label></div>
        <div class="apps-float-50"></div>
        <div class="clear-float"></div>
      </div>
      <div class="apps-content-block-inner">
        <div class="apps-float-40">&nbsp;</div>
        <div class="apps-float-20"><g:message code="address.careOf.label"/></div>
        <div class="apps-float-35"><g:textField name="coadr" value="${usd?.coadr}"/></div>
      </div>
      <div class="clear-float"></div>
      <div class="apps-content-block-inner">
        <div class="apps-float-40">&nbsp;</div>
        <div class="apps-float-20"><g:message code="address.street.label"/></div>
        <div class="apps-float-35"><g:textField name="gatadr" value="${usd?.gatadr}" class="${hasErrors(bean: usd, field:'gatadr', 'error')}"/></div>
      </div>
      <div class="clear-float"></div>
      <div class="apps-content-block-inner">
        <div class="apps-float-40">&nbsp;</div>
        <div class="apps-float-20"><g:message code="address.zip.label"/></div>
        <div class="apps-float-35"><g:textField name="postnr" size="6" value="${usd?.postnr}" class="${hasErrors(bean: usd, field:'postnr', 'error')}"/></div>
      </div>
      <div class="clear-float"></div>
      <div class="apps-content-block-inner">
        <div class="apps-float-40">&nbsp;</div>
        <div class="apps-float-20"><g:message code="address.location.label"/></div>
        <div class="apps-float-35"><g:textField name="ort" value="${usd?.ort}" class="${hasErrors(bean: usd, field:'ort', 'error')}"/></div>
      </div>
      <div class="clear-float">&nbsp;</div>
    </div>
  </div>

  <div class="section mgn-bottom-20">
    <h2><g:message code="emailChoice.question"/></h2>
    <div class="content-block apps-colorbox1 mgn-bottom-10">
      <div class="apps-content-block-inner">
        <div class="apps-float-40"><label><g:radio value="su" name="email" checked="${usd?.email.equalsIgnoreCase('su') ? 'checked':false}"/><g:message code="emailChoice.su.label"/></label></div>
        <div class="apps-float-50">${mail}<br/><span class="apps-hint-text"><g:message code="emailChoice.su.help"/></span></div>
      </div>
      <div class="clear-float"></div>
      <div class="apps-content-block-inner">
        <div class="apps-float-40"><label><g:radio value="other" name="email" checked="${usd?.email.equalsIgnoreCase('other') ? 'checked':false}"/><g:message code="emailChoice.other.label"/></label></div>
        <div class="apps-float-50"><g:textField name="otherEmail" value="${usd?.otherEmail}" class="${hasErrors(bean: usd, field:'otherEmail', 'error')}"/></div>
      </div>
      <div class="clear-float"></div>

    </div>
  </div>
  <div class="section align-right"><g:submitButton name="cardbutton" value="${g.message(code:'cardOrder.button.next.label')}"/></div>
</g:form>

</body>
</html>
