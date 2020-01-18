<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 12.08.18
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Order</title>
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
<%@ include file="security/jspf/main_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>


<form:form method="post" modelAttribute="order">
    <div>
        <form:label path="quantity">Ilość:</form:label>
        <form:input path="quantity"  id="quantity"/>
    </div>
    <div>
        <form:label path="item">Produkt:</form:label>
        <form:select  path="item.id" items="${items}"
                     itemLabel="name" itemValue="id"/>
        <form:errors path="item"></form:errors>
    </div>
    <div>
        <form:errors path="*" />
    </div>
    <input type="submit">
</form:form>
<%--<input type="submit">--%>
</body>
</html>
