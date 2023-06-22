package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.service.CancelOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="CancelOrderServlet", urlPatterns = "/admin/c-order")
public class CancelOrderServlet extends HttpServlet {

    private static CancelOrderService cancelOrderService = new CancelOrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            default:
                showOrderList(req, resp);
        }
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
        Pageable pageable = new Pageable(search, page, 5);
        req.setAttribute("orderlist",cancelOrderService.getCancelOrders(pageable));
        req.setAttribute("pageable", pageable);
        req.getRequestDispatcher("/admin/orders/cancelorders.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
