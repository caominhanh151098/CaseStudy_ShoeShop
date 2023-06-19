package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Delivery;
import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.enums.EPrice;
import com.example.casestudy_shoeshop.model.enums.Status;
import com.example.casestudy_shoeshop.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private static ShopService shopService = new ShopService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "show":
                showProduct(req, resp);
                break;
            case "cart":
                showCart(req, resp);
                break;
            case "cart-edit":
                editCart(req, resp);
                break;
            case "remove-cart":
                removeCartDetail(req, resp);
                break;
            case "checkout":
                showCheckOut(req, resp);
                break;
            default:
                showShop(req, resp);
        }
    }

    private void removeCartDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        int idCartDetail = Integer.parseInt(req.getParameter("id"));
        shopService.removeCartDetail(id, idCartDetail);
        showCart(req, resp);
    }

    private void showCheckOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        Order cartUser = shopService.findCartByUserId(id);
        req.setAttribute("cart", cartUser);
        req.setAttribute("categories", shopService.getCategories());
        req.setAttribute("userinfo", shopService.findUserById(id).getUser_info());
        req.getRequestDispatcher("user/checkout.jsp").forward(req, resp);
    }

    private void editCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        int idCart = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        shopService.updateCartDetail(idCart, quantity);
        shopService.updateCart(id);
        showCart(req, resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        Order cartUser = shopService.findCartByUserId(id);
        List<Product> productList = new ArrayList<>();
        for (OrderDetail cartDetail : cartUser.getOrderDetailList()) {
            productList.add(shopService.getProductById(cartDetail.getProductID()));
        }
        req.setAttribute("cart", cartUser);
        req.setAttribute("products", productList);
        req.setAttribute("categories", shopService.getCategories());
        req.getRequestDispatcher("user/cart.jsp").forward(req, resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", shopService.getProductById(id));
        req.setAttribute("sizes", shopService.findSizeByProductId(id));
        req.setAttribute("categories", shopService.getCategories());
        req.getRequestDispatcher("user/detail.jsp").forward(req, resp);
    }

    private void showShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        String pageString = req.getParameter("page");
        if (pageString != null)
            page = Integer.parseInt(req.getParameter("page"));
        String search = req.getParameter("search");
        if (search == null)
            search = "";
        Pageable pageable = new Pageable(search, page, 9, "id", "ASC");
        String prices = req.getParameter("price");

        if (prices != null && !prices.isEmpty()) {
            String[] pricesString = prices.split(",");
            List<Integer> integers = Arrays.stream(pricesString).map(Integer::parseInt).collect(Collectors.toList());
            List<EPrice> ePrices = new ArrayList<>();
            integers.forEach(value -> {
                for (EPrice ePrice : EPrice.values()) {
                    if (value == ePrice.getValue()) {
                        ePrices.add(ePrice);
                    }
                }
            });
            pageable.setPrices(ePrices);
        }

        req.setAttribute("productList", shopService.getProducts(pageable));
        req.setAttribute("prices", EPrice.values());
        req.setAttribute("categories", shopService.getCategories());
        req.setAttribute("pageable", pageable);
        req.getRequestDispatcher("user/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "ordered":
                acceptOrder(req, resp);
                break;
            case "add-to-cart":
                addToCart(req, resp);
                break;
            default:
                showShop(req, resp);
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        int productId = Integer.parseInt(req.getParameter("productId"));
        int sizeId = Integer.parseInt(req.getParameter("sizeId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        OrderDetail cartDetail = new OrderDetail(productId, sizeId, quantity);
        shopService.addToCart(id, cartDetail);
        showShop(req, resp);
    }

    private void acceptOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        Order cartUser = shopService.findCartByUserId(id);
        String nameUser = req.getParameter("name");
        String emailUser = req.getParameter("email");
        String phoneUser = req.getParameter("phone");
        String addressUser = req.getParameter("address");
        Delivery delivery = new Delivery(nameUser, emailUser, phoneUser, addressUser);
        shopService.acceptOrder(cartUser, delivery);
        req.setAttribute("categories", shopService.getCategories());
        req.getRequestDispatcher("user/cart.jsp").forward(req, resp);

    }
}
