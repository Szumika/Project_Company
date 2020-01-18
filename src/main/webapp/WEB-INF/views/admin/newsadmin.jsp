<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 12.08.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Aktualnosci</title>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
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

<h2>Dodaj</h2>
<div><a href="/add/news">Dodaj news</a> </div>
<h2>Aktualnosci:</h2>
<c:forEach var="news" items="${news1}">
    <p>${news.title} - <a href="/news/edit/${news.id}">edycja</a> -<a href="newsdel/${news.id}">usun</a></p>
</c:forEach>
</body>
</html>
