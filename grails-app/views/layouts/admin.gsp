<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml" lang="sv">

<head>

  <title>
    <g:message code="signup.title.label"/>
  </title>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="content-style-type" content="text/css"/>

  <!-- included styles -->
  <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'styles.css')}"/>

  <!--Print stuff-->
  <link rel="stylesheet" type="text/css" media="print" href="${resource(dir: 'css', file: 'print.css')}"/>

  <!-- page specific styles -->
  <style type="text/css"></style>

</head>

<body id="oBody">
<!-- container -->
<div id="container" class="wrapper">
  <!-- content -->
  <div id="content">
    <a class="accessibility-link" accesskey="s" href="#content-top" title="Skip navigation"></a>

    <!-- head -->
    <g:render template="/layouts/header"/>
    <!-- /head -->

    <!-- columns -->
    <div id="columns" class="columns">
      <div class="clear-float"></div>

      <!-- ************************************************** PAGE ************************************************** -->
      <div class="left-column">
        <div class="section">

          <div class="apps-content-block-inner">

              <ul>
                <li><g:link controller="info" action="list">Information</g:link></li>
                <li><g:link controller="section">Section</g:link></li>
                <li><g:link controller="value">Value</g:link></li>
            </ul>

         </div>

         <!-- apps-content-block-inner -->

       </div>
      </div>
      <div class="main-column">
        <g:layoutBody/>
      </div>

      <!-- ************************************************** /PAGE ************************************************** -->
      <div class="clear-float"></div>
    </div>
    <!-- /columns -->
  </div>

  <!-- /content -->
  <g:render template="/layouts/footer" />

  <div class="clear-float"></div>
</div>
<!-- /container -->
</body>
</html>
