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

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Admin</title>
</head>
<body>
<div class="apps-mid-column">
  <g:if test="${flash.error}">
    <div class="error">${flash.error}</div>
  </g:if>
  <div>
    <g:form action="index" method="post">
      <div class="apps-float-15"><label for="ssn">Personnummer</label>: </div>
      <div class="apps-float-20"><g:textField name="ssn" maxlength="13" size="15"/></div>
      <div class="apps-float-10"><g:submitButton name="submit" value="${g.message(code:'admin.searchLabel')}"/></div>
      <div class="clear-float"></div>
    </g:form>
  </div>
  <div>
    <g:form action="index" method="post">
      <div class="apps-float-15"><label for="referenceId">ReferensId</label>:</div>
      <div class="apps-float-20"><g:textField name="referenceId" maxlength="15" size="15"/></div>
      <div class="apps-float-10"><g:submitButton name="submit" value="${g.message(code:'admin.searchLabel')}"/></div>
      <div class="clear-float"></div>
    </g:form>
  </div>
  <g:if test="${eventLogs}">
    <div>
      <p>Senaste raderna i eventlog</p>
      <table>
        <g:each in="${eventLogs}" var="eventLog">
          <tr>
            <td><g:formatDate format="yyyy-MM-dd HH:mm" date="${eventLog.dateCreated}"/></td>
            <td>${eventLog.description}</td>
            <td>${eventLog.referenceId}</td>
            <td>${eventLog.userId}</td>
          </tr>
        </g:each>
      </table>
    </div>
  </g:if>
</div>
</body>
</html>
