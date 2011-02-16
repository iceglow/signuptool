<html>
<head>
  <g:set var="entityName" value="${message(code: 'info.label')}"/>
</head>

<body>
<div class="section">
  <div class="apps-float-85">

    <h1><g:message code="info.edit.label" args="[entityName]"/></h1>
  </div>
</div>

<div class="clear-float"></div>

<div class="section">
  <div class="nav">
    <span class="menuButton"><g:link class="list" action="list"><g:message code="info.list.label" args="[entityName]"/></g:link></span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="info.new.label" args="[entityName]"/></g:link></span>
  </div>

  <div class="body">

    <g:form>
      <g:hiddenField name="id" value="${infoInstance?.id}"/>
      <g:hiddenField name="version" value="${infoInstance?.version}"/>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="subject"><g:message code="info.subject.label"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'subject', 'errors')}">
              <g:textField name="subject" value="${infoInstance?.subject}"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="body"><g:message code="info.body.label"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'body', 'errors')}">
              <g:textArea name="body" cols="80" rows="25" value="${infoInstance?.body}"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="locale"><g:message code="info.locale.label"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'locale', 'errors')}">
              <g:select name="locale" from="${infoInstance.constraints.locale.inList}" value="${infoInstance?.locale}" valueMessagePrefix="info.locale"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <g:message code="info.sitekey.label"/>
            </td>
            <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'siteKey', 'errors')}">
              <g:select name="siteKey" from="${availableSiteKeys}" valueMessagePrefix="info.sitekey" value="${infoInstance?.siteKey }"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="active"><g:message code="info.active.label"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: infoInstance, field: 'active', 'errors')}">
              <g:checkBox name="active" value="${infoInstance?.active}"/>
            </td>
          </tr>

          </tbody>
        </table>
      </div>

      <div class="buttons">
        <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'info.update.label')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'info.delete.label')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"/></span>
      </div>
    </g:form>
  </div>
</div>
</body>
</html>
