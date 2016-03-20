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
    <title>Order</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="order-view">
        <div class="order-view-item">
            <form:form method="post" action="/admin/changeOrderStatus">
                <input type="hidden" name="version" value="${order.version}">
                <input type="hidden" name="orderId"  value="${order.id}">
                <select name="status" size="1">
                    <option value="${order.orderStatus.id}">${order.orderStatus.name}</option>
                    <c:forEach var="orderStatus" items="${orderStatusList}">
                        <option value="${orderStatus.id}">${orderStatus.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Change">
            </form:form>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">firstName: ${order.firstName}</span>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">secondName: ${order.secondName}</span>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">phoneNumber: ${order.phoneNumber}</span>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">email: ${order.email}</span>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">address: ${order.address}</span>
        </div>

        <div class="order-view-item">
            <span class="order-view-sign">message: ${order.message}</span>
        </div>
</div>
<div id="product-list-in-order">
    <c:forEach var="orderedProduct" items="${order.productList}">
        <div class="product-in-order">
            <span class="product-name-in-all-list"><a href="/product?id=${orderedProduct.productId}">${orderedProduct.name} - </a></span>
            <span class="product-code-in-all-list">${orderedProduct.vendorCode} - </span>
            <span class="product-price-in-all-list">${orderedProduct.price} - </span>
            <span class="product-currency-in-all-list">${orderedProduct.currency} - </span>
            <span class="product-avail-in-all-list">${orderedProduct.availability} - </span>
        </div>
    </c:forEach>
</div>
<div id="order-info">
    <p id="product-number">${order.totalNumber}</p>
    <p id="total-price">${order.totalPrice}</p>
</div>
</body>
</html>
