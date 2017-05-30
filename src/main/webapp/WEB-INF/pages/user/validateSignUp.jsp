<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ĐĂNG KÝ</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajax/signUp.js"></script>
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container">
		<div id="loginbox"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<H1>ĐĂNG KÝ TÀI KHOẢN MỚI</H1>
			<form:form class="form-horizontal" id="formSignUp" action="signUp"
				method="POST">

				<label>Tên tài khoản: </label>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>
					<form:input type="text" id="username" class="form-control"
						path="userName" placeholder="Tên tài khoản" required="required" />
				</div>

				<p class="help-block">Tên tài khoản bao gồm tất cả các ký tự chữ
					và số, không bao gồm dấu cách.</p>


				<label>Mật khẩu: </label>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span>
					<form:input type="password" id="password" class="form-control passwordfield"
						path="password" placeholder="Mật khẩu" required="required" />
					<span class="input-group-addon eyeOpen"><i
						class="glyphicon glyphicon-eye-open"></i></span>

				</div>
				<p class="help-block">Mật khẩu tối thiểu 4 ký tự.</p>
				<div class="control-group">
					<div class="input-group">
						<span class="errorValidate">Tên tài khoản đã tồn tại, mời
							bạn đặt tên khác</span><br>
						<button class="btn btn-success">ĐĂNG KÝ</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>