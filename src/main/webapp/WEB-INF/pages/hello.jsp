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

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 1px solid #ff0000;
            padding: 10px;
            margin: 5px;
        }
    </style>
</head>
<body>

<h2>Person Information Request</h2>

<form:form method="POST" modelAttribute="person" >
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <td>ФИО :</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Возраст :</td>
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
