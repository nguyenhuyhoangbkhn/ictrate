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
					<h1>Tạo tiêu chí mới</h1>
					<form:form method="post" action="addCriteria">
						<div class="form-group">
							<label for="name">Tên tiêu chí:</label> <input name="name"
								class="form-control" id="validateName" required="required" />
						</div>
						<div class="form-group">
							<label for="note">Ghi chú:</label> <input name="note"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="type_criteria">Loại tiêu chí:</label> <select
								name="type_criteria" class="form-control" required="required">
								<c:forEach var="typeCriteria" items="${typeCriteriaList}">
									<option value="${typeCriteria.id}">${typeCriteria.name}</option>
								</c:forEach>

							</select>
						</div>

						<div class="form-group">
							<label for="type_score">Loại điểm:</label> <select
								name="type_score" class="form-control" required="required">
								<c:forEach var="score" items="${stepScoreList}">
									<option value="${score.id}">${score.name} (${score.typeScore})</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="among">Điểm số thang điểm:</label> <input name="among"
								class="form-control" required="required" />
						</div>

						<div>
							<input type="submit" class="btn btn-submit submitTypeCriteria"
								value="Add" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>