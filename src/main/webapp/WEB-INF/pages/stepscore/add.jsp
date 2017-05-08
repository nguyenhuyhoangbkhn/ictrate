<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Step score add</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajax/stepScore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lib/ajax-jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stepScore.css">
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1>Create step score</h1>
				<form method="post" id="xxx">
					<div class="form-group">
						<label for="name">tên loại điểm:</label> <input name="name"
							class="form-control nameStepScore form-input-default"
							id="nameStepScore" required="required" />
					</div>
					<div class="form-group">
						<label for=typeScore>Loại điểm: </label> 
						<select name="typeScore"
							class="form-control typeStepScore form-input-default" required="required">
							<option>Định tính</option>
							<option>Điểm lượng</option>
						</select>
					</div>
					<div class="form-group">
						<label for="sel1">Loại điểm: </label> 
						<select name="note"
							class="form-control noteStepScore form-input-default"
							id="noteStepScore" required="required">
							<option>Điểm tăng dần</option>
							<option>Điểm giảm dần</option>
						</select>
					</div>
					<div class="form-group formButtonAddStepForm">
						<label for="detailScore">Chi tiết các bước điểm:</label>
						<div class="flex">
							<input name="detailScore" required="required"
								class="form-control detailStepScoreAdd form-input-default" />
							<button class="addStepForm btn btn-private">Add Step
								Score</button>
						</div>
					</div>

					
					<div>
						<input type="submit" class="btn btn-submit" value="Add" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>