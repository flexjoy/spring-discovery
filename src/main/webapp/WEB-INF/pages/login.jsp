<html>
<head>
    <title><spring:message code="user.login"/></title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>

  <c:if test="${param.error != null}">
      <p class="error">
          <spring:message code="user.error"/><br />
          <c:out value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" />
      </p>
  </c:if>

  <h3><spring:message code="user.loginHeader"/></h3>

  <form name="f" action="<%=Url.LOGIN%>" method="POST">
      <table>
          <tr>
              <td><spring:message code="user.user"/></td>
              <td><input name="username" value="" type="text"></td>
          </tr>
          <tr>
              <td><spring:message code="user.password"/></td>
              <td><input name="password" type="password"></td>
          </tr>
          <tr>
              <td colspan="2" align="right">
                  <input name="submit" value="Login" type="submit">
              </td>
          </tr>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </table>
  </form>

  <spring:url value="<%=Url.SHOW_PERSON%>" var="showPersonUrl"/>
  <a href="<c:out value="${showPersonUrl}" />"><spring:message code="link.backToPersonList"/></a>

</body>
</html>
