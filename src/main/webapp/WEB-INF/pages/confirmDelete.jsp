<html>
<head>
  <title>Confirm delete</title>
</head>
<body>
<h2>Delete person?</h2>
<spring:url value="<%=Url.DELETE_PERSON%>" var="deleteUrl">
    <spring:param name="id" value="${id}" />
</spring:url>
<form:form method="delete" action="${deleteUrl}">
  <input type="submit" value="Delete" />
  <input type="hidden" name="id" value="${id}" />
  <a href="..<%=Url.SHOW_PERSON%>" ><button type="button">Cancel</button></a>
</form:form>
</body>
</html>
