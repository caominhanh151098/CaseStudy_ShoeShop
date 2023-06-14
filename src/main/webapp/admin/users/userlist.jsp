<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>
<div class="table-responsive text-nowrap">
    <table class="table">
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
        <c:forEach items="${user}" var="user1">
            <tr>
            <td>${user1.id}</td>
            <td>${user1.Username}</td>
            <td><img src="../../assets/img/avatars/5.png" alt="Avatar" class="rounded-circle" width="50px"/></td>
            <td><span class="badge bg-label-info me-1">User</span></td>
            <td>
                <div class="dropdown">
                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                        <i class="bx bx-dots-vertical-rounded"></i>
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="javascript:void(0);"
                        ><i class="bx bx-edit-alt me-1"></i>Info</a
                        >
                        <a class="dropdown-item" href="javascript:void(0);"
                        ><i class="bx bx-trash me-1"></i>Edit</a
                        >
                    </div>
                </div>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../layout/footer.jsp"/>