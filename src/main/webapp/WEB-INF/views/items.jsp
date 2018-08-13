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
    <%@ include file="security/jspf/head_config.jspf"%>
</head>
<body>
<%--<%@ include file="security/jspf/menu.jspf"%>--%>
<%@ include file="security/jspf/main_menu.jspf"%>
Artykuly:
<div>
    <ul>
        <c:forEach var="item" items="${items}">
            <li>Nazwa produktu: ${item.name} Kolor: ${item.color} Cena: ${item.prize} zl</li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
