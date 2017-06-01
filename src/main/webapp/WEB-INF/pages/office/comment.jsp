<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2 col-md-1">
			<div class="thumbnail">
				<img class="img-responsive user-photo"
					src="${pageContext.request.contextPath}/img/${comment.imgprofile}">
			</div>
		</div>
		<div class="col-sm-10 col-md-11">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>${comment.usernameid}</strong> <span class="text-muted">${comment.times}</span>
				</div>
				<div class="panel-body">${comment.content}</div>
			</div>
		</div>
	</div>
</body>
</html>