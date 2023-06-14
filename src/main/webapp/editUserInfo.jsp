<%--
  Created by IntelliJ IDEA.
  User: QuocPhap
  Date: AD 2023/06/08
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <span>${message}</span>
</c:if>
<a href="/user">Back</a><br>
<form action="/user?action=edit" method="post">
    <%--    <label for="id">ID</label>--%>
    <input type="hidden" name="id" id="id" value="${userInfo.user_id}" />

    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${userInfo.name}" />

    <label for="dob">Dob</label>
    <input type="text" name="dob" id="dob" value="${userInfo.dob}" />

    <label for="email">Email</label>
    <input type="text" name="email" id="email" value="${userInfo.email}" />

        <label for="phone">Phone</label>
        <input type="text" name="phone" id="phone" value="${userInfo.phone}" />

<%--    <select name="categoryBook" id="role">--%>
<%--        &lt;%&ndash;        <option value="">--None--</option>&ndash;%&gt;--%>
<%--        <c:forEach items="${listcategory}" var="category">--%>
<%--            <c:if test="${category.idCategory == book.categoryBook.idCategory}">--%>
<%--                <option selected value="${category.idCategory}">${category.nameCategory}</option>--%>
<%--            </c:if>--%>
<%--            <c:if test="${category.idCategory != book.categoryBook.idCategory}">--%>
<%--                <option value="${category.idCategory}">${category.nameCategory}</option>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
    <button type="submit">Edit</button>
</form>
</body>
</html>
