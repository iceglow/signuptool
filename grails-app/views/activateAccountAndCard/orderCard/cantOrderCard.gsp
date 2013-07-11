<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title><g:message code="activateAccountAndCard.cantOrderCard.title"/></title>
  <meta name="layout" content="main"/>
</head>
<body>
<div class="apps-mid-column">
  <p><g:message code="activateAccountAndCard.cantOrderCard.text"/></p>

  <g:if test="${!(cardInfo?.hasAddress)}">
    <label for="hasAddress">
      <g:message code="activateAccountAndCard.cantOrderCard.hasAddress.label"/>
    </label>
    <span id="hasAddress"><g:message code="activateAccountAndCard.cantOrderCard.hasAddress.text"/></span>
  </g:if>

  <g:if test="${(cardInfo?.suCards)}">
    <label for="suCards">
      <g:message code="activateAccountAndCard.cantOrderCard.suCards.label"/>
    </label>
    <span id="suCards"><g:message code="activateAccountAndCard.cantOrderCard.suCards.text"/></span>
  </g:if>

  <g:if test="${(cardInfo?.cardOrders)}">
    <label for="cardOrders">
      <g:message code="activateAccountAndCard.cantOrderCard.cardOrders.label"/>
    </label>
    <span id="cardOrders"><g:message code="activateAccountAndCard.cantOrderCard.cardOrders.text"/></span>
  </g:if>

  <br/>
  <g:form>
    <g:submitButton name="continue" value="${g.message(code:'activateAccountAndCard.cantOrderCard.continue')}"/>
  </g:form>
</div>
</body>
</html>