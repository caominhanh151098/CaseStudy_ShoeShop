<%--
  Created by IntelliJ IDEA.
  User: dtv
  Date: 12/06/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delivery</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
<div class="nav">
    <img src="https://static.topcv.vn/company_logos/0ZT9refQobeAkpzsYWBdyaki10IlbFB4_1655288503____f48c9fc932b36c4eec44ec23d223fa18.png"
         width="50px" height="50px">
    <div class="menu-item">
        <ul class="menu-bar">
            <li>Demo
                <div >
                <ul class="sub-menu-bar">
                    <li>Demo1</li>
                    <li>Demo1</li>
                    <li>Demo1</li>
                    <li>Demo1</li>
                </ul>
                </div>
            </li>
            <li>Demo</li>
            <li>Demo</li>
            <li>Demo</li>
        </ul>
    </div>
    <span>Tài khoản</span>
</div>
<h1>${action}</h1>
<a href="/delivery?action=create">Create Customer</a>
<form action="/delivery" method="get">
    <input type="search" name="search" id="search" value="${pageable.search}" onsearch="onClearSearch()"/>
    <button id="searchButton">Search</button>
</form>
</br>
<c:if test="${requestScope['deliveryList'].size() != 0}">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>delivery_place</td>
            <td>customer_name</td>
            <td>customer_email</td>
            <td>customer_phone</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${deliveryList}" var="delivery">
            <tr>
                <td>${delivery.id}</td>
                <td>${delivery.delivery_place}</td>
                <td>${delivery.customer_name}</td>
                <td>${delivery.customer_email}</td>
                <td>${delivery.customer_phone}</td>
                <td><a href="/delivery?action=edit&id=${delivery.id}">Edit</a></td>
                <td><a href="/delivery?action=delete&id=${delivery.id}"
                       onclick="return confirm('Do you want to remove ${delivery.delivery_place}?')">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>

</html>
