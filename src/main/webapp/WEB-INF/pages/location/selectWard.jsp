<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
ID PARENT :
	<form:form method="post">
		<form:select path="id_parent">
			<form:option value="0" label="Select" />
			<c:forEach var="location" items="${DistrictList}">
				<form:option value="${location.id}" label="${location.name}" />
			</c:forEach>
		</form:select>
	</form:form>
	
