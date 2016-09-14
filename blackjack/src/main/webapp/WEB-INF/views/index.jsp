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
    <spring:url value="/resources/js/bigj/" var="bigjPackage" />
    <spring:url value="/webjars/dojo/1.10.4/dojo/dojo.js" var="dojo" />
    <spring:url value="/resources/js/app/blackjack.js" var="blackjackApp" />
    <script>
        var dojoConfig = {
            isDebug: true,
            packages: [
                {
                    name: "bigj",
                    location: "${bigjPackage}"
                }
            ]
        };
    </script>
    <script data-dojo-config="async: true, parseOnLoad: true" src="${dojo}"></script>
    <script src="${blackjackApp}"></script>
</head>
<body>
    <h3>Greeting, blackjack player ${username}</h3>
    <div id="mainLayout"
         data-dojo-type="bigj/widget/Main">
    </div>
</body>
</html>
