$(document).ready(function() {
	$(".submitTypeCriteria").click(function() {
		var params = {name,note,detailScore};
		params.name = $(".nameStepScore").val();
		params.note = $(".noteStepScore").val();
		params.detailScore = $(".detailStepScore").val();		
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
		var text = $(".formAddStepScore").html();
		content = $("<tr>"+text+"</tr>");
		content.insertBefore($(".formButtonAddStepForm"));
		return false;
	})
})