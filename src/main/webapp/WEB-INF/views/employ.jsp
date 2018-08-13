<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.08.18
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><html>
<head>
    <title>Title</title>
    <%@ include file="security/jspf/head_config.jspf"%>
</head>
<body>
<%@ include file="security/jspf/main_menu.jspf"%>
Pracownicy:
<ul>
    <c:forEach var="e" items="${employees}">
        <li>${e.firstname} - ${e.lastname} - ${e.group.groupName}</li>
    </c:forEach>

</ul>

</body>
</html>
