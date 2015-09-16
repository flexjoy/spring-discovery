<html>
<head>
    <title>Person list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        function confirm_delete(id) {
            <sec:authorize access="!isAuthenticated()">
                window.location("<c:url value="login" />");
            </sec:authorize>
            if (!confirm("Delete person?")) return false;
            $.ajax({
                method: "POST",
                url: "<c:url value="<%=Url.DELETE_PERSON%>" />",
                data: {
                    id: id,
                    _method: "DELETE",
                    _csrf: "${_csrf.token}"
                }
            }).done(function(html) {
                $("body").html(html);
            });
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
                <spring:url value="<%=Url.CONFIRM_DELETE%>" var="confirmDeleteUrl">
                    <spring:param name="id" value="${person.id}" />
                </spring:url>
                <a href="${confirmDeleteUrl}" onclick="confirm_delete(${person.id});  return false;">Delete</a>
                <spring:url value="<%=Url.EDIT_PERSON%>" var="editPersonUrl">
                    <spring:param name="id" value="${person.id}" />
                </spring:url>
                <a href="${editPersonUrl}">Edit</a>
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
