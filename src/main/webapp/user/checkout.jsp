<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="layout/header.jsp"></c:import>

<!-- Breadcrumb Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <div class="col-12">
            <nav class="breadcrumb bg-light mb-30">
                <a class="breadcrumb-item text-dark" href="/home">Home</a>
                <a class="breadcrumb-item text-dark" href="/shop">Shop</a>
                <span class="breadcrumb-item active">Checkout</span>
            </nav>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->


<!-- Checkout Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <div class="col-lg-8">
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span>
            </h5>
            <form action="/shop?action=ordered" method="post" id="ordered">
                <div class="bg-light p-30 mb-5">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Name</label>
                            <input class="form-control" type="text" name="name" placeholder="Your Name"
                                   value="${userinfo.name}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <input class="form-control" type="text" name="email" placeholder="Your Email"
                                   value="${userinfo.email}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Mobile No</label>
                            <input class="form-control" type="text" name="phone" placeholder="Your Phone Number"
                                   value="${userinfo.phone}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address</label>
                            <input class="form-control" type="text" name="address" placeholder="Your Address"
                                   value="${userinfo.address}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 2</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Country</label>
                            <select class="custom-select">
                                <option selected>United States</option>
                                <option>Afghanistan</option>
                                <option>Albania</option>
                                <option>Algeria</option>
                            </select>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>City</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>State</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>ZIP Code</label>
                            <input class="form-control" type="text" placeholder="123">
                        </div>
                        <%--                    <div class="col-md-12 form-group">--%>
                        <%--                        <div class="custom-control custom-checkbox">--%>
                        <%--                            <input type="checkbox" class="custom-control-input" id="newaccount">--%>
                        <%--                            <label class="custom-control-label" for="newaccount">Create an account</label>--%>
                        <%--                        </div>--%>
                        <%--                    </div>--%>
            </form>
        </div>
    </div>
</div>
<div class="col-lg-4">
    <h5 class="section-title position-relative text-uppercase mb-3"><span
            class="bg-secondary pr-3">Order Total</span></h5>
    <div class="bg-light p-30 mb-5">
        <div class="border-bottom">
            <h6 class="mb-3">Products</h6>
            <c:forEach items="${cart.orderDetailList}" var="cartDetail">
                <div class="d-flex justify-content-between">
                    <p>${cartDetail.productName}</p>
                    <p><fmt:formatNumber type="number" value="${cartDetail.quantity * cartDetail.price}"/>
                        VND</p>
                </div>
            </c:forEach>
            <%--          <div class="d-flex justify-content-between">--%>
            <%--            <p>Product Name 2</p>--%>
            <%--            <p>$150</p>--%>
            <%--          </div>--%>
            <%--          <div class="d-flex justify-content-between">--%>
            <%--            <p>Product Name 3</p>--%>
            <%--            <p>$150</p>--%>
            <%--          </div>--%>
        </div>
        <div class="border-bottom pt-3 pb-2">
            <div class="d-flex justify-content-between mb-3">
                <h6>Subtotal</h6>
                <h6><fmt:formatNumber type="number" value="${cart.totalPrice}"/> VND</h6>
            </div>
            <div class="d-flex justify-content-between">
                <h6 class="font-weight-medium">Shipping</h6>
                <h6 class="font-weight-medium"><fmt:formatNumber type="number" value="10000"/> VND</h6>
            </div>
        </div>
        <div class="pt-2">
            <div class="d-flex justify-content-between mt-2">
                <h5>Total</h5>
                <h5>
                    <fmt:formatNumber type="number"
                                      value="${cart.totalPrice + 10000}"/> VND
                </h5>
            </div>
        </div>
    </div>
    <div class="mb-5">
        <h5 class="section-title position-relative text-uppercase mb-3"><span
                class="bg-secondary pr-3">Payment</span></h5>
        <div class="bg-light p-30">
            <button class="btn btn-block btn-primary font-weight-bold py-3" form="ordered"
                    onclick="return confirm('Do you want to accept this order?')">Place Order
            </button>
        </div>
    </div>
</div>
</div>
</div>
<!-- Checkout End -->

<c:import url="layout/footer.jsp"></c:import>