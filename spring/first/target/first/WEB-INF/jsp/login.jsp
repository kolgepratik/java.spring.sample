<html>
<body>

<div>
    <h3>Login to the Application</h3>

    <hr/>

    <form action="/login">
        <div><input
            type="text"
            name="username"
            placeholder="Username"/>
        </div>

        <div><input
            type="password"
            name="password"
            placeholder="Password"/>
        </div>

        <hr/>

        <div><input
            type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
        </div>

        <div>
            <button type="submit">Login</button>
        </div>
    </form>
</div>

</body>
</html>
