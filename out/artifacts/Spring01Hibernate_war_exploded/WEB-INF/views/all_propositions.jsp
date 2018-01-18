<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 18.01.18
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Tytuł</td>
        <td>Opis</td>

    </tr>
    <c:forEach items="${propositions}" var="book">
    <tr>

        <td>${book.title}</td>

        <td>${book.description}</td>

        </c:forEach>
    </tr>
</table>
</body>
</html>
