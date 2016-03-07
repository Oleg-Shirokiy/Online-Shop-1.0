<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:12
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
<p><a href="/">Home</a></p>
<div id="basketPanel">
    <a href="/showBasket">Basket: ${basket.size()}</a>
</div>
    <div id="allCategories">
        <p>Categories</p>
        <c:forEach var="category" items="${categoryList}">
            <div class="categoryInAllListDiv">
                <span class="categoryInAllListSpan">${category.level}-lvl: ${category.categoryName}</span></div>
        </c:forEach>
    </div>
<div id="allProducts">
    <p>Products</p>
    <c:forEach var="product" items="${productList}">
        <div class="productInAllListDiv">
            <span class="productNameInAllList"><a href="/product?id=${product.id}">${product.name} - </a></span>
            <span class="productCodeInAllList">${product.vendorCode} - </span>
            <span class="productAvailInAllList">${product.availability} - </span>
            <span class="productPriceInAllList">${product.price} - </span>
            <span class="productCurrencyInAllList">${product.currency} - </span>
            <span class="productCategoryInAllList">in: ${product.category.categoryName}</span>
            <form:form method="post" action="/addToBasket">
                <input type="hidden" name="id" value="${product.id}">
                <input type="hidden" name="redirect" value="/productList">
                <span>
                    <input type="number" name="number" cols="3" min="1" value="1">
                    <input type="submit" value="Add to basket">
                    </span>
            </form:form>
        </div>
    </c:forEach>
</div>
</body>
</html>
