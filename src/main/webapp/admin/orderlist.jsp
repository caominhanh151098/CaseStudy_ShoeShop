<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="layout/header.jsp"/>
<div class="table-responsive text-nowrap">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Name User</th>
            <th>Price</th>
            <th>Order Date</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody class="table-border-bottom-0">
        <c:forEach items="${orderlist}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.nameUser}</td>
                <td><fmt:formatNumber type="number" value="${order.totalPrice}"/>đ</td>
                <td>${order.orderDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status.getIndex() == 2}">
                            <span class="badge bg-label-info me-1">${order.status}</span>
                        </c:when>
                        <c:when test="${order.status.getIndex() == 3}">
                            <span class="badge bg-label-warning me-1">${order.status}</span>
                        </c:when>
                        <c:when test="${order.status.getIndex() == 4}">
                            <span class="badge bg-label-success me-1">${order.status}</span>
                        </c:when>
                    </c:choose>
                </td>
                <td>
                    <div class="dropdown">
                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                            <i class="bx bx-dots-vertical-rounded"></i>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="javascript:void(0);">
                                <i class="bx bx-edit-alt me-1"/>Show Info</a>
                            <a class="dropdown-item" href="javascript:void(0);">
                                <i class="bx bx-trash me-1"/>Change Status</a>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="layout/footer.jsp"/>
