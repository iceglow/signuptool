<h2><g:message code="admin.result.referenceId" args="${eventLog?.id}"/></h2>
<ul>
  <g:each in="${eventLog?.events}" var="event">
    <li>${event.dateCreated}: ${event?.description}</li>
  </g:each>
</ul>
