<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 12.08.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Aktualnosci</title>
    <%@ include file="security/jspf/head_config.jspf"%>
</head>
<body>
<%@ include file="security/jspf/main_menu.jspf"%>

<p>Aktualnosci:</p>
<c:forEach var="news" items="${news}">
    <h3>${news.title}</h3>
    <p>${news.created}</p>
    <div>
        ${news.description}
    </div>


</c:forEach>
</body>
</html>
