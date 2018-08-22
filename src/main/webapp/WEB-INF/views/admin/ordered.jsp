<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Orderes list</title>
    <%@ include file="../security/jspf/head_config.jspf"%>
</head>
<body>
<%@ include file="../security/jspf/admin_menu.jspf"%>
Zamownienia:
<c:forEach var="order" items="${orders}">
    <div>
            ${order.quantity} - ${order.item} - <a href="/delorder/${order.id}">usun</a>
    </div>
</c:forEach>

</body>
</html>
