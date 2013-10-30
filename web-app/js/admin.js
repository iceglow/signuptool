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