<html>
  <head>
  <g:set var="entityName" value="${message(code: 'info.label')}" />
  </head>

  <body>
    <div class="section">
      <div class="apps-float-85">

        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      </div>
    </div>

    <div class="clear-float"></div>

	<div class="section">
    <div class="nav">
      <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
    </div>

    <div class="body">

      <div class="list">
        <table>
          <thead>
            <tr>
              <g:sortableColumn property="subject" title="${message(code: 'generic.subject.label')}" />
              <g:sortableColumn property="locationKey" title="${message(code: 'info.key.label')}" />
              <g:sortableColumn property="locale" title="${message(code: 'generic.locale.label')}" />
              <g:sortableColumn property="ladok" title="${message(code: 'generic.type.label')}" />
              <g:sortableColumn property="active" title="${message(code: 'generic.active.label')}" />
              <g:sortableColumn property="created" title="${message(code: 'generic.created.label')}" />
            </tr>
          </thead>

          <tbody>
            <g:each in="${infoInstanceList}" status="i" var="infoInstance">
              <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td><g:link action="edit" id="${infoInstance.id}">${fieldValue(bean: infoInstance, field: "subject")}</g:link></td>
                <td><g:message code="info.key.${infoInstance.locationKey}" /></td>
                <td><g:message code="generic.locale.${infoInstance.locale}" /></td>
                <td>${(fieldValue(bean: infoInstance, field: "ladok") == "true") ?g.message(code:'generic.ladok.label') :g.message(code:'generic.minastudier.label')}</td>
                <td><g:formatBoolean boolean="${infoInstance.active}" /></td>
                <td><g:formatDate format="${message(code:'default.date.format')}" date="${infoInstance.created}" /></td>
              </tr>
            </g:each>
          </tbody>

        </table>
      </div>

      <div class="paginateButtons">
        <g:paginate total="${infoInstanceTotal}" />
      </div>

    </div>
    </div>
  </body>
</html>
