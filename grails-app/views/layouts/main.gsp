<!DOCTYPE html>
  <head>
    <title><g:layoutTitle default="${g.message(code:'application.title')}"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="content-style-type" content="text/css"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <g:layoutHead/>

    <r:require modules="jquery, css"/>

    <r:layoutResources/>
  </head>

  <body id="oBody">

  <!-- container -->
  <div id="container" class="wrapper">
    <!-- content -->
    <div id="content">
      <!-- accessibility links -->
      <a class="accessibility-link" accesskey="s" href="#content-top" title="Skip navigation"></a>
      <!-- /accessibility links -->

      <!-- head top -->
      <g:render template="/layouts/top_menu"/>
      <!-- /head top -->

      <!-- head -->
      <g:render template="/layouts/header"/>
      <!-- /head -->

      <!-- columns -->
      <div id="columns" class="columns">

        <div class="row-path-tools">
          <div class="clear-float"></div>
        </div>
        <!-- ************************************************** PAGE ************************************************** -->
        <div class="left-column">
          <g:render template="/layouts/menu"/>
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
    <g:render template="/layouts/footer"/>
  </div>
  <!-- /container -->
  <r:layoutResources/>
  </body>
</html>
