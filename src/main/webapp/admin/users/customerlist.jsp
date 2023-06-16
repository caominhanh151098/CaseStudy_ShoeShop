<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"/>
<div class="table-responsive text-nowrap">
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