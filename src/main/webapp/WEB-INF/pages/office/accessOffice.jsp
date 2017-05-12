<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office List</title>
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
					<h1 class="text">DANH SÁCH VĂN PHÒNG</h1>


					<c:forEach var="office" items="${officeList}">
						<div class="tr_${office.id} col-sm-4 col-md-3">
							<form:form method="post" id="addAccessOffice${office.id}">
								<div></div>
								<div>
									<span class="glyphicon glyphicon-erase"></span>${office.name}</div>
								<div>
									<span class="glyphicon glyphicon-phone"></span>${office.phone}</div>
								<div>
									<span class="glyphicon glyphicon-globe"></span>${office.location}</div>
								<!-- 
								<div>
									<select name="test" class="form-control" required="required">
										<c:forEach var="user" items="${userList}">
											<option value="${user.userName}">${user.userName}</option>
										</c:forEach>
									</select>
								</div>
								 -->

								<div>
									<a href="${pageContext.request.contextPath}/criteria/edit?=${criteria.id}" class="btn btn-submit" value="Giao quyền" /></a>
								</div>
							</form:form>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</body>
</html>