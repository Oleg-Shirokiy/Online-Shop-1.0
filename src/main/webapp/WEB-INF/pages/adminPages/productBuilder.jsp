<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:21
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
<div id="productBuilder">
    <form:form method="post" action="/admin/saveProduct">
            <div class="builderInput">
                <span class="builderInputSign">category</span>
                <select name="categoryID" size="1">
                    <option value=""></option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}">${category.level}-lvl: ${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
        <form:form method="post" action="/admin/saveProduct" modelAttribute="Product">
        <div class="builderInput">
            <%--<span class="builderInputSign">categoryID</span>--%>
            <%--<select name="category" size="1">--%>
                <%--<c:forEach var="category" items="${categoryList}">--%>
                    <%--<option value="${category.id}">${category.level}-lvl: ${category.categoryName}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        <%--</div>--%>
        <div class="builderInput">
            <span class="builderInputSign">vendorCode</span>
            <input type="text" name="vendorCode" value="">
        </div>
        <div class="builderInput">
            <span class="builderInputSign">name</span>
            <input type="text" name="name" value="">
        </div>
        <div class="builderInput">
            <span class="builderInputSign">price</span>
            <input type="number" name="price" min="0" step="any" value="">
        </div>
        <div class="builderInput">
            <span class="builderInputSign">currency</span>
            <select name="currency" size="1">
                <c:forEach var="currency" items="${currencyEnum}">
                    <option value="${currency}">${currency}</option>
                </c:forEach>
            </select>
        </div>
        <div class="builderInput">
            <span class="builderInputSign">imageLink</span>
            <input type="text" name="imageLink" value="">
        </div>
        <div class="builderInput">
            <span class="builderInputSign">availability</span>
            <select name="availability" size="1">
                <c:forEach var="availability" items="${availabilityEnum}">
                    <option value="${availability}">${availability}</option>
                </c:forEach>
            </select>
        </div>
        <div class="builderInput">
            <span class="builderInputSign">vendor</span>
            <input type="text" name="vendor" value="">
        </div>
        <div class="builderInput">
            <span class="builderInputSign">keyWords</span>
            <textarea rows="5" cols="20" name="keyWords"></textarea>
        </div>

            <form:form method="post" action="/admin/saveProduct" modelAttribute="ProductContent">
                <div class="builderInput">
                    <span class="builderInputSign">description</span>
                    <textarea rows="10" cols="20" name="description"></textarea>
                </div>
                <div class="builderInput">
                    <span class="builderInputSign">imageLinks</span>
                    <textarea rows="5" cols="20" name="imageLinks"></textarea>
                </div>
                <input type="submit" value="Save product">
            </form:form>
        </form:form>

    </form:form>
</div>

</body>
</html>
