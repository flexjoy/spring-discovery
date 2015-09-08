<html>
<head>
    <title>Person detail</title>
</head>
<body>
<h2>Person detail:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <td><c:out value="${person.getId()}" /></td>
    </tr>
    <tr>
        <th>Name</th>
        <td><c:out value="${person.getName()}" /></td>
    </tr>
    <tr>
        <th>Age</th>
        <td><c:out value="${person.getAge()}" /></td>
    </tr>
</table>
<br>
<spring:url value="<%=Url.SHOW_PERSON%>" htmlEscape="true" var="url1"/>
<spring:url value="<%=Url.ADD_PERSON%>" htmlEscape="true" var="url2"/>
<a href="<c:out value="${url1}" />">&lt; Back to person list</a> |
<a href="<c:out value="${url2}" />">Add new person</a>
</body>
</html>
