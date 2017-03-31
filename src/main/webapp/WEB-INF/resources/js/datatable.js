$(document).ready(function() {
	$('#myDatatable').DataTable({
		"jQueryUI" : true,
		"pagingType" : "full_numbers",
		"lengthMenu" : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ]
	/* few more options are available to use */
	});
});