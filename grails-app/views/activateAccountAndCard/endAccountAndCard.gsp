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
        <div><g:message code='activateAccountAndCardController.endAccountAndCard.cardDetails'/></div>
        <div><g:message code='activateAccountAndCardController.endAccountAndCard.cardIsDelivered'/></div>

        <br/>

        <div><g:message code='activateAccountAndCardController.endAccountAndCard.nowYouCan'/></div>
        <div><g:message code='activateAccountAndCardController.endAccountAndCard.registerOnCourse'/><g:link url=""><g:message code='activateAccountAndCardController.endAccountAndCard.myStudies'/></g:link></div>
        <div><g:message code='activateAccountAndCardController.endAccountAndCard.activateEduroam'/><g:link url=""><g:message code='activateAccountAndCardController.endAccountAndCard.accountHandling'/></g:link></div>

        <br/>

        <div><g:message code='activateAccountAndCardController.endAccountAndCard.otherServices'/><g:link url=""><g:message code='activateAccountAndCardController.endAccountAndCard.myUniversity'/></g:link></div>
      </div>

      <div class="clear-float"></div>

      <br/>

      <div class="align-right">
        <div><g:message code='activateAccountAndCardController.endAccountAndCard.registerOnCourse'/></div>
        <g:link url="">
          <g:submitButton class="signupButton" name="toMinaStudier" value="${message(code:'activateAccountAndCardController.endAccountAndCard.myStudies', default: 'Mina studier')}"/>
        </g:link>
    </div>
    </div>

    <div class="state_progress_img">
      <img src="${resource(dir: 'img', file: (request.getLocale() =~ /sv_SE/) ? 'end_activate_account_se.png' : 'end_activate_account_en.png')}" border="0"
        class="logotype" title="<g:message code='activateAccountAndCardController.step5.counter'/>">
    </div>
  </div>
</div>
</body>
</html>