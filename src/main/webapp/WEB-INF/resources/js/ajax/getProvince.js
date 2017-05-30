$(document).ready(function($) {
	$("#provinceSelection").change(function() {
		searchAjax();

	});
});

function searchAjax(params) {
	var params = {};
	params.id = $("#provinceSelection").val();

	$.ajax({
		url : "/ictrate/location/addById",
		type : "GET",
		data : params,
		//dataType : 'json',
		//contentType : "application/json; charset=utf-8",
		success : function(data) {
			console.log("SUCCESS: ", data);
			if(($('#provinceSelection').val()) == 0){
				$("#district").html('<div class="form-group"><label for="name">Trực thuộc Quận-Huyện-Thị Xã:</label><select class="form-control"><option value="0" label="Select" /></div>');
			}
			else {
				$("#district").html(data);
			}
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