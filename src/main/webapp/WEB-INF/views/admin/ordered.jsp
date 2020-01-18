<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Orderes list</title>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <%@ include file="../security/jspf/head_config.jspf"%>
    <style>
        body {

            background-color: #ffffff ;
            background-size: 100%;
        }
    </style>
</head>
<body style="text-align:center;">
<%@ include file="../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<h2>Zamownienia:</h2>
<c:forEach var="order" items="${orders}">
    <div>
           Ilosc: ${order.quantity} - ${order.item} - Status: ${order.status} - <a href="/status/edit/${order.id}">Zmien status</a>
                - <a href="/delorder/${order.id}">usun</a>
    </div>
</c:forEach>

</body>
</html>
