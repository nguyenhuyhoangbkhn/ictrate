$(document).ready(function() {
	$('#myDatatable').DataTable({
		"jQueryUI" : true,
		"pagingType" : "full_numbers",
		"lengthMenu" : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		 dom: 'Bfrtip',
	        buttons: [
	            {
	                extend: 'copyHtml5',
	                exportOptions: {
	                 columns: ':contains("Office")'
	                }
	            },
	            'excelHtml5',
	            'csvHtml5',
	            'pdfHtml5'
	        ]
		
	/* few more options are available to use */
	});
});