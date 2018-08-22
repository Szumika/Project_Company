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
</head>
<body>
<%@ include file="../security/jspf/admin_menu.jspf"%>
<h3>Dodaj</h3>
<div><a href="/add/news">Dodaj news</a> </div>
<h3>Aktualnosci:</h3>
<c:forEach var="news" items="${news1}">
    <p>${news.title} - <a href="/news/edit/${news.id}">edycja</a> -<a href="newsdel/${news.id}">usun</a></p>
</c:forEach>
</body>
</html>
