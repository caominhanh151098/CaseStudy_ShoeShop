<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<h1>${action}</h1>
<a href="/user?action=show">Show User</a>
<c:if test="${requestScope['user'].size() != 0}">
    <table border="1" >
        <tr class="bg-danger" class="rounded-pill">
            <td>Id</td>
            <td>Username</td>
            <td>user_id</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${user}" var="user1">
            <tr>
                <td>${user1.id}</td>
                <td>${user1.username}</td>
                <td>${user1.user_info.user_id}</td>
                <td>${user1.user_info.name}</td>
                <td><a href="/user?action=edit&id=${user1.id}">Edit</a> </td>
                <td><a href="/user?action=showall&id=${user1.id}">ShowAll</a> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>