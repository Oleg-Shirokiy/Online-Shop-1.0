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
<div id="product">
    <form:form method="post" action="/addToBasket">
        <input type="hidden" name="id" value="${product.id}">
        <input type="hidden" name="redirect" value="/product?id=${product.id}">
        <span>
            <input type="number" name="number" cols="3" min="1" value="1">
            <input type="submit" value="Add to basket">
        </span>
    </form:form>
    <div class="productAttribute">
        <span class="productAttributeContent">category: ${product.category.categoryName}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">vendorCode: ${product.vendorCode}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">name: ${product.name}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">price: ${product.price}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">currency: ${product.currency}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">imageLink: ${product.imageLink}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">availability: ${product.availability}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">vendor: ${product.vendor}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">keyWords: ${product.keyWords}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">description: ${productContent.description}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">imageLinks: ${productContent.imageLinks}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">exCategoryID: ${product.exCategoryID}</span>
    </div>
    <div class="productAttribute">
        <span class="productAttributeContent">exProductID: ${product.exProductID}</span>
    </div>
</div>

</body>
</html>
