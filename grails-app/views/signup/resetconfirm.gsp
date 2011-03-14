<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
</head>
<body>

<div class="section">

  <div id="suErrors">

  </div>

  <h1>Du har fått ett nytt lösenord</h1>
</div>

<div class="clear-float"></div>

<div class="section mgn-bottom-20">
  <h2>Notera dina kontouppgifter:</h2>
  <div class="content-block apps-colorbox1 mgn-bottom-10">
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark">Användarnamn</div>
      <div class="apps-float-60">${vo.uid}</div>
    </div>
    <div class="clear-float"></div>
    <div class="apps-content-block-inner">
      <div class="apps-float-30 label-grey-dark">Lösenord</div>
      <div class="apps-float-60">
        ${vo.password}</div>
    </div>
    <div class="clear-float"></div>
  </div>

  <div class="apps-content-block-inner"></div>
  <div class="clear-float"></div>
  <div class="clear-float"></div>
  <div class="apps-content-block-inner">
    <g:form url="[action:'print']" name="printForm" target="_blank"></g:form>
    <input type="button" class="button-block-right" value="Skriv ut kontouppgifter..." onclick="document.printForm.submit()" />
    <div class="clear-float"></div>
  </div>
  <div class="apps-dotted-divider"></div>

</div>
<div class="section">
  <h2>Vill du byta ditt lösenord?</h2>
  <p>Om du vill ändra ditt lösenord kan du logga in i <a href="http://kontohantering.su.se">Kontohantering</a></p>
</div>

</body>
</html>
