<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a href="${pageContext.request.contextPath}/stepscore">Thang điểm</a></li>
		<li><a href="${pageContext.request.contextPath}/location">Địa chỉ</a></li>
		<li><a href="${pageContext.request.contextPath}/typecriteria">Loại tiêu chí</a></li>
		<li><a href="${pageContext.request.contextPath}/criteria">Tiêu chí</a></li>
		<c:if test="${userInfo.role.equals('ADMIN')}">
		<li><a href="${pageContext.request.contextPath}/accessOffice">Giao quyền</a></li>
		<li><a href="${pageContext.request.contextPath}/rank">Chạy xếp hạng</a></li>
		</c:if>
		<li><a href="${pageContext.request.contextPath}/office">Cơ quan</a></li>
		<c:if test="${userInfo.role.equals('EXPERT')}">
		<li><a href="${pageContext.request.contextPath}/scoreOffice">Danh gia co quan</a></li>
		</c:if>
		<c:if test="${userInfo.role.equals('OFFICE')}">
		<li><a href="${pageContext.request.contextPath}/officeuserrate">Danh gia co quan</a></li>
		</c:if>
	</ul>
</div>