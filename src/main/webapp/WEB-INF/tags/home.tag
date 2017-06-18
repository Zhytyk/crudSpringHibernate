<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <title>Localized Dates</title>
</head>
<body>
    <header>
        <h1>Welcome</h1>
        <a href="/basic/user/login">Log in</a>
    </header>
    <section>
        <jsp:doBody/>
    </section>
    <footer>
         <p id="copyright">Made it by Paul Vaidalauskas</p>
    </footer>
</body>
</html>