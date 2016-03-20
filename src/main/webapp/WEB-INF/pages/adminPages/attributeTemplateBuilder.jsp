<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 12.03.16
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attribute templates builder</title>
</head>
<body>
<p><a href="/">Home</a></p>
    <div id="attr-temp-builder">
        <%--<div id="attr-temp-builder-categories">--%>
            <%--<form:form method="post" action="/admin/selectCategory">--%>
                <%--<select name="category" size="1">--%>
                    <%--<c:forEach var="category" items="${categoryList}">--%>
                        <%--<option value="${category.id}">category.name</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
        <%--</div>--%>
        <div id="attr-temp-builder-form">
            <%--<p class="builder-form-sign">Current category: ${currentCategory}</p>--%>
            <form:form method="post" action="/admin/addAttributeTemplate" modelAttribute="attributeTemplate">
                <input type="hidden" name="version" value="${attributeTemplate.version}">
                <input type="hidden" name="id" value="${attributeTemplate.id}">
                <span class="builder-input-sign">Attribute name</span>
                <input type="text" name="name" value="${attributeTemplate.name}">
                <span class="builder-input-sign">measurement</span>
                <input type="text" name="measurement" value="${attributeTemplate.measurement}">

                <input type="submit" value="Save attribute template">
            </form:form>
        </div>
        <div id="attr-temp-templates-list">
            <c:forEach var="attrTmp" items="${attributeTemplateList}">
                <a href="/admin/attributeBuilder?id=${attrTmp.id}">${attrTmp.name}, ${attrTmp.measurement}</a>
            </c:forEach>
        </div>
    </div>

</body>
</html>
