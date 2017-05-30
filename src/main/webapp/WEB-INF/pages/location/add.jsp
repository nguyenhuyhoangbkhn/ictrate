<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div id="body">
					<h1>THÊM ĐỊA CHỈ MỚI</h1>
					<div>
						<select id="mySelect" class="form-control">
							<option value="0" label="Type of Location" />
							<option value="1" label="Thành Phố - Tỉnh" />
							<option value="2" label="Quận - Huyện - Thị Xã" />
							<option value="3" label="Xã - Phường - Thị Trấn" />
						</select>
					</div>

					<div id="selectProvince">
						<form:form method="post" action="addProvince">
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
								</form:select>
							</div>

							<div>
								<input class="btn btn-submit" type="submit" value="Thêm" />
							</div>
						</form:form>
					</div>

					<div id="selectDistrict">
						<form:form method="post" action="addDistrict">
							<div class="form-group">
								<label for="name">Tên địa điểm:</label>
								<form:input path="name" class="form-control form-input-default"
									required="required" />
							</div>
							<div class="form-group">
								<label for="note">Kiểu địa điểm:</label>
								<form:select path="type" class="form-control">
									<form:option value="0" label="Select" />
									<form:option value="Quận" label="Quận" />
									<form:option value="Huyện" label="Huyện" />
									<form:option value="Thị Xã" label="Thị Xã" />
								</form:select>
							</div>
							<div class="form-group">
								<label for="note">Trực thuộc Thành phố - Tỉnh:</label>
								<form:select path="id_parent" class="form-control">
									<form:option value="0" label="Select" />
									<c:forEach var="location" items="${locationList}">
										<form:option value="${location.id}" label="${location.name}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<input class="btn btn-submit" type="submit" value="Thêm" />
							</div>
						</form:form>
					</div>

					<div id="selectWard">
						<form:form method="post" action="addWard">
							<div class="form-group">
								<label for="name">Tên địa điểm:</label>
								<form:input path="name" class="form-control form-input-default"
									required="required" />
							</div>
							<div class="form-group">
								<label for="note">Kiểu địa điểm:</label>
								<form:select path="type" class="form-control">
									<form:option value="0" label="Select" />
									<form:option value="Xã" label="Xã" />
									<form:option value="Phường" label="Phường" />
									<form:option value="Thị Trấn" label="Thị Trấn" />
								</form:select>
							</div>
							<div class="form-group">
								<label for="note">Trực thuộc Thành phố - Tỉnh:</label>
								<form:select path="id" class="form-control"
									id="provinceSelection" onchange="searchAjax() ;">
									<form:option value="0" label="Select" />
									<c:forEach var="location" items="${locationList}">
										<form:option value="${location.id}" label="${location.name}" />
									</c:forEach>
								</form:select>
							</div>
							<div id="district" class="form-group">
								<label for="note">Trực thuộc Quận-Huyện-Thị Xã:</label>
								<form:select path="id_parent" class="form-control">
									<form:option value="0" label="Select" />
									<c:forEach var="location" items="${DistrictList}">
										<form:option value="${location.id}" label="${location.name}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<input class="btn btn-submit" type="submit" value="Thêm" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>