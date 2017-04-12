<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validateform.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/pop-up.js"></script>
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />

	<h1>Tạo tiêu chí mới</h1>
	<div>
		<select id="mySelect">
			<option value="0" label="Type of Location" />
			<option value="1" label="Thành Phố - Tỉnh" />
			<option value="2" label="Quận - Huyện - Thị Xã" />
			<option value="3" label="Xã - Phường - Thị Trấn" />
		</select>
	</div>

	<div id="selectProvince">
		<form:form method="post" action="addProvince">
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Type :</td>
					<td><form:select path="type">
							<form:option value="" label="Chọn Kiểu" />
							<form:option value="Thành Phố" label="Thành Phố" />
							<form:option value="Tỉnh" label="Tỉnh" />
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div id="selectDistrict">
		<form:form method="post" action="addDistrict">
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Type :</td>
					<td><form:select path="type">
							<form:option value="0" label="Chọn Kiểu" />
							<form:option value="Quận" label="Quận" />
							<form:option value="Huyện" label="Huyện" />
							<form:option value="Thị Xã" label="Thị Xã" />
						</form:select></td>
				</tr>
				<tr>
					<td>Id parent :</td>
					<td><form:select path="id_parent">
							<form:option value="0" label="Chọn Kiểu" />
							<c:forEach var="location" items="${locationList}">
								<form:option value="${location.id}" label="${location.name}" />
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div id="selectWard">
		<form:form method="post" action="addWard">
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Type :</td>
					<td><form:select path="type">
							<form:option value="0" label="Chọn Kiểu" />
							<form:option value="Quận" label="Quận" />
							<form:option value="Huyện" label="Huyện" />
							<form:option value="Thị Xã" label="Thị Xã" />
						</form:select></td>
				</tr>
				<tr>
					<td>Id parent :</td>
					<td><form:select path="id">
							<form:option value="0" label="Chọn Kiểu" />
							<c:forEach var="location" items="${locationList}">
								<form:option value="${location.id}" label="${location.name}" />
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Id parent :</td>
					<td><form:select path="id_parent">
							<form:option value="0" label="Chọn Kiểu" />
							<c:forEach var="location" items="${locationList}">
								<form:option value="${location.id}" label="${location.name}" />
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>