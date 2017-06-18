<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:home>
    <jsp:body>
        <p><a href="/basic">Go to back</a></p>
        <c:forEach var = "section" items="${sections}">
                <article>
                    <div><c:out value="${section.getName()}" /></div>
                    <div><c:out value="${section.getDescription()}" /></div>
                    <div><c:out value="${section.getDate().toString()}" /></div>
                    <div><a href="/basic/sections/edit/${section.getId()}">Edit</a></div>
                    <div>
                        <form method="POST" action="/basic/sections/delete">
                            <input type="hidden" name="id" value="${section.getId()}" />
                            <input type="submit" value="Delete" />
                        </form>
                    </div>
                </article>
        </c:forEach>
        <div><a href="/basic/sections/add/${sections.get(0).getLibrary().getId()}">Add section</a></div>
    </jsp:body>
</t:home>