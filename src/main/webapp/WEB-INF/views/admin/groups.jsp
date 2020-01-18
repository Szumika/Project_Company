<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Admin-groups</title>
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

<c:forEach var="group" items="${groups1}">
    <div>
            ${group.groupName} - <a href="/grp/edit/${group.id}">Zmien nazwe</a> <a href="/employeeadmin/${group.id}">Lista pracowników</a>
    </div>
</c:forEach>

</body>
</html>
