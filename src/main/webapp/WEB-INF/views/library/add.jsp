<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home>
    <jsp:body>
        <div><a href="/basic">Go to back</a></div>
        <form action="/basic/library/add" method="POST">
            <div>Name:</div>
            <div><input type="text" name="name" /></div>
            <div>Description:</div>
            <div><textarea name="description"></textarea></div>
            <div><input type="submit" value="Add library" /></div>
        </form>
    </jsp:body>
</t:home>
