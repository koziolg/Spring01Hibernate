<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 17.01.18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${violations}" var="violation">
    ${violation.propertyPath} : ${violation.message}

</c:forEach>

</body>
</html>
