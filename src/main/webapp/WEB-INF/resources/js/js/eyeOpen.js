$(document).ready(function() {
	$(".eyeOpen").on('mousedown',function() {
		if ($(".passwordfield").attr("type") == "password") {
			$(".passwordfield").attr("type", "text");
		} else {
			$(".passwordfield").attr("type", "password");
		}
		$(".eyeOpen").mouseout(function() {
			$(".passwordfield").attr("type", "password");
		});

	});
});