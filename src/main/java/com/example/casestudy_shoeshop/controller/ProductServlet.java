package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.service.CategoryService;
import com.example.casestudy_shoeshop.service.ProductService;
import com.example.casestudy_shoeshop.ulti.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/admin/product"})

public class ProductServlet extends HttpServlet {

    private int TOTAL_ITEMS = 5;

    private List<Product> products = new ArrayList<>();

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    Validate validate = new Validate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(req, resp);
                break;
            case "update":
                showUpdateProduct(req, resp);
                break;
            default:
                showProduct(req, resp);
        }
    }


    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        int page = 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }

        String sortBy = req.getParameter("sortBy");
        if (sortBy == null) {
            sortBy = "asc";
        }

        String fieldName = req.getParameter("fieldName");
        if (fieldName == null) {
            fieldName = "product.id";
        }

        Pageable pageable = new Pageable(search, page, TOTAL_ITEMS, fieldName, sortBy);
        req.setAttribute("products", productService.findAll(pageable));
        req.setAttribute("pageable", pageable);
        req.getRequestDispatcher("/admin/products/productlist.jsp").forward(req, resp);
    }

    private void showCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryService.findAll());
        req.getRequestDispatcher("/admin/products/createProduct.jsp").forward(req, resp);
    }

    private void showUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("categories", categoryService.findAll());
        req.setAttribute("product", product);
        req.getRequestDispatcher("/admin/products/updateProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "update":
                updateProduct(req, resp);
                break;
            default:
                showProduct(req, resp);
        }

    }


    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("product_name");
        boolean checkName = validate.checkEmpty(name);
        if (checkName) {
            req.setAttribute("errorName", "Tên Không Được Để Trống");
        } else if (productService.finByName(name) != null) {
            req.setAttribute("errorName", "Tên Sản Phẩm Đã Tồn Tại");
        }

        String priceS = req.getParameter("price");
        boolean checkPrice = validate.checkEmpty(priceS);
        if(!checkPrice){
            req.setAttribute("errorPrice","Giá Sản Phẩm Không Được Để Trống");
        }
        if(!validate.checkPrice(priceS)){
            req.setAttribute("errorPrice","Giá Sản Phẩm Phải Lớn Hơn 0");
        }
        if(checkName && checkPrice && validate.checkPrice(priceS)){
            double price = Double.parseDouble(priceS);

            String description = req.getParameter("description");
            String img = req.getParameter("img");

            int idCategory = Integer.parseInt(req.getParameter("category"));
            Category category = categoryService.findById(idCategory);
            productService.insert(new Product(name, price, description, img, category));

            req.setAttribute("errorCreate","Tạo Sản Phẩm Thành Công");
            showCreateProduct(req,resp);
        }
        else {
            showCreateProduct(req,resp);
        }

    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("product_name");
        boolean checkName = validate.checkEmpty(name);
        if (checkName) {
            req.setAttribute("errorName", "Tên Không Được Để Trống");
        } else if (productService.finByName(name) != null) {
            req.setAttribute("errorName", "Tên Sản Phẩm Đã Tồn Tại");
        }

        String priceS = req.getParameter("price");
        boolean checkPrice = validate.checkEmpty(priceS);
        if(!checkPrice){
            req.setAttribute("errorPrice","Giá Sản Phẩm Không Được Để Trống");
        }
        if(!validate.checkPrice(priceS)){
            req.setAttribute("errorPrice","Giá Sản Phẩm Phải Lớn Hơn 0");
        }
        if(checkName && checkPrice && validate.checkPrice(priceS)) {

            double price = Double.parseDouble(priceS);


            String description = req.getParameter("description");
            String img = req.getParameter("img");

            int idCategory = Integer.parseInt(req.getParameter("category"));
            Category category = categoryService.findById(idCategory);
            productService.update(new Product(id, name, price, description, img, category));

            req.setAttribute("errorUpdate","Sửa Thông Tin Sản Phẩm Thành Công");
            showUpdateProduct(req, resp);
        }
        else {
            showUpdateProduct(req,resp);
        }

    }
}
