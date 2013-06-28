<div id="feedback">
  <g:if test="${flash.info}">
    <div>${flash.info}</div>
  </g:if>
  <g:if test="${flash.error}">
    <div class="error">${flash.error}</div>
  </g:if>
</div>