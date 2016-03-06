<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="product">
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
        <span class="productAttributeContent">productID: ${product.productID}</span>
    </div>
</div>

</body>
</html>
