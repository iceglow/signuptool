<!-- head -->
<div class="top-links apps-darkblue">
  <div class="clear-float"></div>
  <div class="top-links-left">
  </div>
  <div class="top-links-right">
    <ul>
      <li class="last-item"><g:link class="last-item" controller="signup" action="changeLanguage" params="${[c:params.controller, a:params.action, params:params]}">${g.message(code: 'application.toggle.language.label')}</g:link></li>
    </ul>
  </div>
  <div class="clear-float"></div>
</div>

<div id="head" class="head apps-darkblue">
  <div class="head-left">
    <a href="http://www.su.se/" accesskey="0" title="${g.message(code: 'application.su.label')}">
      <img class="logotype" src="${resource(dir: 'img', file: (session.locale == 'sv_SE') ? 'logo_su_se_big_dark_blue.gif' : 'logo_su_en_big_dark_blue.gif')}" alt="${g.message(code: 'application.su.label')}" title="${g.message(code: 'application.su.label')}" border="0"/>
    </a>
  </div>

  <div class="head-right">

    <img src='${resource(dir: 'img', file: (session.locale == 'sv_SE') ? 'app-logotype-signuptool-se.gif' : 'app-logotype-signuptool-en.gif')}' alt="${g.message(code: 'application.activate.su.account.label')}" title="${g.message(code: 'application.activate.su.account.label')}" border='0' class='department'/>

  </div>

  <div class="clear-float"></div>

  <div id="apps-headmargin">
    <div class="clear-float"></div>
  </div>
</div>
<!-- /head -->
