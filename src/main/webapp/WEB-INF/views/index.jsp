<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value="/resources/js/timer.js" var="timer"/>
<c:url value="/resources/jpg/tlo.jpg" var="index1"/>
<c:url value="/resources/jpg/piwo.jpg" var="index2"/>
<c:url value="/resources/jpg/rzetelna_firma.jpg" var="index3"/>
<c:url value="/resources/jpg/eu.png" var="index4"/>

<html>
<head>
    <script  src="${timer}"></script>
    <%@ include file="security/jspf/head_config.jspf"%>
    <style>
        body {

            background-image: url(${index1});
            background-size: 100%;
        }
    </style>
</head>
<body onload="odliczanie();">
<div id='watch'>12:00:00</div>
<%@ include file="security/jspf/main_menu.jspf"%>
<c:url value="/resources/css/style.css" var="style"/>
<link href="${style}" rel="stylesheet"/>


<h2>O firmie</h2>



<%--<p> Ta firma zajmuje sie ... jestesmy na runku od ... I pisze takich pare rzeczy mozna napisac</p>--%>

<img class="index2" src="${index2} ">

<h2>Gwarancja jakosci</h2>
<div class="bottom">Zapewniamy jakos i zadowolenie z naszych uslug ! Jestesmy tez czescia projektu Rzetelna Firma :)</div>
<div class="right">
    <img class="index3" src="${index3}">     <img class="index4" src="${index4}">

</div>

</body>
</html>
