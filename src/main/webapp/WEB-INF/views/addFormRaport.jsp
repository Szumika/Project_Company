<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page contentType="text/html; charset=UTF-8"  isELIgnored="false" %>
<html>
<head>
    <title>Add Order</title>
    <%@ include file="security/jspf/head_config.jspf"%>
    <c:url value="/resources/jpg/head.png" var="index1"/>
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

<h2>Wygeneruj raport</h2>
<form:form method="post" modelAttribute="itemR">

    <div align="center">
        Data od(rrrr-mm-dd): <input name="date1" type="text" maxlength="10" size="10">
    </div>
    <div align="center">
        Data do(rrrr-mm-dd): <input name="date2" type="text" maxlength="10" size="10">
    </div>
    <div align="center">
        <form:label path="name">Produkt:</form:label>
        <form:checkboxes path="name" items="${itemsR}"
                     itemLabel="name" itemValue="name"/>
    </div>
    <%--<div>--%>
        <%--<form:label path="name">Produkt:</form:label>--%>
        <%--<form:select path="name"--%>
                     <%--itemLabel="name" itemValue="id"/>--%>
    <%--</div>--%>

    <input type="submit" align="center">
</form:form>
<%--<input type="submit">--%>
</body>
</html>
