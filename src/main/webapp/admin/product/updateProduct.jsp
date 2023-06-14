
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<jsp:include page="../layout/header.jsp"/>

<form action="?action=update" method="post">
  <input type="hidden" name="id" value="${product.id}">

  <div>
    <label for="name">Product_Name</label>
    <input type="text" name="product_name" id="name" placeholder="Nike" value="${product.product_name}"/>
  </div><br>
  <div>
    <label for="price">Price</label>
    <input type="number" name="price" id="price" step="any" placeholder="1000000 VND" value="${product.price}"/>
  </div><br>
  <div>
    <label for="des">Description</label>
    <input type="text" name="description" id="des" placeholder="nike 2023" value="${product.description}"/>
  </div><br>
  <div>
    <label for="img">Image</label>
    <input type="text" name="img" id="img" placeholder="Nike" value="${product.image}"/>
  </div><br>
  <div>
    <label for="category">Category</label>
    <select name="category" id="category">
      <c:forEach items="${categories}" var="category">
        <c:if test="${category.id == product.category.id }">
          <option selected value="${category.id}" >${category.category_name}</option>
        </c:if>
        <c:if test="${category.id != product.category.id }">
          <option value="${category.id}" >${category.category_name}</option>
        </c:if>
      </c:forEach>
    </select>

  </div>
  <div>
    <button type="submit">SUBMIT</button>
  </div>
</form>
<jsp:include page="../layout/footer.jsp"/>
