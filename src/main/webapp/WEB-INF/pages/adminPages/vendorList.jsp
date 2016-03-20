<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 14.03.16
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of vendors</title>
</head>
<body>
<p><a href="/">Home</a></p>
    <div>
        <div>
            <form:form method="post" action="/admin/saveVendor" modelAttribute="vendor">
                <input type="hidden" name="id" value="${vendor.id}">
                <input type="hidden" name="version" value="${vendor.version}">
                <span class="builder-input-sign">Vendor name</span>
                <input type="text" name="name" value="${vendor.name}">

                <input type="submit" value="Save vendor">
            </form:form>
        </div>
        <div>
            <div>
                <c:forEach var="v" items="${vendorList}">
                    <a href="/admin/vendors?id=${v.id}">${v.name}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
