<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home>
    <jsp:body>
        <div><a href="/basic">Go to back</a></div>
        <form action="/basic/library/edit" method="POST">
            <input type="hidden" name="id" value="${library.getId()}" />
            <div>Name:</div>
            <div><input type="text" name="name" value="${library.getName()}" /></div>
            <div>Description:</div>
            <div><textarea name="description"><c:out value="${library.getDescription()}" /></textarea></div>
            <div>Date:</div>
            <div><input type="date" name = "date" value = "${library.getDate()}"/></div>
            <div><input type="submit" value="Edit library" /></div>
        </form>
    </jsp:body>
</t:home>
