<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${title}</title>
<jsp:include page="home/lib.jsp" />
</head>
<body>
	<jsp:include page="home/_menu.jsp" />
	<h1>Message : ${message}</h1>
</body>
</html>