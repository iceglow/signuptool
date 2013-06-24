<g:render template="/layouts/top_menu"/>
<div id="head" class="head">

  <div class="clear-float"></div>

  <div class="head-left">
    <a href="http://www.su.se/" title="${g.message(code: 'layout.su.logo.alternative.name')}">
      <img class="logotype"
           src="${resource(dir: 'img', file: (request.getLocale() =~ /sv_SE/) ? 'logo_su_se_big_dark_blue.gif' : 'logo_su_en_big_dark_blue.gif')}"
           alt="${g.message(code: 'layout.su.logo.alternative.name')}" border="0"/>
    </a>
  </div>

  <div class="head-right">
    <img class=department
         src="${resource(dir: 'img', file: (request.getLocale() =~ /sv_SE/) ? 'app-logotype-signuptool-se.gif' : 'app-logotype-signuptool-en.gif')}"
         alt="${g.message(code: 'application.title')}" title="${g.message(code: 'application.title')}" border="0"/>
  </div>

  <div class="clear-float"></div>

  <div id="apps-headmargin">
    <div class="clear-float"></div>
  </div>
</div>