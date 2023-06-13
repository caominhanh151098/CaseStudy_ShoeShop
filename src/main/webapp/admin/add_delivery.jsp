<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 12/06/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>add_delivery</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <span>${message}</span>
</c:if>
<a href="/customers">Back</a>
<form action="/delivery?action=create" method="post">
    <label for="delivery_place">delivery_place</label>
    <input type="text" name="delivery_place" id="delivery_place" value="${delivery.delivery_place}"/>
    <label for="customer_name">customer_name</label>
    <input type="text" name="customer_name" id="customer_name" value="${delivery.customer_name}"/>
    <label for="customer_email">customer_email</label>
    <input type="text" name="customer_name" id="customer_email" value="${delivery.customer_name}"/>
    <label for="customer_phone">customer_phone</label>
    <input type="text" name="customer_phone" id="customer_phone" value="${delivery.customer_phone}"/>
    <button type="submit">Create</button>
</form>
</body>
</html>
