<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml" lang="sv"><head>


    <title><g:layoutTitle default="${g.message(code:'sukattool.application.title')}"/></title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="content-style-type" content="text/css" />
    <link rel="icon" type="image/png" href="" />
    <link rel="schema.DC" href="http://purl.org/DC/elements/1.0/" />
    <meta name="DC.Identifier" scheme="URL" content="" />

    <meta name="DC.Title" content="Forskning" />
    <meta name="DC.Publisher" content="Stockholm University" />
    <meta name="DC.Date.Modified" scheme="W3CDTF" content="" />
    <meta name="DC.Date.Created" scheme="W3CDTF" content="" />
    <meta name="DC.Type" content="text" />
    <meta name="DC.Format" scheme="IMT" content="text/html" />
    <meta name="DC.Language" scheme="RFC1766" content="en" />


    <meta name="geo.position" content="59.363268, 18.058637" />
    <meta name="geo.placename" content="Stockholm" />
    <meta name="geo.region" content="SE-AB" />

    <g:layoutHead/>
    <!-- included styles -->
     <link rel="stylesheet" type="text/css" href="https://webshare.su.se/templates/stylesheets/reset.css" />
     <link rel="stylesheet" type="text/css" href="https://webshare.su.se/templates/stylesheets/basic.css" />
     <link rel="stylesheet" type="text/css" href="${resource(dir:'css',file:'layout.css')}" />

    <!-- included scripts -->
    <!--[if lt IE 7]>
    <script defer language="javascript" type="text/javascript" src="/js/pngfix.js"></script>
    <![endif]-->

    <!-- /included scripts -->
    <!-- page specific scripts -->

    <!-- /page specific scripts -->
    <script type="text/javascript">
    <!--
    function clearDefault(el) {
    if (el.defaultValue==el.value) el.value = ""
    }
    // -->
    </script>
  <g:javascript src="util.js" />

  </head><body id="oBody">
  <div id="doc">
    <!-- container -->
    <div id="container" class="wrapper">
      <!-- content -->
      <div id="allcontent">
        <!-- accessibility links -->
        <a class="accessibility-link" accesskey="s" href="#content-top" title="Skip navigation"></a>
        <!-- /accessibility links -->
        <!-- head top -->

        <g:render template="/layouts/header" />
        <!-- /head -->


        <!-- columns -->
        <div id="columns" class="columns">
          <!-- /path, tools -->

          <div class="clear-float"></div>

          <!-- ************************************************** PAGE ************************************************** -->

          <!-- main column -->
          <div class="main-column fullpage-wrapper">
            <!-- content anchor -->
            <a class="accessibility-link" id="content-top" name="content-top"></a><!-- /content anchor -->
            <g:if test="${flash.message && flash.type == 0}">
              <div class="section">
                <div class="apps-dialogue-red">${flash.message}</div>
              </div>
            </g:if>
            <g:if test="${flash.message && flash.type == 1}">
              <div class="section">
                <div class="apps-dialogue-green">${flash.message}</div>
              </div>
            </g:if>
            <div id="bd">
              <div id="menu">
              </div>
              <div id="wrap">
                <div id="breadcrumbs">
                  <a href="http://www.su.se">www.su.se</a>
                </div>
                <g:layoutBody />
              </div>
            </div>
          </div>
          <!-- main column -->
          <!-- ************************************************** /PAGE ************************************************** -->

          <div class="clear-float"></div>
          <g:render template="/layouts/footer" /> 

        </div>
        <!-- /columns -->
      </div>

      <!-- /content -->
      <div class="clear-float"></div>
    </div>
    <!-- /container -->
    <!-- script for google analytics -->
    <!-- /script for google analytics -->
    <!-- js -->
    <!-- /js -->
    </div>
  </body>
</html>