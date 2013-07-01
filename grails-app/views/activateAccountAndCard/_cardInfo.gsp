<g:if test="${cardInfo.canOrderCard}">
  Order card: 'click!'
</g:if>
<g:else>
  <g:if test="${cardInfo.suCards}">
    <div>
      <p>Aktiva Kort</p>
      <table style="width:99%">
        <thead>
        <tr><th style="width:60%">UUID</th><th style="width:40%">Serial</th></tr>
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
    No order for youuu.
  </g:else>
</g:else>