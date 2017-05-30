<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

				<!-- them bieu do tai day -->


				<div class="col-sm-8">
					<div class="panel panel-default">
						<div class="panel-heading">Xếp hạng</div>
						<div class="panel-body" style="margin: 0 15px;">
							<div class="row">
								<div class="">
									<c:forEach var="office" items="${officeList}">
										<div class="row office-stt">
											<div class="col-md-2 left-rank">${office.id }</div>
											<div class="col-md-10 right-rank">
												<div class="title-name">
													<a href="">${office.name }</a>
												</div>
												<div>${office.profile}</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="form-right">
						<jsp:include page="../home/_right.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- them js -->
	<script
		src="${pageContext.request.contextPath}/js/metisMenu/metisMenu.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/js/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/morrisjs/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/data/morris-data.js"></script>

	<script src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>

</body>
</html>