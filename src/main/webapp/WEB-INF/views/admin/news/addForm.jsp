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

<form:form method="post" modelAttribute="news">
    <div>
        <form:label path="title">Tytul:</form:label>
        <form:input path="title" id="title"/>
    </div>
    <div>
        <form:label path="description">Opis:</form:label>
        <form:input path="description" id="description"/>
    </div>
    <input type="submit">
</form:form>

</body>
</html>
