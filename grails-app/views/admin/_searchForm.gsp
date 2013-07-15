<g:form>
  <g:textField id="searchText" name="searchText" placeholder="${g.message(code:'admin.searchPlaceholder')}"/>

  <g:radioGroup
      values="[
          'referenceId',
          'socialSecurityNumber'
      ]" labels="[
      g.message(code:'admin.searchFor.referenceId'),
      g.message(code:'admin.searchFor.socialSecurityNumber')
  ]" name="searchFor" value="referenceId">
    <p>${it.radio} ${it.label}</p>
  </g:radioGroup>

  <g:submitButton class="float-right" name="search" value="${g.message(code:'admin.search')}"/>
  <div class="clear-float"></div>
</g:form>
