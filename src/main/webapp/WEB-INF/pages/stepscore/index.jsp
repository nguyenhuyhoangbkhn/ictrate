<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
					<h1 class="text">List Step Score</h1>

					<div class="button">
						<a href="${pageContext.request.contextPath}/stepscore/add">Add</a>
					</div>
					<table id="myDatatable">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>NOTE</th>
								<th>DETAIL</th>
								<th>EDIT</th>
								<th>DELETE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="score" items="${stepScoreList}">
								<tr>
									<td>${score.id}</td>
									<td>${score.name}</td>
									<td>${score.note}</td>
									<td>${score.detailScore}</td>
									<td><a
										href="${pageContext.request.contextPath}/stepscore/edit?id=${score.id}">EDIT</a></td>
									<td><a
										href="${pageContext.request.contextPath}/stepscore/delete?id=${score.id}">DELETE</a></td>
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