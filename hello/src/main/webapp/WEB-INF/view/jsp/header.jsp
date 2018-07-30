<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="<c:url value="/app/home" />" target="frame-main">Quick Notes App</a>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="<c:url value="/app/home" />" target="frame-main">Notes</a>
                <a class="nav-item nav-link" href="<c:url value="/app/customer/" />" target="frame-main">Notebook</a>
                <a class="nav-item nav-link" href="<c:url value="/app/product/" />" target="frame-main">Settings</a>
                <a class="nav-item nav-link" href="#" target="frame-main">About</a>
            </div>
        </div>

        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search Notes" aria-label="Search">
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>