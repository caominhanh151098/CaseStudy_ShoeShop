package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.service.HomeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private static HomeService homeService = new HomeService();

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            Order order = homeService.getCartByUserId(user.getId());
            Order orderSession = homeService.getCartBySession(session.getId());
            if (orderSession != null) {}
        }
        req.setAttribute("productList", homeService.getProducts());
        req.setAttribute("categories", homeService.getCategories());
        req.getRequestDispatcher("user/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
