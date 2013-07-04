<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title></title>
</head>
<body>
<div class="apps-mid-column">
  <div class="float-left">
    <div class="prompt">
      <div class="apps-float-80">
        <div>Kortuppgifter</div>
        <div>Kort är beställt och levereras till din adress tidigast om en vecka</div>

        <br/>

        <div>Nu kan du:</div>
        <div>Registrera dig på kurser i <g:link url="">Mina studier</g:link></div>
        <div>Aktivera åtkomst till det trådlösa nätverket (eduroam) i <g:link url="">Kontohantering</g:link></div>

        <br/>

        <div>Övriga tjänster hittar du på <g:link url="">Mitt universitet</g:link></div>
      </div>

      <div class="clear-float"></div>

      <br/>

      <div class="align-right">
        <div>Registrera dig på kurser i</div>
        <g:link url="">
          <g:submitButton class="signupButton" name="toMinaStudier" value="Mina Studier"/>
        </g:link>
    </div>
    </div>

    <div class="state_progress_img">
      <img src="${resource(dir: 'img', file: 'end_activate_account.png')}" border="0"
        class="logotype" title="<g:message code='activateAccountAndCardController.step5.counter'/>">
    </div>
  </div>
</div>
</body>
</html>