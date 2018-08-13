<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<%@ include file="security/jspf/main_menu.jspf"%>

<sec:authentication var="principal" property="principal" />
<form:form method="post" modelAttribute="order">
    <div>
        <form:label path="quantity">Ilosc:</form:label>
        <form:input path="quantity"  id="quantity"/>
        <form:errors path="quantity"></form:errors>
    </div>
    <div>
        <form:label path="item">Produkt:</form:label>
        <form:select path="item.id" items="${items}"
                     itemLabel="name" itemValue="id"/>
        <form:errors path="item"></form:errors>
    </div>

    <input type="submit">
</form:form>
<%--<input type="submit">--%>
</body>
</html>
