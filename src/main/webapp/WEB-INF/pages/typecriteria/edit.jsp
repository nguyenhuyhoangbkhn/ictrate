<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location List</title>
<jsp:include page="../home/lib.jsp" />
</head>
<body>
	<jsp:include page="../home/_menu.jsp" />
	<h1>Add New Staff</h1>
	<form:form method="post" action="updateTypeCriteria" modelAttribute="typeCireriaDao">
		<table>
			<tr>
				<td>id :</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Note :</td>
				<td><form:input path="note" /></td>
			</tr>
			<tr>
				<td>Id parent :</td>
				<td><form:input path="id_parent" /></td>
			</tr>
			<tr>
				<td>Flag delete :</td>
				<td><form:input path="flag_delede" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>