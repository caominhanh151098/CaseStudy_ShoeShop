<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="../layout/header.jsp"/>

<nav
        class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
        id="layout-navbar"
>
  <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
      <i class="bx bx-menu bx-sm"></i>
    </a>
  </div>

  <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
    <!-- Search -->
    <div class="navbar-nav align-items-center">
      <div class="nav-item d-flex align-items-center">
        <i class="bx bx-search fs-4 lh-0"></i>
        <form>
          <input
                  type="search"
                  class="form-control border-0 shadow-none"
                  placeholder="Search..."
                  aria-label="Search..."
                  name="search" value="${pageable.search}" onsearch="onClearSearch()"
          />
          <button id="searchButton" type="submit" style="display: none"/>
        </form>
        <script>
          function onClearSearch(){
            let searchButton = document.getElementById("searchButton");
            searchButton.click();
          }
        </script>
      </div>
    </div>
    <!-- /Search -->

    <ul class="navbar-nav flex-row align-items-center ms-auto">
      <!-- User -->
      <li class="nav-item navbar-dropdown dropdown-user dropdown">
        <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);"
           data-bs-toggle="dropdown">
          <div class="avatar avatar-online">
            <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle"/>
          </div>
        </a>
        <ul class="dropdown-menu dropdown-menu-end">
          <li>
            <a class="dropdown-item" href="#">
              <div class="d-flex">
                <div class="flex-shrink-0 me-3">
                  <div class="avatar avatar-online">
                    <img src="../assets/img/avatars/1.png" alt
                         class="w-px-40 h-auto rounded-circle"/>
                  </div>
                </div>
                <div class="flex-grow-1">
                  <span class="fw-semibold d-block">${user.username}</span>
                  <small class="text-muted">${admin}</small>
                </div>
              </div>
            </a>
          </li>
          <li>
            <div class="dropdown-divider"></div>
          </li>
          <li>
            <a class="dropdown-item" href="#">
              <i class="bx bx-user me-2"></i>
              <span class="align-middle">My Profile</span>
            </a>
          </li>
          <li>
            <a class="dropdown-item" href="#">
              <i class="bx bx-cog me-2"></i>
              <span class="align-middle">Settings</span>
            </a>
          </li>
          <li>
            <a class="dropdown-item" href="#">
                                    <span class="d-flex align-items-center align-middle">
                                      <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                                      <span class="flex-grow-1 align-middle">Billing</span>
                                      <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                                    </span>
            </a>
          </li>
          <li>
            <div class="dropdown-divider"></div>
          </li>
          <li>
            <a class="dropdown-item" href="/logout">
              <i class="bx bx-power-off me-2"></i>
              <span class="align-middle">Log Out</span>
            </a>
          </li>
        </ul>
      </li>
      <!--/ User -->
    </ul>
  </div>
</nav>
<br><br>

<div class="card h-100">
  <div class="card-header d-flex align-items-center justify-content-between pb-0">
    <div class="card-title mb-0">
      <h5 class="m-0 me-2">Order Statistics</h5>
      <small class="text-muted">42.82k Total Sales</small>
    </div>
    <div class="dropdown">
      <button class="btn p-0" type="button" id="orederStatistics" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="bx bx-dots-vertical-rounded"></i>
      </button>
      <div class="dropdown-menu dropdown-menu-end" aria-labelledby="orederStatistics" style="">
        <a class="dropdown-item" href="javascript:void(0);">Select All</a>
        <a class="dropdown-item" href="javascript:void(0);">Refresh</a>
        <a class="dropdown-item" href="javascript:void(0);">Share</a>
      </div>
    </div>
  </div>
  <div class="card-body">
    <div class="d-flex justify-content-between align-items-center mb-3" style="position: relative;">
      <div class="d-flex flex-column align-items-center gap-1">
        <h2 class="mb-2">8,258</h2>
        <span>Total Orders</span>
      </div>
      <div id="orderStatisticsChart" style="min-height: 137.55px;"><div id="apexcharts23uyyutw" class="apexcharts-canvas apexcharts23uyyutw apexcharts-theme-light" style="width: 130px; height: 137.55px;"><svg id="SvgjsSvg2695" width="130" height="137.55" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.dev" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: transparent;"><g id="SvgjsG2697" class="apexcharts-inner apexcharts-graphical" transform="translate(-7, 0)"><defs id="SvgjsDefs2696"><clipPath id="gridRectMask23uyyutw"><rect id="SvgjsRect2699" width="150" height="173" x="-4.5" y="-2.5" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clipPath><clipPath id="forecastMask23uyyutw"></clipPath><clipPath id="nonForecastMask23uyyutw"></clipPath><clipPath id="gridRectMarkerMask23uyyutw"><rect id="SvgjsRect2700" width="145" height="172" x="-2" y="-2" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clipPath></defs><g id="SvgjsG2701" class="apexcharts-pie"><g id="SvgjsG2702" transform="translate(0, 0) scale(1)"><circle id="SvgjsCircle2703" r="44.835365853658544" cx="70.5" cy="70.5" fill="transparent"></circle><g id="SvgjsG2704" class="apexcharts-slices"><g id="SvgjsG2705" class="apexcharts-series apexcharts-pie-series" seriesName="Electronic" rel="1" data:realIndex="0"><path id="SvgjsPath2706" d="M 70.5 10.71951219512195 A 59.78048780487805 59.78048780487805 0 0 1 97.63977353321047 123.7648046533095 L 90.85483014990785 110.44860348998213 A 44.835365853658544 44.835365853658544 0 0 0 70.5 25.664634146341456 L 70.5 10.71951219512195 z" fill="rgba(105,108,255,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="5" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-0" index="0" j="0" data:angle="153" data:startAngle="0" data:strokeWidth="5" data:value="85" data:pathOrig="M 70.5 10.71951219512195 A 59.78048780487805 59.78048780487805 0 0 1 97.63977353321047 123.7648046533095 L 90.85483014990785 110.44860348998213 A 44.835365853658544 44.835365853658544 0 0 0 70.5 25.664634146341456 L 70.5 10.71951219512195 z" stroke="#ffffff"></path></g><g id="SvgjsG2707" class="apexcharts-series apexcharts-pie-series" seriesName="Sports" rel="2" data:realIndex="1"><path id="SvgjsPath2708" d="M 97.63977353321047 123.7648046533095 A 59.78048780487805 59.78048780487805 0 0 1 70.5 130.28048780487805 L 70.5 115.33536585365854 A 44.835365853658544 44.835365853658544 0 0 0 90.85483014990785 110.44860348998213 L 97.63977353321047 123.7648046533095 z" fill="rgba(133,146,163,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="5" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-1" index="0" j="1" data:angle="27" data:startAngle="153" data:strokeWidth="5" data:value="15" data:pathOrig="M 97.63977353321047 123.7648046533095 A 59.78048780487805 59.78048780487805 0 0 1 70.5 130.28048780487805 L 70.5 115.33536585365854 A 44.835365853658544 44.835365853658544 0 0 0 90.85483014990785 110.44860348998213 L 97.63977353321047 123.7648046533095 z" stroke="#ffffff"></path></g><g id="SvgjsG2709" class="apexcharts-series apexcharts-pie-series" seriesName="Decor" rel="3" data:realIndex="2"><path id="SvgjsPath2710" d="M 70.5 130.28048780487805 A 59.78048780487805 59.78048780487805 0 0 1 10.71951219512195 70.50000000000001 L 25.664634146341456 70.5 A 44.835365853658544 44.835365853658544 0 0 0 70.5 115.33536585365854 L 70.5 130.28048780487805 z" fill="rgba(3,195,236,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="5" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-2" index="0" j="2" data:angle="90" data:startAngle="180" data:strokeWidth="5" data:value="50" data:pathOrig="M 70.5 130.28048780487805 A 59.78048780487805 59.78048780487805 0 0 1 10.71951219512195 70.50000000000001 L 25.664634146341456 70.5 A 44.835365853658544 44.835365853658544 0 0 0 70.5 115.33536585365854 L 70.5 130.28048780487805 z" stroke="#ffffff"></path></g><g id="SvgjsG2711" class="apexcharts-series apexcharts-pie-series" seriesName="Fashion" rel="4" data:realIndex="3"><path id="SvgjsPath2712" d="M 10.71951219512195 70.50000000000001 A 59.78048780487805 59.78048780487805 0 0 1 70.48956633664653 10.719513105630845 L 70.4921747524849 25.664634829223125 A 44.835365853658544 44.835365853658544 0 0 0 25.664634146341456 70.5 L 10.71951219512195 70.50000000000001 z" fill="rgba(113,221,55,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="5" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-3" index="0" j="3" data:angle="90" data:startAngle="270" data:strokeWidth="5" data:value="50" data:pathOrig="M 10.71951219512195 70.50000000000001 A 59.78048780487805 59.78048780487805 0 0 1 70.48956633664653 10.719513105630845 L 70.4921747524849 25.664634829223125 A 44.835365853658544 44.835365853658544 0 0 0 25.664634146341456 70.5 L 10.71951219512195 70.50000000000001 z" stroke="#ffffff"></path></g></g></g><g id="SvgjsG2713" class="apexcharts-datalabels-group" transform="translate(0, 0) scale(1)" style="opacity: 1;"><text id="SvgjsText2714" font-family="Helvetica, Arial, sans-serif" x="70.5" y="90.5" text-anchor="middle" dominant-baseline="auto" font-size="0.8125rem" font-weight="400" fill="#a1acb8" class="apexcharts-text apexcharts-datalabel-label" style="font-family: Helvetica, Arial, sans-serif; fill: rgb(161, 172, 184);">Weekly</text><text id="SvgjsText2715" font-family="Public Sans" x="70.5" y="71.5" text-anchor="middle" dominant-baseline="auto" font-size="1.5rem" font-weight="400" fill="#566a7f" class="apexcharts-text apexcharts-datalabel-value" style="font-family: &quot;Public Sans&quot;;">38%</text></g></g><line id="SvgjsLine2716" x1="0" y1="0" x2="141" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" stroke-linecap="butt" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine2717" x1="0" y1="0" x2="141" y2="0" stroke-dasharray="0" stroke-width="0" stroke-linecap="butt" class="apexcharts-ycrosshairs-hidden"></line></g><g id="SvgjsG2698" class="apexcharts-annotations"></g></svg><div class="apexcharts-legend"></div><div class="apexcharts-tooltip apexcharts-theme-dark" style="left: -10.6406px; top: -12.8906px;"><div class="apexcharts-tooltip-series-group apexcharts-active" style="order: 1; display: flex; background-color: rgb(113, 221, 55);"><span class="apexcharts-tooltip-marker" style="background-color: rgb(113, 221, 55); display: none;"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label">Fashion: </span><span class="apexcharts-tooltip-text-y-value">50</span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 2; display: none; background-color: rgb(113, 221, 55);"><span class="apexcharts-tooltip-marker" style="background-color: rgb(113, 221, 55); display: none;"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label">Fashion: </span><span class="apexcharts-tooltip-text-y-value">50</span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 3; display: none; background-color: rgb(113, 221, 55);"><span class="apexcharts-tooltip-marker" style="background-color: rgb(113, 221, 55); display: none;"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label">Fashion: </span><span class="apexcharts-tooltip-text-y-value">50</span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 4; display: none; background-color: rgb(113, 221, 55);"><span class="apexcharts-tooltip-marker" style="background-color: rgb(113, 221, 55); display: none;"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label">Fashion: </span><span class="apexcharts-tooltip-text-y-value">50</span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>
      <div class="resize-triggers"><div class="expand-trigger"><div style="width: 662px; height: 139px;"></div></div><div class="contract-trigger"></div></div></div>
    <ul class="p-0 m-0">
      <li class="d-flex mb-4 pb-1">
        <div class="avatar flex-shrink-0 me-3">
          <span class="avatar-initial rounded bg-label-primary"><i class="bx bx-mobile-alt"></i></span>
        </div>
        <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
          <div class="me-2">
            <h6 class="mb-0">Electronic</h6>
            <small class="text-muted">Mobile, Earbuds, TV</small>
          </div>
          <div class="user-progress">
            <small class="fw-semibold">82.5k</small>
          </div>
        </div>
      </li>
      <li class="d-flex mb-4 pb-1">
        <div class="avatar flex-shrink-0 me-3">
          <span class="avatar-initial rounded bg-label-success"><i class="bx bx-closet"></i></span>
        </div>
        <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
          <div class="me-2">
            <h6 class="mb-0">Fashion</h6>
            <small class="text-muted">T-shirt, Jeans, Shoes</small>
          </div>
          <div class="user-progress">
            <small class="fw-semibold">23.8k</small>
          </div>
        </div>
      </li>
      <li class="d-flex mb-4 pb-1">
        <div class="avatar flex-shrink-0 me-3">
          <span class="avatar-initial rounded bg-label-info"><i class="bx bx-home-alt"></i></span>
        </div>
        <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
          <div class="me-2">
            <h6 class="mb-0">Decor</h6>
            <small class="text-muted">Fine Art, Dining</small>
          </div>
          <div class="user-progress">
            <small class="fw-semibold">849k</small>
          </div>
        </div>
      </li>
      <li class="d-flex">
        <div class="avatar flex-shrink-0 me-3">
          <span class="avatar-initial rounded bg-label-secondary"><i class="bx bx-football"></i></span>
        </div>
        <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
          <div class="me-2">
            <h6 class="mb-0">Sports</h6>
            <small class="text-muted">Football, Cricket Kit</small>
          </div>
          <div class="user-progress">
            <small class="fw-semibold">99</small>
          </div>
        </div>
      </li>
    </ul>
  </div>
</div>
<jsp:include page="../layout/footer.jsp"/>