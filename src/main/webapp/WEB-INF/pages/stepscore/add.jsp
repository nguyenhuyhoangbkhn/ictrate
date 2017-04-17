<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Location List</title>
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
				<form:form method="post">
					<table>
						<tr class="form-group">
							<td>Name :</td>
							<td><form:input path="name"
									class="form-control nameStepScore" /></td>
						</tr>
						<tr class="form-group">
							<td>Note :</td>
							<td><form:input path="note"
									class="form-control noteStepScore" /></td>
						</tr>
						<tr class="form-group">
							<td>Detail Step Score:</td>
							<td><form:input path="detailScore"
									class="form-control detailStepScore1" id="detailStepScore1" /></td>
							<td><button class="btn deleteBtn">Delete</button></td>
						</tr>

						<tr class="formButtonAddStepForm">
							<td></td>
							<td>
								<button class="addStepForm">Add Step Score</button>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Add"
								class="submitTypeCriteria" /></td>
						</tr>
					</table>
				</form:form>
			</div>

		</div>
	</div>
</body>
</html>