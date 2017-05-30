<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-default">
	<div class="panel-heading">Danh sách các chuyên gia</div>
	<c:forEach var="expect" items="${expectList}">

		<div class="row expectlist">
			<div class="col-sm-4">
				<div class="image-avatar">
					<img class="avatar-expect"
						src="${pageContext.request.contextPath}/img/${expect.imgprofile}">
				</div>
			</div>
			<div class="col-sm-8">
				<div class="UserNameExpect">${expect.userName}</div>
			</div>
		</div>
		<hr>
	</c:forEach>
</div>