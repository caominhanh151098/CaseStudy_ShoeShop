package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.Role;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.service.ProductService;
import com.example.casestudy_shoeshop.service.RoleService;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.ulti.PasswordEncoder;

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

    private final UserService userService = new UserService();
    private final RoleService roleService = new RoleService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByName(username);

        if(user != null){
            if(password.equals(user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("role", user.getRole().getRole_name());

                response.sendRedirect("/product");

//                if(user.getRole().equals(roleService.findByName(username))){
//                    session.setAttribute("user",user);
//                    response.sendRedirect("/product");
//                }
//                else {
//                    session.setAttribute("user",user);
//                    response.sendRedirect("");
//                }
            }
            else {
                request.setAttribute("error","Mật khẩu không đúng");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
        else {
            request.setAttribute("errors","Tài khoản không đúng");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
