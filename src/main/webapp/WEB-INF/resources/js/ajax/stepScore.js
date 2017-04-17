var countRow = 1;
$(document).ready(function() {
	$(".submitTypeCriteria").click(function() {
		var params = {name,note,detailScore};
		params.name = $(".nameStepScore").val();
		params.note = $(".noteStepScore").val();
		var text = "";
		for (var i = 1; i<= countRow;i++){
			text = text + "\t"+$(".detailStepScore"+i).val();
		}
		params.detailScore = text;
		$.ajax({
			url : '/ictrate/stepscore/addStepScore', // Ten action
			type : 'POST', // GET or POST
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
		content = $("<tr><td></td><td><input  name='detailScore"+countRow+"' class='form-control' id = 'detailStepScore"+ countRow+" 'type='text' value=''></td><td><a class='btn deleteBtn' id = 'deleteBtn"+ countRow+"'>Delete</a></td></tr>");		
		content.insertBefore($(".formButtonAddStepForm"));
		return false;
	});
	
	$( "form#command" ).on( "click", "a", function() {
		$(this).parents('tr').remove();
	});
})