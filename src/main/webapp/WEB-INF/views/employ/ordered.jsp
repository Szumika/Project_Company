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
<%@ include file="../security/jspf/employee_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<h2>Raport z zamówienia:</h2>
<div style="text-align:center;">
    <table border="1" class="center">
        <tr>
            <td>Produkt:</td>
            <td>Ilość:</td>
            <td>Cena:</td>
            <td>Status:</td>
        </tr>
        <c:forEach var="order" items="${ordersRa}">
        <tr>
            <td>${order.item}</td>
            <td>${order.quantity}</td>
            <td>${order.price}</td>
            <td>${order.status}</td>
        </tr>
            <%--Ilosc: ${order.quantity} - ${order.item} - ${order.price} - Status: ${order.status}--%>
        </c:forEach>
</div>


</body>
</html>
