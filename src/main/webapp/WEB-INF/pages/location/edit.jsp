<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
					<h1>UPDATE LOCATION</h1>
					<form:form method="post" action="updateLocation" modelAttribute="locationDao">
						<table>
							<tr>
								<td><form:hidden path="id" /></td>
							</tr>

							<tr>
								<td>NAME :</td>
								<td><form:input path="name" /></td>
							</tr>
							<tr>
								<td>TYPE_PLACE :</td>
								<td><form:select path="type">
											<form:option value="" label="Select" />
											<form:option value="Thành Phố" label="Thành Phố" />
											<form:option value="Tỉnh" label="Tỉnh" />
											<form:option value="Quận" label="Quận" />
											<form:option value="Huyện" label="Huyện" />
											<form:option value="Thị Xã" label="Thị Xã" />
											<form:option value="Xã" label="Xã" />
											<form:option value="Phường" label="Phường" />
											<form:option value="Thị Trấn" label="Thị Trấn" />
										</form:select></td>
							</tr>
							<tr>
								<td><form:hidden path="id_parent" /></td>
							</tr>
							<tr>
								<td><form:hidden path="flag_delete" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Update" /></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>