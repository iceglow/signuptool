<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title><g:layoutTitle/></title>
  <g:layoutHead/>
</head>
<body>
<div class="apps-mid-column">
  <tmpl:/shared/feedback flash="${flash}"/>

  <div class="float-left">
    <div class="prompt">
      <g:pageProperty name="flow.prompt"/>
    </div>

    <div class="state_progress_img">
      <g:pageProperty name="flow.step.image"/>
    </div>
  </div>
</div>
</body>
</html>
