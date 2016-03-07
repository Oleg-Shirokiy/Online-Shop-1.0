<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:23
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
<form:form method="post" action="/saveOrder" modelAttribute="order">
<div id="basketForm">

        <div class="basketInput">
            <span class="basketInputSign">firstName: </span>
            <input type="text" name="firstName" value="">
        </div>

        <div class="basketInput">
            <span class="basketInputSign">secondName: </span>
            <input type="text" name="secondName" value="">
        </div>

        <div class="basketInput">
            <span class="basketInputSign">phoneNumber: </span>
            <input type="text" name="phoneNumber" value="">
        </div>

        <div class="basketInput">
            <span class="basketInputSign">email: </span>
            <input type="text" name="email" value="">
        </div>

        <div class="basketInput">
            <span class="basketInputSign">address: </span>
            <input type="text" name="address" value="">
        </div>

        <div class="basketInput">
            <span class="basketInputSign">message: </span>
            <input type="text" name="message" value="">
        </div>

            <input type="submit" value="Send order">

</div>

<div id="productListInBasket">
    <c:forEach var="product" items="${productList}">
        <div class="productInBasket">
            <span class="productNameInBasket"><a href="/product?id=${product.id}">${product.name} - </a></span>
            <span class="productCodeInBasket">${product.vendorCode} - </span>
            <span class="productAvailInBasket">${product.availability} - </span>
            <span class="productPriceInBasket">${product.price} - </span>
            <span class="productCurrencyInBasket">${product.currency} - </span>
            <span class="productCategoryInBasket">in: ${product.category.categoryName}</span>

            <span class="productNumberInBasket">
                <input type="hidden" name="id" value="${product.id}">
                <input type="number" name="number" cols="3" min="0" value="${basket.get(product.id)}">
                <input type="hidden" name="name" value="${product.name}">
                <input type="hidden" name="vendorCode" value="${product.vendorCode}">
                <input type="hidden" name="price" value="${product.price}">
                <input type="hidden" name="currency" value="${product.currency}">
                <input type="hidden" name="availability" value="${product.availability}">
            </span>
        </div>
    </c:forEach>
</div>

        </form:form>
<div id="orderInfo">
    <p id="productNumber">${order.totalNumber}</p>
    <p id="totalPrice">${order.totalPrice}</p>
</div>
</body>
</html>
