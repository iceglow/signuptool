<html>
  <head>

  </head>

  <body>
    <div class="section">
      <div class="apps-float-85">

        <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
      </div>
    </div>

    <div class="clear-float"></div>

    <div class="section">
    <div class="nav">
      <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
    </div>

    <div class="body">

      <g:form>
        <g:hiddenField name="id" value="${infoInstance?.id}" />
        <g:hiddenField name="version" value="${infoInstance?.version}" />
        <div class="dialog">
          <table>
            <tbody>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="subject"><g:message code="generic.subject.label" /></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'subject', 'errors')}">
                  <g:textField name="subject" value="${infoInstance?.subject}" />
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="body"><g:message code="generic.body.label" /></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'body', 'errors')}">
                  <g:textArea name="body" cols="80" rows="25" value="${infoInstance?.body}" />
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <g:message code="info.key.label" />
                </td>
                <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'locationKey', 'errors')}">
                  <g:select name="locationKey" from="${availableKeys}" valueMessagePrefix="info.key" value="${infoInstance?.locationKey }" />
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="locale"><g:message code="generic.locale.label" /></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'locale', 'errors')}">
                  <g:select name="locale" from="${infoInstance.constraints.locale.inList}" value="${infoInstance?.locale}" valueMessagePrefix="generic.locale"  />
                </td>
              </tr>

              <tr class="prop">
                <td><g:message code="generic.site.label"/></td>
                  <span>
                    <td>
                      <g:radioGroup name="ladok" labels="['application.minastudier.label','application.ladok.label']" values="[false,true]" value="${infoInstance?.ladok}">
                         ${it.radio} <g:message code="${it.label}"/>
                      </g:radioGroup>
                    </td>
                  </span>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="active"><g:message code="generic.active.label" /></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'active', 'errors')}">
                  <g:checkBox name="active" value="${infoInstance?.active}" />
                </td>
              </tr>

            </tbody>
          </table>
        </div>

        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label')}" /></span>
          <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');" /></span>
        </div>
      </g:form>
    </div>
    </div>
  </body>
</html>
