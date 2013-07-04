<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Order University Card</title>
</head>
<body>
  <div class="apps-mid-column">
    <div class="float-left">

      <div class="prompt">
        <div>Adressuppgifter</div>
        <div>Förnamn - Efternamn</div>
        <div>Gata</div>
        <div>stad</div>

        <g:form>
          <g:radio name="registeredAddressValid" value="1"/>
            <label for="registeredAddressValid">Ovanstående adress stämmer - beställ och skicka kort</label><br/>

          <div class="indent-small">
            <g:checkBox name="acceptLibraryRules"/>
              <label for="acceptLibraryRules">Jag accepterar bibliotekets låneregler</label><br/>
          </div>

          <g:radio name="registeredAddressInvalid" value="0"/>
            <label for="registeredAddressInvalid">Ovanstående adress är felaktig - jag beställer kort när den är korrigerad</label><br/>

          <div class="align-right">
            <g:submitButton class="signupButton" name="sendCardOrder" value="${g.message(code:'activateAccountAndCardController.cardOrder.continue')}"/>
          </div>
        </g:form>
      </div>

      <div class="state_progress_img">
        <img src="${resource(dir: 'img', file: 'universitycard_activate_account.png')}" border="0"
             class="logotype" title="<g:message code='activateAccountAndCardController.step4.counter'/>">
      </div>
    </div>
  </div>
</body>
</html>