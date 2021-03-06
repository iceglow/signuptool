<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
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

<g:set var="lang" value="${RequestContextUtils.getLocale(request)?.language}"/>

<div id="head" class="head apps-darkblue">

  <div class="clear-float"></div>

  <div class="head-left">
    <a href="http://www.su.se/" title="${g.message(code: 'layout.su.logo.alternative.name')}">
      <img class="logotype"
           src="${resource(dir: 'img', file: (lang == 'sv') ? 'logo_su_se_big_dark_blue.gif' : 'logo_su_en_big_dark_blue.gif')}"
           alt="${g.message(code: 'layout.su.logo.alternative.name')}" border="0"/>
    </a>
  </div>

  <div class="head-right">
    <img class=department
         src="${resource(dir: 'img', file: (lang == 'sv') ? 'app-logotype-signuptool-se.gif' : 'app-logotype-signuptool-en.gif')}"
         alt="${g.message(code: 'application.title')}" title="${g.message(code: 'application.title')}" border="0"/>
  </div>

  <div class="clear-float"></div>

  <div id="apps-headmargin">
    <div class="clear-float"></div>
  </div>
</div>
