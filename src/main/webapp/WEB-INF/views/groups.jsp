<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.08.18
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="security/jspf/head_config.jspf"%>
</head>
<body>
<%@ include file="security/jspf/main_menu.jspf"%>
    <c:forEach var="group" items="${groups}">
        <div>
                ${group.groupName} - <a href="/employee/${group.id}">Lista pracowników Brygady</a>
        </div>
    </c:forEach>



</body>
</html>
