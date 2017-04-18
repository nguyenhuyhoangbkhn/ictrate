<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office List</title>
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
					<h1 class="text">DANH SÁCH VĂN PHÒNG</h1>

					<a href="${pageContext.request.contextPath}/office/add">Thêm
						Văn Phòng</a>
					<table id="myDatatable">
						<thead>
							<tr>
								<th>ID</th>
								<th>TÊN VĂN PHÒNG</th>
								<th>ĐIỆN THOẠI LIÊN HỆ</th>
								<th>ĐỊA CHỈ</th>
								<th>KIỂU VĂN PHÒNG</th>
								<th>THÔNG TIN</th>
								<th>CHỈNH SỬA</th>
								<th>XOÁ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="office" items="${officeList}">
								<tr>
									<td>${office.id}</td>
									<td>${office.name}</td>
									<td>${office.phone}</td>
									<td>${office.location}</td>
									<td>${office.type_office}</td>
									<td>${office.profile}</td>
									<td><a
										href="${pageContext.request.contextPath}/office/edit?officeid=${office.id}">CHỈNH
											SỬA</a></td>
									<td><a
										href="${pageContext.request.contextPath}/office/delete?officeid=${office.id}">XOÁ</a></td>
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