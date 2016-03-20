<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top scrollclass">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <li><a href="/showBasket">Basket: ${basket.size()}</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                <li><a href="/logout">Logout</a></li>

                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ANONYMOUS')">

                <li><a href="/login.jsp">Login</a></li>

                </sec:authorize>

                <li><a href="/productList">Product list</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">

                <li><a href="/admin/categoryBuilder">Category Builder</a></li>


                <li><a href="/admin/productBuilder">Product Builder</a></li>


                <li><a href="/admin/orderList">Order list</a></li>


                <li><a href="/admin/settings">Settings</a></li>


                <li><a href="/admin/vendors">Vendors</a></li>


                <li><a href="/admin/attributeBuilder">Attribute template builder</a></li>

            </ul>
        </div>
    </div>
</div>

</body>
</html>