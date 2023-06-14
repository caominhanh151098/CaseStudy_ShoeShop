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
        <tr>
            <td>ID</td>
            <td>Name User</td>
            <td>Price</td>
            <td>Order Date</td>
            <td><span class="badge bg-label-info me-1">Ordered</span></td>
            <td>
                <button type="button" class="btn rounded-pill btn-outline-secondary"><a><i
                        class="bx bx-edit-alt me-1"></i>Edit</a></button>
            </td>
        </tr>
        <tr>
            <td>ID</td>
            <td>Name User</td>
            <td>Price</td>
            <td>Order Date</td>
            <td><span class="badge bg-label-warning me-1">Delivery</span></td>
            <td>
                <button type="button" class="btn rounded-pill btn-outline-secondary"><a><i
                        class="bx bx-edit-alt me-1"></i>Edit</a></button>
            </td>
        </tr>
        <tr>
            <td>ID</td>
            <td>Name User</td>
            <td>Price</td>
            <td>Order Date</td>
            <td><span class="badge bg-label-success me-1">Complete</span></td>
            <td>
                <button type="button" class="btn rounded-pill btn-outline-secondary"><a><i
                        class="bx bx-edit-alt me-1"></i>Edit</a></button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="layout/footer.jsp"/>
