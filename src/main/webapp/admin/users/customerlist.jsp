<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        </tbody>
    </table>
</div>
<jsp:include page="../layout/footer.jsp"/>