<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>UserInfo Page</title>
<jsp:include page="home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js/uploadInfo.js"></script>
</head>
<body>
	<jsp:include page="home/_menu.jsp" />



	<div class="container perInfo">
		<div class="row">
			<div
				class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-2 col-lg-offset-2 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Thông tin cá nhân</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6 col-lg-6 " align="center">
								<c:if
									test="${pageContext.request.userPrincipal.name == userInfo.userName}">
									<img alt="User Pic"
										src="${pageContext.request.contextPath}/img/${userInfo.imgprofile}"
										class="img-thumbnail img-responsive">
								</c:if>
							</div>

							<div class=" col-md-6 col-lg-6 infoEditForm">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Tên tài khoản:</td>
											<td>${userInfo.userName}</td>
										</tr>
										<tr>
											<td>Chức vụ:</td>
											<td>Admin & Deverloper</td>
										</tr>
										<tr>
											<td>Ngày sinh:</td>
											<td>01/24/1988</td>
										</tr>

										<tr>
										<tr>
											<td>Giới tính:</td>
											<td>Nam</td>
										</tr>
										<tr>
											<td>Địa chỉ:</td>
											<td>Kathmandu,Nepal</td>
										</tr>
										<tr>
											<td>Email</td>
											<td><a href="mailto:info@support.com">info@support.com</a></td>
										</tr>
										<tr>
											<td>Điện thoại liên hệ</td>
											<td>1555-4567-890(Mobile)</td>
										</tr>
									</tbody>
								</table>
								<a href="#" class="btn btn-info btn-sm pull-right infoEdit"> <span
									class="glyphicon glyphicon-edit "></span> Chỉnh sửa
								</a>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<form:form action="savefiles" modelAttribute="uploadForm"
							enctype="multipart/form-data">
							<div id="fileTable">
								<div class="form-group">
									<input type="file" name="images" class="file">
									<div class="input-group col-md-12 col-xs-12">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-picture"></i></span> <input type="text"
											class="form-control input-lg" disabled
											placeholder="Upload ảnh đại diện"> <span
											class="input-group-btn">
											<button class="browse btn btn-primary input-lg" type="button">
												<i class="glyphicon glyphicon-search"></i> Browse
											</button>
										</span>
									</div>
								</div>
								<button type="submit" class="btn btn-success pull-right">
									<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
									Upload
								</button>
								<button type="reset" class="btn btn-warning">
									<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
									Reset
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>