<html>
<head>
    <title><spring:message code="person.title"/></title>
</head>
<body>
<jsp:include page="include/userInfo.jspf" />
<h2><spring:message code="person.title"/>:</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th><spring:message code="person.ID"/></th>
        <td><c:out value="${person.id}" /></td>
    </tr>
    <tr>
        <th><spring:message code="person.Name"/></th>
        <td><c:out value="${person.name}" /></td>
    </tr>
    <tr>
        <th><spring:message code="person.Age"/></th>
        <td><c:out value="${person.age}" /></td>
    </tr>
</table>
<br>
<spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
<a href="<c:out value="${showPersonUrl}" />"><spring:message code="link.backToPersonList"/></a>
<sec:authorize access="hasRole('ADMIN')">
    &nbsp;|&nbsp;
    <spring:url value="<%=Url.ADD_PERSON%>" var="addPersonUrl"/>
    <a href="<c:out value="${addPersonUrl}" />"><spring:message code="link.addNewPerson"/></a>
</sec:authorize>
</body>
</html>
