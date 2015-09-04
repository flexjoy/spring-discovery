<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.springapp.Url" %>
<html>
<head>
    <title>Error</title>
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
<h2 class="error">Error!</h2>
<div class="errorblock">
    <p>Error message: <b><c:out value="${message}" /></b></p>
</div>
<br>
<spring:url value="<%=Url.HOME_PAGE%>" htmlEscape="true" var="url"/>
<a href="<c:out value="${url}" />">&lt; Back to home page</a>
</body>
</html>
