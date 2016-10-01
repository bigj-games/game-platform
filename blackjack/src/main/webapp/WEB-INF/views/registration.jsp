<%--
  Created by IntelliJ IDEA.
  User: arthan
  Date: 09.09.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<html>
<head>
    <title>Registration</title>
    <link href="<spring:url value="/resources/css/registration.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:url var="registerUrl" value="/register" />
<form id="registration" action="${registerUrl}" method="POST">
    <h1>Registration</h1>
    <fieldset id="inputs">
        <input id="username" name="username" type="text" placeholder="Username" autofocus required>
        <input id="password" name="password" type="password" placeholder="Password" required>
        <input id="repeatedPassword" name="repeatedPassword" type="password" placeholder="Repeat password" required>
    </fieldset>
    <c:if test="${param.exists != null}">
        User with this name already exists.
    </c:if>
    <fieldset id="actions">
        <input type="submit" name="submit" id="submit" value="Sign Up">
    </fieldset>
</form>

</body>
</html>