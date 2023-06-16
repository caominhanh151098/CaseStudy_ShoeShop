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
        <span class="breadcrumb-item active">Shop Detail</span>
      </nav>
    </div>
  </div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Detail Start -->
<div class="container-fluid pb-5">
  <div class="row px-xl-5">
    <div class="col-lg-5 mb-30">
      <div id="product-carousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner bg-light">
          <div class="carousel-item active">
            <img class="w-100 h-100" src="${product.image}" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="user/img/product-2.jpg" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="user/img/product-3.jpg" alt="Image">
          </div>
          <div class="carousel-item">
            <img class="w-100 h-100" src="user/img/product-4.jpg" alt="Image">
          </div>
        </div>
        <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
          <i class="fa fa-2x fa-angle-left text-dark"></i>
        </a>
        <a class="carousel-control-next" href="#product-carousel" data-slide="next">
          <i class="fa fa-2x fa-angle-right text-dark"></i>
        </a>
      </div>
    </div>

    <div class="col-lg-7 h-auto mb-30">
      <div class="h-100 bg-light p-30">
        <h3>${product.product_name}</h3>
        <h3 class="font-weight-semi-bold mb-4"><fmt:formatNumber type="number" value="${product.price}"/> VND</h3>
        <p class="mb-4">${product.description}</p>
        <div class="d-flex mb-3">
          <strong class="text-dark mr-3">Sizes:</strong>
          <form action="google.com" method="get" id="formBuy">
            <c:forEach items="${sizes}" var="size">
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" class="custom-control-input" id="size-${size.id}" name="size-${size.size}">
                <label class="custom-control-label" for="size-${size.size}">${size.size}</label>
              </div>
            </c:forEach>
          </form>
        </div>
        <div class="d-flex align-items-center mb-4 pt-2">
          <div class="input-group quantity mr-3" style="width: 130px;">
            <div class="input-group-btn">
              <button class="btn btn-primary btn-minus">
                <i class="fa fa-minus"></i>
              </button>
            </div>
            <input type="text" class="form-control bg-secondary border-0 text-center" value="1">
            <div class="input-group-btn">
              <button class="btn btn-primary btn-plus">
                <i class="fa fa-plus"></i>
              </button>
            </div>
          </div>
          <button type="submit" form="formBuy" class="btn btn-primary px-3" id="buttonSubmit"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
        </div>
      </div>
    </div>
  </div>
  <div class="row px-xl-5">
    <div class="col">
      <div class="bg-light p-30">
        <div class="nav nav-tabs mb-4">
          <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">Description</a>
          <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-2">Information</a>
          <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-3">Reviews (0)</a>
        </div>
        <div class="tab-content">
          <div class="tab-pane fade show active" id="tab-pane-1">
            <h4 class="mb-3">Product Description</h4>
            <p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam sea. Consetetur vero aliquyam invidunt duo dolores et duo sit. Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod. Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut diam consetetur duo justo est, sit sanctus diam tempor aliquyam eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr sanctus eirmod takimata dolor ea invidunt.</p>
            <p>Dolore magna est eirmod sanctus dolor, amet diam et eirmod et ipsum. Amet dolore tempor consetetur sed lorem dolor sit lorem tempor. Gubergren amet amet labore sadipscing clita clita diam clita. Sea amet et sed ipsum lorem elitr et, amet et labore voluptua sit rebum. Ea erat sed et diam takimata sed justo. Magna takimata justo et amet magna et.</p>
          </div>
          <div class="tab-pane fade" id="tab-pane-2">
            <h4 class="mb-3">Additional Information</h4>
            <p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam sea. Consetetur vero aliquyam invidunt duo dolores et duo sit. Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod. Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut diam consetetur duo justo est, sit sanctus diam tempor aliquyam eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr sanctus eirmod takimata dolor ea invidunt.</p>
            <div class="row">
              <div class="col-md-6">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item px-0">
                    Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                  </li>
                  <li class="list-group-item px-0">
                    Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                  </li>
                  <li class="list-group-item px-0">
                    Duo amet accusam eirmod nonumy stet et et stet eirmod.
                  </li>
                  <li class="list-group-item px-0">
                    Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                  </li>
                </ul>
              </div>
              <div class="col-md-6">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item px-0">
                    Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                  </li>
                  <li class="list-group-item px-0">
                    Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                  </li>
                  <li class="list-group-item px-0">
                    Duo amet accusam eirmod nonumy stet et et stet eirmod.
                  </li>
                  <li class="list-group-item px-0">
                    Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="tab-pane fade" id="tab-pane-3">
            <div class="row">
              <div class="col-md-6">
                <h4 class="mb-4">1 review for "Product Name"</h4>
                <div class="media mb-4">
                  <img src="user/img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                  <div class="media-body">
                    <h6>John Doe<small> - <i>01 Jan 2045</i></small></h6>
                    <div class="text-primary mb-2">
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star-half-alt"></i>
                      <i class="far fa-star"></i>
                    </div>
                    <p>Diam amet duo labore stet elitr ea clita ipsum, tempor labore accusam ipsum et no at. Kasd diam tempor rebum magna dolores sed sed eirmod ipsum.</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <h4 class="mb-4">Leave a review</h4>
                <small>Your email address will not be published. Required fields are marked *</small>
                <div class="d-flex my-3">
                  <p class="mb-0 mr-2">Your Rating * :</p>
                  <div class="text-primary">
                    <i class="far fa-star"></i>
                    <i class="far fa-star"></i>
                    <i class="far fa-star"></i>
                    <i class="far fa-star"></i>
                    <i class="far fa-star"></i>
                  </div>
                </div>
                <form>
                  <div class="form-group">
                    <label for="message">Your Review *</label>
                    <textarea id="message" cols="30" rows="5" class="form-control"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="name">Your Name *</label>
                    <input type="text" class="form-control" id="name">
                  </div>
                  <div class="form-group">
                    <label for="email">Your Email *</label>
                    <input type="email" class="form-control" id="email">
                  </div>
                  <div class="form-group mb-0">
                    <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Shop Detail End -->


<!-- Products Start -->
<div class="container-fluid py-5">
  <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">You May Also Like</span></h2>
  <div class="row px-xl-5">
    <div class="col">
      <div class="owl-carousel related-carousel">
        <div class="product-item bg-light">
          <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="user/img/product-1.jpg" alt="">
            <div class="product-action">
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
          </div>
          <div class="text-center py-4">
            <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
            <div class="d-flex align-items-center justify-content-center mt-2">
              <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
            </div>
            <div class="d-flex align-items-center justify-content-center mb-1">
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small>(99)</small>
            </div>
          </div>
        </div>
        <div class="product-item bg-light">
          <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="user/img/product-2.jpg" alt="">
            <div class="product-action">
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
          </div>
          <div class="text-center py-4">
            <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
            <div class="d-flex align-items-center justify-content-center mt-2">
              <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
            </div>
            <div class="d-flex align-items-center justify-content-center mb-1">
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small>(99)</small>
            </div>
          </div>
        </div>
        <div class="product-item bg-light">
          <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="user/img/product-3.jpg" alt="">
            <div class="product-action">
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
          </div>
          <div class="text-center py-4">
            <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
            <div class="d-flex align-items-center justify-content-center mt-2">
              <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
            </div>
            <div class="d-flex align-items-center justify-content-center mb-1">
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small>(99)</small>
            </div>
          </div>
        </div>
        <div class="product-item bg-light">
          <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="user/img/product-4.jpg" alt="">
            <div class="product-action">
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
          </div>
          <div class="text-center py-4">
            <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
            <div class="d-flex align-items-center justify-content-center mt-2">
              <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
            </div>
            <div class="d-flex align-items-center justify-content-center mb-1">
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small>(99)</small>
            </div>
          </div>
        </div>
        <div class="product-item bg-light">
          <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="user/img/product-5.jpg" alt="">
            <div class="product-action">
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
              <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
          </div>
          <div class="text-center py-4">
            <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
            <div class="d-flex align-items-center justify-content-center mt-2">
              <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
            </div>
            <div class="d-flex align-items-center justify-content-center mb-1">
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small class="fa fa-star text-primary mr-1"></small>
              <small>(99)</small>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Products End -->


<!-- Footer Start -->
<div class="container-fluid bg-dark text-secondary mt-5 pt-5">
  <div class="row px-xl-5 pt-5">
    <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
      <h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
      <p class="mb-4">No dolore ipsum accusam no lorem. Invidunt sed clita kasd clita et et dolor sed dolor. Rebum tempor no vero est magna amet no</p>
      <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
      <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
      <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
    </div>
    <div class="col-lg-8 col-md-12">
      <div class="row">
        <div class="col-md-4 mb-5">
          <h5 class="text-secondary text-uppercase mb-4">Quick Shop</h5>
          <div class="d-flex flex-column justify-content-start">
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Home</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
            <a class="text-secondary" href="#"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
          </div>
        </div>
        <div class="col-md-4 mb-5">
          <h5 class="text-secondary text-uppercase mb-4">My Account</h5>
          <div class="d-flex flex-column justify-content-start">
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Home</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
            <a class="text-secondary" href="#"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
          </div>
        </div>
        <div class="col-md-4 mb-5">
          <h5 class="text-secondary text-uppercase mb-4">Newsletter</h5>
          <p>Duo stet tempor ipsum sit amet magna ipsum tempor est</p>
          <form action="">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Your Email Address">
              <div class="input-group-append">
                <button class="btn btn-primary">Sign Up</button>
              </div>
            </div>
          </form>
          <h6 class="text-secondary text-uppercase mt-4 mb-3">Follow Us</h6>
          <div class="d-flex">
            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
            <a class="btn btn-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row border-top mx-xl-5 py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
    <div class="col-md-6 px-xl-0">
      <p class="mb-md-0 text-center text-md-left text-secondary">
        &copy; <a class="text-primary" href="#">Domain</a>. All Rights Reserved. Designed
        by
        <a class="text-primary" href="https://htmlcodex.com">HTML Codex</a>
        <br>Distributed By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
      </p>
    </div>
    <div class="col-md-6 px-xl-0 text-center text-md-right">
      <img class="img-fluid" src="user/img/payments.png" alt="">
    </div>
  </div>
</div>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="user/lib/easing/easing.min.js"></script>
<script src="user/lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="user/mail/jqBootstrapValidation.min.js"></script>
<script src="user/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="user/js/main.js"></script>
</body>

</html>