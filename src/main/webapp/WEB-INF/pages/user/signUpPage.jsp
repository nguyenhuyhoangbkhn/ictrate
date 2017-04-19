<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ĐĂNG KÝ</title>
<jsp:include page="../home/lib.jsp" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<H1>ĐĂNG KÝ TÀI KHOẢN MỚI</H1>
				<form class="form-horizontal" action="signUp" method="POST">
					<fieldset>
						<div class="control-group">
							<!-- Username -->
							<label class="control-label" for="username">TÊN TÀI KHOẢN</label>
							<div class="controls">
								<span>👤</span> <input type="text" id="username" name="userName"
									placeholder="Tên tài khoản" class="input-xlarge">
								<p class="help-block">Tên tài khoản bao gồm tất cả các ký tự
									chữ và số,</p><p class="help-block">không bao gồm dấu cách.</p>
							</div>
						</div>


						<div class="control-group">
							<!-- Password-->
							<label class="control-label" for="password">MẬT KHẨU</label>
							<div class="controls">
								<span>🔒</span> <input type="password" id="password"
									name="password" placeholder="Mật khẩu" class="input-xlarge">
								<p class="help-block">Mật khẩu tối thiểu 4 ký tự.</p>
							</div>
						</div>

						<div class="control-group">
							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success">ĐĂNG KÝ</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>