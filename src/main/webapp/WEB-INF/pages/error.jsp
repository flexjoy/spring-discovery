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
            font-size: 0.8em;
        }
    </style>
</head>
<body>
<h2 class="error">Error!</h2>
<div>
    <p><b>${name}: </b>${exception.message}</p>
</div>
<spring:url value="<%=Url.HOME_PAGE%>" var="url"/>
<a href="<c:out value="${url}" />">&lt; Back to home page</a>
<br>
<br>
<div class="errorblock">
    <b>Detailed information:</b>
        <br>
    <c:forEach items="${exception.stackTrace}" var="ste">
        ${ste}
    </c:forEach>
</div>
</body>
</html>
