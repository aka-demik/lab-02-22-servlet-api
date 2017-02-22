<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список студентов</title>
</head>
<body>

<table>
    <caption>Список студентов</caption>
    <thead>
    <th>Имя</th>
    <th>Фамилия</th>
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
