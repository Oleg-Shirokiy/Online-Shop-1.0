<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.03.16
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="shop.model.Category" %>--%>

<html>
<head>
    <title>Category builder</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="basket-panel">
    <a href="/showBasket">Basket: ${basket.size()}</a>
</div>
<div>
    <form:form method="post" action="/admin/saveCategory" modelAttribute="category">
        <input type="hidden" name="version" value="${category.version}">
        <input type="hidden" name="categoryId" value="${category.id}">
        <input type="text" name="name" value="${category.name}">
        <select name="parentCategoryId" size="1">
            <option value="${category.parentCategory.id}">${category.parentCategory.name}</option>
            <c:forEach var="parentCategory" items="${categoryList}">
                <option value="${parentCategory.id}">${parentCategory.name}</option>
            </c:forEach>
            </select>
        <input type="submit" value="Save category">
    </form:form>
</div>
<c:if test="${category != null}">
<div>
    <div>
        <form:form method="post" action="/admin/snapAttributeTemplate">
            <input type="hidden" name="categoryId" value="${category.id}">
            <select name="attributeTemplateId">
            <c:forEach var="attrTmp" items="${attributeTemplateList}">
                <option value="${attrTmp.id}">${attrTmp.name}, ${attrTmp.measurement}</option>
            </c:forEach>
            </select>
            <input type="submit" value="Snap attribute template">
        </form:form>
    </div>
    <div>
        <c:forEach var="attrTmp" items="${category.attributeTemplateList}">
            <a href="/admin/attributeBuilder?id=${attrTmp.id}">${attrTmp.name}, ${attrTmp.measurement}</a>
        </c:forEach>
    </div>
</div>
</c:if>
<div id="all-categories" style="margin: 5%; border: 1px solid black">
    <p>Categories</p>
    <c:forEach var="category" items="${categoryList}">
        <div class="category-in-all-list-div">
                <span class="categoryInAllListSpan">
                    <a href="/admin/categoryBuilder?id=${category.id}">
                            ${category.level}-lvl: ${category.name}
                    </a>
                        <form:form method="post" action="admin/deleteCategory">
                            <input type="hidden" name="categoryId" value="${category.id}">
                            <input type="submit" value="Delete">
                        </form:form>
                </span></div>
    </c:forEach>
</div>

</body>
</html>
