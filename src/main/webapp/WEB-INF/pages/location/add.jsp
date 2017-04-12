<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="UTF-8">
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validateform.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/pop-up.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajax/getProvince.js"></script>
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div id="body">
		<h1>ADD NEW LOCATION</h1>
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
						<td>NAME :</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>TYPE :</td>
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
						<td>NAME :</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>TYPE :</td>
						<td><form:select path="type">
								<form:option value="0" label="Chọn Kiểu" />
								<form:option value="Quận" label="Quận" />
								<form:option value="Huyện" label="Huyện" />
								<form:option value="Thị Xã" label="Thị Xã" />
							</form:select></td>
					</tr>
					<tr>
						<td>ID PARENT :</td>
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
				NAME: <form:input path="name" />
				<br>
				TYPE: <form:select path="type">
					<form:option value="0" label="Chọn Kiểu" />
					<form:option value="Xã" label="Xã" />
					<form:option value="Phường" label="Phường" />
					<form:option value="Thị Trấn" label="Thị Trấn" />
				</form:select><br>
				SELECT PROVINCE :<form:select path="id" id="provinceSelection" onchange="searchAjax() ;">
					<form:option value="0" label="Chọn Kiểu" />
						<c:forEach var="location" items="${locationList}">
							<form:option value="${location.id}" label="${location.name}" />
						</c:forEach>
				</form:select>
				 <div id="district">ID PARENT :<form:select path="id_parent" id="districtSelection">
							<form:option value="0" label="Chọn Kiểu" />
								<c:forEach var="location" items="${DistrictList}">
									<form:option value="${location.id}" label="${location.name}" />
								</c:forEach>
							</form:select> </div>
				<input type="submit" value="Add" />
			</form:form>
		</div>
	</div>
</body>
</html>