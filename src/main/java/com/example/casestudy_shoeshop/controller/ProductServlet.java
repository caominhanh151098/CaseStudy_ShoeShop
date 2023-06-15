package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.service.CategoryService;
import com.example.casestudy_shoeshop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/product"})

public class ProductServlet extends HttpServlet {

    private List<Product> products = new ArrayList<>();

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case  "insert":
                showInsertProduct(req,resp);
                break;
            case "update":
                showUpdateProduct(req,resp);
                break;
            default:
                showProduct(req,resp);
        }
    }



    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        Pageable pageable = new Pageable(search);
        req.setAttribute("products", productService.findAll(pageable));
        req.setAttribute("pageable",pageable);
        req.getRequestDispatcher("/admin/products/productlist.jsp").forward(req,resp);
    }

    private void showInsertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categoryService.findAll());
        req.getRequestDispatcher("/admin/products/createProduct.jsp").forward(req,resp);
    }

    private void showUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("categories",categoryService.findAll());
        req.setAttribute("product", product);
        req.getRequestDispatcher("/admin/products/updateProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "insert":
                insertProduct(req,resp);
                break;
            case "update":
                updateProduct(req,resp);
                break;
            default:
                showProduct(req,resp);
        }

    }


    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("product_name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String img = req.getParameter("img");

        int idCategory = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(idCategory);
        productService.insert(new Product(name,price,description,img,category));
        showProduct(req,resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("product_name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String img = req.getParameter("img");

        int idCategory = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.findById(idCategory);
        productService.update(new Product(id,name,price,description,img,category));
        showProduct(req,resp);

    }
}
