function commentJudge(officeid, content) {
	var params = {officeid, content};
	params.officeid = $(".officeIdCmt").val();
	params.content = $(".contentCmt").val();
	$.ajax({
		url : "/ictrate/office/comment",
		type : "GET",
		data : params,
		//dataType : 'json',
		//contentType : "application/json; charset=utf-8",
		success : function(data) {
			$("#cmtJudgeDiv").html(data);
			$(".contentCmt").val("")
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}