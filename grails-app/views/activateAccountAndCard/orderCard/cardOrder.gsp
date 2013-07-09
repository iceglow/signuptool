<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Order University Card</title>
</head>
<body>
  <div class="apps-mid-column">
    <g:if test="${error}">
      <div class="error">${error}</div>
    </g:if>

    <div class="float-left">

      <div class="prompt">
        <div><g:message code="activateAccountAndCardController.cardOrder.addressDetail"/></div>
        <div>${session?.givenName} ${session?.sn}</div>
        <div>${session?.street}</div>
        <g:if test="${session?.coAddr}">
          <div>${session?.coAddr}</div>
        </g:if>
        <div>${session?.zip} ${session?.city}</div>

        <g:form>
          <g:radio name="registeredAddressValid" value="1"/>
            <label for="registeredAddressValid"><g:message code="activateAccountAndCardController.cardOrder.registeredAddressValid"/></label>
            <a href="#" title="<g:message code="activateAccountAndCardController.cardOrder.registeredAddressValid.tooltip"/>"><span class="help"></span></a>
          <br/>

          <div class="indent-small">
            <g:checkBox name="acceptLibraryRules"/>
              <label for="acceptLibraryRules"><g:message code="activateAccountAndCardController.cardOrder.acceptLibraryRules"/></label><br/>
          </div>

          <g:radio name="registeredAddressInvalid" value="0"/>
            <label for="registeredAddressInvalid"><g:message code="activateAccountAndCardController.cardOrder.registeredAddressInvalid"/></label><br/>

          <div class="align-right">
            <g:submitButton class="signupButton" name="sendCardOrder" value="${g.message(code:'activateAccountAndCardController.cardOrder.continue')}"/>
          </div>
        </g:form>
      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: 'universitycard_activate_account.png')}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step4.counter'/>">
      </div>
    </div>
  </div>
</body>
</html>