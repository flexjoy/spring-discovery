<html>
<head>
    <title>Person list</title>
    <script type="text/javascript">
        function confirm_delete(id){
            if(confirm("Delete person?"))
            {
                var url = "<%=Url.DELETE_PERSON%>".replace("{id}", id);
                window.location = url;
            }
            return false;
        }
    </script>
</head>
<body>
<h2>Person list:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    <c:forEach var="person" items="${personList}" varStatus="myIndex">
        <tr>
            <td>${myIndex.count}</td>
            <td>
                <a href="<c:out value="${person.id}" />">
                    <c:out value="${person.name}" />
                </a>
            </td>
            <td><c:out value="${person.age}" /></td>
            <td>
                <a href="#" onclick="confirm_delete(${person.id})">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            Total persons: <c:out value="${personList.size()}" />
        </td>
    </tr>
</table>
<br>
<spring:url value="<%=Url.ADD_PERSON%>" var="addPersonUrl"/>
<a href="<c:out value="${addPersonUrl}" />">Add new person</a>
</body>
</html>
