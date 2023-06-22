<%--
  Created by IntelliJ IDEA.
  User: QuocPhap
  Date: AD 2023/06/15
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../layout/header.jsp"/>
<div class="col-xxl-12xl-15 d-flex justify-content-center mb-10 row">

    <!-- HTML5 Inputs -->
    <div class="card mb-4">
        <h5 class="card-header">Show User Info</h5>
        <div class="card-body">
            <form action="/user?action=show" method="post"></form>
            <div class="mb-3 row">
                <label for="html5-text-input" class="col-md-2 col-form-label">ID</label>
                <div class="col-md-10">
                    <%--          <input class="form-control" type="number" value="${user.id}" id="html5-text-input">--%>
                    <label class="form-control" type="number" value="${user.id}"
                           id="html5-text-input">${user.id}</label>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-search-input" class="col-md-2 col-form-label">Username</label>
                <div class="col-md-10">
                    <label class="form-control" type="search" value="${user.username}"
                           id="html5-search-input">${user.username}</label>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-tel-input" class="col-md-2 col-form-label">Role Name</label>
                <div class="col-md-10">
                    <label class="form-control" type="text" value="${user.role.role_name}"
                           id="html5-tel-input">${user.role.role_name}</label>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-number-input" class="col-md-2 col-form-label">Name</label>
                <div class="col-md-10">
                    <label class="form-control" type="text" value="${user.user_info.name}"
                           id="html5-number-input">${user.user_info.name}</label>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-datetime-local-input" class="col-md-2 col-form-label">Dob</label>
                <div class="col-md-10">
                    <input class="form-control" type="date" value="${user.user_info.dob}"
                           id="html5-datetime-local-input" disabled>
                    <%--              <label class="form-control" type="date" value="${user.user_info.dob}" id="html5-datetime-local-input">${user.user_info.dob}</label>--%>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-date-input" class="col-md-2 col-form-label">Email</label>
                <div class="col-md-10">
                    <input class="form-control" type="text" value="${user.user_info.email}" id="html5-date-input"
                           disabled>
                    <%--              <label class="form-control" type="text" value="${user.user_info.email}" id="html5-date-input">${user.user_info.email}</label>--%>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-month-input" class="col-md-2 col-form-label">Phone</label>
                <div class="col-md-10">
                    <input class="form-control" type="text" value="${user.user_info.phone}" id="html5-month-input"
                           disabled>
                    <%--              <label class="form-control" type="text" value="${user.user_info.phone}" id="html5-month-input">${user.user_info.phone}</label>--%>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="html5-month-input" class="col-md-2 col-form-label">Address</label>
                <div class="col-md-10">
                    <input class="form-control" type="text" value="${user.user_info.address}" id="html5-month-input"
                           disabled>
                    <%--                    <label class="form-control" type="text" value="${user.user_info.address}"--%>
                    <%--                           id="html5-month-input">${user.user_info.address}</label>--%>
                </div>
            </div>

        </div>
    </div>
<jsp:include page="../layout/footer.jsp"/>