$(function() {
  $("#searchForm").on("submit", function() {
    var searchFor = $("input[name=searchFor]:checked").val();
    var searchText = $("#searchText").val();
    var target$ = $("#searchResults");

    if (searchText.length === 0) {
      target$.html("Please enter a value to search for.");
      return false;
    }

    $.ajax({
      url:"/admin/search",
      type:"POST",
      data:{searchFor:searchFor, searchText:searchText},
      success:function(data) {
        target$.html(data);
      },
      error: function(data) {
        target$.html($("<div>").addClass("error").html(data.responseText));
      }
    });

    return false;
  });
});