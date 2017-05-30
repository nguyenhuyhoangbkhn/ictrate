<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html ">
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
					<form:form method="post" action="addTypeCriteria">

						<div class="form-group">
							<label for="name">tên tiêu chí:</label> <input name="name"
								class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="note">tên loại điểm:</label> <input name="note"
								class="form-control nameStepScore" required="required" />
						</div>
						<div class="form-group">
							<label for="note">tên loại điểm:</label>
							<select name="id_parent" class="form-control">
								<option value="0">Tiêu chí lớn</option>
								<c:forEach var="criteria" items="${typeCriteriaList}">
									<option value="${criteria.id}">${criteria.name}</option>
								</c:forEach>
							</select>
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