<g:if test="${request['javax.servlet.error.message']}">
  <span>${request['javax.servlet.error.message']}</span>
</g:if>
<g:else>
  <span><g:message code="errorHandler.unknown.error"/></span>
</g:else>