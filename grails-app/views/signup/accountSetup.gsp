<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>
<div class="apps-mid-column">

  <a class="accessibility-link" id="content-top" name="content-top"></a>

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
          <span style="font-family: 'Courier New', Courier, monospace">${vo.password}</span>
        </div>
      </div>
      <div class="clear-float"></div>
    </div>

    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark">E-postadress</div>
      <div class="apps-float-60">${mail}</div>
    </div>
    <div class="clear-float"></div>
    <div class="apps-content-block-inner">
      <input name="" type="button" value="Skriv ut kontouppgifter..."/>
      <div class="clear-float"></div>
    </div>
    <div class="apps-dotted-divider"></div>

  </div>
  <div class="section mgn-bottom-20">
    <h2>Sista steget: registrera dig på kurser</h2>
    <p>Logga in i Mina studier med kontouppgifterna ovan och registrera dig på de kurser du ska gå.</p>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" summary="Summary">
      <CAPTION>
        Du kan registrera dig på följande kurser.
      </CAPTION>
      <tr>
        <th>Kursnamn</th>
        <th>Högskolepoäng</th>
        <th>Kurskod</th>
      </tr>
      <tr>
        <td>Antikens kultur och samhällsliv - kandidatkurs</td>
        <td>30.0</td>
        <td>FI1001</td>
      </tr>
      <tr>
        <td>Historia med didaktisk inriktning II</td>
        <td>30.0</td>
        <td>UH111F</td>
      </tr>
      <tr>
        <td>Samhällsvetenskap och juridik I</td>
        <td>60.0</td>
        <td>PD131</td>
      </tr>
    </table>

    <div class="clear-float"></div>
  </div>

  <div class="section align-right">
    <input name="" type="button" value="Steg 3: Kursregistrering ->" onclick="window.location.href='https://minastudier.su.se/registrate'"/>
    <br/>
    <span class="apps-hint-text">Logga in med kontouppgifterna ovan</span>
    <div class="clear-float"></div>
  </div>
</div>
</body>
</html>

