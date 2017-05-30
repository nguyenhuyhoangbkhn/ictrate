<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>UserInfo Page</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js/uploadInfo.js"></script>
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />



	<div class="container perInfo">
		<div class="row">
			<div
				class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-2 col-lg-offset-2 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Cập nhật thông tin cá nhân</h3>
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
								<form:form method="post" action="updateUserInfo"
									modelAttribute="userInfo1">
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>Tên tài khoản:</td>
												<td>${userInfo1.userName}<form:hidden path="userName"/></td>
											</tr>
											<tr>
												<td>Chức vụ:</td>
												<td>${userInfo1.role}<form:hidden path="role"/></td>
											</tr>
											<tr>
												<td>Mật khẩu:</td>
												<td><div class="input-group userInfoPass"><form:input type="password"
														class="form-control passwordfield" path="password"
														required="required" /><span
													class="input-group-addon eyeOpen"><i
														class="glyphicon glyphicon-eye-open"></i></span></div></td>
											</tr>
											<tr>
												<td>Ngày sinh:</td>
												<td><form:input path="dob" class="form-control"
														required="required" /></td>
											</tr>
											<tr>
											<tr>
												<td>Giới tính:</td>
												<td><form:input path="gender" class="form-control"
														required="required" /></td>
											</tr>
											<tr>
												<td>Địa chỉ:</td>
												<td><form:input path="address" class="form-control"
														required="required" /></td>
											</tr>
											<tr>
												<td>Email</td>
												<td><form:input path="mail" class="form-control"
														required="required" /></td>
											</tr>
											<tr>
												<td>Điện thoại liên hệ</td>
												<td><form:input path="telephone" class="form-control"
														required="required" /></td>
											</tr>
										</tbody>
									</table>
									<button type="submit" class="btn btn-info pull-right">
										<span class="glyphicon glyphicon-saved"></span> Cập nhật
									</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>