<g:if test="${cardInfo.canOrderCard}">
  <g:message code="cardOrder.start"/>
</g:if>
<g:else>
  <g:if test="${cardInfo.suCards}">
    <div>
      <p><g:message code="cardInfo.existing"/></p>
      <table style="width:99%">
        <thead>
        <tr><th style="width:60%"><g:message code="cardInfo.uuid"/></th><th style="width:40%"><g:message code="cardInfo.serial"/></th></tr>
        </thead>
        <tbody>
          <g:each in="${cardInfo.suCards}" var="suCard">
            <tr><td>${suCard.suCardUUID}</td><td>${suCard.suCardSerial}</td></tr>
          </g:each>
        </tbody>
      </table>
    </div>
  </g:if>
  <g:else>
    <g:if test="${cardInfo.cardOrders}">
      <div>
        <p><g:message code="cardInfo.orders"/></p>
        <table>
          <thead>
          <tr><th>Namn</th><th>Serial</th></tr>
          </thead>
          <tbody>
          <g:each in="${cardInfo.cardOrders}" var="cardOrder">
            <tr><td>${cardOrder.firstname} ${cardOrder.lastname}</td><td>${cardOrder.serial}</td></tr>
          </g:each>
          </tbody>
        </table>
      </div>
    </g:if>
    <g:else>
      No order for youuu, cauze im ze soupnazi! (shouldnt get here, since we most likely tell the user he/she already has a card, or has made a cardorder)
    </g:else>
  </g:else>
</g:else>