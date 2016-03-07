<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:15
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
<div id="orderList">
    <p>Orders</p>
    <c:forEach var="order" items="${orderList}">
        <div class="productInAllListDiv">
            <span class="orderDateInAllList"><a href="/order?id=${order.id}">${order.date} - </a></span>
            <span class="orderFirstNameInAllList">${order.firstName} - </span>
            <span class="orderSecondNameInAllList">${order.secondName} - </span>
            <span class="orderStatusInAllList">${order.orderStatus} - </span>
            <span class="orderSizeInAllList">${order.totalNumber} - </span>
            <span class="orderPriceInAllList">in: ${order.totalPrice}</span>
        </div>
    </c:forEach>
</div>

</body>
</html>
