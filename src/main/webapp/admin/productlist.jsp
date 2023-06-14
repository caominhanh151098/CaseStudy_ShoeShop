<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="layout/header.jsp"/>
<div class="table-responsive text-nowrap">
    <table class="table">
        <thead class="table-light">
        <tr align="center">
            <th>Product ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Image</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-border-bottom-0">
        <c:forEach items="${products}" var="product">
            <tr align="center">
                <td>${product.id}</td>
                <td>${product.product_name}</td>
                <td><fmt:formatNumber type="number" value="${product.price}"/>đ</td>
                <td><img src="${product.image}" width="50px"></td>
                <td>${product.category.category_name}</td>
                <td>
                    <button type="button" class="btn rounded-pill btn-outline-secondary">
                        <a href="product?action=update&id=${product.id}">
                            <i class="bx bx-edit-alt me-1"></i>Edit
                        </a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <script>
            function onClearSearch(){
                searchButton.click();
            }
        </script>
        </tbody>
    </table>
</div>
<jsp:include page="layout/footer.jsp"/>
