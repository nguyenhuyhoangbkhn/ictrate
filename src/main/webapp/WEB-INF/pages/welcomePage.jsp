<%@page session="false"%>
<html>
<head>
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="_menu.jsp" />
	<h1>Message : ${message}</h1>
</body>
</html>