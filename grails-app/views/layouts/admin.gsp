%{--
  - Copyright (c) 2013, IT Services, Stockholm University
  - All rights reserved.
  -
  - Redistribution and use in source and binary forms, with or without
  - modification, are permitted provided that the following conditions are met:
  -
  - Redistributions of source code must retain the above copyright notice, this
  - list of conditions and the following disclaimer.
  -
  - Redistributions in binary form must reproduce the above copyright notice,
  - this list of conditions and the following disclaimer in the documentation
  - and/or other materials provided with the distribution.
  -
  - Neither the name of Stockholm University nor the names of its contributors
  - may be used to endorse or promote products derived from this software
  - without specific prior written permission.
  -
  - THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  - AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  - IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  - ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
  - LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  - CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  - SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
  - INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
  - CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  - ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  - POSSIBILITY OF SUCH DAMAGE.
  --}%

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
