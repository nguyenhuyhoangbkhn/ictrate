<%@page session="false"%>
<html>
<head>
<title>Access Denied</title>
<jsp:include page="home/lib.jsp"/>
</head>
<body>
<jsp:include page="home/_menu.jsp"/>
 
    <h3 style="color:red;">${message}</h3>
</body>
</html>