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
<%@ include file="../security/jspf/admin_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>

<h2>Dodaj</h2>
<div><a href="/add/warehouse">Dodaj przedmiot do magazynu</a> </div>
<h2>Magazyn:</h2>
    <c:forEach var="warehouse" items="${warehouse}">
        <p>${warehouse.name} w ilośći : ${warehouse.ilosc} status: ${warehouse.warehouseStatus.status}-
            <a href="/warehouse/edit/${warehouse.id}">edit</a> <a href="warehousdel/${warehouse.id}">usun</a> </p>
        </div>
    </c:forEach>



</body>
</html>
