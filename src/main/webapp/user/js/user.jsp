<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    localStorage.setItem("idCart", <%=request.getAttribute("idCart")%>);
    var idCart = localStorage.getItem("idCart");

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/home", true);
    xhr.open("POST", "/shop", true);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("idCart=" + idCart);




    class Product {
        constructor(id, productName, price, description, image) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.description = description;
            this.image = image;
        }
    }



    class CartDetail {
        constructor(productId, sizeId, quantity, productName, price) {
            this.productId = productId;
            this.sizeId = sizeId;
            this.quantity = quantity;
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }


    }

    function buyProduct() {
        var sizeSelect = document.getElementsByClassName("size-select");
        var buttonSubmit = document.getElementById("buttonSubmit");
        var check = false;
        Array.from(sizeSelect).forEach(e => {
            if (e.checked == true)
                check = true;
        })
        if (check == false) {
            alert("You haven't selected the size yet!!");
            buttonSubmit.disabled = true;
        } else {
            buttonSubmit.disabled = false;
        }


    }


</script>