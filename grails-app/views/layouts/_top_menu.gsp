<div class="top-links apps-darkblue">
  <div class="clear-float"></div>

  <div class="top-links-right">
    <ul>
      <li class="last-item">
        <g:link
            class="last-item"
            controller="activateAccountAndCard"
            action="changeLanguage"
            params="${[c:params.controller, a:params.action, params:params]}">${g.message(code: 'application.toggle.language.label')}</g:link>
      </li>
    </ul>
  </div>

  <div class="clear-float"></div>
</div>