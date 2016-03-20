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
    <title>Order list</title>
</head>
<body>
<p><a href="/">Home</a></p>
<%--<div id="logout">--%>
    <%--<a href="/logout">Logout</a>--%>
<%--</div>--%>
<div id="order-list">
    <p>Orders</p>
    <c:forEach var="order" items="${orderList}">
        <div class="product-in-all-list-div">
            <span class="order-date-in-all-list-span"><a href="/admin/order?id=${order.id}">${order.date} - </a></span>
            <span class="order-first-name-in-all-list-span">${order.firstName} - </span>
            <span class="order-second-name-in-all-list-span">${order.secondName} - </span>
            <span class="order-size--in-all-list-span">${order.totalNumber} - </span>
            <span class="order-price-in-all-list-span">in: ${order.totalPrice}</span>
            <span class="order-status-in-all-list-span">
                <form:form method="post" action="/admin/changeOrderStatus">
                    <input type="hidden" name="orderId"  value="${order.id}">
                    <select name="status" size="1">
                        <option value="${order.orderStatus.id}">${order.orderStatus.name}</option>
                        <c:forEach var="orderStatus" items="${orderStatusList}">
                            <option value="${orderStatus.id}">${orderStatus.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Change">
                </form:form>
            </span>
        </div>
    </c:forEach>
</div>

</body>
</html>
