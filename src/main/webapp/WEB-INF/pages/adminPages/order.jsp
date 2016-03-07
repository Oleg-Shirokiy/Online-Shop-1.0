<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="basketForm">
        <div class="basketInput">
            <span class="basketInputSign">firstName: ${order.firstName}</span>
        </div>

        <div class="basketInput">
            <span class="basketInputSign">secondName: ${order.secondName}</span>
        </div>

        <div class="basketInput">
            <span class="basketInputSign">phoneNumber: ${order.phoneNumber}</span>
        </div>

        <div class="basketInput">
            <span class="basketInputSign">email: ${order.email}</span>
        </div>

        <div class="basketInput">
            <span class="basketInputSign">address: ${order.address}</span>
        </div>

        <div class="basketInput">
            <span class="basketInputSign">message: ${order.message}</span>
        </div>
</div>
<div id="productListInBasket">
    <c:forEach var="orderedProduct" items="${order.productList}">
        <div class="productInBasket">
            <span class="productNameInAllList"><a href="/product?id=${orderedProduct.productId}">${orderedProduct.name} - </a></span>
            <span class="productCodeInAllList">${orderedProduct.vendorCode} - </span>
            <span class="productPriceInAllList">${orderedProduct.price} - </span>
            <span class="productCurrencyInAllList">${orderedProduct.currency} - </span>
            <span class="productAvailInAllList">${orderedProduct.availability} - </span>
        </div>
    </c:forEach>
</div>
<div id="orderInfo">
    <p id="productNumber">${order.totalNumber}</p>
    <p id="totalPrice">${order.totalPrice}</p>
</div>
</body>
</html>
