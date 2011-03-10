<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml" lang="sv">

<head>

  <title>
    <g:message code="application.title.label"/>
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
    <!-- ******** Start left column ****** -->
    <div class="left-column">
      <div class="section">

        <div class="apps-content-block-inner">
          <g:if test="${params.controller == 'signup' && params.action == 'index'}">
            We are at index!!!
          </g:if>
        </div>
      </div>
    </div>
      <!-- ***** End left column ******* -->
    <!-- ****** Start main column ******** -->
      <div class="main-column">
      <a class="accessibility-link" id="content-top" name="content-top"></a>
        <div class="apps-mid-column">
        <g:layoutBody/>
        </div>
        <!-- ***** Start inner right column ****** -->
        <div class="apps-right-column" id="content-inner-right" name="content-inner-right">

        </div>
        <!-- ****** End inner right column ******* -->
      </div>
      <!-- ********* End main column ******** -->
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
