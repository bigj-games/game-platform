<%--
  Created by IntelliJ IDEA.
  User: arthan
  Date: 09.09.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Blackjack</title>
    <spring:url value="/resources/js/app/dojoConfig.js" var="dojoConfig" />
    <spring:url value="/webjars/dojo/1.10.4/dojo/dojo.js" var="dojo" />
    <spring:url value="/resources/js/app/blackjack.js" var="blackjackApp" />
    <script src="${dojoConfig}"></script>
    <script data-dojo-config="async: true, parseOnLoad: true" src="${dojo}"></script>
    <script src="${blackjackApp}"></script>
</head>
<body>
    <h1>Greeting, blackjack player ${username}</h1>
    <h2>Java Bean test: ${user.name}</h2>
</body>
</html>
