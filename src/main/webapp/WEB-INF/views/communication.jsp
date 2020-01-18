<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
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
<h2>Kontakt</h2>
<div>
    Adres: Bochnia, ul Gazowa 4
</div>
<div>
    Tel: 666 666 666, 12 285 23 23
</div>
<div>
    Email: adresfirmowy@firma.pl
</div>
</body>
</html>
