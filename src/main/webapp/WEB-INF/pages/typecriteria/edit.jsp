<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Update Criteria</title>
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
					<h1>Update Tiêu Chí</h1>
					<form:form method="post" action="updateTypeCriteria"
						modelAttribute="typeCireriaDao">
						<div>
							<div class="form-group">
								<form:hidden path="id" />
							</div>
							<div class="form-group">
								<label for="name">Tên tiêu chí:</label>
								<form:input path="name" id="validateName"
									class="form-control" required="required" />
							</div>
							<div class="form-group">
								<label for="note">Tên loại điểm:</label>
								<form:input path="note" class="form-control nameStepScore"
									required="required" />
							</div>
							<div class="form-group">
								<label for="note">Tên loại điểm:</label>
								<form:select path="id_parent" class="form-control">
									<form:option value="0" label="Tiêu chí lớn" />
									<c:forEach var="criteria" items="${typeCriteriaList}">
										<form:option value="${criteria.id}" label="${criteria.name}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<input type="submit"
									class="btn btn-submit submitTypeCriteria" value="update" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>