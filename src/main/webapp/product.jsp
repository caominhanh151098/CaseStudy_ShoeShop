<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/12/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        img{
            width: 100px;
            height: 100px;
        }
        .id{
            width: 30px;
        }
        .price{
            width: 150px;
        }
        .action{
            width: 20px;
        }
    </style>
    <title>Product</title>
</head>
<body>
<button type="button">
    <a href="product?action=insert">INSERT</a>
</button>
<form action="product" method="get">
    <div>
    <table border="=1">
        <tr align="center">
            <td class="id">Id</td>
            <td>Product_Name</td>
            <td class="price">Price</td>
            <td>Description</td>
            <td>Image</td>
            <td>Category_Name</td>
            <td class="action">Action</td>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr align="center">
                <td>${product.id}</td>
                <td>${product.product_name}</td>
                <td>${product.price} VND</td>
                <td><img src ="${product.image}"></td>
                <td>${product.category.category_name}</td>
                <td>
                    <a href="product?action=update&id=${product.id}">UPDATE</a>
                </td>
            </tr>
        </c:forEach>
            </table>
    </div>
</form>

</body>
</html>
