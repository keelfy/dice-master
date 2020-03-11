<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <title>Race Information</title>
</head>
<body>
<h1>Race Details</h1>

<table class="tg">
    <tr>
        <th width="60">ID</th>
        <th width="120">Name</th>
        <th width="60">Basic speed</th>
    </tr>
    <tr>
        <td>${race.id}</td>
        <td>${race.name}</td>
        <td>${race.speedModifier}</td>
    </tr>
</table>
</body>
</html>
