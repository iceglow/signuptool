<div class="float-left">
  <div class="prompt">
    <p><g:message code="activateAccountAndCardController.hasActivatedAccount.accountActivated"/></p>

    <div class="clear-float"></div>

    <div class="bordered-detail-square apps-float-50">
      <g:link action="" class="print-details">
        <span class="mgn-left-30"><g:message code="activateAccountAndCardController.hasActivatedAccount.print"/></span>
      </g:link>
      <div><g:message code="activateAccountAndCardController.hasActivatedAccount.username"/>: ${uid}</div>
      <g:if test="${password}">
        <div><g:message code="activateAccountAndCardController.hasActivatedAccount.password"/>: ${password}</div>
      </g:if>
      <g:else>
        <g:link controller="dashboard" action="resetAccountOrPassword">
          <g:message code="activateAccountAndCardController.forgotten_password"/>
        </g:link>
      </g:else>
    </div>

    <div class="clear-float"></div>

    <g:form id="activateAccountForm" url="${[controller:'activateAccountAndCard', action:'orderCard']}">
      <div class="align-right"><g:message code="activateAccountAndCardController.hasActivatedAccount.orderCard"/></div>
      <div class="align-right">
        <g:submitButton class="signupButton" name="orderCard" value="${g.message(code:'activateAccountAndCardController.hasActivatedAccount.card')}"/>
      </div>
    </g:form>
  </div>

  <div class="state_progress_img">
    <img src="${resource(dir: 'img', file: 'universityaccount_activate_account.png')}" border="0"
         class="logotype" title="<g:message code='activateAccountAndCardController.step3.counter'/>">
  </div>
</div>
