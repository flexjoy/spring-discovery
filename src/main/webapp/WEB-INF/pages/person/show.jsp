<html>
<head>
    <title>Person list</title>
</head>
<body>
<h2>Person list:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach var="person" items="${personList}" varStatus="myIndex">
        <tr>
            <td>${myIndex.count}</td>
            <td>
                <c:set var="subUrl" scope="session" value="<%=Url.PERSON%>"/>
                <spring:url value="${subUrl}${person.id}" htmlEscape="true" var="url"/>
                <a href="<c:out value="${url}" />"><c:out value="${person.name}" /></a>
            </td>
            <td><c:out value="${person.age}" /></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">Total persons: ${personList.size()}</td>
    </tr>
</table>
<br>
<spring:url value="<%=Url.ADD_PERSON%>" htmlEscape="true" var="url"/>
<a href="<c:out value="${url}" />">Add new person</a>
</body>
</html>
