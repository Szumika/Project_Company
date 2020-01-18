<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
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
<%@ include file="../security/jspf/employee_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

    <c:forEach var="warehouse" items="${warehousePP}">
        <div>
                ${warehouse.name} w ilości : ${warehouse.ilosc} - <a href="/warehouse/status/${warehouse.id}">Zużycie</a>
        </div>
    </c:forEach>



</body>
</html>
