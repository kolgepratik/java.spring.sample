<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en" style="min-height: 100%; height: 100%">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>

<body style="min-height: 100%; height: 100%">

<c:import url="header.jsp" />

<br/>

<div style="min-height: 80%; height: 80%">
    <iframe
        src="/first/app/home"
        height="100%"
        width="100%"
        frameBorder="0">
    </iframe>
</div>

<br/>

<c:import url="footer.jsp" />

</body>
</html>
