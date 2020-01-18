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

            background-color: #ffffff ;
            background-size: 100%;
        }
    </style>
</head>
<body style="text-align:center;">
<%@ include file="../../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<form:form method="post" modelAttribute="employee">
    <div>
        <form:label path="firstname">Imię:</form:label>
        <form:input path="firstname" id="firstname"/>
    </div>
    <div>
        <form:label path="lastname">Nazwisko:</form:label>
        <form:input path="lastname" id="lastname"/>
    </div>
    <div>
        <form:label path="salaryPerHouer">Stawka na godzine:</form:label>
        <form:input path="salaryPerHouer"  id="salaryPerHouer"/>
    </div>
    <div>
        <form:label path="hoursPerMonth">Ilosc godzin w miesiącu:</form:label>
        <form:input path="hoursPerMonth"  id="hoursPerMonth"/>
    </div>

    <form:hidden path="group.id"></form:hidden>
    <input type="submit">
</form:form>

</body>
</html>
