<html>
<head>
  <title><spring:message code="delete.title"/></title>
</head>
<body>
<%@ include file="/WEB-INF/include/userInfo.jspf" %>
<h2><spring:message code="delete.request"/></h2>
<spring:url value="<%=Url.DELETE_PERSON%>" var="deleteUrl">
    <spring:param name="id" value="${id}" />
</spring:url>
<form:form method="delete" action="${deleteUrl}">
  <input type="submit" value="<spring:message code="label.delete"/>" />
  <input type="hidden" name="id" value="${id}" />
  <spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
  <a href="<c:out value="${showPersonUrl}"/>"><button type="button"><spring:message code="label.cancel"/></button></a>
</form:form>
</body>
</html>
