<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<jsp:include page="home/lib.jsp" />
<body>
	<jsp:include page="home/_menu.jsp" />

	<div class="container">
		<div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<h1>ĐĂNG NHẬP TÀI KHOẢN</h1>

			<!-- /login?error=true -->
			<c:if test="${param.error == 'true'}">
				<div style="color: red; margin: 10px 0px;">

					Login Failed!!!<br /> Reason :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

				</div>
			</c:if>

			<h4>MỜI BẠN NHẬP VÀO TÊN TÀI KHOẢN VÀ MẬT KHẨU:</h4>

			<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
				<label>Tên tài khoản: </label>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input type="text"
						class="form-control" name="username" value=""
						placeholder="Tên tài khoản" required="required">
				</div>
				<label>Mật khẩu: </label>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input type="password"
						class="form-control passwordfield" name="password" placeholder="Mật khẩu" required="required">
						<span class="input-group-addon eyeOpen"><i
						class="glyphicon glyphicon-eye-open"></i></span>
				</div>

				<div class="form-group">
					<input name="submit" class="btn btn-success" type="submit"
						value="Đăng nhập" />
				</div>

				<div class="form-group">
					<div
						style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
						Bạn chưa có tài khoản! <a
							href="${pageContext.request.contextPath}/user/signUpPage">
							Đăng ký tại đây </a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>