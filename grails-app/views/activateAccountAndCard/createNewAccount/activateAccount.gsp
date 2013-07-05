<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <meta name="layout" content="main"/>
</head>
<body>
  <div class="apps-mid-column">
    <g:if test="${error}">
      <div class="error">${error}</div>
    </g:if>
    <div class="float-left">
      <div class="prompt">
        <p><g:message code="activateAccountAndCardController.activateAccount.promptText"/></p>

        <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'']}">

          <label for="forwardAddress"><g:message code="activateAccountAndCardController.activateAccount.forwardAddress"/></label>
          <a class="hint--right hint--info" data-hint="abcdefgh"><span class="help"></span></a>
          <br/>
          <g:textField name="forwardAddress" value="${forwardAddress}"/>

          <div class="clear-float"></div>

          <g:checkBox name="approveTermsOfUse" />
          <label for="approveTermsOfUse"><g:message code="activateAccountAndCardController.activateAccount.approveTermsOfUse"/></label>
          <a class="hint--right hint--info" data-hint="abcdefgh"><span class="help"></span></a>
          <div class="align-right">
            <g:submitButton class="signupButton" name="acceptAccountActivation" value="${g.message(code:'activateAccountAndCardController.activateAccount.activate')}"/>
          </div>
        </g:form>
      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: 'universityaccount_activate_account.png')}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step3.counter'/>">
      </div>
    </div>
  </div>
</body>
</html>