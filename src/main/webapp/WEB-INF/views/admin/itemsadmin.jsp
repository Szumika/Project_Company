<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 12.08.18
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><html>

<head>
    <title>Title</title>
    <%@ include file="../security/jspf/head_config.jspf"%>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <style>
        body {

            background-image: url(${index1});
            background-size: 100%;
        }
    </style>
</head>
<body>
<%--<%@ include file="security/jspf/menu.jspf"%>--%>
<%@ include file="../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<h2>Artykuly:</h2>
<div>
    <ul>
        <c:forEach var="item" items="${items}">
            <li>Nazwa produktu: ${item.name} Kolor: ${item.color} Cena: ${item.prize} zl -
                <a href="/item/edit/${item.id}">edycja</a> - <a href="item/del/${item.id}">usum</a> </li>
        </c:forEach>
    </ul>
</div>
<div>
    <h3><a href="/add/items">Dodaj produkt</a> </h3>
</div>
</body>
</html>
