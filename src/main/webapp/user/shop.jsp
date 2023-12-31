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
                <span class="breadcrumb-item active">Shop List</span>
            </nav>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Start -->
<div class="container-fluid">
    <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-lg-3 col-md-4">
            <!-- Price Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by price</span>
            </h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" id="price-all"
                               onclick="filterBy()">
                        <label class="custom-control-label" for="price-all">All Price</label>
                        <%--            <span class="badge border font-weight-normal"></span>--%>
                    </div>
                    <c:forEach var="eprice" items="${prices}">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input prices" id="price-1${eprice.value}"
                                   value="${eprice.value}" onclick="filterBy()"
                            <c:forEach items="${pageable.prices}" var="pricesSelect">
                                   <c:if test="${pricesSelect.value == eprice.value}">checked</c:if>
                            </c:forEach>
                            >
                            <label class="custom-control-label" for="price-1${eprice.value}">${eprice.begin}
                                - ${eprice.end} (VND)</label>
                                <%--            <span class="badge border font-weight-normal">150</span>--%>
                        </div>
                    </c:forEach>
                </form>
            </div>
            <!-- Price End -->

            <!-- Color Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by Category</span>
            </h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" checked id="color-all">
                        <label class="custom-control-label" for="price-all">All Color</label>
                        <%--                        <span class="badge border font-weight-normal">1000</span>--%>
                    </div>
                    <c:forEach items="${categories}" var="category">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input categories" id="category-1${category.id}"
                                   value="${category.id}" onclick="filterBy()"
                            <c:forEach items="${pageable.categories}" var="categorySelect">
                                   <c:if test="${categorySelect.id == category.id}">checked</c:if>
                            </c:forEach>>
                            <label class="custom-control-label"
                                   for="category-1${category.id}">${category.categoryName}</label>
                        </div>
                    </c:forEach>
                </form>
            </div>
            <!-- Color End -->

            <!-- Size Start -->
            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by Size</span>
            </h5>
            <div class="bg-light p-4 mb-30">
                <form>
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input" checked id="size-all">
                        <label class="custom-control-label" for="size-all">All Size</label>
                    </div>
                    <c:forEach items="${sizes}" var="size">
                    <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                        <input type="checkbox" class="custom-control-input sizes" id="size-1${size.id}"
                               value="${size.id}" onclick="filterBy()"
                        <c:forEach items="${pageable.sizes}" var="sizeSelect">
                               <c:if test="${sizeSelect.id == size.id}">checked</c:if>
                        </c:forEach>>
                        <label class="custom-control-label" for="size-1${size.id}">Size ${size.size}</label>
                    </div>
                    </c:forEach>
                </form>
            </div>
            <!-- Size End -->
        </div>
        <!-- Shop Sidebar End -->


        <!-- Shop Product Start -->
        <div class="col-lg-9 col-md-8">
            <div class="row pb-3">
                <div class="col-12 pb-1">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <div>
                            <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                            <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                        </div>
                        <div class="ml-2">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-light dropdown-toggle"
                                        data-toggle="dropdown">Sorting
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="#">Latest</a>
                                    <a class="dropdown-item" href="#">Popularity</a>
                                    <a class="dropdown-item" href="#">Best Rating</a>
                                </div>
                            </div>
                            <div class="btn-group ml-2">
                                <button type="button" class="btn btn-sm btn-light dropdown-toggle"
                                        data-toggle="dropdown">Showing
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="#">10</a>
                                    <a class="dropdown-item" href="#">20</a>
                                    <a class="dropdown-item" href="#">30</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <c:forEach items="${productList}" var="product">
                    <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <div class="product-img position-relative overflow-hidden">
                                <img class="img-fluid w-100" src="${product.image}" alt="">
                                <div class="product-action">
                                    <a class="btn btn-outline-dark btn-square"
                                       href="/shop?action=show&id=${product.id}"><i
                                            class="fa fa-shopping-cart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                </div>
                            </div>
                            <div class="text-center py-4">
                                <a class="h6 text-decoration-none text-truncate"
                                   href="/shop?action=show&id=${product.id}">${product.product_name}</a>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5><fmt:formatNumber type="number" value="${product.price}"/> VND</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-12">
                    <nav>
                        <ul class="pagination justify-content-center">
                            <c:choose>
                                <c:when test="${pageable.page == 1}">
                                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link"
                                                             href="shop?search=${pageable.search}&page=2">2</a></li>
                                    <li class="page-item"><a class="page-link"
                                                             href="shop?search=${pageable.search}&page=3">3</a></li>
                                    <li class="page-item"><a class="page-link"
                                                             href="shop?search=${pageable.search}&page=2">Next</a></li>
                                </c:when>
                                <c:when test="${pageable.page > 1 && pageable.page < pageable.totalPage}">
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page - 1}">Previous
                                        </a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page - 1}">${pageable.page - 1}
                                        </a>
                                    </li>
                                    <li class="page-item active">
                                        <a class="page-link" href="#">${pageable.page}
                                        </a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page + 1}">${pageable.page + 1}
                                        </a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page + 1}">Next</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page - 1}">Previous</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page - 2}">${pageable.page - 2}
                                        </a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link"
                                           href="shop?search=${pageable.search}&page=${pageable.page - 1}">${pageable.page - 1}
                                        </a>
                                    </li>
                                    <li class="page-item active">
                                        <a class="page-link"
                                           href="#">${pageable.page}
                                        </a>
                                    </li>
                                    <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Shop Product End -->
    </div>
</div>
<!-- Shop End -->


<c:import url="layout/footer.jsp"></c:import>