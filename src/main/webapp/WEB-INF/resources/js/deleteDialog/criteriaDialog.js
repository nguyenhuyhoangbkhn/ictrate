function showDialog(locationId) {
	$(".btnConfirm").attr('onclick', 'deleteLocation(' + locationId + ')');

	$(".btnConfirm").click(function() {
		$("#myModal").modal("hide");
		 setTimeout(function(){
		       $('#mySuccessModal').modal('show');
		   }, 500);
		 
		 $(".btnOK").click(function(){
				$("#mySuccessModal").modal("hide");
			})
		})	

	$(".btnCancel").click(function() {
		$("#myModal").modal("hide");
	})
	
	$("#myModal").on("show", function() { // wire up the OK button to dismiss
		// the modal when shown
		$("#myModal a.btn").on("click", function(e) {
			console.log("button pressed"); // just as an example...
			$("#myModal").modal('hide'); // dismiss the dialog
		});
	});
	
	$("#myModal").on("hide", function() { // remove the event listeners when
		// the dialog is dismissed
		$("#myModal a.btn").off("click");
	});

	$("#myModal").on("hidden", function() { // remove the actual elements from
		// the DOM when fully hidden
		$("#myModal").remove();
	});

	$("#myModal").modal({ // wire up the actual modal functionality and show
		// the dialog
		"backdrop" : "static",
		"keyboard" : true,
		"show" : true
	// ensure the modal is shown immediately
	});
}

function deleteLocation(locationId) {
	var params = {};
	params.criteriaid = locationId;
	$.ajax({
		url : '/ictrate/criteria/delete', // Ten action
		type : 'GET', // GET or POST
		dateType : "json", // dữ liệu trả về dạng text
		data : params, // Du lieu truyen sang action VD: id=123
		success : function(response) {
			$("tr.tr_" + locationId).remove();
		},
		error : function(jqXhr, textStatus, errorThrown) {
			alert('error');
		}
	});
}
