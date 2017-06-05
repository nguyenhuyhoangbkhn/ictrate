<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datatable.js"></script>

</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<c:if test="${officeList.size() > 0}">
					<div class="panel panel-default">
						<div class="panel-heading">Tìm kiếm văn phòng</div>
						<div class="panel-body">
							<c:forEach var="office" items="${officeList}">
								<div>${office.name} ${office.profile}</div>
							</c:forEach>
						</div>
					</div>
				</c:if>

				<c:if test="${criteriaList.size() > 0}">
					<div class="panel panel-default">
						<div class="panel-heading">Tìm kiếm tiêu chí</div>
						<div class="panel-body">
							<c:forEach var="criteria" items="${criteriaList}">
								<div>${criteria.name} ${criteria.note }</div>
							</c:forEach>
						</div>
					</div>
				</c:if>

				<c:if test="${stepScoreList.size() > 0}">
					<div class="panel panel-default">
						<div class="panel-heading">Tìm kiếm trong thang điểm</div>
						<div class="panel-body">
							<c:forEach var="stepscore" items="${stepScoreList}">
								<div>${stepscore.name} ${stepscore.note} ${stepscore.typeScore}
								</div> 
							</c:forEach>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>