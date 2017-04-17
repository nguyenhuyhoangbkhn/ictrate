<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Step Score List</title>
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
					<h1 class="text">Type Criteria list</h1>
					<div class="button">
						<a href="${pageContext.request.contextPath}/typecriteria/add">Add</a>
					</div>
					<table id="myDatatable">
						<thead>
							<tr>
								<th>id</th>
								<th>name</th>
								<th>note</th>
								<th>detail</th>
								<th>edit</th>
								<th>delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="criteria" items="${typeCriteriaList}">
								<tr>
									<td>${criteria.id}</td>
									<td>${criteria.name}</td>
									<td>${criteria.note}</td>
									<td><a
										href="${pageContext.request.contextPath}/typecriteria/detail?tyecriteriaid=${criteria.id}">detail</a></td>
									<td><a
										href="${pageContext.request.contextPath}/typecriteria/edit?tyecriteriaid=${criteria.id}">Edit</a></td>
									<td><a
										href="${pageContext.request.contextPath}/typecriteria/delete?tyecriteriaid=${criteria.id}">Delete</a></td>
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