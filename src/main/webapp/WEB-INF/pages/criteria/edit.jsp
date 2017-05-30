<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Step Score List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datatable.js"></script>
<!-- Initialization code of data table at the time of page load. -->
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>
					<h1>Cập nhật tiêu chí</h1>
					<form:form method="post" action="updateCriteria"
						modelAttribute="criteriaDao">
						
						<div class="form-group">
							<form:hidden path="id" class="form-control" />
						</div>

						<div class="form-group">
							<label for="name">Tên tiêu chí:</label>
							<form:input path="name" class="form-control" id="validateName"
								required="required" />
						</div>
						<div class="form-group">
							<label for="note">Ghi chú:</label>
							<form:input path="note" class="form-control" />
						</div>
						<div class="form-group">
							<label for="type_criteria">Loại tiêu chí:</label>
							<form:select path="type_criteria" class="form-control"
								required="required">
								<c:forEach var="typeCriteria" items="${typeCriteriaList}">
									<form:option value="${typeCriteria.id}">${typeCriteria.name}</form:option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group">
							<label for="type_score">Loại điểm:</label>
							<form:select path="type_score" class="form-control"
								required="required">
								<c:forEach var="score" items="${stepScoreList}">
									<form:option value="${score.id}">${score.name} (${score.typeScore})</form:option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group">
							<form:hidden path="flag_delete" class="form-control" />
						</div>

						<div class="form-group">
							<label for="among">Điểm số thang điểm:</label>
							<form:input path="among" class="form-control" required="required" />
						</div>

						<div>
							<input type="submit" class="btn btn-submit submitTypeCriteria"
								value="Update" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>