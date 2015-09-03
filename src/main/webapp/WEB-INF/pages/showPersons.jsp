<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.springapp.Url" %>
<html>
<head>
    <title>Person list</title>
</head>
<body>
<h2>Person list:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach var="person" items="${personList}" varStatus="myIndex">
        <tr>
            <td>${myIndex.index + 1}</td>
            <td>${person.name}</td>
            <td>${person.age}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">Total persons: ${personList.size()}</td>
    </tr>
</table>
<br>
<a href="<%=Url.ADD_PERSON%>">Add new person</a>
</body>
</html>
