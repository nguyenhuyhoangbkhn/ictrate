<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Update Criteria</title>
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
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div>
     <h1>Add New Staff</h1>
     <form:form method="post" action="updateTypeCriteria"
      modelAttribute="typeCireriaDao">
      <table>
       <tr>
        <td><form:hidden path="id" /></td>
       </tr>

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
          <form:option value="0" label="Tieu chi lon" />
          <c:forEach var="criteria" items="${typeCriteriaList}">
           <form:option value="${criteria.id}" label="${criteria.name}" />
          </c:forEach>
         </form:select></td>
       </tr>
       <tr>
        <td></td>
        <td><input type="submit" value="update"
         class="submitTypeCriteria" /></td>
       </tr>
      </table>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>