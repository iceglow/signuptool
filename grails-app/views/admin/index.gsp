<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="admin"/>
  <title><g:message code="admin.title"/></title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
    $(function() {
      $("#searchForm").on("submit", function(event) {
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
  <div id="content">
    <div id="searchForm">
      <tmpl:searchForm />
    </div>
    <div id="searchResults"></div>
  </div>
</body>
</html>