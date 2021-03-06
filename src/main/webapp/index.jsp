<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>QuickByg</title>
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css.css">

</head>
<body>
<%@include file="WEB-INF/include/header.jsp" %>
<div class="container mt-5 mb-5">
    <h1>QUICKBYG</h1>
</div>
<div class="container-fluid background">
    <div class="container background pt-5 pb-5">
        <b>QUICK-BYG TILBUD</b>
        <p>
            Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en
            carport<br>
            indenfor vores standardprogram, der tilpasses dine specifikke ønsker.<br>
            <br>
            Tilbud og skitsetegning fremsendes med post hurtigst muligt.<br>
            Ved bestilling medfølger standardbyggevejledning.<br>
            <br>
            Rekvirér tilbud - start med at vælge type:<br>
        </p>
        <hr>
        <div class="row justify-content-md-center">
            <div class="col-xs">
                <div class="container"><b>Carport med fladt tag:</b><br>
                    <form name="flatRoofCheck" action="FrontController" method="post">
                        <input type="hidden" name="command" value="flatRoofCheck">
                        <a href="FrontController?command=flatRoofCheck"><img class="img-fluid rounded" src="img/quickurejs.gif" alt="uden rejsning"></a>
                    </form>
                </div>
            </div>
        </div>
        <hr>
        <div class="row justify-content-md-center">
            <div class="col-xs">
                <div class="container"><b>Carport med rejsning:</b><br>
                    <form name="withRoofCheck" action="FrontController" method="post">
                        <input type="hidden" name="command" value="withRoofCheck">
                        <a href="FrontController?command=withRoofCheck"><img class="img-fluid rounded" src="img/quickmrejs.gif" alt="med rejsning"></a>
                    </form>
                </div>
            </div>
        </div>
        <hr>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<%@include file="WEB-INF/include/footer.jsp" %>
</body>
</html>
