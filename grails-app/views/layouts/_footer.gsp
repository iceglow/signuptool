<%--
  Created by IntelliJ IDEA.
  User: tomma
  Date: Sep 8, 2010
  Time: 9:42:24 AM
  To change this template use File | Settings | File Templates.
--%>

<div id="ft">
  
  <div class="footer-right">
    <ul class="footer-links">
      <li>${grailsApplication?.metadata['app.name'] + " " + grailsApplication?.metadata['app.version']}</li>
      <li class="last-item"><g:link controller="section">Administration</g:link></li>
    </ul>
  </div>
  <div class="clear-float"></div>
  <div class="footer-bottom"></div>
</div>