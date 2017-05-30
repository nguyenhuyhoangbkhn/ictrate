function signUp(userName) {
	var params = {};
	params = $("#formSignUp").serialize();
	params.username = userName;

	$.ajax({
		url : "/ictrate/user/signUp",
		type : "POST",
		data : params,
		//dataType : 'json',
		//contentType : "application/json; charset=utf-8",
		success : function(data) {
		
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