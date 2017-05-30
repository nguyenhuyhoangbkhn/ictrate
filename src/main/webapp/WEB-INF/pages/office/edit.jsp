<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>UPDATE VĂN PHÒNG</title>
<jsp:include page="../home/lib.jsp" />
<!-- Initialization code of data table at the time of page load. -->
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>
					<h1>UPDATE VĂN PHÒNG</h1>
					<form:form method="post" action="updateOffice"
						modelAttribute="officeDao">
						<div>
							<div class="form-group">
								<form:hidden path="id" class="form-control" />
							</div>
							<div class="form-group">
								<label for="name">Tên văn phòng :</label>
								<form:input path="name" class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="phone">SĐT liên hệ</label>
								<form:input path="phone" class="form-control" type="tel"
									required="required" />

							</div>
							<div class="form-group">
								<label for="profile">Thông tin:</label>
								<form:textarea name="profile" class="form-control"
									path="profile" id="profile" required="required" cols="60"
									rows="10"></form:textarea>
							</div>
							<div class="form-group">
								<label for="location">Địa chỉ</label>
								<form:input path="location" class="form-control"
									required="required" />
							</div>
							<div class="form-group">
								<label for="name">Kiểu văn phòng:</label>
								<form:input path="type_office" class="form-control"
									required="required" />
							</div>
							<div class="form-group">
								<form:hidden path="flag_delete" class="form-control" />
							</div>

							<div class="form-group">
								<input class="btn btn-primary" type="submit" value="Update" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>