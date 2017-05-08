<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<h1 class="text">List Step Score</h1>

					<div class="button">
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/stepscore/add">Add</a>
					</div>
					<table id="myDatatable" class="table table-striped table-bordered table-hover"
							id="dataTables-example">
						<thead>
							<tr>
								<th>TÊN</th>
								<th>Ghi chú</th>
								<th>Định tính | Định lượng</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="score" items="${stepScoreList}">
								<tr class="tr_${score.id}">
									<td>${score.name}</td>
									<td>${score.note}</td>
									<td>${score.typeScore}</td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/stepscore/edit?id=${score.id}"
										class="btn btn-warning btn-sm"> <span
											class="glyphicon glyphicon-edit"></span>
									</a>|<a class="btn btn-danger btn-sm"
										onclick="showDialog('${score.id}');"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
			<!-- set up the modal to start hidden and fade in and out -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- dialog body -->
						<div class="modal-body">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							Bạn muốn xoá bản ghi này?
						</div>
						<!-- dialog buttons -->
						<div class="modal-footer">
							<button data-bb-handler="cancel" type="button"
								class="btn btn-default btnCancel">
								<i class="glyphicon glyphicon-remove"></i> Cancel
							</button>
							<button data-bb-handler="confirm" type="button"
								class="btn btn-primary btnConfirm">
								<i class="glyphicon glyphicon-ok"></i> Confirm
							</button>
						</div>
					</div>
				</div>
			</div>
			
			<div id="mySuccessModal" class="modal fade">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-body">
							<div class="bootbox-body">
								<h4>
									<span class="glyphicon glyphicon-ok-sign text-success"></span>
									Đã xoá thành công bản ghi!
								</h4>
							</div>
						</div>
						<div class="modal-footer">
							<button data-bb-handler="ok" type="button"
								class="btn btn-success btnOK">OK</button>
						</div>
					</div>
				</div>
			</div>
			
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/js/deleteDialog/scoreDialog.js"></script>
			
		</div>
	</div>

</body>
</html>