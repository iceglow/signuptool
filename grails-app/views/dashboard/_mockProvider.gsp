<g:if test="${env == 'mock'}">
  <div id="useCases" class="apps-colorbox2 mgn-bottom-20" >
    <div class="header-id-provider">
      <g:message code="dashboardController.idProvider.mock.header"/>
    </div>
    <g:message code="dashboardController.idProvider.mock.promptText"/>
    <g:form name="useCaseAccountForm" action="useCase" class="mgn-bottom-10">
      <g:select name="caseId"
                from="${useCases}"
                value="${useCase}"
                optionKey="id"
                optionValue="${{message(code:it.type.toString()) + " - " + message(code:it.displayName)}}"

      />
      <div id="accountUseCaseDescription" class="useCaseDescription">${useCase?.description}</div>
      <div class="align-right">
        <g:submitButton class="signupButton" name="run" value="${g.message(code:'activateAccountAndCardController.idProvider.select')}"/>
      </div>
    </g:form>
  </div>
</g:if>
