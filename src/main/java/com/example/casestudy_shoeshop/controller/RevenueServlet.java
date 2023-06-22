package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.service.RevenueService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "RevenueServlet", urlPatterns = "/admin/revenue")
public class RevenueServlet extends HttpServlet {
    private static RevenueService revenueService = new RevenueService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        String dateFrom = req.getParameter("date1");
        String dateTo = req.getParameter("date2");
        Pageable pageable = new Pageable(search, page, 6);
        req.setAttribute("orderlist", revenueService.getListOrder(dateFrom, dateTo, pageable));
        req.setAttribute("pageable", pageable);
        req.setAttribute("datefrom", dateFrom);
        req.setAttribute("dateto", dateTo);
        req.setAttribute("totalprice", revenueService.getTotalPriceRevenue(dateFrom, dateTo, pageable));
        req.getRequestDispatcher("/admin/revenue.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
