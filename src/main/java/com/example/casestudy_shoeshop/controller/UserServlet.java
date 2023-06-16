package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;
import com.example.casestudy_shoeshop.service.RoleService;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.service.UserInfoService;
import com.example.casestudy_shoeshop.ulti.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "user", urlPatterns = "/user")

public class UserServlet extends HttpServlet {
    private String message;
    private UserService userService = new UserService();
    private UserInfoService user_infoService = new UserInfoService();
    private RoleService roleService = new RoleService();

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
            case "usercustomer":
                showUserCustomer(req, resp);
                break;
            case "createUser":
                showCreateUser(req,resp);
                break;
            default:
                showUser(req, resp);
        }
    }

    private void showCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("role", roleService.findAll());
        req.setAttribute("userinfo", userService.findALL());
        req.getRequestDispatcher("/admin/users/createUser.jsp").forward(req,resp);

    }

    private void showEditUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        // lấy customer có id bằng với id trong parameter;
        // gửi customer qua bên editUserInfo.jsp;
        // điều hướng tới trang editUserInfo.jsp;
        UserInfo userInfo = user_infoService.findById(id);
        req.setAttribute("userInfo", userInfo);
//        req.setAttribute("listcategory", categoryService.findAll());
        req.getRequestDispatcher("/admin/users/userEdit.jsp").forward(req, resp);
    }

    private void showInfoUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findByID(id);
        req.setAttribute("user",user);
//        req.setAttribute("userAll",userService.findALL());
        req.getRequestDispatcher("admin/users/showUserInfo.jsp").forward(req,resp);

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
            case "usercustomer":
                showUserCustomer(req, resp);
                break;

            default:
                showUser(req, resp);
        }
    }

    public void showUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user",userService.findALL());
        request.getRequestDispatcher("/admin/users/userlist.jsp").forward(request,response);
    }

    public void showUserCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usercustomer", userService.findALL());
        request.getRequestDispatcher("/admin/users/customerlist.jsp").forward(request,response);
    }

//    public void createUser(HttpServletRequest request, HttpServletResponse response){
//        String username = request.getParameter("name");
//        String password = request.getParameter("password");
//        String rolename = request.getParameter("rolename");
//        String name = request.getParameter("name");
//        String dob = request.getParameter("dob");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
////        UserInfo userInfo = user_infoService.findAll();
//        User user = new User(username,password,);
//
//    }

    private void editUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        int user_id = Integer.parseInt(req.getParameter("id"));

        validateName(req, errors,userInfo);
        validateDate(req, errors, userInfo);
        validateEmail(req, errors, userInfo);

        String phone = req.getParameter("phone");
        userInfo.setPhone(phone);


        if(errors.isEmpty()){
            user_infoService.editUserInfo(userInfo);
        }else{
            req.setAttribute("errors", errors);
            req.setAttribute("userInfo",userInfo);
        }
        req.getRequestDispatcher("/admin/users/userEdit.jsp").forward(req,resp);
//        message = "Thêm thành công";
//        req.setAttribute("message", message);
        showUser(req, resp);
    }

    private void validateEmail(HttpServletRequest req, List<String> errors, UserInfo userInfo) {
        String email = req.getParameter("email");
        if (!ValidateUtils.isEmailValid(email)){
            errors.add("Vui lòng nhập emmail !");
        }
        userInfo.setEmail(email);
    }
    private void validateDate(HttpServletRequest req, List<String> errors, UserInfo userInfo) {
        Date Dob = null;
        try{
            Dob = Date.valueOf(req.getParameter("dob"));
        }catch (IllegalArgumentException illegalArgumentException){
            errors.add("Loi dinh dang ngay thang");
        }
        userInfo.setDob(Dob);
    }
    private void validateName(HttpServletRequest req, List<String> errors, UserInfo userInfo) {
        String name = req.getParameter("name");
        if(!ValidateUtils.isNameValid(name)){        // rong
            errors.add("Ten khong duoc de trong");
        }
        userInfo.setName(name);
    }
}
