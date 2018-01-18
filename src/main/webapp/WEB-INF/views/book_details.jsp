<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 16.01.18
  Time: 09:43
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
        <td>Title</td>
        <td>${book.title}</td>
    </tr>
    <tr>
        <td>Authors</td>
        <td>
            <c:forEach items="${book.authors}" var="author">
                ${author.fristName} ${author.lastName} <br>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>Publisher</td>
        <td>${book.publisher.name}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${book.description}</td>
    </tr>
</table>

</body>
</html>
