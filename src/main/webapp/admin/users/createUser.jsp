<%--
  Created by IntelliJ IDEA.
  User: QuocPhap
  Date: AD 2023/06/15
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../layout/header.jsp"/>
<div class="col-xl-8 ">

    <!-- HTML5 Inputs -->
    <div class="card mb-4">

        <h5 class="card-header">Create User</h5>

            <form action="/admin/user?action=createUser" method="post">
                <div class="card-body" >
                <div class="mb-3 row">
                    <label for="html5-search-input"  class="col-md-2 col-form-label" >Username</label>
                    <div class="col-md-10">
                        <input class="form-control" name="username" type="search"  id="html5-search-input">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="html5-email-input" class="col-md-2 col-form-label" >Password</label>
                    <div class="col-md-10">
                        <input class="form-control" name="password" type="text"  id="html5-email-input">
                    </div>
                </div>

<%--                <div class="mb-3 row">--%>
<%--                    <label for="html5-tel-input" class="col-md-2 col-form-label" >Role Id</label>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input class="form-control" name="roleId" type="text" id="html5-tel-input">--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="mb-3 row">
                    <label for="html5-number-input" class="col-md-2 col-form-label" >Name</label>
                    <div class="col-md-10">
                        <input class="form-control" name="name" type="text"  id="html5-number-input">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="html5-datetime-local-input" class="col-md-2 col-form-label" >Dob</label>
                    <div class="col-md-10">
                        <input class="form-control" name="dob" type="date" id="html5-datetime-local-input">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="html5-date-input" class="col-md-2 col-form-label" >Email</label>
                    <div class="col-md-10">
                        <input class="form-control" name="email" type="text"  id="html5-date-input">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="html5-month-input" class="col-md-2 col-form-label" >Phone</label>
                    <div class="col-md-10">
                        <input class="form-control" name="phone" type="text"  id="html5-month-input">
                    </div>
                </div>


        </div>
        <div class="  ">
            <div class="col-sm-10 d-flex justify-content-center" >
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
                <c:if test="${requestScope['message'] != null}">
                    <span style="color: red">${message}</span>
                </c:if>

            </form>


        <br><br>
    </div>

<jsp:include page="../layout/footer.jsp"/>