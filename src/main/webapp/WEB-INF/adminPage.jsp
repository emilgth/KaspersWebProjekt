<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Adminside</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon-16x16.png" sizes="16x16"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css">
</head>
<body>

<%@include file="include/loggedInHeader.jsp" %>


<div class="container mt-5 mb-5"><h1>Adminside</h1>
    <h2>Velkommen ${sessionScope.user.surname}</h2></div>

<div class="container-fluid background mt-5" style="padding-bottom: 20%">
    <div class="container background  pt-5 pb-5">
        <div class="row">
            <form class="mr-2" name="showAdminOrders" action="FrontController" method="POST">
                <input type="hidden" name="command" value="showAdminOrders">
                <button class="btn btn-primary" type="submit" value="Se mine ordrer">Se alle ordrer</button>
            </form>

            <form class="mr-2" name="showNewOrders" action="FrontController" method="POST">
                <input type="hidden" name="command" value="showOrdersByStatus">
                <input type="hidden" name="status" value="pending">
                <button class="btn btn-primary" type="submit" value="Se mine ordrer">Se nye ordrer</button>
            </form>

            <form class="mr-2" name="showOrderByStatus" action="FrontController" method="POST">
                <input type="hidden" name="command" value="showOrdersByStatus">
                <input type="hidden" name="status" value="pending
">
                <button class="btn btn-primary" type="submit" value="Se mine ordrer">Se accepterede ordrer</button>
            </form>

        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<%@include file="include/footer.jsp" %>
</body>
</html>