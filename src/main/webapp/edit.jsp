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
    <input type="hidden" name="id" id="id" value="${book.id}" />

    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${book.name}" />

    <label for="publicDate">publicDate</label>
    <input type="text" name="publicDate" id="publicDate" value="${book.publicDate}" />

    <label for="author">author</label>
    <input type="text" name="author" id="author" value="${book.author}" />

    <select name="categoryBook" id="role">
        <%--        <option value="">--None--</option>--%>
        <c:forEach items="${listcategory}" var="category">
            <c:if test="${category.idCategory == book.categoryBook.idCategory}">
                <option selected value="${category.idCategory}">${category.nameCategory}</option>
            </c:if>
            <c:if test="${category.idCategory != book.categoryBook.idCategory}">
                <option value="${category.idCategory}">${category.nameCategory}</option>
            </c:if>
        </c:forEach>
    </select>
    <button type="submit">Edit</button>
</form>
</body>
</html>
