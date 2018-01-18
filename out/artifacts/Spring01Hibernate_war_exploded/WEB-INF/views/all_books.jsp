<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 17.01.18
  Time: 09:48
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
        <td>autor</td>
        <td>tytul</td>
        <td>Wydawca</td>
        <td>Opis</td>
        <td>Ocena</td>
        <td>Edycja</td>
        <td>Usuń</td>
    </tr>
    <c:forEach items="${books}" var="book">
    <tr>
        <td>
            <c:forEach items="${book.authors}" var="author">
                ${author.firstName} ${author.lastName}
            </c:forEach>
        </td>
        <td>${book.title}</td>
        <td>${book.publisher.name}</td>
        <td>${book.description}</td>
        <td>${book.rating}</td>
        <td><a href="/book/update/${book.id}">EDYTUJ</a></td>
        <td><a href="/book/deleteAsk/${book.id}">USUN </a></td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
