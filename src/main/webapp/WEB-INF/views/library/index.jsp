<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:home>
    <jsp:body>
        <c:forEach var = "library" items="${libraries}">
                <article>
                    <div><c:out value="${library.getName()}" /></div>
                    <div><c:out value="${library.getDescription()}" /></div>
                    <div><c:out value="${library.getDate().toString()}" /></div>
                    <div><a href="/basic/library/edit/${library.getId()}">Edit</a></div>
                    <div>
                        <form method="POST" action="/basic/library/delete">
                            <input type="hidden" name="id" value="${library.getId()}" />
                            <input type="submit" value="Delete" />
                        </form>
                    </div>
                    <div><a href="/basic/sections/${library.getId()}">Go to sections</a></div>
                </article>
        </c:forEach>
        <div><a href="/basic/library/add">Add library</a></div>
    </jsp:body>
</t:home>