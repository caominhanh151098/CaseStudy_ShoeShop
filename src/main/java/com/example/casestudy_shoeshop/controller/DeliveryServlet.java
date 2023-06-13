package com.example.casestudy_shoeshop.controller;

import com.example.casestudy_shoeshop.model.Delivery;
import com.example.casestudy_shoeshop.service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeliveryServlet", urlPatterns = "/delivery")
public class DeliveryServlet extends HttpServlet {

    private static DeliveryService deliveryService = new DeliveryService();
    private static List<Delivery> deliveryList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showAddDeli(req, resp);
                break;
            case "edit":
                showEditDeli(req, resp);
                break;
            default:
                showList(req, resp);
        }

    }

    private void showEditDeli(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("delivery", deliveryService.findById(id));
        req.getRequestDispatcher("/admin/edit_delivery.jsp").forward(req, resp);
    }

    private void showAddDeli(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/add_delivery.jsp").forward(req, resp);
    }

    public void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("deliveryList", deliveryService.findAll());
        req.getRequestDispatcher("/admin/delivery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addDeli(req, resp);
                break;
            case "edit":
                editDeli(req,resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void editDeli(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String delivery_place = req.getParameter("delivery_place");
        String customer_name = req.getParameter("customer_name");
        String customer_email = req.getParameter("customer_email");
        String customer_phone = req.getParameter("customer_phone");
        Delivery delivery = new Delivery(id, delivery_place, customer_name, customer_email, customer_phone);
        deliveryService.editDeli(delivery);
        req.setAttribute("deliveryList", deliveryService.findAll());
        req.getRequestDispatcher("/admin/delivery.jsp").forward(req, resp);
    }

    private void addDeli(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delivery_place = req.getParameter("delivery_place");
        String customer_name = req.getParameter("customer_name");
        String customer_email = req.getParameter("customer_email");
        String customer_phone = req.getParameter("customer_phone");
        Delivery delivery = new Delivery(delivery_place, customer_name, customer_email, customer_phone);
        deliveryService.createDelivery(delivery);
        req.setAttribute("deliveryList", deliveryService.findAll());
        req.getRequestDispatcher("/admin/delivery.jsp").forward(req, resp);
    }
}
