<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <title>Races</title>
</head>
<body>
<a href="../index.jsp">Back</a>

<br/>
<br/>

<h1>Races List</h1>

<c:if test="${!empty listRaces}">
    <table class="tg">
        <tr>
            <th width="120">Name</th>
            <th width="120">Description</th>
            <th width="120">Speed Modifier</th>

            <c:forEach items="${listRaces}" var="race">
                <c:forEach items="${race.attributeBonuses.keySet}" var="attribute">
                    <th width="60">+${attribute.name}</th>
                </c:forEach>

                <c:forEach items="${race.abilityBonuses.keySet}" var="ability">
                    <th width="60">+${ability.name}</th>
                </c:forEach>
            </c:forEach>

            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listRaces}" var="race">
            <tr>
                <td><a href="/races/info/${race.id}" target="_blank">${race.name}</a></td>
                <td>${race.description}</td>
                <td>${race.speedModifier}</td>

                <c:forEach items="${race.attributeBonuses.values}" var="attribute">
                    <th width="60">${attribute.intValue}</th>
                </c:forEach>

                <c:forEach items="${race.abilityBonuses.values}" var="ability">
                    <th width="60">${ability.intValue}</th>
                </c:forEach>

                <td><a href="<c:url value='/races/edit/${race.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/races/remove/${race.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Race</h1>

<c:url var="addAction" value="/races/add"/>

<form:form action="${addAction}" commandName="race">
    <table>
        <c:if test="${!empty race.name}">
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
                <form:label path="speedModifier">
                    <spring:message text="Speed Modifier"/>
                </form:label>
            </td>
            <td>
                <form:input path="speedModifier"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty race.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Race"/>"/>
                </c:if>
                <c:if test="${empty race.name}">
                    <input type="submit"
                           value="<spring:message text="Add Race"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>