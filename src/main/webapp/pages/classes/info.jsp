<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <title>Class Information</title>
</head>
<body>

<h1>Class Details</h1>
<table class="tg">
    <tr>
        <th width="60">ID</th>
        <th width="120">Name</th>
        <th width="120">Description</th>
        <th width="60">Hit Dice</th>
    </tr>
    <tr>
        <td>${clazz.id}</td>
        <td>${clazz.name}</td>
        <td>${clazz.description}</td>
        <td>k${clazz.hitDice}</td>
    </tr>
</table>
</body>
</html>
