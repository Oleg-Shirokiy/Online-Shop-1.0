<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<div id="header">
    <p><a href="/">Home</a></p>
    <div id="basket-panel" style="float: left">
        <a href="/showBasket">Basket: ${basket.size()}</a>
    </div>
</div>
<c:if test="${message!=null}">
<div id="messages" style="color: red">
    <br/>
    ${message}
</div>
</c:if>
    <div id="all-categories" style="margin: 5%; border: 1px solid black">
        <p><span>Categories  |  </span>current: ${category.name}   |   <span></span>
            <span><a href="/goTo?category=${category.parentCategory.id}">go back..</a></span></p>
        <c:forEach var="category" items="${categoryList}">
            <div class="category-in-all-list-div">
                <span class="categoryInAllListSpan">
                    <a href="/goTo?category=${category.id}">
                ${category.level}-lvl: ${category.name}
                        </a>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <form:form method="get" action="admin/categoryBuilder">
                            <input type="hidden" name="categoryId" value="${category.id}">
                            <input type="submit" value="Edit">
                        </form:form>
                        <form:form method="post" action="admin/deleteCategory">
                            <input type="hidden" name="categoryId" value="${category.id}">
                            <input type="submit" value="Delete">
                        </form:form>
                    </sec:authorize>
                </span></div>
        </c:forEach>
    </div>
<div id="product-list-side-panel" style="float: left; width: 30%; border: 1px solid black">
    <div id="display-mode-change-panel">
        <a href="/productList?display=byCategories">By categories</a>
        <a href="/productList?display=allProducts">Al products</a>
    </div>
    <div id="quick-search" style="margin: 5%; border: 1px solid black">
        <p class="filter-input-sign">Quick search for code..</p>
        <form:form method="get" action="/productList" modelAttribute="filterDTO">
            <input type="text" name="code" value="">
            <input type="submit" value="Search">
        </form:form>
    </div>
    <div id="filter-panel" style="margin: 10%; border: 1px solid black">
        <form:form method="get" action="/doFilter" modelAttribute="filterDTO">
            <div class="filter">
                <input type="submit" value="Filter">
            </div>
            <div class="filter">
                <p class="filter-input-sign">Search for name..</p>
                <input type="text" name="search" value="${filter.search}">
            </div>
            <div class="filter">
                <p class="filter-input-sign">Search for vendor..</p>
                <select name="vendor" size="1">
                    <option value="${filter.vendor}">${filter.vendor}</option>
                    <c:forEach var="vendor" items="${vendorList}">
                        <option value="${vendor.name}">${vendor.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="filter">
                <p class="filter-input-sign">Sorting by price</p>
                <select name="sorting" size="1">
                    <option value="${filter.sorting}">${filter.sorting}</option>
                    <c:forEach var="sorting" items="${sortingEnum}">
                        <option value="${sorting}">${sorting}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="filter">
                <p class="filter-input-sign">Availability</p>
                <select name="availability" size="1">
                    <option value="${filter.availability}">${filter.availability}</option>
                    <c:forEach var="availability" items="${availabilityList}">
                        <option value="${availability.status}">${availability.status}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="filter">
                <p class="filter-input-sign">Min price</p>
                <input type="number" min="0" step="0.01" name="minPrice" value="${filter.minPrice}">
                <p class="filter-input-sign">Max price</p>
                <input type="number" min="0" step="0.01" name="maxPrice" value="${filter.maxPrice}">
            </div>

            <input type="hidden" name="category" value="${filter.category}">
            <input type="hidden" name="page" value="${filter.page}">
            <input type="hidden" name="number" value="${filter.number}">

        </form:form>
    </div>
</div>
<div id="all-products" style="margin-left: 30%; border: 1px solid black">
    <p>Products</p>
    <c:forEach var="product" items="${productList}">
        <div class="product-in-all-list-div">
            <span class="product-Name-in-all-list-span"><a href="/product?id=${product.id}">${product.name} - </a></span>
            <span class="product-code-in-all-list-span">${product.vendorCode} - </span>
            <span class="product-avail-in-all-list-span">${product.availability.status} - </span>
            <span class="product-price-in-all-list-span">${product.price} - </span>
            <span class="product-currency-in-all-list-span">${product.currency.name} - </span>
            <span class="product-category-in-all-list-span">in: ${product.category.name}</span>
            <form:form method="post" action="/addToBasket">
                <input type="hidden" name="id" value="${product.id}">
                <input type="hidden" name="redirect" value="/productList">
                <span>
                    <input type="number" name="number" cols="3" min="1" value="1">
                    <input type="submit" value="Add to basket">
                    </span>
            </form:form>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <form:form method="get" action="/admin/productBuilder">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Edit">
                </form:form>
                <form:form method="post" action="admin/deleteProduct">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Delete">
                </form:form>
            </sec:authorize>
        </div>
    </c:forEach>
</div>

</body>
</html>
