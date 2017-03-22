<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location List</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css">

<!-- Below are the Style Sheets required for Data Tables. These can be customized as required -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js">
<!-- Below is the jQuery file required for using any Jquery component. -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Below are the jQuery scripts required for Data Tables. -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
	
<!-- Initialization code of data table at the time of page load. -->
<script>
$(document).ready(function() {
	$('#myDatatable').DataTable({
		"jQueryUI" : true,
		"pagingType" : "full_numbers",
		"lengthMenu" : [ [ 5, 10, 50, -1 ], [ 5, 10, 50, "All" ] ]
	/* few more options are available to use */
	});
});
</script>


</head>
<body>
	<div>
		<h1 class="text">LOCATION LIST</h1>
		<table id="myDatatable">
			<thead>
				<tr>
					<th>ID_LOCATION</th>
					<th>NAME</th>
					<th>TYPE_PLACE</th>
					<th>CODE</th>
					<th>ID_PARENT</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="location" items="${locationlist}">
					<tr>
						<td>${location.id_location}</td>
						<td>${location.name}</td>
						<td>${location.type_place}</td>
						<td>${location.code}</td>
						<td>${location.id_parent}</td>
						<td><a href="edit?staffid=${location.id_location}">Edit</a></td>
						<td><a href="delete?staffid=${location.id_location}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>