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
        <div class="categoryInAllListDiv">
            <span class="productInAllListSpan">${product.name} - ${product.availability} - ${product.price} - ${product.currency} - in: ${product.category.categoryName}</span></div>
    </c:forEach>
</div>
</body>
</html>
