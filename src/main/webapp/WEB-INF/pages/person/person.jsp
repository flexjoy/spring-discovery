<html>
<head>
    <title>Person detail</title>
</head>
<body>
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
<spring:url value="<%=Url.ADD_PERSON%>" var="addPersonUrl"/>
<a href="<c:out value="${showPersonUrl}" />">&lt; Back to person list</a> |
<a href="<c:out value="${addPersonUrl}" />">Add new person</a>
</body>
</html>
