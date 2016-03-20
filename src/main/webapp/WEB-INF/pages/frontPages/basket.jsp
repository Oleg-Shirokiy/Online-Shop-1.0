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
    <title>Basket</title>
</head>
<body>
<p><a href="/">Home</a></p>
<form:form method="post" action="/saveOrder" modelAttribute="order">
<div id="basket-form">

        <div class="basket-input">
            <span class="basket-input-sign">firstName: </span>
            <input type="text" name="firstName" value="">
        </div>

        <div class="basket-input">
            <span class="basket-input-sign">secondName: </span>
            <input type="text" name="secondName" value="">
        </div>

        <div class="basket-input">
            <span class="basket-input-sign">phoneNumber: </span>
            <input type="text" name="phoneNumber" value="">
        </div>

        <div class="basket-input">
            <span class="basket-input-sign">email: </span>
            <input type="text" name="email" value="">
        </div>

        <div class="basket-input">
            <span class="basket-input-sign">address: </span>
            <input type="text" name="address" value="">
        </div>

        <div class="basket-input">
            <span class="basket-input-sign">message: </span>
            <input type="text" name="message" value="">
        </div>

            <input type="submit" value="Send order">

</div>

<div id="product-list-in-basket">
    <c:forEach var="product" items="${productList}">
        <div class="product-in-basket">
            <span class="product-name-in-basket"><a href="/product?id=${product.id}">${product.name} - </a></span>
            <span class="product-code-in-basket">${product.vendorCode} - </span>
            <span class="product-avail-in-basket">${product.availability.status} - </span>
            <span class="product-price-in-basket">${product.price} - </span>
            <span class="product-currency-in-basket">${product.currency.name} - </span>
            <span class="product-category-in-basket">in: ${product.category.name}</span>

            <span class="product-number-in-basket">
                <input type="hidden" name="id" value="${product.id}">
                <input type="number" name="number" cols="3" min="0" value="${basket.get(product.id)}">
                <input type="hidden" name="name" value="${product.name}">
                <input type="hidden" name="vendorCode" value="${product.vendorCode}">
                <input type="hidden" name="price" value="${product.price}">
                <input type="hidden" name="currency" value="${product.currency.name}">
                <input type="hidden" name="availabilityStatus" value="${product.availability.status}">
            </span>
        </div>
    </c:forEach>
</div>

        </form:form>
<div id="order-info">
    <p id="product-number">${order.totalNumber}</p>
    <p id="total-price">${order.totalPrice}</p>
</div>
</body>
</html>
