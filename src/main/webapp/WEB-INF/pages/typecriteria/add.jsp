<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<h1>Add New Staff</h1>
	<form:form method="post" action="addTypeCriteria">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" class="validate" /></td>
			</tr>
			<tr>
				<td>Note :</td>
				<td><form:input path="note" /></td>
			</tr>
			<tr>
				<td>Id parent :</td>
				<td><form:select path="id_parent">
						<c:forEach var="criteria" items="${typeCriteriaList}">
							<form:option value="${criteria.id}" label="${criteria.name}" />
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add"
					onclick="return validateForm()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>