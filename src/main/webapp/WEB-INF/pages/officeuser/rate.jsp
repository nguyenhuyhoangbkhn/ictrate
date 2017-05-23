<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datatable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js/expect.js"></script>
<!-- Initialization code of data table at the time of page load. -->
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>${office.name}</div>
				<div>
					<form:form method="get" action="officeUserRate">
						<c:forEach var="criteria" items="${criteriaList}">
							<div class="form-group rateCriteria">
								Tiêu chí ${criteria.name}:
								<div class="form-group">
									<select class="form-control" name="criteria" required>
										<option value = "">Chọn điểm</option>
										<c:forEach var="splt"
											items="${fn:split(criteria.type_criteria,'*/')}">
											<c:if test="${not empty fn:trim(splt)}">
												<option value = "${splt}">${splt}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:forEach>
						<div class="form-group">
							<label>Ghi chú về cơ quan</label>
							<textarea name = "noteOffice"class="form-control" rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-default">Đánh giá</button>
					</form:form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>