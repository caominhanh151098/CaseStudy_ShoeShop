package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private static HomeService homeService = new HomeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", homeService.getAllProduct());
        req.setAttribute("categories", homeService.getCategories());
        req.getRequestDispatcher("user/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
