<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>

<body>

<div class="container-fluid">
    <div class="row justify-content-md-center">
        <br/>
    </div>

    <div class="row align-items-center justify-content-md-center">
        <div class="col col-4">
            <div class="card">
                <div class="card-body">
                    <div>
                        <h5 class="card-title">Login to the Application</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Enter credentials to access app</h6>
                    </div>

                    <hr/>

                    <div>
                        <form action="${contextPath}/login" method="post">
                            <div class="form-group">
                                <label
                                    for="username">
                                    Username
                                </label>

                                <input
                                    type="text"
                                    class="form-control"
                                    id="username"
                                    name="username"/>
                            </div>

                            <div class="form-group">
                                <label
                                    for="password">
                                    Password
                                </label>

                                <input
                                    type="password"
                                    class="form-control"
                                    id="password"
                                    name="password"
                                    placeholder="Password"/>
                            </div>

                            <hr/>

                            <div>
                                <input
                                    type="hidden"
                                    name="${_csrf.parameterName}"
                                    value="${_csrf.token}"/>
                            </div>

                            <div>
                                <button
                                    type="submit"
                                    class="btn btn-primary">
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>