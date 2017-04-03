$(document).ready(function() {
	$(".submitTypeCriteria").click(function() {
		if ($("#validateName").val() == "" || $("#validateName").val()== undefined) {
			$("#validateName").addClass("errorForm");
			
			console.info("test");
			return false;
		}else {
			$("#validateName").removeClass("errorForm");
			return true;
		}
	});
})