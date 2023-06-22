package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/admin/order")
public class OrderServlet extends HttpServlet {
    public static OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "info":
                showInfo(req, resp);
                break;
            case "change":
                changeStatus(req, resp);
                break;
            case "cancel":
                cancelOrder(req, resp);
                break;
            default:
                showOrderList(req, resp);
        }
    }

    private void cancelOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        orderService.cancelOrder(orderId);
        showOrderList(req, resp);
    }

    private void changeStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        int statusIndex = Integer.parseInt(req.getParameter("status"));
        orderService.changeStatusOrder(orderId, statusIndex);
        showOrderList(req, resp);
    }

    private void showInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("order", orderService.getOrderByOrderId(orderId));
        req.setAttribute("products", orderService.getAllProduct());
        req.getRequestDispatcher("/admin/orders/orderdetail.jsp").forward(req, resp);
    }

    private void showOrderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if (search == null)
            search = "";
        int page = 1;
        if (req.getParameter("page") != null)
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1;
            }
        Pageable pageable = new Pageable(search, page, 6);
        req.setAttribute("orderlist", orderService.findAll(pageable));
        req.setAttribute("pageable", pageable);
        req.getRequestDispatcher("/admin/orders/orderlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
