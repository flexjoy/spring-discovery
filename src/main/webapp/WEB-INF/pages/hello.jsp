<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.springapp.Url" %>
<html>
<head>
    <title>Request</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>

<h2>Person Information Request</h2>

<form:form method="POST" modelAttribute="person" action="<%=Url.SHOW_PERSON%>">
    <table>
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
            <td colspan="3"><input type="submit" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>
