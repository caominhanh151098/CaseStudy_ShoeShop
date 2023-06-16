<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../layout/header.jsp"/>
<div class="col-xxl">
    <div class="card mb-4">
        <div class="card-header d-flex align-items-center justify-content-between">
            <h5 class="mb-0">UPDATE PRODUCT</h5>
        </div>
        <div class="card-body">
            <form action="product?action=update" method="post">
                <input  type="hidden" name="id" value="${product.id}">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="basic-default-name">name</label>
                    <div class="col-sm-10">
                        <input type="text" name="product_name" class="form-control" id="basic-default-name" placeholder="Nike" value="${product.product_name}" />
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="basic-default-company">price</label>
                    <div class="col-sm-10">
                        <input
                                type="text"
                                name="price"
                                class="form-control"
                                id="basic-default-company"
                                placeholder="ACME Inc."
                                value="${product.price}"
                        />
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="basic-default-email">Description</label>
                    <div class="col-sm-10">
                        <div class="input-group input-group-merge">
                            <input
                                    type="text"
                                    name="description"
                                    id="basic-default-email"
                                    class="form-control"
                                    placeholder="john.doe"
                                    aria-label="john.doe"
                                    aria-describedby="basic-default-email2"
                                    value="${product.description}"
                            />
                        </div>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" for="basic-default-phone">Image</label>
                    <div class="col-sm-10">
                        <input
                                type="text"
                                name="img"
                                id="basic-default-phone"
                                class="form-control phone-mask"
                                placeholder=""
                                aria-label="658 799 8941"
                                aria-describedby="basic-default-phone"
                                value="${product.image}"
                        />
                    </div>
                </div>

<%--                <label class="col-sm-2 col-form-label" >Category</label>--%>
<%--                <div class="btn-group">--%>
<%--                    <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Secondary--%>
<%--                    </button>--%>
<%--                    <ul class="dropdown-menu" style="">--%>
<%--                        <li><a class="dropdown-item" href="javascript:void(0);">Action</a></li>--%>
<%--                        <li><a class="dropdown-item" href="javascript:void(0);">Another action</a></li>--%>
<%--                        <li><a class="dropdown-item" href="javascript:void(0);">Something else here</a></li>--%>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>
<%--                        <li><a class="dropdown-item" href="javascript:void(0);">Separated link</a></li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--                <br><br>--%>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label" >Category</label>
                    <div class="col-sm-10">
                        <select class="form-select" name="category" id="category"  >

                            <c:forEach items="${categories}" var="category">
                                <c:if test="${category.id == product.category.id }">
                                    <option selected value="${category.id}" >${category.categoryName}</option>
                                </c:if>
                                <c:if test="${category.id != product.category.id }">
                                    <option value="${category.id}" >${category.categoryName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                </div>
                    <br><br><br>
                <div class="row justify-content-end">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                    </div>
                </div>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>