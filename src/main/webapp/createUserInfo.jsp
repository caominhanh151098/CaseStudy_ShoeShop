<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>CreateUser</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
  <span>${message}</span>
</c:if>
<a href="/user">Back</a>
<form action="/user?action=create" method="post">
  <label for="name">Name</label>
  <input type="text" name="name" id="name" value="${userInfo.name}" />

  <label for="dob">Dob</label>
  <input type="date" name="dob" id="dob" value="${userInfo.dob}" />

  <label for="email">Email</label>
  <input type="text" name="email" id="email" value="${userInfo.email}" />

  <label for="phone">Phone</label>
  <input type="text" name="phone" id="phone" value="${userInfo.phone}" />

<%--  <label for="user_avatar">user_avatar</label>--%>
<%--  <input type="text" name="user_avatar" id="user_avatar" value="${book.user_avatar}" />--%>
  </select>
  <button type="submit">Create</button>
</form>
</body>
</html>