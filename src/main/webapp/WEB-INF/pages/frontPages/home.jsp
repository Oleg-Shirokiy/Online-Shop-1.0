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
    <title>Title</title>
</head>
<body>
<div id="basketPanel">
    <a href="/showBasket">Basket: ${basket.size()}</a>
</div>
<div id="header">
    <p class="navMenuItem">
        <a href="/productList">Product list</a>
    </p>
    <p class="navMenuItem">
        <a href="/admin/categoryBuilder">Category Builder</a>
    </p>
    <p class="navMenuItem">
        <a href="/admin/productBuilder">Product Builder</a>
    </p>
    <p class="navMenuItem">
        <a href="/admin/orderList">Order list</a>
    </p>
    </div>

</body>
</html>