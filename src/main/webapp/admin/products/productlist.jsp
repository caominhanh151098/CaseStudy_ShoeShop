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
        <!-- /Search -->

        <ul class="navbar-nav flex-row align-items-center ms-auto">
            <!-- User -->
            <li class="nav-item navbar-dropdown dropdown-user dropdown">
                <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);"
                   data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                        <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle"/>
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                        <a class="dropdown-item" href="#">
                            <div class="d-flex">
                                <div class="flex-shrink-0 me-3">
                                    <div class="avatar avatar-online">
                                        <img src="../assets/img/avatars/1.png" alt
                                             class="w-px-40 h-auto rounded-circle"/>
                                    </div>
                                </div>
                                <div class="flex-grow-1">
                                    <span class="fw-semibold d-block">${user.username}</span>
                                    <small class="text-muted">${admin}</small>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <div class="dropdown-divider"></div>
                    </li>
                    <li>
                        <a class="dropdown-item" href="user?action=showInfo&id=${user.id}">
                            <i class="bx bx-user me-2"></i>
                            <span class="align-middle">My Profile</span>
                        </a>
                    </li>
                    <li>
                        <div class="dropdown-divider"></div>
                    </li>
                    <li>
                        <a class="dropdown-item" href="/logout">
                            <i class="bx bx-power-off me-2"></i>
                            <span class="align-middle">Log Out</span>
                        </a>
                    </li>
                </ul>
            </li>
            <!--/ User -->
        </ul>
    </div>
</nav>
<br><br>
    <button type="button" class="btn rounded-pill btn-outline-secondary">
        <a href="/admin/product?action=create">
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
                <td align="left">${product.product_name}</td>
                <td align="right"><fmt:formatNumber type="number" value="${product.price}"/>đ</td>
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
<%--<div class="d-flex justify-content-center">--%>
<%--<c:if test="${pageable.page > 1}">--%>
<%--    <button type="button" class="btn rounded-pill btn-outline-secondary mr-2">--%>
<%--        <a href="product?page=${pageable.page - 1}"> << PREV </a>--%>
<%--    </button>--%>
<%--</c:if>--%>
<%--    <c:if test="${pageable.page < pageable.totalPage}">--%>
<%--        <button type="button" class="btn rounded-pill btn-outline-secondary">--%>
<%--            <a href="product?page=${pageable.page + 1}"> NEXT >> </a>--%>
<%--        </button>--%>
<%--    </c:if>--%>
<%--</div>--%>

<%--<ul class="pagination d-flex justify-content-center" >--%>
<%--    <li class="page-item first">--%>
<%--        <a class="page-link" href="javascript:void(0);"><i class="tf-icon bx bx-chevrons-left"></i></a>--%>
<%--    </li>--%>
<%--    <li class="page-item prev">--%>
<%--        <a class="page-link" href="javascript:void(0);"><i class="tf-icon bx bx-chevron-left"></i></a>--%>
<%--    </li>--%>
<%--<c:if test="${pageable.page > 1}">--%>
<%--    <li class="page-item ">--%>
<%--        <a class="page-link" href="product?page=${pageable.page - 1}">Prev</a>--%>
<%--    </li>--%>
<%--</c:if>--%>
<%--<c:if test="${pageable.page < pageable.totalPage}">--%>
<%--    <li class="page-item " >--%>
<%--        <a class="page-link" href="product?page=${pageable.page + 1}">Next</a>--%>
<%--    </li>--%>
<%--</c:if>--%>

<%--    <li class="page-item next">--%>
<%--        <a class="page-link" href="javascript:void(0);"><i class="tf-icon bx bx-chevron-right"></i></a>--%>
<%--    </li>--%>

<%--    <li class="page-item last">--%>
<%--        <a class="page-link" href="javascript:void(0);"><i class="tf-icon bx bx-chevrons-right"></i></a>--%>
<%--    </li>--%>
<%--</ul>--%>
<ul class="pagination d-flex justify-content-center">
    <li class="page-item first">
        <c:choose>
            <c:when test="${pageable.page > 1}">
                <a class="page-link" href="product?search=${pageable.search}"><i
                        class="tf-icon bx bx-chevrons-left"></i></a>
            </c:when>
            <c:otherwise>
                <a class="page-link" href="#"><i
                        class="tf-icon bx bx-chevrons-left"></i></a>
            </c:otherwise>
        </c:choose>
    </li>
    <li class="page-item prev">
        <c:choose>
            <c:when test="${pageable.page > 1}">
                <a class="page-link" href="product?page=${pageable.page - 1}&search=${pageable.search}">
                    <i class="tf-icon bx bx-chevron-left"></i></a>
            </c:when>
            <c:otherwise>
                <a class="page-link" href="#"><i
                        class="tf-icon bx bx-chevrons-left"></i></a>
            </c:otherwise>
        </c:choose>
    </li>
    <li><a class="page-link" href="#">${pageable.page}</a></li>
    <li class="page-item next">
        <c:choose>
            <c:when test="${pageable.page < pageable.totalPage}">
                <a class="page-link" href="product?page=${pageable.page + 1}&search=${pageable.search}">
                    <i class="tf-icon bx bx-chevron-right"></i></a>
            </c:when>
            <c:otherwise>
                <a class="page-link" href="#"><i
                        class="tf-icon bx bx-chevron-right"></i></a>
            </c:otherwise>
        </c:choose>
    </li>
    <li class="page-item last">
        <c:choose>
            <c:when test="${pageable.page < pageable.totalPage}">
                <a class="page-link" href="product?page=${pageable.totalPage}&search=${pageable.search}">
                    <i class="tf-icon bx bx-chevrons-right"></i></a>
            </c:when>
            <c:otherwise>
                <a class="page-link" href="#"><i
                        class="tf-icon bx bx-chevrons-right"></i></a>
            </c:otherwise>
        </c:choose>
    </li>
</ul>
<jsp:include page="../layout/footer.jsp"/>
