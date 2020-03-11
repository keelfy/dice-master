<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <title>Classes</title>
</head>
<body>
<a href="../index.jsp">Back</a>

<br/>
<br/>

<h1>Classes List</h1>

<c:if test="${!empty listClasses}">
    <table class="tg">
        <tr>
            <th width="120">Name</th>
            <th width="120">Description</th>
            <th width="60">Hit Dice</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listClasses}" var="clazz">
            <tr>
                <td><a href="/classes/info/${clazz.id}" target="_blank">${clazz.name}</a></td>
                <td>${clazz.description}</td>
                <td>k${clazz.hitDice}</td>
                <td><a href="<c:url value='/classes/edit/${clazz.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/classes/remove/${clazz.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Class</h1>

<c:url var="addAction" value="/classes/add"/>

<form:form action="${addAction}" commandName="clazz">
    <table>
    <c:if test="${!empty clazz.name}">
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="description">
                <spring:message text="Description"/>
            </form:label>
        </td>
        <td>
            <form:input path="description"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="hitDice">
                <spring:message text="Hit Dice (eg. 8)"/>
            </form:label>
        </td>
        <td>
            <form:input path="hitDice"/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty clazz.name}">
                <input type="submit"
                       value="<spring:message text="Edit Class"/>"/>
            </c:if>
            <c:if test="${empty clazz.name}">
                <input type="submit"
                       value="<spring:message text="Add Class"/>"/>
            </c:if>
        </td>
    </tr>
    </table>
</form:form>
</body>
</html>