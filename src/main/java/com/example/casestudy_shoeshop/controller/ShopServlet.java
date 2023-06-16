package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.enums.EPrice;
import com.example.casestudy_shoeshop.service.ShopService;
import com.sun.xml.internal.ws.util.StringUtils;

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
            default:
                showShop(req, resp);
        }
    }

    private void editCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        shopService.
//        showCart(req, resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 5;
        List<OrderDetail> orderDetailList = shopService.getCartByUserId(id);
        List<Product> productList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {
            productList.add(shopService.getProductById(orderDetail.getProductID()));
        }
        req.setAttribute("orderDetails", orderDetailList);
        req.setAttribute("products", productList);
        req.setAttribute("categories", shopService.getCategories());
        req.getRequestDispatcher("user/cart.jsp").forward(req, resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", shopService.findById(id));
        req.setAttribute("sizes", shopService.findSizeByProductId(id));
        req.setAttribute("categories", shopService.getCategories());
        req.getRequestDispatcher("user/detail.jsp").forward(req, resp);
    }

    private void showShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        String pageString = req.getParameter("page");
        if (pageString != null)
            page = Integer.parseInt(req.getParameter("page"));

        Pageable pageable = new Pageable("", page, 9, "id", "ASC");
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
            req.setAttribute("ePricesSelect", ePrices);
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
        super.doPost(req, resp);
    }
}
