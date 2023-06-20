<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/header.jsp"></c:import>
<!-- Carousel Start -->
<div class="container-fluid mb-3">
    <div class="row px-xl-5">
        <div class="col-lg-8">
            <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#header-carousel" data-slide-to="1"></li>
                    <li data-target="#header-carousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item position-relative active" style="height: 430px;">
                        <img class="position-absolute w-100 h-100" src="user/img/carousel-1.jpg"
                             style="object-fit: cover;">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 700px;">
                                <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Men
                                    Fashion</h1>
                                <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Lorem rebum magna amet lorem
                                    magna erat diam stet. Sadips duo stet amet amet ndiam elitr ipsum diam</p>
                                <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                   href="#">Shop Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item position-relative" style="height: 430px;">
                        <img class="position-absolute w-100 h-100" src="user/img/carousel-2.jpg"
                             style="object-fit: cover;">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 700px;">
                                <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Women
                                    Fashion</h1>
                                <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Lorem rebum magna amet lorem
                                    magna erat diam stet. Sadips duo stet amet amet ndiam elitr ipsum diam</p>
                                <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                   href="#">Shop Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item position-relative" style="height: 430px;">
                        <img class="position-absolute w-100 h-100" src="user/img/carousel-3.jpg"
                             style="object-fit: cover;">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 700px;">
                                <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Kids
                                    Fashion</h1>
                                <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Lorem rebum magna amet lorem
                                    magna erat diam stet. Sadips duo stet amet amet ndiam elitr ipsum diam</p>
                                <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                   href="#">Shop Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-offer mb-30" style="height: 200px;">
                <img class="img-fluid" src="user/img/offer-1.jpg" alt="">
                <div class="offer-text">
                    <h6 class="text-white text-uppercase">Save 20%</h6>
                    <h3 class="text-white mb-3">Special Offer</h3>
                    <a href="" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
            <div class="product-offer mb-30" style="height: 200px;">
                <img class="img-fluid" src="user/img/offer-2.jpg" alt="">
                <div class="offer-text">
                    <h6 class="text-white text-uppercase">Save 20%</h6>
                    <h3 class="text-white mb-3">Special Offer</h3>
                    <a href="" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Carousel End -->


<!-- Featured Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5 pb-3">
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
            <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
            </div>
        </div>
    </div>
</div>
<!-- Featured End -->


<!-- Categories Start -->
<div class="container-fluid pt-5">
    <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span
            class="bg-secondary pr-3">Categories</span></h2>
    <div class="row px-xl-5 pb-3">
        <c:forEach items="${categories}" var="category">
            <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                <a class="text-decoration-none" href="">
                    <div class="cat-item d-flex align-items-center mb-4">
                        <div class="overflow-hidden" style="width: 100px; height: 100px;">
                            <img class="img-fluid" src="${category.img}" alt="">
                        </div>
                        <div class="flex-fill pl-3">
                            <h6>${category.categoryName}</h6>
                        </div>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Categories End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
    <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Featured Products</span>
    </h2>
    <div class="row px-xl-5">
        <c:forEach var="index" begin="0" end="7">
        <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
            <div class="product-item bg-light mb-4">
                <div class="product-img position-relative overflow-hidden">
                    <img class="img-fluid w-100" src="${productList[index].image}" style="height: 350px" alt="${productList[index].product_name}">
                    <div class="product-action">
                        <a class="btn btn-outline-dark btn-square" href="shop?action=show&id=${productList[index].id}"><i class="fa fa-shopping-cart"></i></a>
                        <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                    </div>
                </div>
                <div class="text-center py-4">
                    <a class="h6 text-decoration-none text-truncate" href="">${productList[index].product_name}</a>
                    <div class="d-flex align-items-center justify-content-center mt-2">
                        <h5>${productList[index].price}</h5>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
<!-- Products End -->

<!-- Vendor Start -->
<div class="container-fluid py-5">
    <div class="row px-xl-5">
        <div class="col">
            <div class="owl-carousel vendor-carousel">
                <div class="bg-light p-4" style="height: 230px">
                    <img src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b68b0684-1ffb-4cf3-82f7-02cc4bbf5fc2/phantom-gx-club-dynamic-fit-mg-multi-ground-football-boot-24PQkr.png" width="50px"  height="180px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/5084b9a7-c425-4108-866e-1bdffedc8ad1/gripknit-phantom-gx-elite-fg-football-boot-6t4Xff.png" width="50px" height="180px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/61d18281-89f5-4a1d-a0a5-3f426a8a5d03/metcon-8-training-shoes-p9rQzn.png" width="50px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/06366ceb-2b4c-44cf-bb2a-5c9bcdd21bb1/metcon-8-amp-training-shoes-qCXZkL.png" width="50px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a2eaf301-687e-4235-9dc6-d1cb70f927be/blazer-mid-77-shoes-fW78R7.png" width="50px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f56ebbc8-9c68-4e2b-a3cb-01f6f57083c0/zoom-mercurial-superfly-9-elite-xxv-fg-football-boot-RxNPgm.png" width="50px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f9e940d3-2192-434e-a017-072303ce2f14/air-max-90-shoes-N7Tbw0.png" width="50px">
                </div>
                <div class="bg-light p-4">
                    <img src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b61bbd79-bb41-4a55-9a61-255fffa5fded/phantom-gx-club-tf-football-shoes-K2rSnK.png" width="50px" height="180px">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Vendor End -->
<c:import url="layout/footer.jsp"></c:import>