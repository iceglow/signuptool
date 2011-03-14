<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>
<div class="section">

  <div id="suErrors">

  </div>

  <h1>Kontot är skapat</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
  <h2>Dina kontouppgifter:</h2>
  <div class="content-block apps-colorbox1 mgn-bottom-10">
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark">Användarnamn</div>
      <div class="apps-float-60">${vo.uid}</div>
    </div>
    <div class="clear-float"></div>
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark">Lösenord</div>
      <div class="apps-float-60">
        ${vo.password}
      </div>
    </div>
    <div class="clear-float"></div>
  </div>

  <div class="apps-content-block-inner">
    <div class="apps-float-30 label-grey-dark">E-postadress</div>
    <div class="apps-float-60">${mail}</div>
	<div class="clear-float"></div>
  </div>
  
  <div class="apps-content-block-inner">
    <g:form url="[action:'print']" name="printForm" target="_blank"></g:form>
    <input type="button" value="Skriv ut kontouppgifter..." onclick="document.printForm.submit()" />
    <div class="clear-float"></div>
  </div>
  <div class="apps-dotted-divider"></div>

</div>
<div class="section mgn-bottom-20">
  <h2>Sista steget: registrera dig på kurser</h2>
  <p>Logga in i Mina studier med kontouppgifterna ovan och registrera dig på de kurser du ska gå.</p>


  <g:if test="${coursesugg}">

    <table width="100%" border="0" cellspacing="0" cellpadding="0" summary="Summary">
      <caption>Du kan registrera dig på följande kurser.</caption>
      <thead>
        <tr>
          <th>Kursnamn</th>
          <th>Kurskod</th>
          <th>Termin</th>
          <th>Högskolepoäng</th>
          <th>Kurstakt</th>
          <th>Kurstid</th>
        </tr>
      </thead>

      <tbody>
        <g:each in="${coursesugg}" status="i" var="courseVO">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td><su:localizedString sv="${courseVO.kursbenamn}" en="${courseVO.kursbenamne}" /></td>
            <td>${courseVO.kurskod}</td>
            <td>${courseVO.termin}</td>
            <td>${courseVO.poang }</td>
            <td>${courseVO.kurstakt }%</td>
            <td><su:showProperTime time="${courseVO.kurstid}" /></td>
          </tr>
        </g:each>
      </tbody>
    </table>

  </g:if>
  <g:else>
    Fel fel fel!!!
  </g:else>

  <div class="clear-float"></div>
</div>

<div class="section align-right">
  <input name="" type="button" value="Steg 3: Kursregistrering ->" onclick="window.location.href = 'https://minastudier.su.se/registrate'"/>
  <br/>
  <span class="apps-hint-text">Logga in med kontouppgifterna ovan</span>
  <div class="clear-float"></div>
</div>
</body>
</html>

