<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Update Score</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajax/updateScore.js"></script>
<!-- Initialization code of data table at the time of page load. -->
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">Chỉnh sửa thang điểm</div>
					<div class="panel-body">
						<form method="post" id="update">
							<div class="form-group">
								<label for="name">tên loại điểm:</label>
								<input hidden="true" name="id" class="idStepScore" value="${stepScore.id }">
								 <input name="name"
									value="${stepScore.name }"
									class="form-control nameStepScore form-input-default"
									id="nameStepScore" required="required" />
							</div>
							<div class="form-group row">
								<div class="col-sm-6">
									<label for=typeScore>Loại điểm: </label> <select
										name="typeScore"
										class="form-control typeStepScore form-input-default"
										required="required">
										<option value="Định tính"
											<c:if test="${stepScore.typeScore.equals('Định tính')}"> selected="selected"</c:if>>
											Định tính</option>
										<option value="Định lượng"
											<c:if test="${stepScore.typeScore.equals('Định lượng')}"> selected="selected"</c:if>>
											Đinh lượng</option>
									</select>
								</div>
								<div class="col-sm-6">
									<label for="sel1">Loại điểm: </label> <select name="note"
										class="form-control noteStepScore form-input-default"
										id="noteStepScore" required="required">
										<option value="Điểm tăng dần"
											<c:if test="${stepScore.note.equals('Điểm tăng dần')}"> selected="selected"</c:if>>Điểm
											tăng dần</option>
										<option value="Điểm giảm dần"
											<c:if test="${stepScore.note.equals('Điểm giảm dần')}"> selected="selected"</c:if>>Điểm
											giảm dần</option>
									</select>
								</div>
							</div>

							<label for="detailScore">Chi tiết các bước điểm:</label>

							<div class="form-group row form-step-score">

								<c:forEach var="splt"
									items="${fn:split(stepScore.detailScore,'*/')}">
									<div class="form-group col-sm-6 row">

										<div class="flex col-sm-8">
											<c:if test="${not empty fn:trim(splt)}">
												<input name="detailScore" required="required"
													value="${splt}" class="form-control form-input-default detailStepScoreAdd"
													type="text" />
											</c:if>
										</div>
										<div class="col-sm-4">
											<a class="btn deleteBtn deleteStepScore">Delete</a>
										</div>
									</div>
								</c:forEach>
								<div class="col-sm-6 inserFlag">
									<button class="addStepScoreBtn btn btn-private row-sm-12">
									Thêm điểm</button>
								</div>
								<div class="col-sm-6">
									<button class="btn btn-update-score row-sm-12"> Chỉnh sửa</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>