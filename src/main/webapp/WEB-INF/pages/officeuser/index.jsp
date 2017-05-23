<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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

				<div class="panel panel-default">
					<div class="panel-heading">Danh sách các văn phòng mà bạn cần đánh giá</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>TÊN VĂN PHÒNG</th>
									<th>ĐIỆN THOẠI LIÊN HỆ</th>
									<th>ĐỊA CHỈ</th>
									<th>KIỂU VĂN PHÒNG</th>
									<th>Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="office" items="${officeList}">

									<tr>
										<td>${office.name}</td>
										<td>${office.phone}</td>
										<td>${office.location}</td>
										<td>${office.type_office}</td>
										<td><a href="${pageContext.request.contextPath}/officeuser/scoreOffice/rate?office=${office.id}">Đánh giá </a>|<a>Chi tiết</a></td>
									</tr>


								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>