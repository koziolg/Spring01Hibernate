<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 16.01.18
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/publisher/update">
    <input type="hidden" name="id" value="${author.id}">
    Name: <input type="text" name="title" value="${publisher.name}"><br>

    <input type="submit">
</form>
</body>
</html>
