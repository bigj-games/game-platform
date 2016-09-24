<%--
  Created by IntelliJ IDEA.
  User: arthan
  Date: 09.09.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:url var="loginUrl" value="/login" />
<form id="login" action="${loginUrl}" method="POST">
    <h1>Log In</h1>
    <fieldset id="inputs">
        <input id="username" name="username" type="text" placeholder="Username" autofocus required>
        <input id="password" name="password" type="password" placeholder="Password" required>
    </fieldset>
    <c:if test="${param.error != null}">
        Invalid username or password
    </c:if>
    <fieldset id="actions">
        <input type="submit" name="submit" id="submit" value="Log in">
        <a href="">Forgot your password?</a><a href="">Register</a>
    </fieldset>
</form>

</body>
</html>