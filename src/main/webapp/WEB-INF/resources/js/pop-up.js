$(document).ready(function() {
	$('#mySelect').change(function() {
		var x = $("#mySelect").val();

		if (x == 0) {
			$("#selectProvince").css("display", "none");
			$("#selectDistrict").css("display", "none");
			$("#selectWard").css("display", "none");
		}
		if (x == 1) {
			$("#selectProvince").css("display", "block");
			$("#selectDistrict").css("display", "none");
			$("#selectWard").css("display", "none");
		}
		if (x == 2) {
			$("#selectProvince").css("display", "none");
			$("#selectDistrict").css("display", "block");
			$("#selectWard").css("display", "none");
		}
		if (x == 3) {
			$("#selectProvince").css("display", "none");
			$("#selectDistrict").css("display", "none");
			$("#selectWard").css("display", "block");
		}
	});
})