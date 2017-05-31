<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office Details</title>
<jsp:include page="../home/lib.jsp" />
</head>
<body>
	${office.profile}
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">Thông tin chi tiết văn phòng</div>
					<div class="panel-body bg-success">
						<div>
							<label for="name">Tên văn phòng:</label>
							<h3 class="text-info">${officeDao.name}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Thông tin:</label>
							<h3 class="text-info">${officeDao.profile}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Địa điểm:</label>
							<h3 class="text-info">${officeDao.location}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Kiểu văn phòng:</label>
							<h3 class="text-info">${officeDao.type_office}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Điện thoại liên hệ:</label>
							<h3 class="text-info">${officeDao.phone}</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>