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

<%@ page import="grails.util.Environment" contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="admin"/>
  <title><g:message code="admin.title"/></title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
    $(function() {
      $("#searchForm").on("submit", function() {
        var searchFor = $("input[name=searchFor]:checked").val();
        var searchText = $("#searchText").val();

        if (searchText.length === 0) {
          return false;
        }

        $.ajax({
          url:"/admin/search",
          type:"POST",
          data:{searchFor:searchFor, searchText:searchText},
          success:function(data) {
            $("#searchResults").html(data)
          },
          error: function(data) {
            console.log(data)
          }
        });

        return false;
      });
    });
  </script>
  <style>
    #searchForm {
      max-width: 300px;
      border: 1px solid black;
      padding: 5px;
    }
    #searchForm p {
      margin-bottom: 0;
    }
    #searchText {
      min-width: 250px;
      margin: 5px;
    }
    #searchResults {
      margin-top: 20px;
    }
    #searchResults ul {
      padding-left: 2px;
      list-style: none;
    }
  </style>
</head>
<body>
  <g:if test="${flash.error}">
    <span class="error">${flash.error}</span>
  </g:if>
  <div id="content">
    <%-- <g:if test="${Environment.current.name == 'mock'}"> --%>
      <div id="useCases">
        <g:form name="useCaseForm" action="useCase">
          <g:select name="caseId"
                    from="${useCases}"
                    optionKey="id"
                    optionValue="name"
          />
          <g:submitButton name="run" value="Kör"/>
        </g:form>
      </div>
    <%-- </g:if> --%>
    <div id="searchForm">
      <tmpl:searchForm />
    </div>
    <div id="searchResults">
      <g:render template="searchResults" model="[eventLog: eventLog]"/>
    </div>
  </div>
</body>
</html>
