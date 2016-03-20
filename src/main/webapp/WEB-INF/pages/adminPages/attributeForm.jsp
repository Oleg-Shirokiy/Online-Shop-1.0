<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 13.03.16
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attribute form</title>
</head>
<body>
<p><a href="/">Home</a></p>
<div id="attributesForm">
    <form:form action="/admin/saveAttributes">
        <div>
            <c:forEach var="attTmp" items="attributeTemplateList">
                <span>
                    <input type="hidden" name="attTmpId" value="${attrTmp.id}">
                    <input type="text" name="attrTmpName" value="${attrTmp.name}">
                    <input type="text" name="attrTmpMeasurement" value="${attrTmp.measurement}">
                    <input type="text" name="attrTmpValue" value="">
                </span>
            </c:forEach>
        </div>
        <%--<div>--%>
            <%--<c:forEach var="attr" items="attributeList">--%>
                <%--<span>--%>
                    <%--<input type="hidden" name="attrId" value="${attr.id}">--%>
                    <%--<input type="text" name="attrName" value="${attr.name}">--%>
                    <%--<input type="text" name="attrMeasurement" value="${attr.measurement}">--%>
                    <%--<input type="text" name="attrValue" value="${attr.value}">--%>
                <%--</span>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
        <input type="submit" value="Save attributes">
    </form:form>
</div>
</body>
</html>
