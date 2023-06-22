<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>
<%--<nav--%>
<%--        class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"--%>
<%--        id="layout-navbar"--%>
<%-->--%>
<%--    <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">--%>
<%--        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">--%>
<%--            <i class="bx bx-menu bx-sm"></i>--%>
<%--        </a>--%>
<%--    </div>--%>

<%--    <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">--%>
<%--        <!-- Search -->--%>
<%--        <div class="navbar-nav align-items-center">--%>
<%--            <div class="nav-item d-flex align-items-center">--%>
<%--                <i class="bx bx-search fs-4 lh-0"></i>--%>
<%--                <form>--%>
<%--                    <input--%>
<%--                            type="search"--%>
<%--                            class="form-control border-0 shadow-none"--%>
<%--                            placeholder="Search..."--%>
<%--                            aria-label="Search..."--%>
<%--                            name="search" value="${pageable.search}" onsearch="onClearSearch()"--%>
<%--                    />--%>
<%--                    <button id="searchButton" type="submit" style="display: none"/>--%>
<%--                </form>--%>
<%--                <script>--%>
<%--                    function onClearSearch(){--%>
<%--                        let searchButton = document.getElementById("searchButton");--%>
<%--                        searchButton.click();--%>
<%--                    }--%>
<%--                </script>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme" id="layout-navbar">
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
                    <input type="search" class="form-control border-0 shadow-none" placeholder="Search..." aria-label="Search..." name="search" value="" onsearch="onClearSearch()">
                    <button id="searchButton" type="submit" style="display: none">

                        <script>
                            function onClearSearch(){
                                let searchButton = document.getElementById("searchButton");
                                searchButton.click();
                            }
                        </script>
                    </button></form></div>
        </div>
        <!-- /Search -->

        <ul class="navbar-nav flex-row align-items-center ms-auto">
            <!-- User -->
            <li class="nav-item navbar-dropdown dropdown-user dropdown">
                <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                        <img src="../assets/img/avatars/1.png" alt="" class="w-px-40 h-auto rounded-circle">
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                        <a class="dropdown-item" href="#">
                            <div class="d-flex">
                                <div class="flex-shrink-0 me-3">
                                    <div class="avatar avatar-online">
                                        <img src="../assets/img/avatars/1.png" alt="" class="w-px-40 h-auto rounded-circle">
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
                        <a class="dropdown-item" href="#">
                            <i class="bx bx-cog me-2"></i>
                            <span class="align-middle">Settings</span>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">
                                    <span class="d-flex align-items-center align-middle">
                                      <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                                      <span class="flex-grow-1 align-middle">Billing</span>
                                      <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                                    </span>
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
<br>
<button type="button" class="btn rounded-pill btn-outline-secondary">
    <a href="user?action=createUser">
        <i class="bx bx-edit-alt me-1"></i>CREATE
    </a>
</button>
<br>
<div class="table-responsive text-nowrap">

    <br>
    <table class="table">
        <form action="/user?action=usercustomer" method="post"></form>
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Avatar</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-border-bottom-0">


        <c:forEach items="${usercustomer}" var="user1">
            <c:if test="${user1.role.id == 3}">

                <tr>
                    <td>${user1.id}</td>
                    <td>${user1.username}</td>
                    <td><img src="../../assets/img/avatars/5.png" alt="Avatar" class="rounded-circle" width="50px"/></td>
                    <td>
                        <span class="badge bg-label-info me-1" value = "${role.id}"></span>
                            ${user1.role.role_name}</td>
                    <td>
                        <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="user?action=edit&id=${user1.id}"
                                ><i class="bx bx-edit-alt me-1"></i>Edit</a
                                >
                                <a class="dropdown-item" href="user?action=showInfo&id=${user1.id}"
                                ><i class="bx bx-info-circle me-1"></i>Info</a
                                >
                            </div>
                        </div>
                    </td>
                </tr>
            </c:if>

        </c:forEach>
        <script>
            function onClearSearch(){
                searchButton.click();
            }
        </script>
        </tbody>
    </table>
</div>

<ul class="pagination d-flex justify-content-center" >
    <li class="page-item first">
        <a class="page-link" href="user?page=${pageable.page - 1}"><i class="tf-icon bx bx-chevrons-left"></i></a>
    </li>

    <li class="page-item last">
        <a class="page-link" href="user?page=${pageable.page + 1}"><i class="tf-icon bx bx-chevrons-right"></i></a>
    </li>
</ul>
<jsp:include page="../layout/footer.jsp"/>