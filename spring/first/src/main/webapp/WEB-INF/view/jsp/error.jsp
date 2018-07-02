<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>

<body>

<div>
    <h3>The Application encountered an error.</h3>

    <p>GO back to <a href="/">Home</a>.</p>
</div>

</body>
</html>
