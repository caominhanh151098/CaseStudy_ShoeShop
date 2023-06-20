<%--
  Created by IntelliJ IDEA.
  User: QuocPhap
  Date: AD 2023/06/15
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../layout/header.jsp"/>
<div class="col-xxl">
        <div class="card mb-4">
                <div class="card-header d-flex align-items-center justify-content-between">
                        <h5 class="mb-0">Edit User Info</h5>
                        <small class="text-muted float-end">Shoe Shop</small>
                </div>
                <div class="card-body">
                    <c:if test="${errors!=null}">
                        <div class="alert alert-danger">
                            <ul>
                                <c:forEach items="${errors}" var="e">
                                    <li>${e}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                        <form action="/admin/user?action=edit" method="post">
<%--                            <c:if test="${requestScope['message'] != null}">--%>
<%--                                <span style="color: red">${message}</span>--%>
<%--                            </c:if>--%>
                            <input type="hidden" name="id" value="${userInfo.user_id}">
                                <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label" for="basic-icon-default-fullname">Name</label>
                                        <div class="col-sm-10">
                                                <div class="input-group input-group-merge">
                              <span id="basic-icon-default-fullname2" class="input-group-text"
                              ><i class="bx bx-user"></i
                              ></span>
                                                        <input
                                                                type="text"
                                                                name="name"
                                                                class="form-control"
                                                                id="basic-icon-default-fullname"
                                                                placeholder="Ngọc Trinh"
                                                                aria-label="Ngọc Trinh"
                                                                aria-describedby="basic-icon-default-fullname2"
                                                                value="${userInfo.name}"
                                                        />
                                                </div>
                                        </div>
                                </div>
                                <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label" for="basic-icon-default-company">Day Of Birth</label>
                                        <div class="col-sm-10">
                                                <div class="input-group input-group-merge">
                              <span id="basic-icon-default-company2" class="input-group-text"
                              ><i class="bx bx-buildings"></i
                              ></span>
                                                        <input  name="dob"
                                                                type="date"
                                                                id="basic-icon-default-company"
                                                                class="form-control"
                                                                placeholder="Please enter your date of birth."
                                                                aria-label="ACME Inc."
                                                                aria-describedby="basic-icon-default-company2"
                                                                value="${userInfo.dob}"
                                                        />
                                                </div>
                                        </div>
                                </div>
                                <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label" for="basic-icon-default-email">Email</label>
                                        <div class="col-sm-10">
                                                <div class="input-group input-group-merge">
                                                        <span class="input-group-text"><i class="bx bx-envelope"></i></span>
                                                        <input  name="email"
                                                                type="text"
                                                                id="basic-icon-default-email"
                                                                class="form-control"
                                                                placeholder="Dquocphap"
                                                                aria-label="john.doe"
                                                                aria-describedby="basic-icon-default-email2"
                                                                value="${userInfo.email}"
                                                        />
                                                        <span id="basic-icon-default-email2" class="input-group-text"></span>
                                                </div>
                                                <div class="form-text">You can use letters, numbers & periods</div>
                                        </div>
                                </div>
                                <div class="row mb-3">
                                        <label class="col-sm-2 form-label" for="basic-icon-default-phone">Phone</label>
                                        <div class="col-sm-10">
                                                <div class="input-group input-group-merge">
                              <span id="basic-icon-default-phone2" class="input-group-text"
                              ><i class="bx bx-phone"></i
                              ></span>
                                                        <input  name="phone"
                                                                type="text"
                                                                id="basic-icon-default-phone"
                                                                class="form-control phone-mask"
                                                                placeholder="0123123123"
                                                                aria-label="658 799 8941"
                                                                aria-describedby="basic-icon-default-phone2"
                                                                value="${userInfo.phone}"
                                                        />
                                                </div>
                                        </div>
                                </div>

                                <div class="row justify-content-end">
                                        <div class="col-sm-10">
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn btn-primary">CLEAR</button>
                                            <a  class="btn btn-primary" href="/admin/user">BACK</a>
                                        </div>
                                </div>
                            <c:if test="${message != null}">
                                <span style="color: red">${message}</span>
                            </c:if>
                        </form>
                </div>
        </div>
</div>
<jsp:include page="../layout/footer.jsp"/>