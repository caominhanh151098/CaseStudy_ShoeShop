package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "user", urlPatterns = "/user")

public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private UserInfoService user_infoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showInfo":
                showInfoUser(req,resp);
                break;
            case "edit":
                showEditUserInfo(req, resp);
                break;
            default:
                showUser(req, resp);
        }
    }

    private void showInfoUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findByID(id);
        req.setAttribute("user",user);
//        req.setAttribute("userAll",userService.findALL());
        req.getRequestDispatcher("showInfo.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "edit":
                editUserInfo(req, resp);
                break;
            default:
                showUser(req, resp);
        }
    }

    public void showUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user",userService.findALL());
        request.getRequestDispatcher("/admin/users/userlist.jsp").forward(request,response);
    }

    private void editUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String name = req.getParameter("name");
        Date Dob = Date.valueOf(req.getParameter("dob"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
//        UserInfo userInfo = user_infoService.findById(user_id);
        UserInfo userInfo = new UserInfo(user_id, name,Dob,email,phone);
        user_infoService.update(userInfo);
//        req.setAttribute("userInfo", user_infoService.findAll());
        req.setAttribute("userInfo",userInfo);
        req.getRequestDispatcher("editUserInfo.jsp").forward(req,resp);
    }

    private void showEditUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        // lấy customer có id bằng với id trong parameter;
        // gửi customer qua bên editUserInfo.jsp;
        // điều hướng tới trang editUserInfo.jsp;
        UserInfo userInfo = user_infoService.findById(id);
        req.setAttribute("userInfo", userInfo);
//        req.setAttribute("listcategory", categoryService.findAll());
        req.getRequestDispatcher("editUserInfo.jsp").forward(req, resp);
    }
}
