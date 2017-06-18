<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home>
    <jsp:body>
        <div><a href="/basic/sections/${id}">Go to back</a></div>
        <form action="/basic/sections/add" method="POST">
            <input type="hidden" name="library_id" value="${id}" />
            <div>Name:</div>
            <div><input type="text" name="name" /></div>
            <div>Description:</div>
            <div><textarea name="description"></textarea></div>
            <div><input type="submit" value="Add section" /></div>
        </form>
    </jsp:body>
</t:home>
