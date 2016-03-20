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
<div id="basket-panel">
    <a href="/showBasket">Basket: ${basket.size()}</a>
</div>
<div>
    <c:if test="${product != null}">
        <a href="/admin/attributeForm?id=${product.id}">Attributes</a>
    </c:if>
</div>
<div id="product-builder">
    <form:form method="post" action="/admin/saveProduct">

            <div class="builder-input">
                <span class="builder-input-sign">category</span>
                <select name="categoryID" size="1">
                    <option value="${product.category.id}">${product.category.name}</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}">${category.level}-lvl: ${category.name}</option>
                    </c:forEach>
                </select>
            </div>



        <form:form method="post" action="/admin/saveProduct" modelAttribute="product">
        <input type="hidden" name="version" value="${product.version}">
        <div class="builder-input">
            <%--<span class="builderInputSign">categoryID</span>--%>
            <%--<select name="category" size="1">--%>
                <%--<c:forEach var="category" items="${categoryList}">--%>
                    <%--<option value="${category.id}">${category.level}-lvl: ${category.name}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        <%--</div>--%>
        <div class="builder-input">
            <span class="builder-input-sign">vendorCode</span>
            <input type="text" name="vendorCode" value="${product.vendorCode}">
        </div>
        <div class="builder-input">
            <span class="builder-input-sign">name</span>
            <input type="text" name="name" value="${product.name}">
        </div>
                <%--<div class="builder-input">--%>
                    <%--<span class="builder-input-sign">image</span>--%>
                        <%--&lt;%&ndash;<input type="file" name="image">&ndash;%&gt;--%>
                    <%--<input type="text" name="imageFile" value="">--%>
                <%--</div>--%>
        <div class="builder-input">
            <span class="builder-input-sign">image</span>
             <input type="text" name="imageLink" value="${product.imageLink}">
         </div>
        <div class="builder-input">
            <span class="builder-input-sign">price</span>
            <input type="number" name="price" min="0" step="0.01" value="${product.price}">
        </div>
        <div class="builder-input">
            <span class="builder-input-sign">currency</span>
            <select name="currencyID" size="1">
                <option value="${product.id}">${product.currency.name}</option>
                <c:forEach var="currency" items="${currencyList}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="builder-input">
            <span class="builder-input-sign">availability</span>
            <select name="availabilityID" size="1">
                <option value="${product.availability.status}">${product.availability.status}</option>
                <c:forEach var="availability" items="${availabilityList}">
                    <option value="${availability.id}">${availability.status}</option>
                </c:forEach>
            </select>
        </div>
        <div class="builder-input">
            <span class="builder-input-sign">vendor</span>
            <select name="vendorID" size="1">
                <option value="${product.vendor.id}">${product.vendor.name}</option>
                <c:forEach var="vendor" items="${vendorList}">
                    <option value="${vendor.id}">${vendor.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="builder-input">
            <span class="builder-input-sign">keyWords</span>
            <textarea rows="5" cols="20" name="keyWords">${product.keyWords}</textarea>
        </div>

            <form:form method="post" action="/admin/saveProduct" modelAttribute="ProductContent">
                <div class="builder-input">
                    <span class="builder-input-sign">description</span>
                    <textarea rows="10" cols="20" name="description">${productContent.description}</textarea>
                </div>
                <div class="builder-input">
                    <span class="builder-input-sign">imageLinks</span>
                    <textarea rows="5" cols="20" name="imageLinks">${productContent.imageLinks}</textarea>
                </div>

                <%--<form:form method="post" action="/admin/saveProduct" enctype="multipart/form-data">--%>


                <input type="submit" value="Save product">
                <%--</form:form>--%>
            </form:form>
        </form:form>

    </form:form>
</div>

</div>
</body>
</html>
