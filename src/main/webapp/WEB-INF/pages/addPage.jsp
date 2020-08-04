<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 04.08.2020
  Time: 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addPage</title>
</head>
<body>
<c:url value="/add" var="var"/>
<form action="${var}" method="POST">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="age">Age</label>
    <input type="text" name="age" id="age">
    <input type="submit" value="Add user">
</form>
</body>
</html>
