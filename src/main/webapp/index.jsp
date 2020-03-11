<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <title>Dice Master</title>
</head>

<body>
<h1>Dice Master - Main</h1>
<br/>
<a href="<c:url value="/races/list"/>">Races List</a>
<br/>
<a href="<c:url value="/classes/list"/>">Classes List</a>
<br/>
</body>
</html>