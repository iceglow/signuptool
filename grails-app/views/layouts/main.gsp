
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml" lang="sv">

<head>

  <title>
    <g:message code="application.title.label"/>

    <g:if test="${g.layoutTitle()}">
    - <g:layoutTitle />
    </g:if>

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

    <!-- Error Messages -->
  <g:if test="${flash.error}">
    <div class="section">
      <div class="apps-dialogue-red">${flash.error}</div>
    </div>
  </g:if>
  <g:if test="${flash.message}">
    <div class="section">
      <div class="apps-dialogue-green">${flash.message}</div>
    </div>
  </g:if>
  <g:if test="${error}">
    <div class="section">
      <div class="apps-dialogue-red">${error}</div>
    </div>
  </g:if>
  <g:if test="${message}">
    <div class="section">
      <div class="apps-dialogue-green">${message}</div>
    </div>
  </g:if>
    <!-- /Error Messages -->

    <!-- columns -->
    <div id="columns" class="columns">
      <div class="clear-float"></div>

      <!-- ************************************************** PAGE ************************************************** -->
      <!-- ******** Start left column ****** -->
      <div class="left-column">
        <div class="section">
          <div class="apps-content-block-inner">

            <g:pageProperty name="page.leftCol" />

            <g:if test="${params.controller == 'signup' && params.action == 'index'}">

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
          <div class="section">
            <div class="apps-content-block-inner">
              <g:if test="${params.controller == 'signup' && params.action == 'index'}">
                <%
                  def feedidentifier = "FEED" + ((null == session.locale || 'sv_SE' == session.locale) ? "SE" : "EN")
                  se.su.it.sufeedparser.Feed feed = se.su.it.sufeedparser.Feed.findByIdentifier(feedidentifier)
                %>
                <g:if test="${feed.data}">
                  <g:each in="${feed.data}" var="entry">
                    <p class="category">Driftinformation</p>
                    <ul class="generated-list">
                      <li><p><strong>${entry.title}</strong><br>
                        <span class="apps-hint-text"><g:formatDate format="yyyy-MM-dd HH:mm:ss" date="${entry.pubDate}"/><br></span>
                        ${entry.body}
                      </p></li>

                    </ul>
                  </g:each>
                </g:if>
              </g:if>
            </div>
          </div>
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
  <g:render template="/layouts/footer"/>

  <div class="clear-float"></div>
</div>
<!-- /container -->
</body>
</html>
