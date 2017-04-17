<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datatable.js"></script>
<!-- Initialization code of data table at the time of page load. -->
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>
					<h1 class="text">LOCATION LIST</h1>

					<a href="${pageContext.request.contextPath}/location/add">Add
						location</a>
					<table id="myDatatable">
						<thead>
							<tr>
								<th>ID_LOCATION</th>
								<th>NAME</th>
								<th>TYPE_PLACE</th>
								<th>DETAIL</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="location" items="${locationlist}">
								<tr>
									<td>${location.id}</td>
									<td>${location.name}</td>
									<td>${location.type}</td>
									<td><a
										href="${pageContext.request.contextPath}/location/detail?locationid=${location.id}">DETAIL</a></td>
									<td><a
										href="${pageContext.request.contextPath}/location/edit?locationid=${location.id}">EDIT</a></td>
									<td><a
										href="${pageContext.request.contextPath}/location/delete?locationid=${location.id}">DELETE</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>