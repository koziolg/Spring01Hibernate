<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 15.01.18
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="book" type="pl.coderslab.model"--%>
<form:form method="POST" action="/book/save" modelAttribute="book">
Title: <form:input path="title"/><br>
    <form:errors path="title" /><br>
Author: <form:select path="authors" items="${authors}" itemLabel="firstName" itemValue="id" multiple="true"/><br>
    <form:errors path="authors" /><br>
description: <form:input path="description"/><br>
    <form:errors path="description" /><br>
publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" multiple="true" /><br>
    <form:errors path="publisher" /><br>
<input type="submit">
</form:form>
</body>
</html>
