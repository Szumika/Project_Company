<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 21.08.18
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Admin-groups</title>
</head>
<body>
<%@ include file="../security/jspf/admin_menu.jspf"%>

<c:forEach var="group" items="${groups1}">
    <div>
            ${group.groupName} - <a href="/grp/edit/${group.id}">Zmien nazwe</a> <a href="/employeeadmin/${group.id}">Lista pracowników</a>
    </div>
</c:forEach>

</body>
</html>
