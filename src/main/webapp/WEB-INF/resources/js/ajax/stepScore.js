var countRow = 1;
$(document).ready(function() {
	$(document).on("submit", "#xxx", function(){
		var params = {};
		params.name = $(".nameStepScore").val();
		params.note = $(".noteStepScore").val();
		params.typeScore = $(".typeStepScore").val();
		var text = "";
		$(".detailStepScoreAdd").each(function(){
			
			text = text + "*/"+$(this).val();
		});
		params.detailScore = text;
		$.ajax({
			url : '/ictrate/stepscore/addStepScore', // Ten action
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
		
	})
	$(".submitTypeCriteria").click(function() {
		var params = {};
		params.name = $(".nameStepScore").val();
		params.note = $(".noteStepScore").val();
		
		var text = "";
		$(".detailStepScoreAdd").each(function(){
			
			text = text + "\t"+$(this).val();
		});
		params.detailScore = text;
		$.ajax({
			url : '/ictrate/stepscore/addStepScore', // Ten action
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
	$(".addStepForm").click(function(){
		countRow++;
		content = $("<tr><td></td><td><input  name='detailScore' class='form-control detailStepScore detailStepScoreAdd'  'type='text'></td><td><a class='btn deleteBtn' id = 'deleteBtn"+ countRow+"'>Delete</a></td></tr>");		
		content.insertAfter($(".formButtonAddStepForm"));
		return false;
	});
	
	$(document).on( "click", "a", function() {
		$(this).parents('tr').remove();
	});

})