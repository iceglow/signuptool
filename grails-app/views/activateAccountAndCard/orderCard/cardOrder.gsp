<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Order University Card</title>
</head>
<body>
  <div class="section">
    <g:form>
      <g:radio name="registeredAddressValid" value="1"/>
        <label for="registeredAddressValid">Ovanstående adress stämmer - beställ och skicka kort</label>

      <g:checkBox name="acceptLibraryRules"/>
        <label for="acceptLibraryRules">Jag accepterar bibliotekets låneregler</label>

      <g:radio name="registeredAddressInvalid" value="0"/>
        <label for="registeredAddressInvalid">Ovanstående adress är felaktig - jag beställer kort när den är korrigerad</label>
      
      <g:submitButton class="button" name="sendCardOrder" value="${g.message(code:'cardOrder.processCardOrder')}"/>
    </g:form>
  </div>
</body>
</html>