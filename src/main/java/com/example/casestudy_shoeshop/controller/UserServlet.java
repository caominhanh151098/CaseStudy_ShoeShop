package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dao.UserDao;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.service.User_infoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private User_infoService user_infoService = new User_infoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showall":
                showAllUser(req,resp);
                break;
            default:
                showUser(req, resp);
        }
    }

    private void showAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findByID(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("showAll.jsp").forward(req,resp);
        req.setAttribute("userAll",userService.findALL());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showUser(req, resp);
        }
    }

    public void showUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user",userService.findALL());
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
