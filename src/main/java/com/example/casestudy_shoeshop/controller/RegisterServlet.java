package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.Role;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;
import com.example.casestudy_shoeshop.service.RoleService;
import com.example.casestudy_shoeshop.service.UserInfoService;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.ulti.Regex;
import com.example.casestudy_shoeshop.ulti.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.casestudy_shoeshop.ulti.Regex.checkUsername;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserInfoService user_infoService = new UserInfoService();
    private UserService userService = new UserService();
    private Validate validate = new Validate();

    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showRegister(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createRegister":
                createRegister(req,resp);
                break;
            default:
                showRegister(req,resp);
        }
    }

    private void createRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean checkEmptyUserName = validate.checkEmpty(username);
        boolean checkUserName = validate.checkUserName(username);
        boolean checkRegexUserName = checkUsername(username);
        if (!checkEmptyUserName) {
            req.setAttribute("errorUserName", "Tài Khoản Không Được Để Trống");
        } else if (!checkUserName) {
            req.setAttribute("errorUserName", "Tài Khoản Đã Tồn Tại");
        }else if(!checkRegexUserName){
            req.setAttribute("errorUserName", "Tài Khoản Không Được Có Ký Tự Đặc Biệt");
        }


        String password = req.getParameter("password");
        boolean checkEmptyPass = validate.checkEmpty(password);
        boolean checkPassword = Regex.checkPassword(password);
        if (!checkEmptyPass) {
            req.setAttribute("errorPassword", "Mật Khẩu Không Được Để Trống");
        }else if(!checkPassword){
            req.setAttribute("errorPassword", "Mật Khẩu gồm chữ và số");
        }

        String email = req.getParameter("email");
        boolean checkEmptyEmail = validate.checkEmpty(email);
        boolean checkEmail = validate.checkEmail(email);
        boolean checkRegexEmail = Regex.checkEmail(email);
        if(!checkEmptyEmail){
            req.setAttribute("errorEmail","Email Không Được Để Trống");
        }else if(!checkEmail){
            req.setAttribute("errorEmail","Email Đã Tồn Tại");
        }else if(!checkRegexEmail){
            req.setAttribute("errorEmail","Sai Định Dạng. Ví Dụ: Phuc@gmail.com");
        }

        if(checkEmptyUserName && checkUserName && checkRegexUserName
                && checkEmptyPass && checkPassword
                && checkEmptyEmail && checkEmail && checkRegexEmail)
        {
            Role role = roleService.findById(3);

            UserInfo userInfo = new UserInfo(email);
            User user = new User(username, password,role,userInfo);

            userService.create(user);

            req.setAttribute("errorRegister", "Tạo Tài Khoản Thành Công");
            showRegister(req,resp);
        }
        else {
            showRegister(req,resp);
        }
    }

    private void showRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

}
