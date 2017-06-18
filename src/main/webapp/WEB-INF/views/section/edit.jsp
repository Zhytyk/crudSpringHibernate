<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home>
    <jsp:body>
        <div><a href="/basic/sections/${section.getLibrary().getId()}">Go to back</a></div>
        <form action="/basic/sections/edit" method="POST">
            <input type="hidden" name="id" value="${section.getId()}" />
            <input type="hidden" name="library_id" value="${section.getLibrary().getId()}" />
            <div>Name:</div>
            <div><input type="text" name="name" value="${section.getName()}" /></div>
            <div>Description:</div>
            <div><textarea name="description"><c:out value="${section.getDescription()}" /></textarea></div>
            <div>Date:</div>
            <div><input type="date" name="date" value="${section.getDate()}"/></div>
            <div><input type="submit" value="Edit section" /></div>
        </form>
    </jsp:body>
</t:home>