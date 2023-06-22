<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
                    function onClearSearch() {
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
                        <a class="dropdown-item" href="#">
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
<div class="table-responsive text-nowrap">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th>Order ID</th>
            <th>Name User</th>
            <th>Total Price</th>
            <th>Order Date</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-border-bottom-0">
        <c:forEach items="${orderlist}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.nameUser}</td>
                <td><fmt:formatNumber type="number" value="${order.totalPrice}"/>đ</td>
                <td>${order.orderDate}</td>
                <td>
                    <span class="badge bg-label-danger me-1">${order.status}</span>
                </td>
                <td>
                    <div class="dropdown">
                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                            <i class="bx bx-dots-vertical-rounded"></i>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/admin/order?action=info&id=${order.id}">
                                <i class="bx bx-edit-alt me-1"></i>Show Info</a>
                            <a class="dropdown-item"
                               href="/admin/order?action=change&id=${order.id}&status=2"
                               onclick="return confirm('Want to reset the status of this order?')">
                                <i class="bx bx-edit-alt me-1"></i>Reset Status</a>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<ul class="pagination d-flex justify-content-center">
    <li class="page-item first">
        <c:choose>
            <c:when test="${pageable.page > 1}">
                <a class="page-link" href="order?search=${pageable.search}"><i
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
                <a class="page-link" href="order?page=${pageable.page - 1}&search=${pageable.search}">
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
                <a class="page-link" href="order?page=${pageable.page + 1}&search=${pageable.search}">
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
                <a class="page-link" href="order?page=${pageable.totalPage}&search=${pageable.search}">
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
