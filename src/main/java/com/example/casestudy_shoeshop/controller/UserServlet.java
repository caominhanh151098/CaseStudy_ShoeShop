package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Role;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;
import com.example.casestudy_shoeshop.service.RoleService;
import com.example.casestudy_shoeshop.service.UserService;
import com.example.casestudy_shoeshop.service.UserInfoService;
import com.example.casestudy_shoeshop.ulti.Regex;
import com.example.casestudy_shoeshop.ulti.Validate;
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

import static com.example.casestudy_shoeshop.ulti.Regex.*;

@WebServlet({"/admin/user"})

public class UserServlet extends HttpServlet {
    private  int TOTAL_ITEMS = 5;

    private UserService userService = new UserService();
    private UserInfoService user_infoService = new UserInfoService();
    private RoleService roleService = new RoleService();
    private Validate validate = new Validate();

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
            case "createUser":
                showCreateUser(req,resp);
                break;
            default:
                showUser(req, resp);
        }
    }

    private void showCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
        String search = req.getParameter("search");

        int page = 1;
        if(req.getParameter("page")!= null){
            page = Integer.parseInt(req.getParameter("page"));
        }

        String sortBy = req.getParameter("sortBy");
        if(sortBy == null){
            sortBy = "asc";
        }

        String fieldName = req.getParameter("fieldName");
        if(fieldName == null){
            fieldName = "product.id";
        }

        Pageable pageable = new Pageable(search, page, TOTAL_ITEMS ,fieldName,sortBy);
        req.setAttribute("pageable", pageable);
        req.setAttribute("usercustomer", userService.findALL(pageable));

        req.setAttribute("role", roleService.findAll());
        req.setAttribute("userinfo", userService.findALL(pageable));
        req.getRequestDispatcher("/admin/users/createUser.jsp").forward(req,resp);

    }

    private void showEditUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
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
        req.getRequestDispatcher("/admin/users/showUserInfo.jsp").forward(req,resp);

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

            case "createUser":
                createUser(req,resp);
                break;

            default:
                showUser(req, resp);
        }
    }

    public void showUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            fieldName = "user.id";
        }

        Pageable pageable = new Pageable(search, page, TOTAL_ITEMS ,fieldName,sortBy);
        request.setAttribute("pageable", pageable);

        request.setAttribute("user",userService.findALL(pageable));
        request.getRequestDispatcher("/admin/users/userlist.jsp").forward(request,response);
    }


    public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean checkEmptyUserName = validate.checkEmpty(username);
        boolean checkUserName = validate.checkUserName(username);
        boolean checkRegexUserName = checkUsername(username);
        if (!checkEmptyUserName) {
            request.setAttribute("errorUserName", "Tài Khoản Không Được Để Trống");
        } else if (!checkUserName) {
            request.setAttribute("errorUserName", "Tài Khoản Đã Tồn Tại");
        }else if(!checkRegexUserName){
            request.setAttribute("errorUserName", "Tài Khoản Không Được Có Ký Tự Đặc Biệt");
        }


        String password = request.getParameter("password");
        boolean checkEmptyPass = validate.checkEmpty(password);
        boolean checkPassword = Regex.checkPassword(password);
        if (!checkEmptyPass) {
            request.setAttribute("errorPassword", "Mật Khẩu Không Được Để Trống");
        }else if(!checkPassword){
            request.setAttribute("errorPassword", "Mật Khẩu gồm chữ và số");
        }

        String name = request.getParameter("name");
        boolean checkEmptyName = validate.checkEmpty(name);
        boolean checkName = Regex.checkName(name);
        if(!checkEmptyName){
            request.setAttribute("errorName", "Tên Không Được Để Trống");
        }else if(!checkName){
            request.setAttribute("errorName", "Tên Không Được Có Ký Tự Đặc Biệt");
        }


        String dobString = request.getParameter("dob");
        Date dob = null;
        if(dobString == "") {
            request.setAttribute("errorDob","Vui Lòng Chọn Ngày Tháng");
        } else {
            dob = Date.valueOf(dobString);
            if(dob.compareTo(new java.util.Date()) >= 0){
                request.setAttribute("errorDob","Không Đươc Chọn Quá Ngày Hiện Tại");
            }
        }


        String email = request.getParameter("email");
        boolean checkEmptyEmail = validate.checkEmpty(email);
        boolean checkEmail = validate.checkEmail(email);
        boolean checkRegexEmail = Regex.checkEmail(email);
        if(!checkEmptyEmail){
            request.setAttribute("errorEmail","Email Không Được Để Trống");
        }else if(!checkEmail){
            request.setAttribute("errorEmail","Email Đã Tồn Tại");
        }else if(!checkRegexEmail){
            request.setAttribute("errorEmail","Sai Định Dạng. Ví Dụ: Phuc@gmail.com");
        }

        String phone = request.getParameter("phone");
        boolean checkEmptyPhone = validate.checkEmpty(phone);
        boolean checkPhone = validate.checkPhone(phone);
        boolean checkRegexPhone = Regex.checkPhone(phone);
        if(!checkEmptyPhone){
            request.setAttribute("errorPhone","Số Điện Thoại Không Được Để Trống");
        }else if(!checkPhone){
            request.setAttribute("errorPhone","Số Điện Thoại Đã Tồn Tại");
        }else if(!checkRegexPhone){
            request.setAttribute("errorPhone","Sai Định Dạng. Ví Dụ: 0123456789");
        }

        String address = request.getParameter("address");
        boolean checkEmptyAddress = validate.checkEmpty(address);
        if(!checkEmptyAddress){
            request.setAttribute("errorAddress","Địa Chỉ Không Được Để Trống");
        }


        if(checkEmptyUserName && checkName && checkRegexUserName
                && checkEmptyPass && checkPassword
                && checkEmptyName && checkName
                && checkEmptyEmail && checkEmail && checkRegexEmail
                && checkEmptyPhone && checkPhone && checkRegexPhone
                && checkEmptyAddress) {

            Role role = roleService.findById(3);

            UserInfo userInfo = new UserInfo(name, dob, email, phone, address);
            User user = new User(username, password, role,userInfo);

            userService.create(user);
//            user_infoService.create(userInfo);

            request.setAttribute("errorCreateUser", "Tạo Tài Khoản Thành Công");
            showCreateUser(request,response);
        }
        else {
            showCreateUser(request,response);
        }



    }

    private void editUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        int user_id = Integer.parseInt(req.getParameter("id"));

        validateName(req, errors,userInfo);
        validateDate(req, errors, userInfo);
        validateEmail(req, errors, userInfo);

        String phone = req.getParameter("phone");
        userInfo.setPhone(phone);
        userInfo.setUser_id(user_id);

        if(errors.isEmpty()){
            user_infoService.editUserInfo(userInfo);
        }else{
            req.setAttribute("errors", errors);
            req.setAttribute("userInfo",userInfo);
        }
        String message = "Sửa thành công";
        req.setAttribute("message", message);
        req.getRequestDispatcher("/admin/users/userEdit.jsp").forward(req,resp);
//        showUser(req, resp);
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
