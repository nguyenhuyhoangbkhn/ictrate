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
					<h1 class="text">DANH SÁCH CÁC TIÊU CHÍ</h1>

					<a href="${pageContext.request.contextPath}/criteria/add"
						class="btn btn-primary">Thêm tiêu chí</a>
					<table id="myDatatable">
						<thead>
							<tr>
								<th><center>TIÊU CHÍ</center></th>
								<th><center>GHI CHÚ</center></th>
								<th><center>LOẠI TIÊU CHÍ</center></th>
								<th><center>THANG ĐIỂM</center></th>
								<th><center>CHỈNH SỬA</center></th>
								<th><center>XOÁ</center></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="criteria" items="${criterialist}">
								<tr>
									<td>${criteria.name}</td>
									<td>${criteria.note}</td>
									<td>${criteria.type_criteria}</td>
									<td>${criteria.type_score}</td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/criteria/edit?criteriaid=${criteria.id}"
										class="btn btn-warning btn-sm"> <span
											class="glyphicon glyphicon-edit"></span>
									</a></td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/criteria/delete?criteriaid=${criteria.id}"
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