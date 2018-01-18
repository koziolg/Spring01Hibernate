<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 18.01.18
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.model"--%>
<form:form method="POST" action="/proposition/save" modelAttribute="book">
    Title: <form:input path="title"/><br>
    Author: <form:select path="authors" items="${authors}" itemLabel="firstName" itemValue="id" multiple="true"/><br>
    description: <form:input path="description"/><br>
    publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" multiple="true" /><br>
    Proposition: <form:radiobutton path="proposition" value="true"/>
    <input type="submit">
</form:form>
</body>
</html>
