<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location List</title>

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
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/typecriteria/add">Add</a>
					</div>
					<table id="myDatatable">
						<thead>
							<tr>
								<th>ID</th>
								<th><center>TIÊU CHÍ ĐÁNH GIÁ</center></th>
								<th><center>NOTE</center></th>
								<th><center>CHI TIẾT</center></th>
								<th><center>CHỈNH SỬA</center></th>
								<th><center>XOÁ</center></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="criteria" items="${typeCriteriaList}">
								<tr>
									<td>${criteria.id}</td>
									<td>${criteria.name}</td>
									<td align="center">${criteria.note}</td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/typecriteria/detail?tyecriteriaid=${criteria.id}"
										class="btn btn-info btn-sm"> <span
											class="glyphicon glyphicon-th"></span>
									</a></td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/typecriteria/edit?tyecriteriaid=${criteria.id}"
										class="btn btn-warning btn-sm"> <span
											class="glyphicon glyphicon-edit"></span>
									</a></td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/typecriteria/delete?tyecriteriaid=${criteria.id}"
										class="btn btn-danger btn-sm"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
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