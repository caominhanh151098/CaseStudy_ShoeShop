package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    public static OrderService orderServlet = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showOrderList(req, resp);
        }
    }

    private void  showOrderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orderlist", orderServlet.findAll());
<<<<<<< HEAD
        req.getRequestDispatcher("/admin/orders/orderlist.jsp").forward(req, resp);
=======
        req.getRequestDispatcher("/admin/order/orderlist.jsp").forward(req, resp);
>>>>>>> 4bf94b8dfd62be25c666c1a6993d5cb466a2b270
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
