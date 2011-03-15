<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title><g:message code="accountPrint.pageHeader"/></title>

  <style type="text/css">
  body, td, th {
    font-family: Verdana, Geneva, sans-serif;
    font-size: 70%;
  }

  table {
    border-style: none;
    border-collapse: collapse;
    empty-cells: show;
  }

  td {
    border-bottom-width: 1px;
    border-bottom-style: solid;
    border-bottom-color: #CCC;
    padding: 5px;
  }
  th {
    text-align: left;
    border-bottom-width: 1px;
    border-bottom-style: solid;
    border-bottom-color: #000;
    padding: 5px;
  }

  </style>
  <style type="text/css" media="print">
  input {
    visibility: hidden;
  }

  </style>

</head>
<body onLoad="window.print()">

<h1><g:message code="accountPrint.pageHeader"/></h1>
<p>
  <input type="submit" name="button" id="button_print" value="<g:message code='generic.button.print'/>" onclick="window.print()" />
  &nbsp;
  <input type="submit" name="button" id="button_close" value="<g:message code='generic.button.close'/>" onclick="window.close()" />
</p>
<table>
  <tr>
    <td><strong><g:message code="accountPrint.username.label"/></strong></td>
    <td>${vo.uid.encodeAsHTML()}</td>
  </tr>
  <tr>
    <td><strong><g:message code="accountPrint.password.label"/></strong></td>
    <td>${vo.password.encodeAsHTML()}</td>
  </tr>
</table>

<br />

<h2><g:message code="accountPrint.spelledPassword.header"/>(<g:message code="info.locale.sv_SE"/>)</h2>

<table cellspacing="0">
  <tr>
    <th><g:message code="accountPrint.character.label"/></th>
    <th><g:message code="accountPrint.spelled.label"/></th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="sv"/>
</table>


<h2><g:message code="accountPrint.spelledPassword.header"/>(<g:message code="info.locale.en_US"/>)</h2>

<table>
  <tr>
    <th><g:message code="accountPrint.character.label"/></th>
    <th><g:message code="accountPrint.spelled.label"/></th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="en"/>
</table>


</body>
</html>