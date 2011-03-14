<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<input type="submit" name="button" id="button" value="Skriv ut" onclick="window.print()" />

<table cellspacing="0" summary="Lösenord">
  <caption>
    Lösenord<br/>
    (Bokstaverat)
  </caption>
  <tr>
    <th>Tecken</th>
    <th>Bokstaverat</th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="sv"/>
</table>


<table caption="test" cellspacing="0" summary="Password">
  <caption>
    Password<br/>
    (Spelled out)
  </caption>
  <tr>
    <th>Character</th>
    <th>Spelled</th>
  </tr>
  <su:passSpell pwd="${vo.password}" lang="en"/>
</table>

</body>
</html>