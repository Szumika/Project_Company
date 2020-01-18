<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 13.08.18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Admin Page</title>
    <script  src="${timer}"></script>
    <%@ include file="../security/jspf/head_config.jspf"%>
    <c:url value="/resources/jpg/tlo.jpg" var="index1"/>
    <style>
        body {
            background-color: #ffffff ;
            background-size: 100%;
        }
    </style>

</head>
<body style="text-align:center;">
<%@ include file="../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>
<p> Admin moze wszystko trzeba bedzie zrobic formularze do edycji usuwania dodoawania :) </p>
</body>
</html>
