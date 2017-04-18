<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<table>
							<tr>
								<td>TÊN VĂN PHÒNG :</td>
								<td><form:input path="name" /></td>
							</tr>
							<tr>
								<td>ĐIỆN THOẠI LIÊN HỆ :</td>
								<td><form:input path="phone" type="number" /></td>
							</tr>
							<tr>
								<td>THÔNG TIN :</td>
								<td><form:textarea id="profile" path="profile" cols="60"
										rows="10"></form:textarea></td>
							</tr>
							<tr>
								<td>ĐỊA CHỈ :</td>
								<td><form:input path="location" /></td>
							</tr>
							<tr>
								<td>KIỂU VĂN PHÒNG :</td>
								<td><form:input path="type_office" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Thêm" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>