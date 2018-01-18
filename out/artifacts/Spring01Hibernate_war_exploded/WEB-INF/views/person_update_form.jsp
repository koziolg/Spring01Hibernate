<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 16.01.18
  Time: 22:59
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
<p1> Upadate</p1>
<%--@elvariable id="person" type="pl.coderslab.model.Person"--%>
<form:form method="post" action="/person/update" modelAttribute="person">
    <form:hidden path="id" />
    Login: <form:input path="login"/>
    Password: <form:password path="password"/>
    Email: <form:input path="email"/>
    First Name: <form:input path="details.firstName" />
    Last Name: <form:input path="details.lastName"/>
    Street: <form:input path="details.street" />
    Street number: <form:input path="details.streetNumber" />
    City: <form:input path="details.city" />

    Gender: <form:radiobuttons path="details.gender" items="${gender}" itemValue="id" itemLabel="name"  />


    Country: <form:select path="details.country" items="${countries}" />
    Notes: <form:textarea path="details.notes" />
    Mailing list: <form:checkbox path="details.mailing" value="Y" />
    <form:hidden path="details.id" />
    <input type="submit" value="save"/>
</form:form>
</body>
</html>