<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<%@ include file="../../security/jspf/admin_menu.jspf"%>

<form:form method="post" modelAttribute="employee">
    <div>
        <form:label path="firstname">Imie:</form:label>
        <form:input path="firstname" id="firstname"/>
    </div>
    <div>
        <form:label path="lastname">Nazwisko:</form:label>
        <form:input path="lastname" id="lastname"/>
    </div>
    <div>
        <form:label path="salaryPerHouer">Stawka na godzine:</form:label>
        <form:input path="salaryPerHouer" type="number" id="salaryPerHouer"/>
    </div>


    <form:hidden path="group.id"></form:hidden>
    <input type="submit">
</form:form>

</body>
</html>
