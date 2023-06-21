<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    function formatNumber(number) {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    }

    function changeQuantity(orderDetailId, price, plus) {
        var quantity = +document.getElementById(orderDetailId + "quantity").value;
        if (plus == 1)
            quantity++;
        else quantity--;
        var totalPriceP = formatNumber(quantity * price) + " VND";
        if (quantity >= 0)
            document.getElementById(orderDetailId + "totalPrice").innerHTML = totalPriceP;
        changeTotalPrice()
    }

    function filterBy() {
        let url = "shop?";
        var checkboxesPrices = document.getElementsByClassName("prices");
        var checkboxesCategories = document.getElementsByClassName("categories");
        var checkboxesSizes = document.getElementsByClassName("sizes");
        if (checkboxesPrices.length !== 0) {
            var price = "";

            for (let i = 0; i < checkboxesPrices.length; i++) {
                let e = checkboxesPrices[i];
                if (e.checked && e.value) {
                    price += e.value;
                }
            }
            if (price !== "") {
                price = "&price=" + price;
            }
            url += price;
        }
        if (checkboxesCategories.length !== 0) {
            var category = "";

            for (let i = 0; i < checkboxesCategories.length; i++) {
                let e = checkboxesCategories[i];
                if (e.checked && e.value) {
                    category += e.value;
                }

            }
            if (category !== "") {
                category = "&category=" + category;
            }
            url += category;
        }
        if (checkboxesSizes.length !== 0) {
            var size = "";

            for (let i = 0; i < checkboxesSizes.length; i++) {
                let e = checkboxesSizes[i];
                if (e.checked && e.value) {
                    size += e.value;
                }
            }
            if (size !== "") {
                size = "&size=" + size;
            }
            url += size;
        }

        window.location = "http://localhost:8080/" + url;
    }


</script>