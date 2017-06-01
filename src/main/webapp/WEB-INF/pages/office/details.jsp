<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Office Details</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajax/cmtJudge.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/deleteDialog/commentDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js/loadMore.js"></script>
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="../home/_left.jsp" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">Thông tin chi tiết văn phòng</div>
					<div class="panel-body bg-success">
						<div>
							<label for="name">Tên văn phòng:</label>
							<h3 class="text-info">${officeDao.name}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Thông tin:</label>
							<h3 class="text-info">${officeDao.profile}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Địa điểm:</label>
							<h3 class="text-info">${officeDao.location}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Kiểu văn phòng:</label>
							<h3 class="text-info">${officeDao.type_office}</h3>
						</div>
						<div
							style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
							<label for="name">Điện thoại liên hệ:</label>
							<h3 class="text-info">${officeDao.phone}</h3>
						</div>
					</div>
				</div>
				<div>
					<c:forEach var="comment" items="${cmtList}">
						<div class="row row_${comment.cmtid} rowCmt">
							<div class="col-sm-2 col-md-1">
								<div class="thumbnail">
									<img class="img-responsive user-photo"
										src="${pageContext.request.contextPath}/img/${comment.imgprofile}">
								</div>
							</div>
							<div class="col-sm-10 col-md-11">
								<div class="panel panel-default">
									<div class="panel-heading">
										<strong>${comment.usernameid} </strong> <span
											class="text-muted">${comment.times}</span>
										<c:if
											test="${pageContext.request.userPrincipal.name == comment.usernameid}">
											<button type="button" class="close" aria-label="Close"
												onclick="showDialog('${comment.cmtid}');">
												<span aria-hidden="true">&times;</span>
											</button>
										</c:if>
									</div>
									<div class="panel-body">${comment.content}</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="cmtJudgeDiv"></div>
				<a href="#" id="loadMore" ><h4>Load More...</h4></a>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<div>
						<div class="panel panel-default">
							<div class="panel-heading">Để lại bình luận</div>
							<div class="panel-body">
								<label for="email" class="col-sm-2 control-label">Bình
									luận:</label>
								<div class="col-sm-10">
									<textarea class="form-control contentCmt" name="content"
										rows="5"></textarea>
								</div>
								<input class="officeIdCmt" name="officeid"
									value="${officeDao.id}" hidden="true">

								<button
									class="btn btn-info btn-circle text-uppercase pull-right btnCmt"
									onclick="commentJudge();">
									<span class="glyphicon glyphicon-share-alt"></span> Gửi bình
									luận
								</button>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>

		<!-- set up the modal to start hidden and fade in and out -->
		<div id="myModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- dialog body -->
					<div class="modal-body">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						Bạn muốn bình luận này?
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
								Đã xoá thành công bình luận!
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
	</div>
</body>
</html>