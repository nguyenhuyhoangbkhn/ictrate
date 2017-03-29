<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location List</title>

<!--add css bootstrap-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

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
	<jsp:include page="../_menu.jsp" />

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Add New Staff</h1>
	<form:form method="post" action="addTypeCriteria">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Note :</td>
				<td><form:input path="note" /></td>
			</tr>
			<tr>
				<td>Id parent :</td>
				<td><form:select path="id_parent">
						<c:forEach var="criteria" items="${typeCriteriaList}">
							<form:option value="${criteria.id}" label="${criteria.name}" />
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>