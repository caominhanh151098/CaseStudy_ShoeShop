<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    function filterByPrice() {
        var url = "/shop?price=";
        var checkboxes = document.getElementsByClassName("prices");
        for (let i = 0; i < checkboxes.length; i++) {
            let e = checkboxes[i];
            if (e.checked) {
                url += e.value + ",";
            }
        }

        window.location = url;
    }

    //nhaan object enum selected o day loop enum selected o day bat checked len lien he huy
</script>