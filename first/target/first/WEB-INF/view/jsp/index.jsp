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
<iframe
    name="frame-main"
    src="/first/app/home"
    style="min-height: 70%; width: 100%;"
    frameBorder="0">
</iframe>
<br/>

<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>
