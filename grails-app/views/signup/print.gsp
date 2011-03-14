<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Kontouppgifter</title>

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
<body>

<h1>Kontouppgifter</h1>
<p>
  <input type="submit" name="button" id="button" value="Skriv ut" onclick="window.print()" />
</p>
<table>
  <tr>
    <td><strong>Användarnamn/user name</strong></td>
    <td>${vo.uid.encodeAsHTML()}</td>
  </tr>
  <tr>
    <td><strong>Lösenord/password</strong></td>
    <td>${vo.password.encodeAsHTML()}</td>
  </tr>
</table>

<br />

<h2>Bokstaverat lösenord</h2>

<table cellspacing="0" summary="Lösenord">
  <tr>
    <th>Tecken</th>
    <th>Bokstaverat</th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="sv"/>
</table>


<h2>Spelled-out password</h2>

<table caption="test" cellspacing="0" summary="Password">
  <tr>
    <th>Character</th>
    <th>Spelled</th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="en"/>
</table>


</body>
</html>