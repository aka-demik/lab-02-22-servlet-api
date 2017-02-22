<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>

<c:if test="${error != null}">
    <div>
        Случилась ошибка. Нам очень жаль. Возможно, сообщение ниже прояснит ситуацию.
    </div>
    <div>
        <c:out value="${error}"/>
    </div>
</c:if>

<table width="95%">
    <caption>Список студентов</caption>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    </thead>

    <c:forEach items="${users}" var="userItem">
        <tr>
            <td><c:out value="${userItem.firstName}"/></td>
            <td><c:out value="${userItem.lastName}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
