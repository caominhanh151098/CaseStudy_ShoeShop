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
<div class="col-xxl-12xl-15 d-flex justify-content-center mb-10 row">

    <!-- HTML5 Inputs -->
    <div class="card mb-4">

        <h5 class="card-header">Create User</h5>

            <form action="/admin/user?action=createUser" method="post">
                <div class="card-body" >
                <div class="mb-3 row">
                    <label for="username"  class="col-md-2 col-form-label" >Username</label>
                    <div class="col-md-10">
                        <input class="form-control" name="username" type="search"  id="username">
                    </div>
                </div>

                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorUserName}</h5>
                        </div>
                    </div>

                <div class="mb-3 row">
                    <label for="password" class="col-md-2 col-form-label" >Password</label>
                    <div class="col-md-10">
                        <input class="form-control" name="password" type="text"  id="password">
                    </div>
                </div>

                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorPassword}</h5>
                        </div>
                    </div>


<%--                <div class="mb-3 row">--%>
<%--                    <label for="html5-tel-input" class="col-md-2 col-form-label" >Role Id</label>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input class="form-control" name="roleId" type="text" id="html5-tel-input">--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="mb-3 row">
                    <label for="name" class="col-md-2 col-form-label" >Name</label>
                    <div class="col-md-10">
                        <input class="form-control" name="name" type="text"  id="name">
                    </div>
                </div>
                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorName}</h5>
                        </div>
                    </div>
                <div class="mb-3 row">
                    <label for="dob" class="col-md-2 col-form-label" >Dob</label>
                    <div class="col-md-10">
                        <input class="form-control" name="dob" type="date" id="dob">
                    </div>
                </div>
                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorDob}</h5>
                        </div>
                    </div>
                <div class="mb-3 row">
                    <label for="email" class="col-md-2 col-form-label" >Email</label>
                    <div class="col-md-10">
                        <input class="form-control" name="email" type="text"  id="email">
                    </div>
                </div>
                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorEmail}</h5>
                        </div>
                    </div>
                <div class="mb-3 row">
                    <label for="phone" class="col-md-2 col-form-label" >Phone</label>
                    <div class="col-md-10">
                        <input class="form-control" name="phone" type="text"  id="phone">
                    </div>
                </div>
                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorPhone}</h5>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <label for="address" class="col-md-2 col-form-label" >Address</label>
                        <div class="col-md-10">
                            <input class="form-control" name="address" type="text"  id="address">
                        </div>
                    </div>
                    <div class="row justify-content-end">
                        <div class="col-sm-10">
                            <h5>${errorAddress}</h5>
                        </div>
                    </div>


        </div>
        <div class=" row justify-content-end ">
            <div class="col-sm-10" >
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-primary">CLEAR</button>
                <a  class="btn btn-primary" href="/admin/user">BACK</a>
            </div>
        </div>
                <br><br>
                <div class="row justify-content-end">
                    <div class="col-sm-10">
                        <h5>${errorCreateUser}</h5>
                    </div>
                </div>
<%--                <c:if test="${requestScope['message'] != null}">--%>
<%--                    <span style="color: red">${message}</span>--%>
<%--                </c:if>--%>

            </form>


        <br><br>
    </div>

<jsp:include page="../layout/footer.jsp"/>