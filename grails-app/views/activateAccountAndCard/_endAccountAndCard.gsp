<div class="float-left">
  <div class="prompt">
    <div class="apps-float-80">
      <p><g:message code="activateAccountAndCard.endAccountAndCard.text"/></p>
    </div>

    <div class="clear-float"></div>

    <br/>

    <div class="align-right">
      <div><g:message code="activateAccountAndCard.endAccountAndCard.webreg.text"/></div>
      <g:link url="${lpwurl}">
        <g:submitButton class="signupButton"
                        name="toMinaStudier"
                        value="${g.message(code:'activateAccountAndCard.endAccountAndCard.webreg.button')}"/>
      </g:link>
    </div>
  </div>

  <div class="state_progress_img">
    <img src="${resource(dir: 'img', file: 'end_activate_account_se.png')}"
         border="0"
         class="logotype"
         title="<g:message code='activateAccountAndCardController.step5.counter'/>">
  </div>
</div>
