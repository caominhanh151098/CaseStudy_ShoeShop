<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../layout/header.jsp"/>

<nav
        class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
        id="layout-navbar"
>
    <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
            <i class="bx bx-menu bx-sm"></i>
        </a>
    </div>

    <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
        <!-- Search -->
        <div class="navbar-nav align-items-center">
            <div class="nav-item d-flex align-items-center">
                <i class="bx bx-search fs-4 lh-0"></i>
                <form>
                    <input
                            type="search"
                            class="form-control border-0 shadow-none"
                            placeholder="Search..."
                            aria-label="Search..."
                            name="search" value="${pageable.search}" onsearch="onClearSearch()"
                    />
                    <button id="searchButton" type="submit" style="display: none"/>
                </form>
                <script>
                    function onClearSearch(){
                        let searchButton = document.getElementById("searchButton");
                        searchButton.click();
                    }
                </script>
            </div>
        </div>
    </div>
</nav>
<br><br>

    <button type="button" class="btn rounded-pill btn-outline-secondary">
        <a href="product?action=insert">
            <i class="bx bx-edit-alt me-1"></i>CREATE
        </a>
    </button>
<br><br>
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
                <td>${product.category.categoryName}</td>
                <td>
                    <button type="button" class="btn rounded-pill btn-outline-secondary">
                        <a href="?action=update&id=${product.id}">
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
<div class="d-flex justify-content-center">
<c:if test="${pageable.page > 1}">
    <button type="button" class="btn rounded-pill btn-outline-secondary mr-2">
        <a href="product?page=${pageable.page - 1}"> << PREV </a>
    </button>
</c:if>
    <c:if test="${pageable.page < pageable.totalPage}">
        <button type="button" class="btn rounded-pill btn-outline-secondary">
            <a href="product?page=${pageable.page + 1}"> NEXT >> </a>
        </button>
    </c:if>
</div>


<jsp:include page="../layout/footer.jsp"/>
