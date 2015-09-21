<html>
<head>
    <title><spring:message code="show.title"/></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <sec:authorize access="hasRole('ADMIN')">
    <script type="text/javascript">
        function confirm_delete(id) {
            if (!confirm("<spring:message code="delete.request"/>")) return false;
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
    </sec:authorize>
</head>
<body>
<%@ include file="/WEB-INF/include/userInfo.jspf" %>
<h2><spring:message code="show.title"/>:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th><spring:message code="show.tableHeaderId"/></th>
        <th><spring:message code="person.Name"/></th>
        <th><spring:message code="person.Age"/></th>
        <sec:authorize access="hasRole('ADMIN')">
        <th><spring:message code="show.tableHeaderAction"/></th>
        </sec:authorize>
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
            <sec:authorize access="hasRole('ADMIN')">
            <td>
                <spring:url value="<%=Url.CONFIRM_DELETE%>" var="confirmDeleteUrl">
                    <spring:param name="id" value="${person.id}" />
                </spring:url>
                <a href="${confirmDeleteUrl}" onclick="confirm_delete(${person.id});  return false;">
                    <spring:message code="label.delete"/>
                </a>
                &nbsp;
                <spring:url value="<%=Url.EDIT_PERSON%>" var="editPersonUrl">
                    <spring:param name="id" value="${person.id}" />
                </spring:url>
                <a href="${editPersonUrl}"><spring:message code="label.edit"/></a>
            </td>
            </sec:authorize>
        </tr>
    </c:forEach>
    <tr>
        <sec:authorize access="hasRole('ADMIN')">
            <c:set var="colspan" value="4" />
        </sec:authorize>
        <sec:authorize access="!hasRole('ADMIN')">
            <c:set var="colspan" value="3" />
        </sec:authorize>
        <td colspan="<c:out value="${colspan}" />">
            <spring:message code="show.totalPersons"/><c:out value="${personList.size()}" />
        </td>
    </tr>
</table>
<br>
<sec:authorize access="hasRole('ADMIN')">
    <spring:url value="<%=Url.ADD_PERSON%>" var="addPersonUrl"/>
    <a href="<c:out value="${addPersonUrl}" />"><spring:message code="link.addNewPerson"/></a>
</sec:authorize>
</body>
</html>
