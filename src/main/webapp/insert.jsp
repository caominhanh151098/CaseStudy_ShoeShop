<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/12/2023
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>INSERT</title>
</head>
<body>
    <form action="product?action=insert" method="post">

        <div>
            <label for="name">Product_Name</label>
            <input type="text" name="product_name" id="name" placeholder="Nike"/>
        </div><br>
        <div>
            <label for="price">Price</label>
            <input type="number" name="price" id="price" step="any" placeholder="1000000 VND"/>
        </div><br>
        <div>
            <label for="des">Description</label>
            <input type="text" name="description" id="des" placeholder="nike 2023"/>
        </div><br>
        <div>
            <label for="img">Image</label>
            <input type="text" name="img" id="img" placeholder="Nike"/>
        </div><br>
        <div>
            <label for="category">Category</label>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${category.id == product.category.id }">
                            <option selected value="${category.id}" >${category.category_name}</option>
                        </c:if>
                        <c:if test="${category.id != product.category.id }">
                            <option value="${category.id}" >${category.category_name}</option>
                        </c:if>
                    </c:forEach>
                </select>

        </div><br>
        <div>
            <button type="submit">SUBMIT</button>
        </div>
    </form>
</body>
</html>
