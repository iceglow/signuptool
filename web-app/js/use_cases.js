$(function() {
  $("select[name=caseId]").on("change", function() {
    var id = $(this).val();
    var target$ = $(this).siblings(".useCaseDescription");
    $.ajax({
      url:"/dashboard/getUseCaseInfo",
      type:"POST",
      data:{caseId:id},
      success: function(data) {
        target$.html(data);
      },
      error: function(data) {
        target$.html("Failed when fetching use case information.");
      }
    })
  });
});