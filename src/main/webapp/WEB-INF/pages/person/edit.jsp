<html>
<head>
  <title>Edit person</title>
  <style>
    .error {
      color: #ff0000;
    }
  </style>
</head>
<body>

<h2>Edit person:</h2>

<form:form method="PUT" modelAttribute="person">
  <table>
    <tr>
      <td><form:label path="id">ID: </form:label></td>
      <td><form:input path="id" disabled="true"/></td>
    </tr>
    <tr>
      <td><form:label path="name">ФИО: </form:label></td>
      <td><form:input path="name" /></td>
      <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
      <td><form:label path="age">Возраст: </form:label></td>
      <td><form:input path="age" /></td>
      <td><form:errors path="age" cssClass="error" /></td>
    </tr>
    <tr>
      <td></td>
      <td align="right"><input type="submit" value="Edit person"/></td>
      <td></td>
    </tr>
  </table>
</form:form>
<spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
<a href="<c:out value="${showPersonUrl}" />">&lt; Back to person list</a>
</body>
</html>

