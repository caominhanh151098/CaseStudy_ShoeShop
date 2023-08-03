package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.*;
import com.example.casestudy_shoeshop.model.enums.EPrice;
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
    public static Order cartUser = new Order();
    public static int idCart;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        req.setAttribute("categories", shopService.getCategories());
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
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        int idCartDetail = Integer.parseInt(req.getParameter("id"));
        shopService.removeCartDetail(cartUser, idCartDetail);
        showCart(req, resp);
    }

    private void showCheckOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        req.setAttribute("cart", cartUser);
        Integer userId = cartUser.getUserId();
        if (userId != 0)
            req.setAttribute("userinfo", shopService.findUserById(userId).getUser_info());
        req.getRequestDispatcher("user/checkout.jsp").forward(req, resp);
    }

    private void editCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        int idCart = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        shopService.updateCartDetail(cartUser, idCart, quantity);
        shopService.updateCart(cartUser);
        showCart(req, resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        List<Product> productList = new ArrayList<>();
        if (cartUser.getOrderDetailList() == null || cartUser.getOrderDetailList().isEmpty()) {
            req.setAttribute("message", "You currently have no items in your shopping cart!");
        } else {
            for (OrderDetail cartDetail : cartUser.getOrderDetailList()) {
                productList.add(shopService.getProductById(cartDetail.getProductID()));
            }
        }
        req.setAttribute("cart", cartUser);
        req.setAttribute("products", productList);
        req.getRequestDispatcher("user/cart.jsp").forward(req, resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", shopService.getProductById(id));
        req.setAttribute("sizes", shopService.findSizeByProductId(id));
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
            String[] pricesString = prices.split("");
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
        String categories = req.getParameter("category");
        if (categories != null && !categories.isEmpty()) {
            String[] categoryString = categories.split("");
            List<Integer> integers = Arrays.stream(categoryString).map(Integer::parseInt).collect(Collectors.toList());
            List<Category> categoryList = new ArrayList<>();
            integers.forEach(value -> {
                for (Category category : shopService.getCategories()) {
                    if (value == category.getId()) {
                        categoryList.add(category);
                    }
                }
            });
            pageable.setCategories(categoryList);
        }
        String sizes = req.getParameter("size");
        if (sizes != null && !sizes.isEmpty()) {
            String[] sizeString = sizes.split("");
            List<Integer> integers = Arrays.stream(sizeString).map(Integer::parseInt).collect(Collectors.toList());
            List<Size> sizeList = new ArrayList<>();
            integers.forEach(value -> {
                for (Size size : shopService.getAllSize()) {
                    if (value == size.getId()) {
                        sizeList.add(size);
                    }
                }
            });
            pageable.setSizes(sizeList);
        }

        req.setAttribute("sizes", shopService.getAllSize());
        req.setAttribute("productList", shopService.getProducts(pageable));
        req.setAttribute("prices", EPrice.values());
        req.setAttribute("pageable", pageable);
        req.setAttribute("priceString", prices);
        req.getRequestDispatcher("user/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        req.setAttribute("categories", shopService.getCategories());
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
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        int productId = Integer.parseInt(req.getParameter("productId"));
        int sizeId = Integer.parseInt(req.getParameter("sizeId"));
        System.out.println(sizeId);
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        OrderDetail cartDetail = new OrderDetail(productId, sizeId, quantity);
        shopService.addToCart(cartUser, cartDetail);
        showShop(req, resp);
    }

    private void acceptOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        cartUser = shopService.findCartBySessionId(sessionId);
        String nameUser = req.getParameter("name");
        String emailUser = req.getParameter("email");
        String phoneUser = req.getParameter("phone");
        String addressUser = req.getParameter("address");
        Delivery delivery = new Delivery(nameUser, emailUser, phoneUser, addressUser);
        shopService.acceptOrder(cartUser, delivery);
        req.getRequestDispatcher("user/cart.jsp").forward(req, resp);
    }


}
