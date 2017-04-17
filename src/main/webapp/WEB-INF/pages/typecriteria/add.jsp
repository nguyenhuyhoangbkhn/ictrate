<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validateform.js"></script>

</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<h1>Tạo tiêu chí mới</h1>
	<form:form method="post" action="addTypeCriteria">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" id="validateName" /></td>
			</tr>
			<tr>
				<td>Note :</td>
				<td><form:input path="note" /></td>
			</tr>
			<tr>
				<td>Id parent :</td>
				<td><form:select path="id_parent">
						<form:option value= "0" label="Tiêu chí lớn" />
						<c:forEach var="criteria" items="${typeCriteriaList}">
							<form:option value="${criteria.id}" label="${criteria.name}" />
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" class ="submitTypeCriteria"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>