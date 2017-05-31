//addStepScoreBtn

$(document).ready(function() {
	$(".addStepScoreBtn").click(function(){
		
		content = $("<div class='form-group col-sm-6 row'>" +
				"<div class= 'flex col-sm-8'>"+
		
			"<input name='detailScore' required='required' class= 'form-control detailStepScoreAdd form-input-default' type= 'text' /></div>"+
			
	"<div class= 'col-sm-4'> <a class= 'btn deleteBtn deleteStepScore '>Delete</a></div></div>");
		content.insertBefore($(".inserFlag"));
		return false;
	});

	$(document).on("click", "a", function() {
		$(this).parents('div.form-group.col-sm-6.row').remove();
	});
	
	$(".btn-update-score").click(function(){
		var params = {};
		params.id = $(".idStepScore").val();
		console.info("params."+params.id);
		params.name = $(".nameStepScore").val();
		params.note = $(".noteStepScore").val();
		params.typeScore = $(".typeStepScore").val();
		var text = "";
		$(".detailStepScoreAdd").each(function(){
			text = text + "*/"+$(this).val();
		});
		params.detailScore = text;
		$.ajax({
			url : '/ictrate/stepscore/updateStepScore', // Ten action
			type : 'POST', // GET or POST
			dateType:"text", // dữ liệu trả về dạng text
			data : params, // Du lieu truyen sang action VD: id=123
			success : function(response) {
				window.location="/ictrate/stepscore"
			},
			error : function(jqXhr, textStatus, errorThrown) {
				alert('error');
			}
		});	
		return false;
	});
})