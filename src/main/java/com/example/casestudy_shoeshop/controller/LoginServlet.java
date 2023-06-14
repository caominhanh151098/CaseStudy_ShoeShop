package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet ("/login")

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final ProductService productService = new ProductService();

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Product product = productService.findByUsername(username);
//        if(product != null && PasswordEncoder.check(password, product.getPassword())){
//            HttpSession session = request.getSession();
//            session.setAttribute("role", product.getRole().getName());
//            response.sendRedirect("admin/customers");
//            return;
//        }
//        request.setAttribute("errors", "Login Failed");
//        request.getRequestDispatcher("index.jsp")
//                .forward(request,response);
//
//    }
}
