
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse navbar-fixed-top set-menu">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand project-name"
				href="${pageContext.request.contextPath}/welcome">RateICT</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right menu-tool">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="${pageContext.request.contextPath}/userInfo"><img
							class="proImgIcon"
							src="${pageContext.request.contextPath}/img/${userInfo.imgprofile}">
							${pageContext.request.userPrincipal.name}</a></li>
				</c:if>
				
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/signUpPage">Sign
							Up</a></li>
				</c:if>

			</ul>
			<form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/searchPage" method="get">
				<input type="text" class="form-control" name="searchPage"
					placeholder="Search...">
			</form>
		</div>
	</div>
</nav>

