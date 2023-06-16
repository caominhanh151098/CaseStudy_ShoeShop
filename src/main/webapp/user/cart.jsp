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
                <span class="breadcrumb-item active">Shopping Cart</span>
            </nav>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->


<!-- Cart Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <div class="col-lg-8 table-responsive mb-5">
            <table class="table table-light table-borderless table-hover text-center mb-0">
                <thead class="thead-dark">
                <tr>
                    <th>Products</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
                </thead>
                <tbody class="align-middle">
                <c:forEach items="${orderDetails}" var="orderDetail">
                    <tr>
                        <td class="align-middle" style="text-align: left"><img
                        <c:forEach items="${products}" var="product">
                                <c:if test="${product.id == orderDetail.productID}">src="${product.image}"</c:if>
                        </c:forEach>
                                alt="" style="width: 50px;">${orderDetail.productName}</td>
                        <td class="align-middle"><fmt:formatNumber type="number" value="${orderDetail.price}"/> VND</td>
                        <td class="align-middle">
                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                <div class="input-group-btn">
<%--                                    <button class="btn btn-sm btn-primary btn-minus"--%>
<%--                                            onclick="changeQuantity(${orderDetail.id}, ${orderDetail.price},-1)">--%>
<%--                                        <i class="fa fa-minus"></i>--%>
                                    <button class="btn btn-sm btn-primary btn-minus"><a href="shop?action=cart-edit&quantity=${orderDetail.quantity-1}&id=${orderDetail.id}">
                                        <i class="fa fa-minus"></i></a>
                                    </button>
                                </div>
                                <input type="text"
                                       id="${orderDetail.id}quantity"
                                       class="form-control form-control-sm bg-secondary border-0 text-center quantity-number"
                                       value="${orderDetail.quantity}" disabled>
                                <div class="input-group-btn">
<%--                                    <button class="btn btn-sm btn-primary btn-plus"--%>
<%--                                            onclick="changeQuantity(${orderDetail.id}, ${orderDetail.price},1)">--%>
<%--                                        <i class="fa fa-plus"></i>--%>
<%--                                    </button>--%>
                                    <button class="btn btn-sm btn-primary btn-plus"><a href="shop?action=cart-edit&quantity=${orderDetail.quantity+1}&id=${orderDetail.id}">
                                        <i class="fa fa-plus"></i</a>
                                    </button>
                                </div>
                            </div>
                        </td>
                        <td class="align-middle" id="${orderDetail.id}totalPrice">
                            <fmt:formatNumber type="number" value="${orderDetail.price * orderDetail.quantity}"/> VND
                        </td>
                        <td class="align-middle">
                            <button class="btn btn-sm btn-danger"><i class="fa fa-times"></i></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-4">
            <h5 class="section-title position-relative text-uppercase mb-3"><span
                    class="bg-secondary pr-3">Cart Summary</span></h5>
            <div class="bg-light p-30 mb-5">
                <div class="border-bottom pb-2">
                    <div class="d-flex justify-content-between mb-3">
                        <h6>Subtotal</h6>
                        <h6 id="totalPrice">$150</h6>
                    </div>
                </div>
                <div class="pt-2">
                    <div class="d-flex justify-content-between mt-2">
                        <h5>Total</h5>
                        <h5>$160</h5>
                    </div>
                    <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->


<c:import url="layout/footer.jsp"></c:import>