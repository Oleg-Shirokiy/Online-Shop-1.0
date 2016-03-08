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
    <title>Add new category</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="basketPanel">
    <a href="/showBasket">Basket: ${basket.size()}</a>
</div>
<div>
    <form:form method="post" action="/admin/saveCategory">
        <input type="text" name="name" value="">
        <select name="parentCategoryId" size="1">
            <option value=""></option>
            <c:forEach var="parentCategory" items="${categoryList}">
                <option value="${parentCategory.id}">${parentCategory.categoryName}</option>
            </c:forEach>
            </select>
        <input type="submit" value="Save category">
    </form:form>
    </div>

</body>
</html>
