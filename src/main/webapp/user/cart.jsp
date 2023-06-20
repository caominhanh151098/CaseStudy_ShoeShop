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
                <c:forEach items="${cart.orderDetailList}" var="cartDetail">
                    <tr>
                        <td class="align-middle" style="text-align: left"><img
                        <c:forEach items="${products}" var="product">
                                <c:if test="${product.id == cartDetail.productID}">src="${product.image}"</c:if>
                        </c:forEach>
                                alt="" style="width: 50px;">${cartDetail.productName}</td>
                        <td class="align-middle"><fmt:formatNumber type="number" value="${cartDetail.price}"/> VND</td>
                        <td class="align-middle">
                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                <div class="input-group-btn">
                                        <%--                                    <button class="btn btn-sm btn-primary btn-minus"--%>
                                        <%--                                            onclick="changeQuantity(${orderDetail.id}, ${orderDetail.price},-1)">--%>
                                        <%--                                        <i class="fa fa-minus"></i>--%>
                                        <%--                                            <c:if test="${orderDetail.quantity} >"></c:if>--%>
                                    <a href="shop?action=cart-edit&id=${cartDetail.id}&quantity=${cartDetail.quantity-1}"
                                       <c:if test="${cartDetail.quantity <= 1}">onclick="return false"></c:if>
                                        <button class="btn btn-sm btn-primary btn-minus"><i class="fa fa-minus"></i>
                                        </button>
                                    </a>
                                </div>
                                <input type="text"
                                       id="${cartDetail.id}quantity"
                                       class="form-control form-control-sm bg-secondary border-0 text-center quantity-number"
                                       value="${cartDetail.quantity}" disabled>
                                <div class="input-group-btn">
                                        <%--                                    <button class="btn btn-sm btn-primary btn-plus"--%>
                                        <%--                                            onclick="changeQuantity(${orderDetail.id}, ${orderDetail.price},1)">--%>
                                        <%--                                        <i class="fa fa-plus"></i>--%>
                                        <%--                                    </button>--%>
                                    <a href="shop?action=cart-edit&id=${cartDetail.id}&quantity=${cartDetail.quantity+1}">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </td>
                        <td class="align-middle" id="${cartDetail.id}totalPrice">
                            <fmt:formatNumber type="number" value="${cartDetail.price * cartDetail.quantity}"/> VND
                        </td>
                        <td class="align-middle">
                            <a href="shop?action=remove-cart&id=${cartDetail.id}" onclick="return confirm('Do you want to remove this product from your cart?')">
                                <button class=" btn btn-sm btn-danger"><i class="fa fa-times"></i></button>
                            </a>
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
                        <h6 id="totalPrice"><fmt:formatNumber type="number" value="${cart.totalPrice}"/> VND</h6>
                    </div>
                </div>
                <div class="pt-2">
                    <div class="d-flex justify-content-between mt-2">
                        <h5>Total</h5>
                        <h5><fmt:formatNumber type="number" value="${cart.totalPrice}"/> VND</h5>
                    </div>
                    <a href="shop?action=checkout">
                        <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->

<c:import url="layout/footer.jsp"></c:import>