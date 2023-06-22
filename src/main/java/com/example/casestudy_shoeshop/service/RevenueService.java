package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.OrderDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RevenueService {
    private static OrderDao orderDao = new OrderDao();

    public List<Order> getListOrder(String dateFrom, String dateTo, Pageable pageable) {
        if (dateFrom == null || dateFrom.equals(""))
            dateFrom = "2023-05-01";
        if (dateTo == null || dateTo.equals(""))
            dateTo = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return orderDao.getRevenue(dateFrom, dateTo, pageable);
    }

    public double getTotalPriceRevenue (String dateFrom, String dateTo, Pageable pageable) {
        if (dateFrom == null || dateFrom.equals(""))
            dateFrom = "2023-05-01";
        if (dateTo == null || dateTo.equals(""))
            dateTo = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return orderDao.getTotalPriceRevenue(dateFrom, dateTo, pageable);
    }
}
