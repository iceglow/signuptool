<%@ page contentType="text/html;charset=UTF-8" %>
<a class="accessibility-link" id="content-top" name="content-top"></a>
<div class="section mgn-35">
  <div class="apps-content-block-inner">
    <g:each in="${info}" var="entry">
      <h1>${entry.subject}</h1>
      ${entry.body}
    </g:each>
  </div>
</div>
