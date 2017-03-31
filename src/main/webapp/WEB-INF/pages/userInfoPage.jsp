<%@page session="false"%>
<html>
<head>
<title>${title}</title>
<jsp:include page="home/lib.jsp"/>
</head>
<body>
    <jsp:include page="home/_menu.jsp" />
 
 
    <h1>Message : ${message}</h1>
</body>
</html>