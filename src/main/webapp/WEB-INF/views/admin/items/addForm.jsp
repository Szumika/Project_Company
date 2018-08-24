<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit grp</title>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <style>
        body {

            background-image: url(${index1});
            background-size: 100%;
        }
    </style>
</head>
<body>
<%@ include file="../../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<form:form method="post" modelAttribute="item">
    <div>
        <form:label path="name">Nazwa:</form:label>
        <form:input path="name" id="name"/>
    </div>
    <div>
        <form:label path="color">Kolor</form:label>
        <form:input path="color" id="color"/>
    </div>
    <div>
        <form:label path="prize">Cena:</form:label>
        <form:input path="prize"  id="prize"/>
    </div>
    <div>
        <form:label path="description">Opis:</form:label>
        <form:input path="description" id="description"/>
    </div>
    <input type="submit">
</form:form>

</body>
</html>
