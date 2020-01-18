<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Edit grp</title>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <style>
        body {

            background-color: #ffffff ;
            background-size: 100%;
        }
    </style>
</head>
<body style="text-align:center;">
<%@ include file="../../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<form:form method="post" modelAttribute="work">
    Jaka ilość została przez Ciebie zużyta ?
    <div>
        <form:label path="ilosc">Ilosc:</form:label>
        <form:input path="ilosc" id="ilosc"/>
    </div>


    <input type="submit">
</form:form>

</body>
</html>
