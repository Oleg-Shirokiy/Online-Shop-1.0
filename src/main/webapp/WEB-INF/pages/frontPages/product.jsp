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
    <title>${product.name}</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="basket-panel">
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
    <div class="product-attribute">
        <span class="product-attribute-content">category: ${product.category.name}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">vendorCode: ${product.vendorCode}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">name: ${product.name}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">price: ${product.price}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">currency: ${product.currency.name}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">imageFile: ${product.imageLink}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">availability: ${product.availability.status}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">vendor: ${product.vendor.name}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">keyWords: ${product.keyWords}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">description: ${productContent.description}</span>
    </div>
    <div class="product-attribute">
        <span class="product-attribute-content">imageLinks:</span>
        <c:forEach var="imageLink" items="${imageLinks}">
            <p>${imageLink}</p>
        </c:forEach>
    </div>

</div>

</body>
</html>
