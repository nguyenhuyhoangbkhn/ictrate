<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<jsp:include page="home/lib.jsp" />
</head>
<body>
	<jsp:include page="home/_menu.jsp" />


	<h1>Message : ${message}</h1>
	<div>
		<table>
			<tr>
				<td>Tên :</td>
				<td><label>${pageContext.request.userPrincipal.name}</label></td>
			</tr>
			<tr>
				<td>Ảnh đại diện:</td>
				<td><c:forEach var="users" items="${userList}">
						<c:if
							test="${pageContext.request.userPrincipal.name == users.userName}">
							<img class="proImg"
								src="${pageContext.request.contextPath}/img/${users.imgprofile}">
						</c:if>
					</c:forEach></td>
			</tr>
		</table>
	</div>
	<div>
		<form:form action="savefiles"
			modelAttribute="uploadForm" enctype="multipart/form-data">
			<table id="fileTable">
				<tr>
					<td><input name="images" type="file" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Upload" />
			<input type="reset" value="Reset" />
		</form:form>
	</div>
</body>
</html>