<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 12.03.16
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="availability-settings">
    <p class="settings-sign">Add new availability status</p>
    <form:form method="post" action="/admin/saveAvailabilityStatus" modelAttribute="availability">
        <input type="hidden" name="version" value="${vendor.version}">
        <input type="text" name="status" value="">
        <input type="submit" value="Add">
    </form:form>
    <div class="settings-list-of-existing">
        <c:forEach var="availability" items="${availabilityList}">
            <p class="settings-existing-item">
                    ${availability.status}
            </p>
        </c:forEach>
    </div>
</div>
<div class="currency-settings">
    <p class="settings-sign">Add new currency</p>
    <form:form method="post" action="/admin/saveCurrency" modelAttribute="currency">
        <input type="hidden" name="version" value="${vendor.version}">
        <input type="text" name="name" value="">
        <input type="submit" value="Add">
    </form:form>
    <div class="settings-list-of-existing">
        <c:forEach var="currency" items="${currencyList}">
            <p class="settings-existing-item">
                    ${currency.name}
            </p>
        </c:forEach>
    </div>
</div>
<div class="order-status-settings">
    <p class="settings-sign">Add new order status</p>
    <form:form method="post" action="/admin/saveOrderStatus" modelAttribute="orderStatus">
        <input type="hidden" name="version" value="${orderStatus.version}">
        <input type="text" name="status" value="">
        <input type="submit" value="Add">
    </form:form>
    <div class="settings-list-of-existing">
        <c:forEach var="currentOrderStatus" items="${orderStatusList}">
            <p class="settings-existing-item">
                    ${currentOrderStatus.status}
            </p>
        </c:forEach>
    </div>
</div>
</body>
</html>
