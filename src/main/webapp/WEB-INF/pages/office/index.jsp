<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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

					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/office/add">Thêm Văn
						Phòng</a>
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
								<tr class="tr_${office.id}">
									<td>${office.id}</td>
									<td>${office.name}</td>
									<td>${office.phone}</td>
									<td>${office.location}</td>
									<td>${office.type_office}</td>
									<td>${office.profile}</td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/office/edit?officeid=${office.id}"
										class="btn btn-warning btn-sm"> <span
											class="glyphicon glyphicon-edit"></span>
									</a></td>
									<td align="center"><a class="btn btn-danger btn-sm"
										onclick="showDialog('${office.id}');"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- set up the modal to start hidden and fade in and out -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- dialog body -->
						<div class="modal-body">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							Bạn muốn xoá bản ghi này?
						</div>
						<!-- dialog buttons -->
						<div class="modal-footer">
							<button data-bb-handler="cancel" type="button"
								class="btn btn-default btnCancel">
								<i class="glyphicon glyphicon-remove"></i> Cancel
							</button>
							<button data-bb-handler="confirm" type="button"
								class="btn btn-primary btnConfirm">
								<i class="glyphicon glyphicon-ok"></i> Confirm
							</button>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/js/deleteDialog/officeDialog.js"></script>

		</div>
	</div>
</body>
</html>