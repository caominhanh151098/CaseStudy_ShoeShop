package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.service.UserInfoService;
import com.example.casestudy_shoeshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customer", urlPatterns = "/customer")
public class CustomerUserServlet extends HttpServlet {
    private  int TOTAL_ITEMS = 5;
    private UserService userService = new UserService();
    private UserInfoService user_infoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showUserCustomer(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showUserCustomer(req, resp);
        }

    }

    public void showUserCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        int page = 1;
        if(request.getParameter("page")!= null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        String sortBy = request.getParameter("sortBy");
        if(sortBy == null){
            sortBy = "asc";
        }

        String fieldName = request.getParameter("fieldName");
        if(fieldName == null){
            fieldName = "product.id";
        }

        Pageable pageable = new Pageable(search, page, TOTAL_ITEMS ,fieldName,sortBy);
        request.setAttribute("pageable", pageable);
        request.setAttribute("usercustomer", userService.findAllCustomer(pageable));

        request.getRequestDispatcher("/admin/users/customerlist.jsp").forward(request,response);

    }
}
