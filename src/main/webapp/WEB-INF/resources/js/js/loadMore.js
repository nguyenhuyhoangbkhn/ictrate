$(function() {
	$(".rowCmt").slice(0, 2).show();
	$("#loadMore").on('click', function(e) {
		e.preventDefault();
		$(".rowCmt:hidden").slice(0, 2).slideDown();
		if ($(".rowCmt:hidden").length == 0) {
			$("#load").fadeOut('slow');
		}
	});
});