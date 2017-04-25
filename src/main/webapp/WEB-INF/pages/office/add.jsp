<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>THÊM VĂN PHÒNG</title>
<jsp:include page="../home/lib.jsp" />
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>
					<h1>THÊM VĂN PHÒNG MỚI</h1>
					<form:form method="post" action="addOffice">
						<div>
							<div class="form-group">
								<label for="name">TÊN VĂN PHÒNG :</label> <input name="name"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="phone">SĐT liên hệ</label> <input name="phone"
									class="form-control" type="tel" required="required" />

							</div>
							<div class="form-group">
								<label for="profile">Thông tin:</label>
								<textarea name="profile" class="form-control" id="profile"
									required="required" cols="60" rows="10"></textarea>
							</div>
							<div class="form-group">
								<label for="location">Địa chỉ</label> <input name="location"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="name">tên loại điểm:</label> <input
									name="type_office" class="form-control" required="required" />
							</div>
							<div class="form-group">

								<input class="btn btn-primary" type="submit" value="Thêm" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>