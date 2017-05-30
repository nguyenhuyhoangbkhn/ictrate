<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Update Location</title>
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
					<h1>UPDATE ĐỊA ĐIỂM</h1>
					<form:form method="post" action="updateLocation"
						modelAttribute="locationDao">
						<div class="form-group">
							<form:hidden path="id" />
						</div>
						<div class="form-group">
							<label for="name">Tên địa điểm:</label>
							<form:input path="name" class="form-control form-input-default"
								required="required" />
						</div>
						<div class="form-group">
							<label for="note">Kiểu địa điểm:</label>
							<form:select path="type" class="form-control">
								<form:option value="" label="Select" />
								<form:option value="Thành Phố" label="Thành Phố" />
								<form:option value="Tỉnh" label="Tỉnh" />
								<form:option value="Quận" label="Quận" />
								<form:option value="Huyện" label="Huyện" />
								<form:option value="Thị Xã" label="Thị Xã" />
								<form:option value="Xã" label="Xã" />
								<form:option value="Phường" label="Phường" />
								<form:option value="Thị Trấn" label="Thị Trấn" />
							</form:select>
						</div>
						<div class="form-group">
							<form:hidden path="id_parent" />
						</div>
						<div class="form-group">
							<form:hidden path="flag_delete" />
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-submit" value="Update" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>