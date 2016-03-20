<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome in our shop!</title>
    <!--REQUIRED STYLE SHEETS-->
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <!-- FONTAWESOME STYLE CSS -->
    <link href="resources/assets/css/font-awesome.min.css" rel="stylesheet">
    <!-- VEGAS STYLE CSS -->
    <link href="resources/assets/scripts/vegas/jquery.vegas.min.css" rel="stylesheet">
    <!-- CUSTOM STYLE CSS -->
    <link href="resources/assets/css/style.css" rel="stylesheet">
    <!-- GOOGLE FONT -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="header" class="navbar-header">
    <div id="basketPanel">
        <a href="/showBasket">Basket: ${basket.size()}</a>
    </div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p class="navMenuItem">
            <a href="/logout">Logout</a>
        </p>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
        <p class="navMenuItem">
            <a href="/login.jsp">Login</a>
        </p>
    </sec:authorize>
        <p class="navMenuItem">
            <a href="/productList">Product list</a>
        </p>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p class="navMenuItem">
            <a href="/admin/categoryBuilder">Category Builder</a>
        </p>
        <p class="navMenuItem">
            <a href="/admin/productBuilder">Product Builder</a>
        </p>
        <p class="navMenuItem">
            <a href="/admin/orderList">Order list</a>
        </p>
        <p class="navMenuItem">
            <a href="/admin/settings">Settings</a>
        </p>
        <p class="navMenuItem">
            <a href="/admin/vendors">Vendors</a>
        </p>
        <p class="navMenuItem">
            <a href="/admin/attributeBuilder">Attribute template builder</a>
        </p>
    </sec:authorize>
</div>

<%--<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->--%>
<!-- CORE JQUERY  -->
<script src="resources/assets/plugins/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP CORE SCRIPT   -->
<script src="resources/assets/plugins/bootstrap.js"></script>
<!-- VEGAS SLIDESHOW SCRIPTS -->
<script src="resources/assets/plugins/vegas/jquery.vegas.min.js"></script>
<!-- SCROLL SCRIPTS -->
<script src="resources/assets/plugins/jquery.easing.min.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="resources/assets/js/custom.js"></script>
</body>
</html>
