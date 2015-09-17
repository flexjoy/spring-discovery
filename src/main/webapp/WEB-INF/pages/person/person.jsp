<html>
<head>
    <title>Person detail</title>
</head>
<body>
<jsp:include page="include/userInfo.jspf" />
<h2>Person detail:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <td><c:out value="${person.id}" /></td>
    </tr>
    <tr>
        <th>Name</th>
        <td><c:out value="${person.name}" /></td>
    </tr>
    <tr>
        <th>Age</th>
        <td><c:out value="${person.age}" /></td>
    </tr>
</table>
<br>
<spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
<a href="<c:out value="${showPersonUrl}" />">&lt; Back to person list</a>
<sec:authorize access="hasRole('ADMIN')">
    &nbsp;|&nbsp;
    <spring:url value="<%=Url.ADD_PERSON%>" var="addPersonUrl"/>
    <a href="<c:out value="${addPersonUrl}" />">Add new person</a>
</sec:authorize>
</body>
</html>
