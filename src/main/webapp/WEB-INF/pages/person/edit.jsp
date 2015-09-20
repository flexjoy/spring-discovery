<html>
<head>
  <title><spring:message code="edit.title"/></title>
  <style>
    .error {
      color: #ff0000;
    }
  </style>
</head>
<body>
<jsp:include page="include/userInfo.jspf" />
<h2><spring:message code="edit.title"/>:</h2>

<form:form method="POST" modelAttribute="person">
  <table>
    <tr>
      <td><form:label path="id"><spring:message code="person.ID"/>: </form:label></td>
      <td><form:input path="id" disabled="true"/></td>
    </tr>
    <tr>
      <td><form:label path="name"><spring:message code="person.Name"/>: </form:label></td>
      <td><form:input path="name" /></td>
      <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
      <td><form:label path="age"><spring:message code="person.Age"/>: </form:label></td>
      <td><form:input path="age" /></td>
      <td><form:errors path="age" cssClass="error" /></td>
    </tr>
    <tr>
      <td></td>
      <td align="right"><input type="submit" value="<spring:message code="label.edit"/>"/></td>
      <td></td>
    </tr>
  </table>
</form:form>
<spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
<a href="<c:out value="${showPersonUrl}" />"><spring:message code="link.backToPersonList"/></a>
</body>
</html>

