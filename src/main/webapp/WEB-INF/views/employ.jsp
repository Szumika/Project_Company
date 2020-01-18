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
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <style>
        body {

            background-color: #ffffff ;
            background-size: 100%;
        }
    </style>
</head>
<body style="text-align:center;">
<%@ include file="security/jspf/employee_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>
<div>
    Pracownicy:

        <c:forEach var="e" items="${employees}">
            <div>${e.firstname} - ${e.lastname} - ${e.groupName}</div>
        </c:forEach>

</div>


</body>
</html>
